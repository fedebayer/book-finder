package biblioteca.busquedas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EncontrarCamino {

	private Grafo<?> grafo;
	private HashMap<String, String> colores;

	public EncontrarCamino(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
	}

	public ArrayList<String> encontrarCamino(String origen, String destino) {

		Iterator<String> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			String vertice = it.next();
			this.colores.put(vertice, "blanco");
		}

		ArrayList<String> camino = encontrarCaminoVisit(origen, destino);
		return camino;
	}

	private ArrayList<String> encontrarCaminoVisit(String actual, String destino) {

		this.colores.put(actual, "amarillo");

		if (actual == destino) {
			ArrayList<String> out = new ArrayList<>();
			out.add(actual);
			return out;
		} else {
			Iterator<String> it = this.grafo.obtenerAdyacentes(actual);
			while (it.hasNext()) {
				String adyacente = it.next();
				if (this.colores.get(adyacente).equals("blanco")) {
					ArrayList<String> camino = new ArrayList<>();
					camino.add(actual);
					camino.addAll(encontrarCaminoVisit(adyacente, destino));
					if (camino.get(camino.size() - 1) == destino) {
						return camino;
					}
				}
			}
			colores.put(actual, "negro");
			return new ArrayList<>();
		}
	}

}

//otra forma
/*
 * this.colores.put(origen, "amarillo");
 * 
 * if (origen == destino) { ArrayList<Integer> out = new ArrayList<Integer>();
 * out.add(origen); return out; } else { ArrayList<Integer> camino = null;
 * Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen); while
 * (it.hasNext() && camino == null) { int adyacente = it.next(); if
 * (this.colores.get(adyacente).equals("blanco")) { ArrayList<Integer>
 * caminoParcial = encontrarCaminoVisit(adyacente, destino); if (caminoParcial
 * != null) { camino = new ArrayList<>(); camino.add(origen);
 * camino.addAll(caminoParcial); } } } // colores.put(verticeActual, "negro");
 * return camino; } }
 */