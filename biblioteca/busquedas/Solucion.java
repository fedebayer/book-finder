package biblioteca.busquedas;

import java.util.ArrayList;

public class Solucion {
	private ArrayList<String> candidatos;

	public Solucion() {
		this.candidatos = new ArrayList<>();
	}

	public void add(String x) {
		this.candidatos.add(x);
	}

	public ArrayList<String> getSolucion() {
		return this.candidatos;
	}
}
