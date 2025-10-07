package ej5_gestionRespuestas;

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
			int randomIntRango = (int) (Math.random() * 4);
			switch(randomIntRango) {
			case 0:
				cont.incrementa2();
				break;
			case 1:
				cont.incrementa3();
				break;
			case 2:
				cont.incrementa4();
				break;
			case 3:
				cont.incrementa5();
				break;
			}
		}
		System.out.println("Hilo " + numHilo + " terminado. "
				+ "Cuenta B: " + cont.getCuentaB()
				+ ", Cuenta C: " + cont.getCuentaC()
				+ ", Cuenta D: " + cont.getCuentaD()
				+ ", Cuenta E: " + cont.getCuentaE());

	}
}

