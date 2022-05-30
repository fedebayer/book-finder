package biblioteca;
import java.util.ArrayList;

public class Libro {
	private String titulo;
	private String autor;
	private String cantPaginas;
	private ArrayList<String> generos;
	
	
	public Libro(String titulo, String autor, String cantPaginas) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.cantPaginas = cantPaginas;
		this.generos = new ArrayList<String>();
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCantPaginas() {
		return cantPaginas;
	}
	public void setCantPaginas(String cantPaginas) {
		this.cantPaginas = cantPaginas;
	}
	public ArrayList<String> getGeneros() {
		return generos;
	}
	public void addGenero(String g) {
		if(!generos.contains(g)){
			this.generos.add(g);
		}
	}
	
	@Override
	public String toString() {
		return this.getTitulo();
	}
}
