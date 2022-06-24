package biblioteca.busquedas.backtracking;

public class Estado {
	private String posActual;
	private Camino caminoActual;

	public Estado() {
		posActual = "";
		caminoActual = new Camino();
	}

	public Camino getCaminoActual() {
		return caminoActual;
	}

	public void setCaminoActual(Camino caminoActual) {
		this.caminoActual = caminoActual;
	}

	public String getPosActual() {
		return posActual;
	}

	public void setPosActual(String posActual) {
		this.posActual = posActual;
	}

	public boolean estaVisitado(String vecino) {
		return this.caminoActual.estaVisitado(vecino);
	}

	public void marcarVisitado(String vecino) {
		this.caminoActual.marcarVisitado(vecino);
	}

	public void desmarcarVisitado(String vecino) {
		this.caminoActual.quitarVisitado(vecino);
	}
}
