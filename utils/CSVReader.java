package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

	public static void main(String[] args) {
		String csvFile = "[PATH-AL-ARCHIVO]/dataset.csv";
		String line = "";
		String cvsSplitBy = ";";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				@SuppressWarnings("unused")
				String[] items = line.split(cvsSplitBy);

				// ---------------------------------------------
				// Poner el codigo para cargar los datos
				// ---------------------------------------------

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}