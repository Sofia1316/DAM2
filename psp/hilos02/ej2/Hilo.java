package ej2;

import java.util.Random;

public class Hilo implements Runnable {
	private final String nombre;
	
	Hilo(String nombre){
		this.nombre= nombre;	
	}
	
	public void run() {
		System.out.println("Hola soy hilo " + nombre);
		for (int i = 0; i < 5; i++) {
			Random r = new Random(); 
			int pausa = 20 + r.nextInt(500-20);
			System.out.println("Hace pausa " + nombre + " hace pausa " + pausa);
			
			try {
				Thread.sleep(pausa);
			} catch(InterruptedException e) {
				e.getMessage();
				System.out.println("Proceso interrumpido");
			}
			
		} 
		System.out.println("Hilo terminado " + nombre);
	}
}
