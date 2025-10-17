package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;

public class Ejemplo1 {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtBlockeao;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo1 window = new Ejemplo1();
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
	public Ejemplo1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DAM\\Downloads\\mv5bntq3mdy5mtewnl5bml5banbnxkftztgwmzi0ndezmzi-v1-sy1000-cr_hh9w.jpg"));
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.getContentPane().setForeground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("hola");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("adios\r\n");
		lblNewLabel_1.setBounds(10, 39, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(60, 8, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtBlockeao = new JTextField();
		txtBlockeao.setText("bloqueado");
		txtBlockeao.setEnabled(false);
		txtBlockeao.setBounds(60, 36, 86, 20);
		frame.getContentPane().add(txtBlockeao);
		txtBlockeao.setColumns(10);
		
		JButton btnNewButton = new JButton("aceptar");
		btnNewButton.setToolTipText("puedes aceptar eh");
		btnNewButton.addActionListener(new ActionListener() { // cuando alguien pulse
			public void actionPerformed(ActionEvent e) { // hago esta acción
				// acción
			}
		});
		btnNewButton.setBounds(27, 137, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(60, 64, 86, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1_1 = new JLabel("spinner\r\n");
		lblNewLabel_1_1.setBounds(10, 98, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner.setBounds(60, 95, 86, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("psw\r\n");
		lblNewLabel_1_1_1.setBounds(10, 70, 46, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
	}
}
