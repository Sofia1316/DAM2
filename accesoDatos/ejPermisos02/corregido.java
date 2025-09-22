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
	
	public static void ej2() {
		System.out.println("Introduce el nombre del fichero 1");
		String fichero1 = entrada.nextLine();
		System.out.println("Introduce el nombre del fichero 2");
		String fichero2 = entrada.nextLine();
		System.out.println("Introduce el nombre de la ruta");
		String ruta = entrada.nextLine();
		
		File rutaPrograma = new File(ruta);
		if(rutaPrograma.isDirectory() && rutaPrograma.exists()) {
			File fichero1Prog = new File(rutaPrograma,fichero1);
			File fichero2Prog = new File(rutaPrograma,fichero2);
			String nombreNuevo = fichero1 + "_" + fichero2;
			File ficheroNuevo = new File(rutaPrograma, nombreNuevo);
			
			try {
				if(!ficheroNuevo.exists()) {
					ficheroNuevo.createNewFile();
				}
				// abri primer fichero para lectura
				FileReader lecturaf1 = new FileReader(fichero1Prog);
				BufferedReader bufferLectura = new BufferedReader(lecturaf1);
				
				while(bufferLectura.readLine() != null) {
					
				}
			} catch(IOException e) {
				
			}
		}
	}
	
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		ej1();
		ej2();
		entrada.close();
	}

}
