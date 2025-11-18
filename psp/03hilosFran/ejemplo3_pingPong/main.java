package ejemplo3_pingPong;

import java.util.concurrent.Semaphore;

public class main {

	public final static Semaphore SEM1 = new Semaphore(1);
	public final static Semaphore SEM2 = new Semaphore(0);
	static int NUMHILOS = 10;

	public static void main(String[] args) {
		System.out.println("-- Juego del ping pong --");
		ping JPing = new ping();
		pong JPong = new pong();

		try {
			JPing.start();
			JPong.start();
			
			JPing.join();
			JPong.join();

		} catch(InterruptedException e) {
			e.getMessage();
		}

		System.out.println("Fin del juego");
	}

}
