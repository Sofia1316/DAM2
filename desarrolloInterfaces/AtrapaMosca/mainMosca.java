package moscaEjercicio;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

import java.awt.Toolkit;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import java.util.Random;

public class mainMosca {

	private JFrame frame;
	private JPanel FotoMosca;

	// Variables para la mosca
	private int moscaX = 0;
	private int moscaY = 0;
	private int moscaW = 50;
	private int moscaH = 50;

	private Random random = new Random();

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				mainMosca window = new mainMosca();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public mainMosca() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/mosca.jpg"));
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// PANEL MOSCA
		FotoMosca = crearPanelConImagen();
		FotoMosca.setBounds(moscaX, moscaY, moscaW, moscaH);
		frame.getContentPane().add(FotoMosca);

		// ETIQUETA RATÓN
		JLabel posicionRatón = new JLabel("X: 0 Y: 0");
		posicionRatón.setBounds(66, 723, 204, 14);
		frame.getContentPane().add(posicionRatón);

		// ETIQUETA MOSCA
		JLabel posicionMosca = new JLabel("X: 0 Y: 0");
		posicionMosca.setBounds(479, 723, 242, 14);
		frame.getContentPane().add(posicionMosca);

		// LISTENER PRINCIPAL
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int xM = e.getX();
				int yM = e.getY();

				posicionRatón.setText("Posición del ratón ---> X: " + xM + " Y: " + yM);

				// Distancia real
				int distanciaX = Math.abs(xM - moscaX);
				int distanciaY = Math.abs(yM - moscaY);

				int limite = 55;

				if (distanciaX < limite && distanciaY < limite) {
					// Movimiento aleatorio para huir
					int moverX = random.nextInt(201) - 50; 
					int moverY = random.nextInt(201) - 50;

					moscaX = Math.max(0, Math.min(moscaX + moverX, frame.getWidth() - 2*moscaW));
					moscaY = Math.max(0, Math.min(moscaY + moverY, frame.getHeight() - 2*moscaH));

					FotoMosca.setLocation(moscaX, moscaY);
				}
				posicionMosca.setText("Posición de la mosca ---> X: " + moscaX + " Y: " + moscaY);
			}
		});
	}

	// PANEL CON LA IMAGEN DE LA MOSCA
	private JPanel crearPanelConImagen() {
		BufferedImage fondo = null;
		try {
			fondo = ImageIO.read(new File("src/mosca.jpg"));
		} catch (IOException e) {
			System.out.println("No hay imagen");
		}
		final Image imagen = fondo;
		JPanel panel = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
			}
		};
		return panel;
	}
}
