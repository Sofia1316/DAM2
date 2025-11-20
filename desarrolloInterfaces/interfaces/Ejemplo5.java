package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;

public class Ejemplo5 {

	private JFrame frame;
	Timer tiempo;
	int i = 11;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo5 window = new Ejemplo5();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejemplo5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FELIZ PUENTE");
		lblNewLabel.setVisible(false);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(70, 130, 180));
		lblNewLabel.setBounds(159, 11, 87, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiempo.start();
			}
		});
		btnNewButton.setBounds(29, 48, 102, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(172, 156, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("SALIR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // liberamos al frame de las cosas
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(321, 216, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\DAM\\Downloads\\gatoFeliz.png"));
		lblNewLabel_2.setBounds(29, 93, 268, 146);
		frame.getContentPane().add(lblNewLabel_2);
		
		// Para hacer el temporizador marcha atrás
		tiempo = new Timer(1000, new ActionListener() { // ponemos un segundo
			@Override
			public void actionPerformed(ActionEvent e) {
				if(i != 0) {
				i--; // por cada segundo se descuenta 1 valor
				lblNewLabel_1.setText(String.valueOf(i)); 
					if(i==0) { // si ese número es 0
						tiempo.stop(); // deja de contar hacia atrás
						lblNewLabel.setVisible(true); // y hacemos que se muestre el mensaje
						btnNewButton.setEnabled(false); // cuando llegue a 0, muestra el mensaje y oculta el botón
						btnNewButton.setVisible(false);
						lblNewLabel_2.setVisible(true);
					} 
				} else {
					i = 10;
					lblNewLabel_1.setText(String.valueOf(i));
					lblNewLabel.setVisible(false); 
				}
			}
		});
	}
}
