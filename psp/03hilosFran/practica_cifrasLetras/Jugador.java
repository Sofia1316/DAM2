package PracticaPSP;

import java.io.IOException;

public class Jugador extends Thread {

	private final int NUM_CARACTERES = 20;

	public Jugador(String nombre) {
		super(nombre);
	}

	private char randomCifra() {
		return (char) ('0' + (int) (Math.random() * 10));
	}

	private char randomLetra() {
		String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] arr = letras.toCharArray();
		
		return arr[(int) (Math.random() * arr.length)];
	}

	@Override
	public void run() {
		try {
			Thread.sleep((long) (Math.random() * 1000)); // Hacemos un aleatorio para ver si empiecan las cifras o las letras

			for (int i = 0; i < NUM_CARACTERES; i++) { // recorremos los 10 caracteres
				char caracter;

				if (getName().equals("cifras")) { // intercalamos entre letras y cifras
					caracter = randomCifra();
				} else {
					caracter = randomLetra();
				}

				escribir(caracter); // escribimos en salida.txt con semáforo
				//Thread.sleep(50);//Forzar intercalación de letras y cifras			
				}
			anunciarGanador();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void escribir(char caracter) throws IOException, InterruptedException {
		main.semaforo.acquire();
		main.txt.write(caracter);
		main.txt.write(',');
		main.semaforo.release();
	}

	private void anunciarGanador() {
		synchronized (main.wyn) {
			if (!main.ganadorAnunciado) {
				main.ganadorAnunciado = true;
				System.out.println("Gana: " + getName());
				main.wyn.notify(); // Despierta al main
			}
		}
	}
}
