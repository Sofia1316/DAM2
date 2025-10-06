package ejercicios01;

import java.io.*;
import java.util.Scanner;

/*
Se quiere crear un programa que gestione productos con las siguientes
características y que se almacene en un fichero binario (hazlo sin clases).
Cada producto tiene:ID (int),Cantidad en stock (int),Precio (double)
	a. Almacenar productos
	b. Visualizar productos (la lista entera)
	c. Visualizar los datos de un producto concreto basado en su ID
	d. Borrar productos dado un ID
	e. Modificar los campos de un producto (Cantidad y precio)
Los ID son contiguos para ayudar a la gestión
 */
public class ej2_gestionProductos {
	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		menu();
	}
	
	static void menu() {		
		boolean bandera = true;
		
		try {
			File fichero = new File("gestionProductsEjs.dat");
			fichero.createNewFile();
			RandomAccessFile raf = new RandomAccessFile(fichero, "rw");
			
			while(bandera) {
				System.out.println();
				System.out.println("1. Almacenar productos\r\n"
					+ "2. Visualizar productos (la lista entera)\r\n"
					+ "3. Visualizar los datos de un producto concreto basado en su ID\r\n"
					+ "4. Borrar productos dado un ID\r\n"
					+ "5. Modificar los campos de un producto (Cantidad y precio)\r\n"
					+ "6. Salir del programa");
				System.out.println("Que quieres hacer?");
				int respuesta = entrada.nextInt();
				
				switch(respuesta) {
				case 1:
					System.out.println("Introduce el id: ");
					int id = entrada.nextInt();
					System.out.println("Introduce el stock: ");
					int stock = entrada.nextInt();
					System.out.println("Precio: ");
					double precio = entrada.nextDouble();
					
					//raf.seek(raf.length()); // cada producto son 16 bytes
                    raf.writeInt(id);
                    raf.writeInt(stock);
                    raf.writeDouble(precio);
	                    
	                System.out.println("Producto añadido");    
					break;
				case 2:
					System.out.println("Lista de productos:");
					raf.seek(0); // volvemos a la posición 0 del archivo
					while (raf.getFilePointer() < raf.length()) { // mientras que el puntero del archivo sea menor que la longuitud del archivo
				        int prodId = raf.readInt();
				        int prodStock = raf.readInt();
				        double prodPrecio = raf.readDouble();
				        
				        System.out.println("ID: " + prodId + " Stock: " + prodStock + " Precio: " + prodPrecio);
				    }
					break;
				case 3:
					System.out.print("Introduce el id: ");
					int respID = entrada.nextInt();
					raf.seek(0);
					raf.seek(respID * 16);
					while (raf.getFilePointer() < raf.length()) { // mientras que el puntero del archivo sea menor que la longuitud del archivo
						int prodId = raf.readInt();
				        int prodStock = raf.readInt();
				        double prodPrecio = raf.readDouble();
				        
				        System.out.println("ID: " + prodId + " Stock: " + prodStock + " Precio: " + prodPrecio);
				    }
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				default:
					System.out.println("Saliendo del programa");
					bandera = false;
				}
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
		
	}

}
