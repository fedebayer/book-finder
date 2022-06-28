package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import biblioteca.busquedas.Arco;
import biblioteca.busquedas.ComparadorPesoArco;
import biblioteca.busquedas.DFS;
import biblioteca.busquedas.Grafo;
import biblioteca.busquedas.Greedy;
import biblioteca.busquedas.arcoIterator;

public class Busquedas<T> implements Grafo<T> {
	private HashMap<String, ArrayList<Arco<T>>> vertices;

	public Busquedas() {
		this.vertices = new HashMap<String, ArrayList<Arco<T>>>();
	}

	public ArrayList<String> generosBuscadosAfter(String genero) {
		ArrayList<String> res = new ArrayList<>();
		Iterator<String> adyacentes = obtenerAdyacentes(genero);
		while (adyacentes.hasNext()) {
			res.add(adyacentes.next());
		}
		Collections.sort(res, new ComparadorPesoArco<T>(genero, this));
		Collections.reverse(res);
		return res;
	}

	public ArrayList<String> getSecuenciaGeneros(String genero) {
		Greedy greedy = new Greedy(this);
		Iterator<String> adyacentesDeGenero = this.obtenerAdyacentes(genero);
		ArrayList<String> candidatos = new ArrayList<>();
		while (adyacentesDeGenero.hasNext()) {
			candidatos.add(adyacentesDeGenero.next());
		}
		return greedy.greedy(candidatos, genero).getSolucion();
	}

	public Busquedas<?> getGrafoGenerosAfines(String genero){
		DFS dfs = new DFS(this);
		ArrayList<ArrayList<String>> generosAfines = dfs.dfs(genero);
		/*
		  System.out.println("\n\n Generos afines del genero ingresado: \n"); 
		  for (ArrayList<String> g : generosAfines) { 
			  System.out.println(g); 
			  }
		 */
		Busquedas<?> grafoNuevo = new Busquedas<>();
		for (ArrayList<String> generos : generosAfines) {
			for (String g : generos) {
				grafoNuevo.agregarVertice(g);
			}
		}
		return grafoNuevo;
		
	}
	@Override
	public void agregarVertice(String vertice) {// O(1) tiempo constante de acceso a memoria
		if (!vertices.containsKey(vertice)) {
			vertices.put(vertice, new ArrayList<Arco<T>>());
		}
	}

	public void agregarArco(String vertice1, String vertice2) {// O(1) tiempo constante de acceso a
																// memoria
		if (existeArco(vertice1, vertice2)) {
			obtenerArco(vertice1, vertice2).sum();

		} else if (vertices.containsKey(vertice1) && vertices.containsKey(vertice2)) {
			vertices.get(vertice1).add(new Arco<T>(vertice1, vertice2));
		}
	}

	@Override
	public boolean contieneVertice(String vertice) {// O(1) constante en memoria busca por el indice que le pasas que
													// representa el vertice
		Iterator<String> vertices = obtenerVertices();
		boolean res = false;
		while (vertices.hasNext()) {
			if (vertices.next().equals(vertice))
				res = true;
		}
		return res;
	}

	@Override
	public boolean existeArco(String vertice1, String vertice2) {// O(A) donde A representa todos los arcos de un
																	// vertice

		if (vertices.containsKey(vertice1) && vertices.containsKey(vertice2)) {
			return this.obtenerArco(vertice1, vertice2) != null;

		}
		return false;
	}

	public Arco<T> obtenerArco(String vertice1, String vertice2) { // O(A) A representa todos los arcos de un
																	// vertice
		// en el peor de los casos ambos elementos se encuentran a lo ultimo
		Iterator<Arco<T>> iteradorArcos = vertices.get(vertice1).iterator();
		while (iteradorArcos.hasNext()) {
			Arco<T> arcoBuscado = iteradorArcos.next();
			if (arcoBuscado.getVerticeDestino().equals(vertice2)) {
				return arcoBuscado;
			}
		}
		return null;
	}

	@Override
	public Iterator<String> obtenerVertices() {// O(1) constante de acceso a memoria
		return vertices.keySet().iterator();

	}

	@Override
	public Iterator<String> obtenerAdyacentes(String vertice) {// 0(1) constante en acceso de memoria

		Iterator<Arco<T>> auxArco = vertices.get(vertice).iterator();
		return new arcoIterator<T>(auxArco);
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {// O(V*a) donde V representa todos los vertices y "a" cada arco de este
												// vertice
		ArrayList<Arco<T>> auxArcos = new ArrayList<Arco<T>>();
		Iterator<Arco<T>> aux = null;
		Iterator<String> iterator = this.obtenerVertices();
		while (iterator.hasNext()) {
			aux = this.obtenerArcos(iterator.next());
			while (aux.hasNext()) {
				auxArcos.add(aux.next());
			}
		}
		aux = auxArcos.iterator();
		return aux;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(String vertice) { // O(1) tiempo constante de acceso a memoria
		return vertices.get(vertice).iterator();
	}

	@Override
	public void borrarVertice(String vertice) {
	}

	@Override
	public void borrarArco(String vertice1, String vertice2) {

	}

	@Override
	public int cantidadVertices() {
		return 0;
	}

	@Override
	public int cantidadArcos() {
		return 0;
	}

	@Override
	public void agregarArco(String verticeId1, String verticeId2, int etiqueta) {
	}

}
