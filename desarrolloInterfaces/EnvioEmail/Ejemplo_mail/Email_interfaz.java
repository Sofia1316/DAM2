package Ejemplo_mail;

import java.awt.EventQueue;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Email_interfaz {

	private JFrame frame;
	private JTextField correoTuyo;
	private JTextField correoEnvio;
	static JLabel exito;

	private Session session;
	private String subject;
	private String body;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Email_interfaz window = new Email_interfaz();
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
	public Email_interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 139, 139));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel mensajeEmailPersonal = new JLabel("Introduce tu email");
		mensajeEmailPersonal.setBounds(10, 43, 180, 14);
		frame.getContentPane().add(mensajeEmailPersonal);

		JLabel mensajeEmailDestinatario = new JLabel("Email del destinatario");
		mensajeEmailDestinatario.setBounds(10, 71, 180, 14);
		frame.getContentPane().add(mensajeEmailDestinatario);

		correoTuyo = new JTextField();
		correoTuyo.setBounds(162, 40, 149, 20);
		frame.getContentPane().add(correoTuyo);
		correoTuyo.setColumns(10);

		correoEnvio = new JTextField();
		correoEnvio.setBounds(162, 68, 149, 20);
		frame.getContentPane().add(correoEnvio);
		correoEnvio.setColumns(10);

		JButton confirmar = new JButton("Confirmar");
		confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = correoEnvio.getText();

			}
		});
		confirmar.setBounds(321, 39, 89, 23);
		frame.getContentPane().add(confirmar);

		JButton enviar = new JButton("Enviar");
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simpleEmail();

			}
		});
		enviar.setBounds(321, 67, 89, 23);
		frame.getContentPane().add(enviar);

		exito = new JLabel("Mensaje enviado!!");
		exito.setVisible(false);
		exito.setBounds(162, 96, 149, 14);
		frame.getContentPane().add(exito);
	}

	public static void EnviarEmail(Session session, String correoEnvio, String subject, String body) {
		try {
			MimeMessage msg = new MimeMessage(session);
			// Configurar Cabeceras
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			msg.setFrom(new InternetAddress("no_reply@example.com", "NO BIZUM NO RESPONDER"));// Datos de ejemplo
			msg.setReplyTo(InternetAddress.parse("no_reply_DOSA@DAM.com", false));
			msg.setSubject(subject, "UTF-8");
			msg.setText(body, "UTF-8");
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoEnvio, false));

			Transport.send(msg);
			exito.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void simpleEmail() {
		final String fromEmail = correoTuyo.getText(); // EMAIL DE SALIDA
		final String password = "hgcx gmlb jbso uruw";
		final String toEmail = correoEnvio.getText();

		System.out.println("Configurando datos conexión SSL");

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP de GMAIL en este caso
		props.put("mail.smtp.socketFactory.port", "465"); // PUERTO SSL
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL Factory Class
		props.put("mail.smtp.auth", "true"); // ACTIVAR SMTP AUTENTIFICACI�N
		props.put("mail.smtp.port", "465"); // SMTP Port
		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getDefaultInstance(props, auth);// CREA UNA SESIÓN CON TODAS LAS PROPIEDADES Y EL "LOGIN"
		System.out.println("Sesión Creada");

		EnviarEmail(session, toEmail, "ASUNTO", "MENSAJE/CUERPO");
	}
}
