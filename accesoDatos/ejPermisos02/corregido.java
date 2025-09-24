package ejercicios00;

import java.io.*;
import java.util.Scanner;

public class apartado2 {
	
	public static boolean esPrimo(int num) {
		boolean primo = true;
		if(num>2) {
			for(int i=2; i<=Math.sqrt(num);i++) {
				if(num%i==0) {
					primo = false;
				}
			}
		}
		return primo;
	}

	public static void ej1() {
		String rutafichero = "primos.txt";
		File fichero = new File(rutafichero);
		try {
			//En en el caso de no existir el fichero
			if(!fichero.exists()) {
				fichero.createNewFile(); // lo creamos
			}
			//Sé que existe el fichero
			FileWriter aperturaEscritura = new FileWriter(fichero);
			BufferedWriter ficheroEscritura = new BufferedWriter(aperturaEscritura);
			
			for(int i = 2; i <=500;i++) {
				// si es primo
				if(esPrimo(i))
				ficheroEscritura.write(String.valueOf(i));
				ficheroEscritura.newLine();
			}
			System.out.println("hecho");
			ficheroEscritura.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void escribirFicheros(String linea, File ficheroEscritura) {
		// 5.1 Abrir fichero para escritura
		try {
			FileWriter fe = new FileWriter(ficheroEscritura, true); // para que no te sobreescriba en la misma línea todo, ponemos un segundo parámetro true para que haga de salto de línea
			BufferedWriter Escritura = new BufferedWriter(fe);
			
			Escritura.write(linea);
			// inserta salto de linea
			Escritura.newLine();
			// cerramos
			Escritura.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void lecturaFichero(File fichero, File ficheroEscritura) {
		try {
			// abro el primer fichero para lectura
			FileReader lecturaf1 = new FileReader(fichero);
			BufferedReader bufferLectura = new BufferedReader(lecturaf1);
			
			String linea;
			while((linea=bufferLectura.readLine()) != null) {
				// leo las lineas
				System.out.println(linea);
				// 5. la llamada a la escritura del fichero
				escribirFicheros(linea, ficheroEscritura);
			}
			bufferLectura.close(); // cuando ya ha leído todo, debemos de liberarlo (MUY IMPORTANTE!!)
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ej9() {
		// 1. Pido datos al usuario
		System.out.println("Introduce el nombre del fichero 1");
		String fichero1 = entrada.nextLine();
		System.out.println("Introduce el nombre del fichero 2");
		String fichero2 = entrada.nextLine();
		System.out.println("Introduce el nombre de la ruta");
		String ruta = entrada.nextLine();
		
		// 2. comprobamos que el directorio existe o que es un directorio
		File rutaPrograma = new File(ruta);
		if(rutaPrograma.isDirectory() && rutaPrograma.exists()) {
			
			// 3. comprobar que los ficheros existen y crear un nuevo fichero
			// 3.1 creamos el objeto File -> fichero1, fichero2, nuevoFichero
			File fichero1Prog = new File(rutaPrograma,fichero1);
			File fichero2Prog = new File(rutaPrograma,fichero2);
			String nombreNuevo = fichero1 + "_" + fichero2;
			File ficheroNuevo = new File(rutaPrograma, nombreNuevo);
			
			//3.2 comprobar que fichero 1 y 2 existen y son archivos
			if(fichero1Prog.exists() && fichero1Prog.isFile() && fichero2Prog.isFile() && fichero2Prog.exists()) {
				try {
					if(!ficheroNuevo.exists()) { // 3.3 crear el nuevo fichero
						ficheroNuevo.createNewFile();
					}
					// 4. abrir fichero para lectura - hacemos una función arriba
					lecturaFichero(fichero1Prog, ficheroNuevo);
					lecturaFichero(fichero2Prog, ficheroNuevo);
				} catch(IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Los ficheros no existen o son directorios");
			}
		} else {
			System.out.println("El directorio introducido no existe");
		}
	}
	
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("¿Que ej quieres hacer?");
		int num = entrada.nextInt();
		entrada.nextLine();
		
		switch(num) {
		case 1:
			ej1();
			break;
		case 9:
			ej9();
			break;
		}
		entrada.close();
	}

}
