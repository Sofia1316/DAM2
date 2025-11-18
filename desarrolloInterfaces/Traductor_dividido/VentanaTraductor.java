package Traductor_dividido;

import javax.swing.JFrame;

public class VentanaTraductor extends JFrame{
	
	public VentanaTraductor() {
		// MARCO
		setTitle("Traductor inglés - español");
		setSize(800,600);
		setLocationRelativeTo(null);
		// para qyue el usuario no tire de la esquinita
		setResizable(false);
		
		// PANELES
		Panel miPanel = new Panel();
		add(miPanel);
		
	}
	
}
