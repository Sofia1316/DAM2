package ej3_cooperacionHilos;

public class Hilo implements Runnable{
	int numHilo, miParte, miCuenta = 0;
	private final Contador cont;
	
	Hilo(int numHilo, int miParte, Contador c){
		this.numHilo = numHilo;
		this.miParte = miParte;
		this.cont = c;
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			miParte++;
		}
	}
}
