package biblioteca.busquedas;

import java.util.ArrayList;
import java.util.Iterator;

import biblioteca.Busquedas;

public class Greedy {
	private Busquedas<?> busquedas;
	private ArrayList<String> conjunto;

	public Greedy(Busquedas<?> busquedas) {
		this.busquedas = busquedas;
		this.conjunto = new ArrayList<>();
	}

	public Solucion greedy(ArrayList<String> c) {
		Solucion solucion = new Solucion();
		conjunto.addAll(c);

		while (!conjunto.isEmpty()) {
			String x = seleccionar(solucion);
			solucion.add(x);
		}
		return solucion;
	}

	private String seleccionar(Solucion solucion) {
		String y = conjunto.get(0);
		Iterator<String> it = busquedas.obtenerAdyacentes(y);

		if (it.hasNext()) {
			conjunto.clear();
			while (it.hasNext()) {
				String sig = it.next();
				if (!solucion.getSolucion().contains(sig))
					conjunto.add(sig);
			}
			return y;

		} else {
			for (String g : conjunto) {
				Iterator<String> it2 = busquedas.obtenerAdyacentes(g);
				if (it2.hasNext()) {
					conjunto.clear();
					while (it2.hasNext()) {
						String sig = it2.next();
						if (!solucion.getSolucion().contains(sig))
							conjunto.add(sig);
					}
					return g;
				}
			}
			return y;
		}
	}
}
