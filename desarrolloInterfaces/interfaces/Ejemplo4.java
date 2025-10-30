package interfaces;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Ejemplo4 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo4 window = new Ejemplo4();
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
	public Ejemplo4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Ejemplo4.class.getResource("/icono.png")));
		frame.setBounds(100, 100, 902, 549);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(añadirPanelconImagen());
	}

	private Component añadirPanelconImagen() {
		// Cargar la imagen
		BufferedImage fondo = null;
		try {
			fondo = ImageIO.read(new File("src/gato.png"));
		} catch(IOException e) {
			e.getMessage();
		}
		
		// Asignar la imagen a un jpanel
		final Image foto = fondo;
		JPanel panelConImagen = new JPanel() {
			private static final long serialVersionUID = 1L;
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(foto,0,0,1000,1000,null);
			}
		};
	
		return panelConImagen;
	}

}
