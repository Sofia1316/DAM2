package ej2;

import java.io.FileWriter;
import java.io.IOException;

public class ejercicio6 {

	public static void main(String[] args) {
		  try (FileWriter fw = new FileWriter("primos.txt")) {
	            for (int i = 2; i <= 500; i++) {
	                if (esPrimo(i)) {
	                    fw.write(i + "\n");
	                }
	            }
	            System.out.println("Archivo primos.txt creado");
	        } catch (IOException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    private static boolean esPrimo(int n) {
	        if (n < 2) return false;
	        for (int i = 2; i <= Math.sqrt(n); i++) {
	            if (n % i == 0) return false;
	        }
	        return true;

	}

}
