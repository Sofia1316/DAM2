package EjemploDividido_email;

import java.awt.EventQueue;

import Ejemplo_mail.Email_interfaz;

public class EventoEmail {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Email_interfaz window = new Email_interfaz();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
