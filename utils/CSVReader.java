package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import biblioteca.Libro;

public class CSVReader {
	
	public static void main(String[] args) {
		
	}
	
	public ArrayList<Libro> getData() {
		
		ArrayList<Libro> libros = new ArrayList<Libro>();
		String csvFile = "./libros/dataset1.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				String[] items = line.split(cvsSplitBy);
				Libro libro = new Libro(items[0],items[1],items[2]);
			        String []aux = items[3].split(" ");
			            for(int j = 0; j < aux.length; j++){
			                libro.addGenero(aux[j]);
		            }
			     libros.add(libro);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return libros;
	}

}