package ejemplo3_pingPong;

import java.util.concurrent.Semaphore;

public class pong extends Thread{
	
	public void pong(boolean bandera) {
		while(bandera) {
			for (int i = 0; i < main.NUMHILOS; i++) {
				try {
					main.SEM2.acquire();
					System.out.println("...pong");
					main.SEM1.release();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
