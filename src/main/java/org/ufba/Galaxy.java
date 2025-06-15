package org.ufba;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Galaxy extends JPanel {
    private PlanetarySystem planetarySystem;
    private Star sun;

    // Constants
    static private final int sunRadius = 35;
    private final int galaxyCenterX = (int) (GUI.getGalaxyCenter().getX());
    private final int galaxyCenterY = (int) (GUI.getGalaxyCenter().getY());


    public Galaxy(PlanetarySystem planetarySystem) {
        this.planetarySystem = planetarySystem;
        this.sun = planetarySystem.getStar();
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.translate(galaxyCenterX, galaxyCenterY);
        g.setColor(sun.getColor());

        g.fillOval(-sunRadius, -sunRadius, sunRadius, sunRadius);

        for (Planet body : planetarySystem.getPlanets()) {
            Vector2D pos = body.getPosition();
            Vector2D relativePos = pos.sub(sun.getPosition());

            double distReal = relativePos.magnitude();
            double distVisual = Math.sqrt(distReal);

            Vector2D direction = relativePos.normalize();
            Vector2D posVisual = direction.multiply(distVisual);

            double scale = 2.5e-4; // Adjust to fit on the frame

            int x = (int) (posVisual.getX() * scale);
            int y = (int) (posVisual.getY() * scale);
    
            if (body instanceof Planet) {
                g.setColor(body.getColor());
            } else {
                g.setColor(Color.WHITE);
            }
    
                g.fillOval(x - 5, y - 5, 8, 8);
            }
        }
        
    }