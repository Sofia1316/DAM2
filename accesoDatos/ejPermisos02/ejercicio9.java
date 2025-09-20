package ej2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ejercicio9 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		 System.out.print("Ruta del primer fichero: ");
	        String ruta1 = entrada.nextLine();

	        System.out.print("Ruta del segundo fichero: ");
	        String ruta2 = entrada.nextLine();

	        System.out.print("Nombre del fichero final: ");
	        String ficheroFinal = entrada.nextLine();

	        try (FileWriter fw = new FileWriter(ficheroFinal);
	             BufferedReader br1 = new BufferedReader(new FileReader(ruta1));
	             BufferedReader br2 = new BufferedReader(new FileReader(ruta2))) {

	            String linea;
	            while ((linea = br1.readLine()) != null) {
	                fw.write(linea + "\n");
	            }
	            while ((linea = br2.readLine()) != null) {
	                fw.write(linea + "\n");
	            }

	            System.out.println("Fichero combinado creado correctamente.");

	        } catch (IOException e) {
	            System.out.println("Error al leer o escribir archivos: " + e.getMessage());
	        }

	        entrada.close();

	}

}
