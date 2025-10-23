package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class Ejemplo2 {

	private JFrame frame;
	private JTextField textField;
	private int contador = 0;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo2 window = new Ejemplo2();
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
	public Ejemplo2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		/*PRIMER PANEL*/
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		frame.getContentPane().add(panel, "name_1770434748416800");
		panel.setLayout(null);
		// botón contador
		JButton btnNewButton = new JButton("BOTONAZO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contador++;
				textField.setText(Integer.toString(contador));
			}
		});
		
		btnNewButton.setBounds(125, 68, 105, 36);
		panel.add(btnNewButton);
		// texto con número de clics enunciado
		JLabel lblNewLabel = new JLabel("Numero de clics");
		lblNewLabel.setBounds(22, 11, 148, 46);
		panel.add(lblNewLabel);
		// caja de texto
		textField = new JTextField();
		textField.setEditable(false); // para evitar poder escribir y así solo aparecen los nº de clics
		textField.setBounds(22, 46, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		// botón de siguiente
		JButton btnNewButton_1 = new JButton("Siguiente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(319, 221, 105, 29);
		panel.add(btnNewButton_1);
		
		/*SEGUNDO PANEL*/
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		frame.getContentPane().add(panel_1, "name_1770465928029900");
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Atrás");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_1.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(10, 227, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Siguiente 2");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(335, 227, 89, 23);
		panel_1.add(btnNewButton_3);
		
		/*TERCER PANEL*/
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(186, 85, 211));
		frame.getContentPane().add(panel_2, "name_1770469654838500");
		panel_2.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Atrás");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(true);
				panel_2.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(10, 227, 89, 23);
		panel_2.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("GRACIAS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(129, 64, 168, 101);
		panel_2.add(lblNewLabel_1);
	}
}
