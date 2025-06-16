package org.ufba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GUI extends JPanel {
    // Swing variables
    private JFrame frame;
    private Timer timer;

    // Simulation Speed variables
    private final int BASE_SIMULATION_TIME = 60 * 60 * 24;
    private final double[] SPEED_LEVELS = {0.33, 0.5, 1.0, 2.0, 3.0};
    private double deltaTime = BASE_SIMULATION_TIME; // Initial value
    private int speedLevel = 2;
    private boolean isRunning = true; // pause/play flag control

    // Frame translation variables
    static private double galaxyCenterX, galaxyCenterY;

    static private Control control;
    static private Galaxy galaxy;

    public GUI(PlanetarySystem planetarySystem) {
        configFrame();
        calcFrameParameters();

        control = new Control(new ActionListener() {
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
                        if (speedLevel >= 0) {
                            speedLevel--;
                            deltaTime = BASE_SIMULATION_TIME * SPEED_LEVELS[speedLevel];
                        }
                        break;
                        case "speed":
                        if (speedLevel < SPEED_LEVELS.length - 1) {
                            speedLevel++;
                            deltaTime = BASE_SIMULATION_TIME * SPEED_LEVELS[speedLevel];
                        }    
                        break;
                }
            }
        });
        galaxy = new Galaxy(planetarySystem);

        frame.add(galaxy);
        frame.add(control, java.awt.BorderLayout.SOUTH);    // Positions buttons in the bottom of the frame

        // ~60 FPS
        startTimer(planetarySystem);        
    }

    private void startTimer(PlanetarySystem planetarySystem) {
        timer = new Timer(17, e -> {
            planetarySystem.update(deltaTime);
            galaxy.repaint();
        });

        timer.start();
    }

    // Configures initial frame state
    private void configFrame() {
        frame = new JFrame("2D Solar System Simulator");
        frame.setLayout(new java.awt.BorderLayout()); // Define layout
        frame.setSize(1150, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centers the frame on the screen
    }

    // Calculates coordinates for translation
    private void calcFrameParameters() {
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();

        galaxyCenterX = frameWidth / 2;
        galaxyCenterY = frameHeight / 2;
    }

    // Shows GUI
    public void openGUI() {
        frame.setVisible(true);
    }
    
    // GalaxyCenter coordinates getter
    static public Vector2D getGalaxyCenter() {
        return new Vector2D(galaxyCenterX, galaxyCenterY);
    }
}
