package ejemplo1;

import java.util.Random;

public class hilo1 extends Thread{

	@Override
	public void run(){
		// El hilo inicialmente duerme una cantidad aleatoria de ms
		Random random = new Random();
		long mseconds = random.nextLong(1000);
		try {
			Thread.sleep(mseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Imprimo el valor de la variable compartida contador
		synchronized (main1.contador) {
			System.out.println("Soy hilo " + this.getName());
			main1.contador--;
			System.out.println("Contador value: " + main1.contador);
		}
	}

}
