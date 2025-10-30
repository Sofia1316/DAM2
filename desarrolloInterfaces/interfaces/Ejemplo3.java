package interfaces;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo3 {

	private JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnIrAMarron;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo3 window = new Ejemplo3();
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
	public Ejemplo3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 630, 437);
		//PARA PONER LA INTERFAZ EN EL MEDIO DE LA PANTALLA
		// OPCIÓN 1; automática
		frame.setLocationRelativeTo(null);
		// OPCIÓN 2; manual
		Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int) monitor.getHeight();
		int width = (int) monitor.getWidth();
		frame.setLocation((width/2 - frame.getWidth() / 2), (height/2 - frame.getHeight() / 2));
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setAlignmentY(430.0f);
		layeredPane.setAlignmentX(630.0f);
		layeredPane.setBounds(0, 0, 614, 398);
		frame.getContentPane().add(layeredPane);
		
		// primer panel
		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(106, 90, 205));
		panel.setBounds(0, 0, 614, 398);
		layeredPane.add(panel);
		panel.setLayout(null);
		panel.setVisible(true); // para que no haya botones fantasmas
		
		JButton btnNewButton = new JButton("ir a verde");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnNewButton.setBounds(444, 283, 113, 43);
		panel.add(btnNewButton);
		
		btnIrAMarron = new JButton("ir a marron");
		btnIrAMarron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnIrAMarron.setBounds(84, 283, 124, 43);
		panel.add(btnIrAMarron);
		
		// tercer panel
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(210, 105, 30));
		panel_2.setBounds(0, 0, 614, 398);
		layeredPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false); // para que no haya botones fantasmas
		
				
				JButton btnNewButton_1 = new JButton("ir al morado");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_2.setVisible(false);
						panel.setVisible(true);
					}
				});
				btnNewButton_1.setBounds(435, 293, 115, 40);
				panel_2.add(btnNewButton_1);
				
				btnNewButton_4 = new JButton("ir al verde");
				btnNewButton_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_2.setVisible(false);
						panel_1.setVisible(true);
					}
				});
				btnNewButton_4.setBounds(99, 293, 121, 40);
				panel_2.add(btnNewButton_4);
		
		// segundo panel
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setBounds(0, 0, 614, 398);
		layeredPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false); // para que no haya botones fantasmas
		
				
				JButton btnNewButton_2 = new JButton("ir al marron");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_1.setVisible(false);
						panel_2.setVisible(true);
					}
				});
				btnNewButton_2.setBounds(436, 288, 113, 43);
				panel_1.add(btnNewButton_2);
				
				btnNewButton_3 = new JButton("ir al morado");
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel_1.setVisible(false);
						panel.setVisible(true);
					}
				});
				btnNewButton_3.setBounds(135, 288, 119, 43);
				panel_1.add(btnNewButton_3);
	}
}
