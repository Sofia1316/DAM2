package ej4_cooperacionHilosSyncro;

public class Contador {
	private int cuenta = 0;
	
	synchronized public int getCuenta() { // de esta forma varios hilos no pueden coger la misma variable, por lo que van ordenadamente, en este caso siempre llega a 100000
		return cuenta;
	}
	
	synchronized public int incrementa() {
		this.cuenta++;
		return cuenta;
	}
}
