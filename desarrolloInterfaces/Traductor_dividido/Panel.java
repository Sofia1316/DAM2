package Traductor_dividido;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;

public class Panel extends JPanel{
	private JTextField PIN;
	private JTextField POUT;
	
	public Panel() {
		setSize(new Dimension(800, 600));
		setLayout(null);
		
		JLabel MIngles = new JLabel("Palabra a traducir");
		MIngles.setBounds(84, 78, 101, 45);
		add(MIngles);
		
		PIN = new JTextField();
		PIN.setBounds(180, 90, 121, 20);
		add(PIN);
		PIN.setColumns(10);
		
		JButton boton = new JButton("Traducir");
		boton.setBounds(311, 89, 89, 23);
		add(boton);
		
		JLabel MEspanol = new JLabel("Palabra traducida");
		MEspanol.setBounds(84, 134, 89, 14);
		add(MEspanol);
		
		POUT = new JTextField();
		POUT.setEditable(false);
		POUT.setBounds(180, 131, 121, 20);
		add(POUT);
		POUT.setColumns(10);
		
		boton.addActionListener(new EventoTraducir(PIN, POUT));
	}
}
