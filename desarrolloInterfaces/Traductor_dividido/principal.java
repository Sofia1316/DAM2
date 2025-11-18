package Traductor_dividido;

import java.awt.EventQueue;
import java.io.IOException;

public class principal {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaTraductor miVentana = new VentanaTraductor();
					miVentana.setSize(1200, 800);
					miVentana.setVisible(true);

				} catch(Exception e) {
					e.getMessage();
				}
			}
		});

	}

}
