package biblioteca.busquedas;

import java.util.ArrayList;

import biblioteca.Busquedas;

public class Greedy {
	public Solucion greedy(ArrayList<String> Conjunto, Busquedas<String> busquedas) {
		Solucion solucion = new Solucion();

		while (!Conjunto.isEmpty()) {
			String x = seleccionar(Conjunto, busquedas);
			Conjunto.remove(x);
			solucion.add(x);
		}
		return solucion;
	}

	private String seleccionar(ArrayList<String> c, Busquedas<String> busquedas) {
		String y = c.get(0);
		if (busquedas.obtenerAdyacentes(y) == null) {
			for (String g : c) {
				if (busquedas.obtenerAdyacentes(g) != null)
					return g;
			}
		}
		return y;
	}

}
