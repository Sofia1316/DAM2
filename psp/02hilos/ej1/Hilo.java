package ej1;

public class Hilo implements Runnable{

	private final String nombre;
	Hilo(String nombre){
		this.nombre= nombre;	
	}
	
	public void run() {
		System.out.println("Hola soy hilo " + nombre);
		System.out.println("Hilo terminado " + nombre);
	}
}
