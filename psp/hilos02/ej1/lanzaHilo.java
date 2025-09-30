package ej1;

public class lanzaHilo {
	public static void main(String[] args) {
		// También se puede hacer esto
		//Thread h1 = new Thread(new Hilo("H1")); // dentro del new Thread un objeto de una clase en la que se haya usado en Runnable
		
		// Creamos los hilos
		Hilo mihilo1 = new Hilo("H1");
		Thread h1 = new Thread(mihilo1);
		
		Hilo mihilo2 = new Hilo("H2");
		Thread h2 = new Thread(mihilo2);
		
		Hilo mihilo3 = new Hilo("H3");
		Thread h3 = new Thread(mihilo3);
		
		// Lanzamos los hilos
		h1.start();
		h2.start();
		h3.start();
		// hasta que no hago start, no creo los hilos (antes del start lo controlo, una vez hecho start no)
		
		// Mensaje desde hilo principal
		System.out.println("Hilo principal terminado");
	}
}
