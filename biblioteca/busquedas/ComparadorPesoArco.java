package biblioteca.busquedas;

import java.util.Comparator;

import biblioteca.Busquedas;

public class ComparadorPesoArco<T> implements Comparator<String> {
	String padre;
	Busquedas<T> busquedas;

	public ComparadorPesoArco(String padre, Busquedas<T> busquedas) {
		this.padre = padre;
		this.busquedas = busquedas;
	}

	@Override
	public int compare(String s1, String s2) {
		return busquedas.obtenerArco(padre, s1).getEtiqueta() - busquedas.obtenerArco(padre, s2).getEtiqueta();
	}
}
