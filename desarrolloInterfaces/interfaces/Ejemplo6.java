package interfaces;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo6 {

    private JFrame frame;
    private Timer tiempo;
    private int posicion = 0;

    JProgressBar progressBar;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ejemplo6 window = new Ejemplo6();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Ejemplo6() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(95, 158, 160));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("Empezar barrita");
        btnNewButton.setBackground(new Color(230, 230, 250));
        btnNewButton.setBounds(130, 40, 159, 52);
        frame.getContentPane().add(btnNewButton);

        // --------------------
        //  BARRA DE PROGRESO
        // --------------------
        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(50, 150, 330, 30);
        progressBar.setStringPainted(true);
        frame.getContentPane().add(progressBar);

        // TIMER que incrementa el valor cada 100 ms
        tiempo = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (posicion < 100) {
                    posicion++;
                    progressBar.setValue(posicion);
                }
            }
        });

        // Botón que arranca el Timer
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                posicion = 0;
                progressBar.setValue(0);
                tiempo.start();
            }
        });

        // Listener: cuando llega al 100 muestra mensaje
        progressBar.addChangeListener(e -> {
            if (progressBar.getValue() == 100) {
                tiempo.stop();
                JOptionPane.showMessageDialog(
                        frame,
                        "¡Ya no queda nada!",
                        "Completado",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
    }
}
