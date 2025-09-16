import java.io.File;
import java.util.Scanner;

public class apartado1 {
	static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Introduce la ruta del directorio: ");
        String ruta = entrada.nextLine();

        File dir = new File(ruta);

        if (dir.exists() && dir.isDirectory()) {
            String[] elementos = dir.list();
            if (elementos != null && elementos.length > 0) {
                System.out.println("Elementos del directorio:");
                for (String elem : elementos) {
                    System.out.println(elem);
                }
            } else {
                System.out.println("El directorio está vacío.");
            }
        } else {
            System.out.println("La ruta no existe o no es un directorio.");
        }
        entrada.close();
    }
}
