package biblioteca.busquedas;

/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
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
