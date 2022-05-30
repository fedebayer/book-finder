import java.util.ArrayList;

public class Libro {
	private String titulo;
	private String autor;
	private Integer cantPaginas;
	private ArrayList<String> generos;
	
	
	public Libro(String titulo, String autor, Integer cantPaginas, ArrayList<String> generos) {
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
	public Integer getCantPaginas() {
		return cantPaginas;
	}
	public void setCantPaginas(Integer cantPaginas) {
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
