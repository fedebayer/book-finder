package biblioteca.busquedas;

import java.util.ArrayList;
import java.util.Iterator;

import biblioteca.Busquedas;

public class Greedy {
	private Busquedas<?> busquedas;
	private ArrayList<String> conjunto;
	private String anterior;

	public Greedy(Busquedas<?> busquedas) {
		this.busquedas = busquedas;
		this.conjunto = new ArrayList<>();
	}

	public Solucion greedy(ArrayList<String> c, String origen) {
		Solucion solucion = new Solucion();
		conjunto.addAll(c);
		anterior = origen;

		while (!conjunto.isEmpty()) {
			String x = seleccionar(solucion);
			solucion.add(x);
		}
		return solucion;
	}

	private String seleccionar(Solucion solucion) {
		int max = Integer.MIN_VALUE;
		String opcion = null;
		for (String g : conjunto) {
			int temp = busquedas.obtenerArco(anterior, g).getEtiqueta();
			if (temp > max) {
				max = temp;
				opcion = g;
			}
		}
		Iterator<String> it = busquedas.obtenerAdyacentes(opcion);
		if (it.hasNext()) {
			conjunto.clear();
			while (it.hasNext()) {
				String sig = it.next();
				if (!solucion.getSolucion().contains(sig))
					conjunto.add(sig);
			}
		}
		anterior = opcion;
		return opcion;
	}
}