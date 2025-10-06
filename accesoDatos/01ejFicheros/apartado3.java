package ejercicios00;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class apartado3 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		 System.out.print("Introduce el nombre del directorio: ");
	        String dirName = entrada.nextLine();

	        System.out.print("Introduce el nombre del fichero: ");
	        String fileName = entrada.nextLine();

	        File directorio = new File(dirName);
	        
	        if (!directorio.exists() && !directorio.mkdir()) {
	            System.out.println("No se pudo crear el directorio");
	            entrada.close();
	            return;
	        }
	        if (!directorio.exists()) {
	            System.out.println("No existe el directorio y no se pudo crear");
	            entrada.close();
	            return;
	        }

	        File fichero = new File(directorio, fileName);
	        
	        try {
	            if (fichero.createNewFile()) {
	                System.out.println("Fichero creado correctamente: " + fichero.getAbsolutePath());
	            } else {
	                System.out.println("El fichero ya existe");
	            }
	        } catch (IOException e) {
	            System.out.println("Error al crear el fichero");
	            e.printStackTrace();
	        }

	        entrada.close();

	}

}
