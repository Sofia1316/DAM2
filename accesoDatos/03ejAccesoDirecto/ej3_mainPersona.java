package EjsAccesoDirecto;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
Crea un programa que pida datos de personas como el nombre y la edad. 
Para guardar estos datos se define una clase denominada persona y en un fichero binario se guardan varias 
instancias de la persona. Después se debe crear una función que permita mostrar todas las personas que están almacenadas.
 */
public class ej3_mainPersona {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		boolean bandera = true;

		try {
			File fichero = new File("personaEjs.dat");
			fichero.createNewFile();
			RandomAccessFile raf = new RandomAccessFile(fichero, "rw");

			while (bandera) {
				System.out.println("1. Añadir personas");
				System.out.println("2. Mostrar personas");
				System.out.println("3. Salir");
				System.out.print("Opción: ");
				int respuesta = entrada.nextInt();
				entrada.nextLine();

				switch (respuesta) {
				case 1:
					System.out.print("Nombre: ");
					String nombre = entrada.nextLine();

					System.out.print("Edad: ");
					int edad = entrada.nextInt();
					entrada.nextLine();

					raf.writeUTF(nombre);
					raf.writeInt(edad);
					System.out.println("Persona añadida");
					break;
				case 2:
					raf.seek(0);

					System.out.println("Personas:");
					while (raf.getFilePointer() < raf.length()) {
						String nombreL = raf.readUTF();
						int edadL = raf.readInt();
						System.out.println("Nombre: " + nombreL);
						System.out.println("Edad: " + edadL);
					}
					break;

				case 3:
					bandera = false;
					raf.close();
					System.out.println("Saliendo del programa.");
					break;
				default:
					System.out.println("Opción no válida");
				}
			}
		} catch (IOException e) {
			e.getStackTrace();
		}

	}

}
