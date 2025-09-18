package ejercicios;

import java.util.Scanner;

public class ejercicio4 {

	static Scanner entrada = new Scanner(System.in);
	
	 public static int factorial(int n) {
	        if (n == 0 || n == 1) {
	            return 1;
	        } else {
	            return n * factorial(n - 1);
	        }
	    }
	 
	public static void main(String[] args) {
		System.out.print("Introduce un número: ");
        int numero = entrada.nextInt();

        if (numero < 0) {
            System.out.println("El número debe ser positivo");
        } else {
            int resultado = factorial(numero);
            System.out.println("El factorial de " + numero + " es: " + resultado);
        }

        entrada.close();

	}

}
