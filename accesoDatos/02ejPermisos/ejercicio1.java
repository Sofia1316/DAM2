package ej2;

import java.io.FileReader;
import java.io.IOException;

public class ejercicio1 {

	public static void main(String[] args) {
		  try (FileReader fr = new FileReader("ejemplo.txt")) {
	            int mensaje;
	            while ((mensaje = fr.read()) != -1) {
	                if (mensaje != ' ') { // omitimos espacios
	                    System.out.print((char) mensaje);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
