package ejemplo2_waitNotify;

import java.io.IOException;
import java.util.Date;

public class hilo implements Runnable{
	
	@Override
	public void run() {
		// Convierte el nombre del hilo en un número para mostrarlo en pantalla
		int threadNumber = Integer.parseInt(Thread.currentThread().getName());
		
		// El tiempo en sistemas informáticos se mide en ms desde 00:00:00 del 1/1/70
		long tsInicio = (new Date().getTime());
				
		System.out.println("Comienza la ejecución del hilo: " + threadNumber);
		
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		long tsFinalizada = (new Date()).getTime();
		System.out.println("Fin del hilo: " + threadNumber + " y tardó " + (tsFinalizada - tsInicio / 1000.0f));
		
		registrarFinEjecucionHilo(threadNumber);
	}

	// Comunica al hilo main de la app que el hilo a finalizado su exec
	// @param threadNumber ID del hilo
	protected synchronized void registrarFinEjecucionHilo(int threadNumber) {
		//boolean[] arrayHilosFinalizados = Sincroniza
		
	}
}
