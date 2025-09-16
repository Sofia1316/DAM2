import java.io.File;
import java.util.Scanner;

public class apartado4 {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("Introduce la ruta del directorio: ");
        String ruta = entrada.nextLine();

        File dir = new File(ruta);

        if (dir.exists() && dir.isDirectory()) {
            File[] elementos = dir.listFiles();
            if (elementos != null && elementos.length > 0) {
                for (File elem : elementos) {
                    if (elem.isFile()) {
                        System.out.println("Fichero: " + elem.getName());
                    } else if (elem.isDirectory()) {
                        System.out.println("Directorio: " + elem.getName());
                    }
                }
            } else {
                System.out.println("El directorio vacío");
            }
        } else {
            System.out.println("La ruta no existe");
        }
        entrada.close();

	}

}
