package ej4_cooperacionHilosSyncro;

public class Hilo implements Runnable{
	int numHilo, miParte, miCuenta = 0;
	private final Contador cont;
	
	Hilo(int numHilo, int miParte, Contador c){
		this.numHilo = numHilo;
		this.miParte = miParte;
		this.cont = c;
	}
	
	public int getCuenta() {
		return miCuenta;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < miParte; i++) {
			this.cont.incrementa(); // incremento el contador compartido
			miCuenta++;
		}
		System.out.println("Hilo " + numHilo + " terminado, cuenta " + cont.getCuenta());
	}
}
