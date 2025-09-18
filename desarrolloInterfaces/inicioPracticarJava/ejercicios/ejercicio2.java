package ejercicios;

public class ejercicio2 {

	public static void main(String[] args) {
		int[] array = {1,2,3,4};
		int n = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i]%2 == 0) {
				System.out.println("El número es par");
				n++;
			} else {
				System.out.println("El número es impar");
			}
		}
		
		System.out.println("El número de pares es de: " + n);

	}

}
