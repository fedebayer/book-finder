package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import utils.CSVReader;

public class Main {
	public static void main(String[] args) {
		CSVReader reader = new CSVReader();
		ArrayList<Libro> libros = reader.getData();
		HashSet<String> generos = new HashSet<>();
		for (Libro libro : libros) {
			generos.addAll(libro.getGeneros());
		}

		Biblioteca biblioteca = new Biblioteca();
		for (String genero : generos) {
			biblioteca.createGenero(genero);
		}

		biblioteca.setLibrosToGenero(libros);

		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese genero: ");
		String toSearch = null;
		try {
			toSearch = entrada.readLine();
			List<Libro> librosOfGenero = biblioteca.getLibrosOfGenero(toSearch);
			Iterator<Libro> itr = librosOfGenero.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next().getTitulo());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

