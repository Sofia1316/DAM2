package ej2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ejercicio5 {

	public static void main(String[] args) {
		 List<String> palabras = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sofia\\Downloads\\prueba\\planetas.txt"))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                String[] partes = linea.trim().split("\\s+");
	                for (String palabra : partes) {
	                    palabras.add(palabra);
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Error al leer el archivo: " + e.getMessage());
	            return;
	        }

	        // Ordenar alfabéticamente ignorando mayúsculas/minúsculas con un solo for interno de Collections.sort
	        Collections.sort(palabras, (a, b) -> a.compareToIgnoreCase(b));

	        System.out.println("Palabras ordenadas:");
	        for (String palabra : palabras) {
	            System.out.println(palabra);
	        }

	}

}
