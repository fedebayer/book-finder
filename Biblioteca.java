import java.util.ArrayList;

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
		}
		else {
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
		Genero g = hasElem(genero);
		if(g != null){
			resultado = g.listTilulos();
		}
		return resultado;
	}
	
	public Genero hasElem(String g) {
		return checkForValue(g, this.generoRaiz);
	}
	
	private Genero checkForValue(String g, Genero actual) {
		if (actual != null) {
			if (actual.getNombre() == g) {
				return actual;
			} else {
				if(actual.getNombre().compareTo(g) < 0) {
					return checkForValue(g, actual.getGeneroIzquierdo());
				}
				else {
					 checkForValue(g, actual.getGeneroDerecho());
				}
			}
			
		} 
		return null;
	}
}