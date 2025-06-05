package org.ufba;

import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        Sun sun = new Sun(1.989e30, new Vector2D(0, 0), new Vector2D(0, 0));
        SolarSystem system = new SolarSystem();

        CelestialBody[] planets = new CelestialBody[] {
             new Planets("Mercury", 88, 3.30e23, new Vector2D(57.9e9, 0), new Vector2D(0, 47.87e3), Color.GRAY),
             new Planets("Venus", 225, 4.87e24, new Vector2D(108.2e9, 0), new Vector2D(0, 35.02e3), new Color(218, 165, 32)),
             new Planets("Earth", 365, 5.97e24, new Vector2D(149.6e9, 0), new Vector2D(0, 29.78e3), Color.BLUE),
             new Planets("Mars", 687, 6.42e23, new Vector2D(227.9e9, 0), new Vector2D(0, 24.07e3), Color.RED),
             new Planets("Jupiter", 4333, 1.90e27, new Vector2D(778.5e9, 0), new Vector2D(0, 13.07e3), new Color(205, 133, 63)),
             new Planets("Saturn", 10759, 5.68e26, new Vector2D(1433.5e9, 0), new Vector2D(0, 9.69e3), new Color(210, 180, 140)),
             new Planets("Uranus", 30687, 8.68e25, new Vector2D(2872.5e9, 0), new Vector2D(0, 6.81e3), new Color(173, 216, 230)),
             new Planets("Neptune", 60190, 1.02e26, new Vector2D(4495.1e9, 0), new Vector2D(0, 5.43e3), new Color(25, 25, 112))
        };
        
        for (CelestialBody planet : planets) {
            system.addbody(planet); // ESSENCIAL: adiciona os planetas ao sistema
        }

        GUI.createGUI(system, sun);
    }
}
