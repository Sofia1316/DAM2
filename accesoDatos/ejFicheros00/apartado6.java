import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class apartado6 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		 System.out.print("Introduce el nombre del fichero: ");
	        String nombreFichero = entrada.nextLine();

	        File fichero = new File(nombreFichero);

	        try {
	            if (fichero.exists()) {
	                System.out.println("El fichero ya existe. Ruta: " + fichero.getAbsolutePath());
	            } else {
	                if (fichero.createNewFile()) {
	                    System.out.println("Fichero creado: " + fichero.getAbsolutePath());
	                    // Cambiar a solo lectura
	                    if (fichero.setReadOnly()) {
	                        System.out.println("El fichero ahora es de solo lectura.");
	                    } else {
	                        System.out.println("No se pudo cambiar el permiso.");
	                    }
	                } else {
	                    System.out.println("No se pudo crear el fichero.");
	                }
	            }
	        } catch (IOException e) {
	            System.out.println("Error al crear el fichero.");
	            e.printStackTrace();
	        }

	        entrada.close();

	}

}
