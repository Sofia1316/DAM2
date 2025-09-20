package ej2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ejercicio4 {

	public static void main(String[] args) {
		List<String> planetas = new ArrayList<>();

        // 1. Leer planetas desde el fichero
        try (BufferedReader br = new BufferedReader(new FileReader("planetas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                planetas.add(linea.trim());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return; // salir si no se puede leer el archivo
        }

        // 2. Ordenar alfabeticamente ignorando mayúsculas/minúsculas
        Collections.sort(planetas, String.CASE_INSENSITIVE_ORDER);

        // 3. Mostrar resultado en pantalla
        System.out.println("Planetas ordenados:");
        for (String planeta : planetas) {
            System.out.println(planeta);
        }
	}
}
