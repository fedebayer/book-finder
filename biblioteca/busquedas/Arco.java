package biblioteca.busquedas;

public class Arco<T> {

	private String verticeOrigen;
	private String verticeDestino;
	private int etiqueta;

	public Arco(String verticeOrigen, String verticeDestino) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = 1;
	}

	public String getVerticeOrigen() {
		return verticeOrigen;
	}

	public String getVerticeDestino() {
		return verticeDestino;
	}

	public int getEtiqueta() {
		return etiqueta;
	}

	public void sum() {
		etiqueta += 1;

	}

}
