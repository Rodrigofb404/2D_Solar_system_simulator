package org.ufba;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Galaxy extends JPanel {
    private PlanetarySystem planetarySystem;
    private Star sun;

    // Constants
    static private final int sunRadius = 50;
    private final int galaxyCenterX = (int) (GUI.getGalaxyCenter().getX());
    private final int galaxyCenterY = (int) (GUI.getGalaxyCenter().getY());

    // Constructor
    public Galaxy(PlanetarySystem planetarySystem) {
        this.planetarySystem = planetarySystem;
        this.sun = planetarySystem.getStar();
        setBackground(Color.BLACK);
    }
    
    private void drawPlanetarySystem(Graphics g) {
        for (Planet body : planetarySystem.getPlanets()) {
            Vector2D pos = body.getPosition();

            // Get distance from sun and decrease the size of the orbits
            double distReal = pos.magnitude();
            double distVisual = Math.sqrt(distReal); 
            
            // Create the position vector of each planet
            Vector2D direction = pos.normalize();
            Vector2D posVisual = direction.multiply(distVisual);

            final double SCALE = 2.5e-4; // size factor 

            // Adjust orbits' sizes to fit on the frame
            int x = (int) (posVisual.getX() * SCALE);
            int y = (int) (posVisual.getY() * SCALE);
    
            g.setColor(body.getColor());
    
            g.fillOval(x - 20, y - 20, 10, 10);
            }
        }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.translate(galaxyCenterX, galaxyCenterY);
        g.setColor(sun.getColor());

        g.fillOval(-sunRadius, -sunRadius, sunRadius, sunRadius);

        drawPlanetarySystem(g);

    }
}