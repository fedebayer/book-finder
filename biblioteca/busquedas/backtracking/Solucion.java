package biblioteca.busquedas.backtracking;

import java.util.ArrayList;

public class Solucion {
	private Camino camino;
	private ArrayList<String> camino2;

	public Solucion(Camino caminoActual) {
		this.camino = caminoActual;
		this.camino2 = new ArrayList<String>(caminoActual.getCamino());
	}

	public Camino getCamino() {
		return camino;
	}

	public ArrayList<String> getCamino2() {
		return camino2;
	}
}
