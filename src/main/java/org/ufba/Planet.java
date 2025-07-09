package org.ufba;

import java.awt.Color;

public class Planet extends CelestialBody {
    private Color color;

    public Planet(String name, double mass, Vector2D position, Vector2D velocity, Color color) {
        super(name, mass, position, velocity);
        this.name = name;
        this.color = color;
        }   

        public Color getColor() {
            return color;
        }        
}
