package ej5_gestionRespuestas;

public class Contador {
	private int cuenta = 0;
	private int cuentaB = 0;
	private int cuentaC = 0;
	private int cuentaD = 0;
	private int cuentaE = 0;
	
	synchronized public int getCuenta() { 
		return cuenta;
	}
	synchronized public int getCuentaB() { 
		return cuentaB;
	}
	synchronized public int getCuentaC() { 
		return cuentaC;
	}
	synchronized public int getCuentaD() { 
		return cuentaD;
	}
	synchronized public int getCuentaE() { 
		return cuentaE;
	}
	
	synchronized public int incrementa() {
		this.cuenta++;
		return cuenta;
	}
	synchronized public int incrementa2() {
		this.cuentaB++;
		return cuentaB;
	}
	synchronized public int incrementa3() {
		this.cuentaC++;
		return cuentaC;
	}
	synchronized public int incrementa4() {
		this.cuentaD++;
		return cuentaD;
	}
	synchronized public int incrementa5() {
		this.cuentaE++;
		return cuentaE;
	}
}
