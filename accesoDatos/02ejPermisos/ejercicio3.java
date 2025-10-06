package ej2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio3 {
	public static void main(String[] args) {
		 String ruta = "C:\\Users\\sofia\\Downloads\\prueba\\Restaurants.csv";

	        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
	            // La primera línea son las cabeceras
	            String linea = br.readLine();
	            String[] cabeceras = linea.split(",");

	            // Leemos el resto del fichero
	            while ((linea = br.readLine()) != null) {
	                String[] valores = linea.split(",");

	                // Emparejamos campo:valor
	                for (int i = 0; i < cabeceras.length && i < valores.length; i++) {
	                    System.out.println(cabeceras[i] + ": " + valores[i]);
	                }
	                System.out.println("------"); // separador entre registros
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
