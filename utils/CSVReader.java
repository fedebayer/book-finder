package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import biblioteca.Biblioteca;
import biblioteca.Busquedas;
import biblioteca.Libro;

public class CSVReader {

	public static void main(String[] args) {
	}

	public CSVReader() {
	}

	public void getData(Biblioteca biblio) {

		ArrayList<Libro> libros = new ArrayList<>();
		ArrayList<String> generos = new ArrayList<>();
		File csvFile = new File("tpe/libros/dataset1.csv");
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				Libro libro = new Libro(items[0], items[1], items[2]);
				String[] aux = items[3].split(" ");
				for (int j = 0; j < aux.length; j++) {
					libro.addGenero(aux[j]);
					if (!generos.contains(aux[j])) {
						generos.add(aux[j]);
						biblio.createGenero(aux[j]);
					}
				}
				libros.add(libro);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		biblio.setLibrosToGenero(libros);
	}

	public void getData2(Busquedas<?> busquedas) {

		ArrayList<String> generos = new ArrayList<>();
		String csvFile = "tpe/libros2/dataset1.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				for (int j = 0; j < items.length; j++) {
					if (!generos.contains(items[j])) {
						generos.add(items[j]);
						busquedas.agregarVertice(items[j]);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getData3(Busquedas<?> busquedas) {

		String csvFile = "tpe/libros2/dataset1.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				for (int j = 0; j < items.length - 2; j++) {
					if (items[j + 1] != null)
						busquedas.agregarArco(items[j], items[j + 1]);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}