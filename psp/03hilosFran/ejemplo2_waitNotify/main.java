package ejemplo2_waitNotify;

public class main {

	static int NUMHILOS = 6;
	private final static boolean[] flagsArrayHilosFinalizados = new boolean[NUMHILOS];
	
	public static void main(String[] args) {
		
		for(int i = 0; i < NUMHILOS; i++) {
			Runnable hiloMain = new hilo();
			Thread hAux = new Thread(hiloMain);
			hAux.setName(Integer.toString(i + 1));
			
			hAux.start();
		}
		
		try {
			synchronized (flagsArrayHilosFinalizados) {
				flagsArrayHilosFinalizados.wait();
			}
			System.out.println("Los hilos han acabado desde el main");
		} catch(InterruptedException e) {
			e.getMessage();
		}

	}

}
