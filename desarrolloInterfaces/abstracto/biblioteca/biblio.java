package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class biblio {

	static Scanner entrada = new Scanner(System.in);
	static ArrayList<Libro> libro = new ArrayList<>();
	static ArrayList<Revista> revista = new ArrayList<>();
	
	public static void main(String[] args) {
		menu();
		entrada.close();
	}
	
	public static void menu() {

		int respuesta;
		boolean salida = true;
		
		do {
			System.out.println("1. Libro");
			System.out.println("2. Revista");
			System.out.println("3. Prestar");
			System.out.println("4. Devolver");
			System.out.println("5. Prestado");
			System.out.println("6. Mirar estado");
			System.out.println("¿Qué quieres añadir?");
			respuesta = entrada.nextInt();
			
			switch(respuesta) {
				case 1: 
					System.out.println("Código: ");
					int codigo = entrada.nextInt();
					System.out.println("Título: ");
					String titulo = entrada.nextLine();
					entrada.nextLine();
					System.out.println("Año de publicación: ");
					int anio = entrada.nextInt();
					
					libro.add(new Libro(codigo,titulo,anio,false));
					System.out.println("Libro añadido");
					break;
				case 2:
					System.out.println("Código: ");
					int codigo2 = entrada.nextInt();
					System.out.println("Título: ");
					String titulo2 = entrada.nextLine();
					entrada.nextLine();
					System.out.println("Año de publicación: ");
					int anio2 = entrada.nextInt();
					System.out.println("Número de revista");
					int numR = entrada.nextInt();
					
					revista.add(new Revista(codigo2, titulo2, anio2, numR));
					System.out.println("Revista añadido");
					break;
				case 3:
					Libro.prestar();
					break;
				case 4:
					Libro.devolver();
					break;
				case 5:
					Libro.prestado();
					break;
				case 6:
					System.out.println(libro);
					System.out.println(revista);
					break;
				default:
					System.out.println("Salida");
					salida = false;
					break;
			}
		} while(salida == true);
		
	}

}
