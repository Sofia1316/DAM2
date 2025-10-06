package ej2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class ejercicio8 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		 Random random = new Random();

	        System.out.print("Cantidad de números aleatorios: ");
	        int cantidad = entrada.nextInt();
	        entrada.nextLine(); // Limpiar buffer

	        System.out.print("Ruta del fichero: ");
	        String ruta = entrada.nextLine();

	        try (FileWriter fw = new FileWriter(ruta)) {
	            for (int i = 0; i < cantidad; i++) {
	                fw.write((random.nextInt(1000) + 1) + "\n"); // números entre 1 y 1000
	            }
	            System.out.println("Archivo creado correctamente.");
	        } catch (IOException e) {
	            System.out.println("Error: " + e.getMessage());
	        }

        entrada.close();
	}

}
