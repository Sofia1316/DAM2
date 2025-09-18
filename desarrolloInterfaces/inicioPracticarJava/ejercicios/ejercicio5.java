package ejercicios;

public class ejercicio5 {

	public static void main(String[] args) {
		System.out.println("El factorial de 5 es: " + factorial(5));

	}

	private static int factorial(int i) {
		if(i == 1) {
			return 1;
		} else {
			return i * factorial(i-1);
		}
	}

}
