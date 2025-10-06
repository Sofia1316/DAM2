package EjsAccesoDirecto;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class ej4_libreria {
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		boolean bandera = true;

		try {
			File fichero = new File("libreriaEjs.dat");
			fichero.createNewFile();
			RandomAccessFile raf = new RandomAccessFile(fichero, "rw");

			while (bandera) {
				System.out.println("\n1. Insertar libro");
				System.out.println("2. Listar libros");
				System.out.println("3. Ordenar libros por precio");
				System.out.println("4. Filtrar por rango de precio");
				System.out.println("5. Salir");
				System.out.print("Elige una opción: ");
				int opcion = entrada.nextInt();
				entrada.nextLine();

				switch (opcion) {
				case 1:
					System.out.print("Título: ");
					String titulo = entrada.nextLine();
					System.out.print("Autor: ");
					String autor = entrada.nextLine();
					System.out.print("Precio: ");
					double precio = entrada.nextDouble();
					entrada.nextLine();

					raf.seek(raf.length());
					raf.writeUTF(titulo);
					raf.writeUTF(autor);
					raf.writeDouble(precio);

					System.out.println("Libro añadido");
					break;

				case 2:
					raf.seek(0);
					System.out.println("\nListado de libros:");
					while (raf.getFilePointer() < raf.length()) {
						String t = raf.readUTF();
						String a = raf.readUTF();
						double p = raf.readDouble();
						System.out.println("Título: " + t);
						System.out.println("Autor: " + a);
						System.out.println("Precio: " + p);
						System.out.println("---");
					}
					break;

				case 3:
					ArrayList<String[]> listaLibros = new ArrayList<>();
					raf.seek(0);
					while (raf.getFilePointer() < raf.length()) {
						String t = raf.readUTF();
						String a = raf.readUTF();
						double p = raf.readDouble();
						listaLibros.add(new String[] { t, a, Double.toString(p) });
					}

					// Ordenar con burbuja por precio
					for (int i = 0; i < listaLibros.size() - 1; i++) {
						for (int j = i + 1; j < listaLibros.size(); j++) {
							double precioI = Double.parseDouble(listaLibros.get(i)[2]);
							double precioJ = Double.parseDouble(listaLibros.get(j)[2]);
							if (precioI > precioJ) {
								String[] temp = listaLibros.get(i);
								listaLibros.set(i, listaLibros.get(j));
								listaLibros.set(j, temp);
							}
						}
					}

					raf.setLength(0); // borrar contenido
					for (String[] libro : listaLibros) {
						raf.writeUTF(libro[0]);
						raf.writeUTF(libro[1]);
						raf.writeDouble(Double.parseDouble(libro[2]));
					}

					System.out.println("Libros ordenados por precio");
					break;

				case 4:
					System.out.print("Precio mínimo: ");
					double min = entrada.nextDouble();
					System.out.print("Precio máximo: ");
					double max = entrada.nextDouble();
					entrada.nextLine();

					raf.seek(0);
					System.out.println("\nLibros en el rango " + min + " - " + max + ":");
					while (raf.getFilePointer() < raf.length()) {
						String t = raf.readUTF();
						String a = raf.readUTF();
						double p = raf.readDouble();
						if (p >= min && p <= max) {
							System.out.println("Título: " + t);
							System.out.println("Autor: " + a);
							System.out.println("Precio: " + p);
							System.out.println("---");
						}
					}
					break;

				case 5:
					bandera = false;
					raf.close();
					System.out.println("Saliendo del programa.");
					break;

				default:
					System.out.println("Opción no válida");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
