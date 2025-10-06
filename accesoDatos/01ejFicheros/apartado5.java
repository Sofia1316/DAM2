package ejercicios00;

import java.io.File;
import java.util.Scanner;

public class apartado5 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		 System.out.print("Introduce la ruta del fichero: ");
	        String ruta = entrada.nextLine();

	        File fichero = new File(ruta);

	        if (!fichero.exists() || !fichero.isFile()) {
	            System.out.println("El fichero no existe o no es válido");
	            entrada.close();
	            return;
	        }

	        String permisos = (fichero.canRead() ? "r" : "_") + (fichero.canWrite() ? "w" : "_") + (fichero.canExecute() ? "x" : "_");
	        System.out.println("Permisos actuales: " + permisos);

	        if (!permisos.equals("rwx")) {
	            entrada.close();
	            return;
	        }

	        System.out.print("Introduce nuevo permiso (r, w o x): ");
	        String opcion = entrada.nextLine();

	        boolean cambiado = switch (opcion) {
	            case "r" -> fichero.setReadable(false);
	            case "w" -> fichero.setWritable(false);
	            case "x" -> fichero.setExecutable(false);
	            default -> {
	                System.out.println("Opción inválida.");
	                yield false;
	            }
	        };

	        if (cambiado) {
	            System.out.println("Permiso cambiado");
	        } else {
	            System.out.println("No se puede cambiar");
	        }
	        entrada.close();
	}

}
