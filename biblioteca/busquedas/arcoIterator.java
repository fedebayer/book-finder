package biblioteca.busquedas;

import java.util.Iterator;

public class arcoIterator<T> implements Iterator<String> {

	private Iterator<Arco<T>> it;

	public arcoIterator(Iterator<Arco<T>> IteradorArco) {
		this.it = IteradorArco;
	}

	@Override
	public boolean hasNext() {

		return it.hasNext();
	}

	@Override
	public String next() {

		return it.next().getVerticeDestino();
	}

}
