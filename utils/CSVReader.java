package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import biblioteca.Libro;

public class CSVReader {

	public static void main(String[] args) {
	}

	public ArrayList<Libro> getData() {

		ArrayList<Libro> libros = new ArrayList<Libro>();
		String csvFile = "tpe/libros/dataset1.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				Libro libro = new Libro(items[0], items[1], items[2]);
				String[] aux = items[3].split(" ");
				for (int j = 0; j < aux.length; j++) {
					libro.addGenero(aux[j]);
				}
				libros.add(libro);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return libros;
	}

	public HashSet<String> getData2() {

		HashSet<String> generos = new HashSet<>();
		String csvFile = "tpe/libros2/dataset1.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				for (int j = 0; j < items.length; j++) {
					generos.add(items[j]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return generos;
	}

	public ArrayList<ArrayList<String>> getData3() {

		ArrayList<ArrayList<String>> lineasGeneros = new ArrayList<>();
		String csvFile = "tpe/libros2/dataset2.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				ArrayList<String> lineaGeneros = new ArrayList<>();

				String[] items = line.split(cvsSplitBy);
				for (int j = 0; j < items.length; j++) {
					lineaGeneros.add(items[j]);
				}
				lineasGeneros.add(lineaGeneros);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lineasGeneros;
	}

}