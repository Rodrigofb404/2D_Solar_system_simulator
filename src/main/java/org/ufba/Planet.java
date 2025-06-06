package org.ufba;

import java.awt.Color;

public class Planet extends CelestialBody {
    private int orbitalPeriod;

    private Color color;

    public Planet(String name, int orbitalPeriod, double mass, Vector2D position, Vector2D velocity, Color color) {
        super(name, mass, position, velocity);
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.color = color;
        }   

        public Color getColor() {
            return color;
        }
        
        public int getOrbitalPeriod () {
            return orbitalPeriod;
        }
}
