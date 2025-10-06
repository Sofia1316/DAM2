package EjsAccesoDirecto;

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
						
						if (prodId != -1) { // mostramos solo los que no están borrados, ya que java pone el id en -1 si está borrado
					        System.out.println("ID: " + prodId + " Stock: " + prodStock + " Precio: " + prodPrecio);
					    }
					}
					break;
				case 3:
					System.out.print("Introduce el id: ");
					int respID = entrada.nextInt();
					
					int posicion = ((respID - 1) * 16); // lo multiplico por 16 porque cada producto tiene 16 bytes,pero le resto 1 porque empieza en 0 el posicionamiento
					raf.seek(posicion); // posicionamos el puntero en donde está el ID del producto pedido
					
					if(posicion >= raf.length()) { // si el puntero en el que se encuentra la posición es "mayor" a la longuitud total del archivo, no es válido
						System.out.println("No válido");
					} else { // de si entrar dentro del límite
						int prodId = raf.readInt();
				        int prodStock = raf.readInt();
				        double prodPrecio = raf.readDouble();
				        
				        System.out.println("ID: " + prodId + " Stock: " + prodStock + " Precio: " + prodPrecio);
					}
					break;
				case 4:
					System.out.print("Introduce el id para borrar: ");
					int borrarID = entrada.nextInt();
					
					int posicionBorrar = ((borrarID - 1) * 16); // lo multiplico por 16 porque cada producto tiene 16 bytes,pero le resto 1 porque empieza en 0 el posicionamiento
					raf.seek(posicionBorrar); // posicionamos el puntero en donde está el ID del producto pedido
					
					if(posicionBorrar >= raf.length()) { // si el puntero en el que se encuentra la posición es "mayor" a la longuitud total del archivo, no es válido
						System.out.println("No válido");
					} else { // de si entrar dentro del límite
						raf.writeInt(-1); // borro el id del producto
						raf.writeInt(0); // pongo el stock a 0
				        raf.writeDouble(0.0); // y el precio también a 0
				        
				        System.out.println("Producto con id " + borrarID + " ha sido borrado");
					}
					break;
				case 5:
					System.out.println("Introduce el id del producto que quieres cambiar: ");
					int prod = entrada.nextInt();
					
					int productoPosicion = ((prod - 1) * 16);
					if(productoPosicion >= raf.length()) {
						System.out.println("Este producto no existe");
					} else {
						raf.seek(productoPosicion); 
						int ID = raf.readInt();
						
						// Miramos si está borrado o si existe
						if(ID != prod || ID == -1) {
							System.out.println("No se puede modificar");
						} else {
							int stockAhora = raf.readInt();
							double precioAhora = raf.readDouble();
							
							System.out.println("Stock actual: " + stockAhora);
							System.out.println("Precio actual: " + precioAhora);
							
							System.out.println("Stock nuevo: ");
							int stockNuevo = entrada.nextInt();
							System.out.println("Precio nuevo: ");
							double precioNuevo = entrada.nextDouble();
							
				            raf.seek(productoPosicion + 4); // saltamos los 4 bytes del ID ya que este se queda igual
				            raf.writeInt(stockNuevo);
				            raf.writeDouble(precioNuevo);
						}
					}
					
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
