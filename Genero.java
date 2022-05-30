import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Genero {
	private String nombre;
	private List<Libro> libros;
	private Genero generoIzquierdo;
	private Genero generoDerecho;
	
	public Genero(String nombre, List<Libro> libros) {
		super();
		this.generoIzquierdo = null;
		this.generoDerecho = null;
		this.nombre = nombre;
		this.libros = libros;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void printNames() {
		Iterator<Libro> itr = libros.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next().toString());
		}
	}
	
	public void addLibro(Libro l) {
		if(!libros.contains(l)){
			this.libros.add(l);
		}
	}

	public Genero getGeneroIzquierdo() {
		return generoIzquierdo;
	}

	public void setGeneroIzquierdo(Genero generoIzquierdo) {
		this.generoIzquierdo = generoIzquierdo;
	}

	public Genero getGeneroDerecho() {
		return generoDerecho;
	}

	public void setGeneroDerecho(Genero generoDerecho) {
		this.generoDerecho = generoDerecho;
	}

	public ArrayList<String> listTilulos(){
		Iterator<Libro> itr = libros.iterator();
		ArrayList<String> lista = new ArrayList<String>();
		while(itr.hasNext()) {
			lista.add(itr.next().getTitulo());
		}
		return lista;
	}
	
}
