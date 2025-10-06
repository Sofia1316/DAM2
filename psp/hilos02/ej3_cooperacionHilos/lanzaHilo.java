package ej3_cooperacionHilos;

import java.io.IOException;
import java.util.ArrayList;

public class lanzaHilo {
	
	private static final int numHilos = 10;
	private static final int cuentaTotal = 10000;
	
	public static void main(String[] args) {
		Contador contCompartido = new Contador();
		Thread[] hilos = new Thread[numHilos];
		
		for (int i = 0; i < 9; i++) {
			Thread th = new Thread(new Hilo("hilo " + i, cuentaTotal/numHilos, contCompartido));
			th.start();
			hilos[i] = th;
		}
		// para cada hilo de mi array, hacer un join
		for(Thread h : hilos) {
			try {
				h.join();
			} catch(InterruptedException e) {
				e.getStackTrace();
			}
		}
		System.out.println("Cuenta global: " + contCompartido);
	}
}
