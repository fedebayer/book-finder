package biblioteca.busquedas;

import java.util.ArrayList;
import java.util.Iterator;

import biblioteca.Busquedas;

public class Greedy {
	@SuppressWarnings("unused")
	private Busquedas<?> busquedas;
	private ArrayList<String> conjunto;

	public Greedy(Busquedas<?> busquedas) {
		this.busquedas = busquedas;
		this.conjunto = new ArrayList<>();
	}

	public Solucion greedy(ArrayList<String> c) {
		Solucion solucion = new Solucion();
		conjunto = c;

		while (!conjunto.isEmpty()) {
			String x = seleccionar();
			this.conjunto.remove(x);
			solucion.add(x);
		}
		return solucion;
	}

	private String seleccionar() {
		String y = conjunto.get(0);
		if (busquedas.obtenerAdyacentes(y) == null) {
			for (String g : conjunto) {
				if (busquedas.obtenerAdyacentes(g) != null) {
					Iterator<String> it = busquedas.obtenerAdyacentes(g);
					while (it.hasNext()) {
						conjunto.add(it.next());
					}
					return g;
				}

			}
			return y;
		} else {
			Iterator<String> it = busquedas.obtenerAdyacentes(y);
			while (it.hasNext()) {
				conjunto.add(it.next());
			}
			return y;
		}

	}

}
