package ejemplo3_pingPong;

import java.util.concurrent.Semaphore;

public class ping extends Thread{

	public void run() {
		try {
			for (int i = 0; i < main.NUMHILOS; i++) {
			main.SEM1.acquire();
			System.out.println("ping...");
			main.SEM2.release();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
