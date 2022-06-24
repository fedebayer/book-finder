package biblioteca.busquedas.backtracking;

import java.util.Iterator;

import biblioteca.busquedas.Grafo;

public class Back {
	private Grafo<?> grafo;
	private String destino;
	private Solucion mejorSolucion;
	private boolean primeraVez;

	public Back(Grafo<?> grafo) {
		this.grafo = grafo;
	}

	public Solucion back(String destino) {
		String origen = destino;
		this.destino = destino;
		this.mejorSolucion = null;
		this.primeraVez = true;

		Estado estado = new Estado();
		estado.getCaminoActual().agregarAlCamino(origen);
		estado.setPosActual(origen);

		this.back(estado);

		if (mejorSolucion == null)
			return new Solucion(new Camino());
		else
			return this.mejorSolucion;
	}

	public void back(Estado e) {
		if (this.destino.equals(e.getPosActual()) && !primeraVez) {
			if (this.mejorSolucion == null) {
				this.mejorSolucion = new Solucion(e.getCaminoActual());
			}
		} else {
			primeraVez = false;
			Iterator<String> vecinos = grafo.obtenerAdyacentes(e.getPosActual());
			String original = e.getPosActual();
			while (vecinos.hasNext()) {
				String siguiente = vecinos.next();
				if (!e.estaVisitado(siguiente)) {
					e.getCaminoActual().agregarAlCamino(siguiente);
					e.setPosActual(siguiente);
					e.marcarVisitado(siguiente);

					this.back(e);

					e.getCaminoActual().quitarUltimo();
					e.setPosActual(original);
					e.desmarcarVisitado(siguiente);
				}
			}
		}
	}
}
