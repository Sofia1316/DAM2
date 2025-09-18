package ejercicios;

import java.util.Scanner;

public class ejercicio3 {

	static Scanner entrada = new Scanner(System.in);
	public static void main(String[] args) {
		int num = 0;
		int num2 = 0;
		int suma = 0;
		
		System.out.println("Introduce la altura: ");
		num = entrada.nextInt();
		System.out.println("Introduce el ancho: ");
		num2 = entrada.nextInt();
		
		int array[][] = new int [num][num2];
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num2; j++) {
				array[i][j] = (int)(Math.random()*10);
				System.out.print(array[i][j]);
				suma = suma + array[i][j];
			}
			System.out.println();
		}
		System.out.println("La suma de la matriz es de: " + suma);
	}

}
