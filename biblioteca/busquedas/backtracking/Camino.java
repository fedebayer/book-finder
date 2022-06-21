package biblioteca.busquedas.backtracking;

import java.util.ArrayList;
import java.util.HashSet;

public class Camino {

	private HashSet<String> visitados;
	private ArrayList<String> camino;

	public Camino() {
		this.visitados = new HashSet<>();
		this.camino = new ArrayList<>();
	}

	public void agregarAlCamino(String genero) {
		this.camino.add(genero);
	}

	public void quitarUltimo() {
		this.camino.remove(this.camino.size() - 1);
	}

	public void marcarVisitado(String genero) {
		this.visitados.add(genero);
	}

	public void quitarVisitado(String genero) {
		this.visitados.remove(genero);
	}

	public boolean estaVisitado(String genero) {
		return this.visitados.contains(genero);
	}

	public ArrayList<String> getCamino() {
		return this.camino;
	}

	public void setCamino(ArrayList<String> generos) {
		this.camino.clear();
		this.camino.addAll(generos);
	}

}