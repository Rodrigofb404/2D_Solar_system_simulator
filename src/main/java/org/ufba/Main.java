package org.ufba;

import java.awt.Color;

public class Main {
    public static void main(String[] args) {

        // Instatiates the sun (The solar system's star) 
        Star sun = new Star("sun", 1.989e30, 5.778e3, new Vector2D(0, 0), new Vector2D(0, 0));
        PlanetarySystem solarSystem = new PlanetarySystem(sun); // Creates the solar system with its star
        
        // Instatiates Solar System's plantes 
        Planet[] planets = new Planet[] {
             new Planet("Mercury", 3.30e23, new Vector2D(57.9e9, 0), new Vector2D(0, 47.87e3), Color.GRAY),
             new Planet("Venus", 4.87e24, new Vector2D(108.2e9, 0), new Vector2D(0, 35.02e3), new Color(218, 165, 32)),
             new Planet("Earth", 5.97e24, new Vector2D(149.6e9, 0), new Vector2D(0, 29.78e3), Color.BLUE),
             new Planet("Mars", 6.42e23, new Vector2D(227.9e9, 0), new Vector2D(0, 24.07e3), Color.RED),
             new Planet("Jupiter", 1.90e27, new Vector2D(778.5e9, 0), new Vector2D(0, 13.07e3), new Color(205, 133, 63)),
             new Planet("Saturn", 5.68e26, new Vector2D(1433.5e9, 0), new Vector2D(0, 9.69e3), new Color(210, 180, 140)),
             new Planet("Uranus", 8.68e25, new Vector2D(2872.5e9, 0), new Vector2D(0, 6.81e3), new Color(173, 216, 230)),
             new Planet("Neptune", 1.02e26, new Vector2D(4495.1e9, 0), new Vector2D(0, 5.43e3), new Color(25, 25, 112))
        };
        
        // Add the planets to the solar system
        for (Planet planet : planets) {
            solarSystem.addBody(planet);
        }   
        
        // Instantiates the GUI and open it
        GUI gui = new GUI(solarSystem);
        gui.openGUI();

    }
}
    