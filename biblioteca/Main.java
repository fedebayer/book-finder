package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import biblioteca.busquedas.Arco;
import biblioteca.busquedas.DFS;
import biblioteca.busquedas.Greedy;
import utils.CSVReader;
import utils.CSVWritter;

public class Main {
	public static <T> void main(String[] args) {

		CSVReader reader = new CSVReader();

		////////////////////////////////////////////////////////////////////////////
		// Parte 1
		////////////////////////////////////////////////////////////////////////////
		/*
		Biblioteca biblioteca = new Biblioteca();
		reader.getData(biblioteca);

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
		*/
		//////////////////////////////////////////////////////////////////////////////
		// Parte 2
		//////////////////////////////////////////////////////////////////////////////
		// Punto 1
		Busquedas<String> busquedas = new Busquedas<>();
		reader.getData2(busquedas);

		System.out.println(" Vertices de grafo busquedas: \n");
		Iterator<String> vertices = busquedas.obtenerVertices();
		while (vertices.hasNext()) {
			System.out.println(vertices.next());
		}

		// Punto 2
		// Usar Dataset2 para ver mejor los arcos, ya que en el Dataset1 todas las
		// etiquetas de los arcos son 1.
		reader.getData3(busquedas);

		System.out.println("\n Arcos de grafo busquedas: \n");
		Iterator<Arco<String>> arcos = busquedas.obtenerArcos();

		while (arcos.hasNext()) {
			Arco<String> arco = arcos.next();
			System.out.println("origen: " + arco.getVerticeOrigen());
			System.out.println("destino: " + arco.getVerticeDestino());
			System.out.println("etiqueta: " + arco.getEtiqueta());
		}

		System.out.println("\n Adyacentes de genero 'terror': \n");
		Iterator<String> adyacentes = busquedas.obtenerAdyacentes("terror");
		while (adyacentes.hasNext()) {
			System.out.println(adyacentes.next());
		}

		BufferedReader entrada2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\n Ingrese genero: ");
		String toSearch2 = "";
		try {
			toSearch2 = entrada2.readLine();
			/// Punto 3//////////
			
			ArrayList<String> generosBuscados = busquedas.generosBuscadosAfter(toSearch2);
			if (generosBuscados != null) {
				System.out.println("\n Generos mas buscados luego del genero ingresado: \n");
				for (String g : generosBuscados) {
					System.out.println(g);
				}
			}

			//// Punto 4//////

			ArrayList<String> secuenciaDeMayorValor = busquedas.getSecuenciaGeneros(toSearch2);
			if (secuenciaDeMayorValor != null) {
				System.out.println(
						"\n\n Secuencia de generos de mayor valor de busqueda a partir del genero ingresado: \n");
				System.out.println(secuenciaDeMayorValor);
			}
			//// Punto 5////

			System.out.println("\n Vetices del grafo nuevo \n");
			Iterator<String> vertices2 = busquedas.getGrafoGenerosAfines(toSearch2).obtenerVertices();
			while (vertices2.hasNext()) {
				System.out.println(vertices2.next());

			}


		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
