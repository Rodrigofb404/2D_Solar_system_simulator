package org.ufba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GUI extends JPanel {
    static private double galaxyCenterX, galaxyCenterY;
    private JFrame frame;
    private double deltaTime = 10000; // valor inicial (em segundos fictícios)
    private Timer timer;
    private boolean isRunning = true; // Flag para controle de pausa/play

    public GUI(PlanetarySystem planetarySystem) {
        configFrame();
        calcFrameParameters();

        Control control = new Control(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "pause":
                        if (isRunning) {
                            timer.stop();
                        } else {
                            timer.start();
                        }
                        isRunning = !isRunning;
                        break;
                    case "slow":
                        deltaTime = Math.max(deltaTime / 2, 1); 
                        break;
                    case "speed":
                        deltaTime *= 2;
                        break;
                }
            }
        });

        Galaxy galaxy = new Galaxy(planetarySystem);

        frame.add(galaxy, java.awt.BorderLayout.CENTER);   // Simulação no centro
        frame.add(control, java.awt.BorderLayout.SOUTH);    // Botões na parte inferior

        timer = new Timer(20, e -> {
            planetarySystem.update(deltaTime);
            galaxy.repaint();
        });
        timer.start();
    }

    // Configura o estado inicial da janela
    public void configFrame() {
        frame = new JFrame("2D Solar System Simulator");
        frame.setLayout(new java.awt.BorderLayout());
        frame.setSize(1150, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centraliza na tela
    }

    // Calcula as coordenadas do centro da galáxia
    public void calcFrameParameters() {
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();

        galaxyCenterX = frameWidth / 2;
        galaxyCenterY = frameHeight / 2;
    }

    // Exibe a GUI na tela
    public void openGUI() {
        frame.setVisible(true);
    }

    // Retorna o centro da galáxia como vetor 2D
    static public Vector2D getGalaxyCenter() {
        return new Vector2D(galaxyCenterX, galaxyCenterY);
    }
}
