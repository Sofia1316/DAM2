import java.io.File;
import java.util.Scanner;

public class apartado2 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Introduce la ruta del fichero: ");
        String ruta = entrada.nextLine();

        File fichero = new File(ruta);

        if (fichero.exists() && fichero.isFile()) {
            if (fichero.delete()) {
                System.out.println("Fichero borrado correctamente.");
            } else {
                System.out.println("No se pudo borrar el fichero.");
            }
        } else {
            System.out.println("El fichero no existe.");
        }
        entrada.close();

	}

}
