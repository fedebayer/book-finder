package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import biblioteca.busquedas.Arco;
import utils.CSVReader;

public class Main {
	public static <T> void main(String[] args) {
		CSVReader reader = new CSVReader();
		///////////////////
		// Parte 1
		////////////////////
		/*
		 * ArrayList<Libro> libros = reader.getData(); HashSet<String> generos = new
		 * HashSet<>(); for (Libro libro : libros) { generos.addAll(libro.getGeneros());
		 * }
		 * 
		 * Biblioteca biblioteca = new Biblioteca(); for (String genero : generos) {
		 * biblioteca.createGenero(genero); }
		 * 
		 * biblioteca.setLibrosToGenero(libros);
		 * 
		 * BufferedReader entrada = new BufferedReader(new
		 * InputStreamReader(System.in)); System.out.println("Ingrese genero: "); String
		 * toSearch = null; try { CSVWritter writter = new CSVWritter(); toSearch =
		 * entrada.readLine(); List<Libro> librosOfGenero =
		 * biblioteca.getLibrosOfGenero(toSearch); Iterator<Libro> itr =
		 * librosOfGenero.iterator();
		 * 
		 * writter.write(itr);
		 * 
		 * Iterator<Libro> itr2 = librosOfGenero.iterator(); while (itr2.hasNext()) {
		 * System.out.println(itr2.next().getTitulo()); }
		 * 
		 * } catch (IOException e) { e.printStackTrace(); }
		 */
		//////////////////////////////////////////////////////////////////////////////
		// Parte 2
		///////////////////////
		HashSet<String> generos = reader.getData2();
		Busquedas<String> busquedas = new Busquedas<>();
		for (String g : generos) {
			busquedas.agregarVertice(g);
		}
		ArrayList<ArrayList<String>> lineasGeneros = reader.getData3();
		for (ArrayList<String> linea : lineasGeneros) {
			ArrayList<String> generosLinea = new ArrayList<>();
			for (String g : linea) {
				generosLinea.add(g);
			}
			for (int i = 0; i < generosLinea.size() - 2; i++) {
				if (generosLinea.get(i + 1) != null)
					busquedas.agregarArco(generosLinea.get(i), generosLinea.get(i + 1));
			}
		}
		Iterator<String> vertices = busquedas.obtenerVertices();
		while (vertices.hasNext()) {
			System.out.println(vertices.next());
		}
		Iterator<Arco<String>> arcos = busquedas.obtenerArcos();
		while (arcos.hasNext()) {
			Arco<String> arco = arcos.next();
			System.out.println("origen: " + arco.getVerticeOrigen());
			System.out.println("destino: " + arco.getVerticeDestino());
			System.out.println("etiqueta: " + arco.getEtiqueta());
		}

		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
		Iterator<String> adyacentes = busquedas.obtenerAdyacentes("terror");
		while (adyacentes.hasNext()) {
			System.out.println(adyacentes.next());
		}
		System.out.println("zzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
		BufferedReader entrada2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese genero: ");
		String toSearch = null;
		try {
			toSearch = entrada2.readLine();
			ArrayList<String> generosBuscados = busquedas.generosBuscadosAfter(toSearch);
			if (generosBuscados != null) {
				for (String g : generosBuscados) {
					System.out.println(g);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
