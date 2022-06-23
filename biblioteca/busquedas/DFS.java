package biblioteca.busquedas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DFS {
	private Grafo<?> grafo;
	private HashMap<String, String> colores;
	private boolean primeraVez;

	public DFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
	}

	public ArrayList<ArrayList<String>> dfs(String destino) {

		Iterator<String> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			String vertice = it.next();
			this.colores.put(vertice, "blanco");
		}
		primeraVez = true;
		ArrayList<ArrayList<String>> caminos = dfsVisit(destino, destino);
		return caminos;
	}

	private ArrayList<ArrayList<String>> dfsVisit(String actual, String destino) {
		ArrayList<ArrayList<String>> solucion = new ArrayList<>();

		if (actual.equals(destino) && !primeraVez) {
			ArrayList<String> out = new ArrayList<String>();
			out.add(actual);
			solucion.add(out);
		} else {
			primeraVez = false;
			if (!actual.equals(destino))
				this.colores.put(actual, "amarillo");
			Iterator<String> it = this.grafo.obtenerAdyacentes(actual);
			while (it.hasNext()) {
				String adyacente = it.next();
				if (this.colores.get(adyacente).equals("blanco")) {
					ArrayList<ArrayList<String>> subcaminosDesdeAdy = dfsVisit(adyacente, destino);
					for (ArrayList<String> subcamino : subcaminosDesdeAdy) {
						subcamino.add(0, actual);
						solucion.add(subcamino);
					}
				}
			}
			colores.put(actual, "blanco");
		}
		return solucion;
	}
}
