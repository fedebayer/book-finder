package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import biblioteca.Libro;

public class CSVWritter {

	public void write(Iterator<Libro> libros) {
		BufferedWriter bw = null;
		try {
			if (!libros.hasNext()) {
				return;
			}
			File file = new File("tpe/libros/salida.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write("Titulo");
			bw.newLine();

			while (libros.hasNext()) {
				String linea = "";
				linea += libros.next().toString();
				bw.write(linea);
				bw.newLine();
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}