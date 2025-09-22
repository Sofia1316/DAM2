package ejercicios00;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class apartado1 {
	
	public static void ej1() {
		System.out.print("Introduce la ruta del directorio: ");
		String ruta = entrada.nextLine();
		
		File dir = new File(ruta);
		
		if (!dir.exists() || !dir.isDirectory()) {
		    System.out.println("La ruta no existe");
		    entrada.close();
		    return;
		}
		
		String[] elementos = dir.list();
		if (elementos == null || elementos.length == 0) {
		    System.out.println("El directorio está vacío.");
		    entrada.close();
		    return;
		}
		
		System.out.println("Elementos del directorio:");
		for (String elem : elementos) {
		    System.out.println(elem);
		}
	}
	
	public static void ej2() {
		System.out.print("Introduce la ruta del fichero: ");
        String ruta = entrada.nextLine();

        File fichero = new File(ruta);

        if (!fichero.exists() || !fichero.isFile()) {
            System.out.println("El fichero no existe");
            entrada.close();
            return;
        }

        if (fichero.delete()) {
            System.out.println("borrado");
        } else {
            System.out.println("No se pudo borrar");
        }
	}
	
	public static void ej3() {
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

	}
	
	public static void ej4() {
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
	}
	
	static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
    	//ej1();
    	//ej2();
    	//ej3();
    	ej4();
    	entrada.close();
    }
}
