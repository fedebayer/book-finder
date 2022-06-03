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
			File file = new File("./libros/salida.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write("Titulo , Autor, Paginas, Generos");
			bw.newLine();

			while (libros.hasNext()) {
				Libro libro = libros.next();
				String linea = "";
				linea += libro.toString();
				linea += " ," + libro.getAutor();
				linea += " ," + libro.getCantPaginas();
				String generos = "";
				for (String g : libro.getGeneros()) {
					generos += " " + g;
				}
				linea += " ," + generos;
				linea = linea.replace("[", "");
				linea = linea.replace("]", "");
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