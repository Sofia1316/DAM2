package ejerciciosCasa00;

import java.io.*;
import java.util.*;

public class ej4 {

	public static void main(String[] args) {
		List<String> planetas = new ArrayList<>();
		String ruta = "C:\\Users\\DAM\\eclipse-workspace\\AccesoADatos\\txt\\planetas.txt";

        // 1. Leer planetas desde el fichero
        try (BufferedReader buff = new BufferedReader(new FileReader(ruta))) { // leemos el arhivo por lineas
            String linea;
            while ((linea = buff.readLine()) != null) { // devuelve cada linea del archivo hasta que llega a null
                planetas.add(linea.trim()); // el trim elimina los espacios antes y después, además mete cada linea (cada planeta) en la lista
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        // 2. Ordenar alfabeticamente 
        Collections.sort(planetas);

        // 3. Mostrar resultado en pantalla
        System.out.println("Planetas ordenados:");
        for (String planeta : planetas) {
            System.out.println(planeta);
        }

	}

}
