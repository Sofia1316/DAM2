package PracticaPSP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class main {
	
	/*
	 * @author Sofía López y Valeria Hidalgo
	 */
	
	final static Object wyn = new Object(); 
	static FileOutputStream txt; 
	final static Semaphore semaforo = new Semaphore(1);
	static boolean ganadorAnunciado = false;

	public static void main(String[] args) {
		try {
			File salidatxt = new File("salida.txt");
			if (salidatxt.exists()) {
				salidatxt.delete();
			}
			txt = new FileOutputStream("salida.txt", true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Jugador cifras = new Jugador("cifras");
		Jugador letras = new Jugador("letras");

		cifras.start();
		letras.start();

		// Espera al ganador
		synchronized (wyn) {
			try {
				wyn.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Se acabó el juego");

		try {
			cifras.join();
			letras.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			txt.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
