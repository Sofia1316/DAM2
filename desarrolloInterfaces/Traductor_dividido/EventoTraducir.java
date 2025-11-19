package Traductor_dividido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventoTraducir implements ActionListener{
	
	JTextField PIN, POUT;

	public EventoTraducir(JTextField PIN, JTextField POUT) {
		this.PIN = PIN;
		this.POUT = POUT;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//1. Control de errores
		if(PIN.getText().isBlank() != true) {
			try {
				POUT.setText(Operaciones.traducir(PIN.getText()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "No se ha introducido el texto correcto", "ERROR", 0);
		}
		
	}
}
