package ej6_bloqueCodigoSincronizado;

public class Hilo implements Runnable{
	int numHilo, miCuenta = 0;
	long miParte = 0;
	private final Contador cont;
	
	Hilo(int numHilo, long l, Contador c){
		this.numHilo = numHilo;
		this.miParte = l;
		this.cont = c;
	}
	
	public int getCuenta() {
		return miCuenta;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < miParte; i++) {
			this.cont.incrementar1();
			this.cont.incrementar2();
		}
		System.out.println("Hilo " + numHilo + " terminado. "
				+ "Cuenta B: " + cont.getContador1());

	}
}

