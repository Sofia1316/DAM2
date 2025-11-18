package ej2;

import java.io.IOException;

public class lanzaHilo {

	public static void main(String[] args) {
		Thread h1 = new Thread(new Hilo("H1"));
		Thread h2 = new Thread(new Hilo("H2"));
		
		// Lanzamos los hilos
		h1.start();
		h2.start();
		
		// Hacemos la espera hasta que los hilos se terminen
		try {
			h1.join();
			h2.join();
		} catch(InterruptedException e) {
			System.out.println("Se ha interrumpido");
			e.getMessage();
		}
		
		// Mensaje desde hilo principal
		System.out.println("Hilo principal terminado");

	}

}
