package ejemplo1;

public class main1 {

	public static final int num_hilos = 5;
	public static Integer contador = 20;
	
	public static void main(String[] args) {
		System.out.println("Soy el hilo principal");

		hilo1 array[] = new hilo1[num_hilos];
		
		for (int i = 0; i < num_hilos; i++) {
			array[i] = new hilo1();
			array[i].setName("H" + i);
			array[i].start();

			/*hilo1 h1 = new hilo1();
			h1.setName("H"+i);
			h1.start();*/
		}

	}

}
