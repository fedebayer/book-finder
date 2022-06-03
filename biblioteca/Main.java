package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import utils.CSVReader;
import utils.CSVWritter;

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
			CSVWritter writter = new CSVWritter();
			toSearch = entrada.readLine();
			List<Libro> librosOfGenero = biblioteca.getLibrosOfGenero(toSearch);
			Iterator<Libro> itr = librosOfGenero.iterator();

			writter.write(itr);

			Iterator<Libro> itr2 = librosOfGenero.iterator();
			while (itr2.hasNext()) {
				System.out.println(itr2.next().getTitulo());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
