import java.io.File;
import java.util.Scanner;

public class apartado5 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		 System.out.print("Introduce la ruta del fichero: ");
	        String ruta = entrada.nextLine();

	        File fichero = new File(ruta);

	        if (fichero.exists() && fichero.isFile()) {
	            String permisos = (fichero.canRead() ? "r" : "_") +
	                              (fichero.canWrite() ? "w" : "_") +
	                              (fichero.canExecute() ? "x" : "_");

	            System.out.println("Permisos actuales: " + permisos);

	            if (permisos.equals("rwx")) {
	                System.out.print("Introduce nuevo permiso (r, w o x): ");
	                String opcion = entrada.nextLine();

	                boolean cambiado = false;
	                switch (opcion) {
	                    case "r":
	                        cambiado = fichero.setReadable(false);
	                        break;
	                    case "w":
	                        cambiado = fichero.setWritable(false);
	                        break;
	                    case "x":
	                        cambiado = fichero.setExecutable(false);
	                        break;
	                    default:
	                        System.out.println("Opción inválida.");
	                }

	                if (cambiado) {
	                    System.out.println("Permiso cambiado correctamente.");
	                } else {
	                    System.out.println("No se pudo cambiar el permiso.");
	                }
	            }
	        } else {
	            System.out.println("El fichero no existe.");
	        }
	        entrada.close();
	}

}
