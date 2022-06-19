package biblioteca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Biblioteca {
	private Genero generoRaiz;

	public Biblioteca() {
		super();
		this.generoRaiz = null;
	}

	public Genero getGeneroRaiz() {
		return generoRaiz;
	}

	public void addGenero(Genero g) {
		if (this.generoRaiz == null) {
			this.generoRaiz = g;
		} else {
			this.add(this.generoRaiz, g);
		}
	}

	private void add(Genero actual, Genero g) {
		if (actual.getNombre().compareTo(g.getNombre()) < 0) {
			if (actual.getGeneroIzquierdo() == null) {
				actual.setGeneroIzquierdo(g);
			} else {
				add(actual.getGeneroIzquierdo(), g);
			}
		} else if (actual.getNombre().compareTo(g.getNombre()) > 0) {
			if (actual.getGeneroDerecho() == null) {
				actual.setGeneroDerecho(g);
			} else {
				add(actual.getGeneroDerecho(), g);
			}
		}
	}

	public ArrayList<String> searchByGenero(String genero) {
		ArrayList<String> resultado = new ArrayList<String>();
		Genero g = getGenero(genero);
		if (g != null) {
			resultado = g.listTilulos();
		}
		return resultado;
	}

	public Genero getGenero(String g) {
		return searchGenero(g, this.generoRaiz);
	}

	public Genero searchGenero(String g, Genero actual) {
		Genero aux = null;
		if (actual != null) {
			if (actual.getNombre().compareTo(g) == 0) {
				aux = actual;
			} else if (actual.getNombre().compareTo(g) < 0) {
				if (actual.getGeneroIzquierdo() != null) {
					return searchGenero(g, actual.getGeneroIzquierdo());
				}
			} else {
				if (actual.getGeneroDerecho() != null) {
					return searchGenero(g, actual.getGeneroDerecho());
				}
			}

		}
		return aux;
	}

	public void createGenero(String g) {
		Genero genero = new Genero(g);
		addGenero(genero);
	}

	public void setLibrosToGenero(ArrayList<Libro> libros) {
		for (Libro libro : libros) {
			for (String genero : libro.getGeneros()) {
				if (getGenero(genero) != null) {
					getGenero(genero).addLibro(libro);
				}
			}
		}
	}

	public List<Libro> getLibrosOfGenero(String g) {
		if (getGenero(g) == null) {
			return new LinkedList<Libro>();
		}
		return (List<Libro>) getGenero(g).getLibros();
	}

}