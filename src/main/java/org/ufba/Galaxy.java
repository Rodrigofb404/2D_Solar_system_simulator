package org.ufba;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Galaxy extends JPanel {
    private SolarSystem solarSystem;
    private Sun sun;

    // Constants
    static private final int sunRadius = 35;
    private final int galaxyCenterX = (int) (GUI.getGalaxyCenter().getX());
    private final int galaxyCenterY = (int) (GUI.getGalaxyCenter().getY());
    private final double deltaTime = 60 * 60 * 24; // 1 dia em segundos


    public Galaxy(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
        this.sun = (Sun) solarSystem.getBodies().get(0);
        setBackground(Color.BLACK);

        // Timer de atualização a cada 33ms (~30 FPS)
        Timer timer = new Timer(33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePhysics(); // Atualiza posições
                repaint();       
            }
        });
        timer.start();
    }

    private void updatePhysics() {
        for (CelestialBody body : solarSystem.getBodies()) {
            if (body instanceof Planet) {
                Planet planet = (Planet) body;
                Vector2D force = Physics.gravitationalForce(planet, sun);
                Physics.updateBody(planet, force, deltaTime);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.translate(galaxyCenterX, galaxyCenterY);
        g.setColor(Color.YELLOW);

        g.fillOval(-sunRadius, -sunRadius, sunRadius, sunRadius);

        for (CelestialBody body : solarSystem.getBodies()) {
            if (body instanceof Planet) {
                Vector2D pos = body.getPosition();
                Vector2D relativePos = pos.sub(sun.getPosition());
    
                double distReal = relativePos.magnitude();
                double distVisual = Math.sqrt(distReal);
    
                Vector2D direction = relativePos.normalize();
                Vector2D posVisual = direction.multiply(distVisual);
    
                double scale = 2.5e-4; // Ajuste para caber na tela
    
                int x = (int) (posVisual.getX() * scale);
                int y = (int) (posVisual.getY() * scale);
    
                if (body instanceof Planet) {
                    g.setColor(((Planet) body).getColor());
                } else {
                    g.setColor(Color.WHITE);
                }
    
                g.fillOval(x - 5, y - 5, 8, 8);
            }
        }
        
    }

    }
