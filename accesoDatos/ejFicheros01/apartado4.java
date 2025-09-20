package ejercicios00;

import java.io.File;
import java.util.Scanner;

public class apartado4 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Introduce la ruta del directorio: ");
        String ruta = entrada.nextLine();

        File dir = new File(ruta);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("La ruta no existe o no es un directorio");
            entrada.close();
            return;
        }

        File[] elementos = dir.listFiles();
        if (elementos == null || elementos.length == 0) {
            System.out.println("El directorio está vacío");
            entrada.close();
            return;
        }

        for (File elem : elementos) {
            if (elem.isFile()) {
                System.out.println("Fichero: " + elem.getName());
            } else if (elem.isDirectory()) {
                System.out.println("Directorio: " + elem.getName());
            }
        }

        entrada.close();

	}

}
