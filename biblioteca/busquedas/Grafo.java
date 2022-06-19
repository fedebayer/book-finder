package biblioteca.busquedas;

import java.util.Iterator;

public interface Grafo<T> {

	// Agrega un vertice
	public void agregarVertice(String verticeId);

	// Borra un vertice
	public void borrarVertice(String verticeId);

	// Agrega un arco con una etiqueta, que conecta el verticeId1 con el verticeId2
	public void agregarArco(String verticeId1, String verticeId2, int etiqueta);

	// Borra el arco que conecta el verticeId1 con el verticeId2
	public void borrarArco(String verticeId1, String verticeId2);

	// Verifica si existe un vertice
	public boolean contieneVertice(String verticeId);

	// Verifica si existe un arco entre dos vertices
	public boolean existeArco(String verticeId1, String verticeId2);

	// Obtener el arco que conecta el verticeId1 con el verticeId2
	public Arco<T> obtenerArco(String verticeId1, String verticeId2);

	// Devuelve la cantidad total de vertices en el grafo
	public int cantidadVertices();

	// Devuelve la cantidad total de arcos en el grafo
	public int cantidadArcos();

	// Obtiene un iterador que me permite recorrer todos los vertices almacenados en
	// el grafo
	public Iterator<String> obtenerVertices();

	// Obtiene un iterador que me permite recorrer todos los vertices adyacentes a
	// verticeId
	public Iterator<String> obtenerAdyacentes(String verticeId);

	// Obtiene un iterador que me permite recorrer todos los arcos del grafo
	public Iterator<Arco<T>> obtenerArcos();

	// Obtiene un iterador que me permite recorrer todos los arcos que parten desde
	// verticeId
	public Iterator<Arco<T>> obtenerArcos(String verticeId);

}
