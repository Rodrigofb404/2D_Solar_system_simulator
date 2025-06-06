package org.ufba;

import java.awt.Color;

public class Star extends CelestialBody {
    private double temperature; 
    private Color color;

    public Star(String name, double mass, double temperature, Vector2D position, Vector2D velocity) {
        super(name, mass, position, velocity);
        this.temperature = temperature;
        defineStarColor();
    }

    public Star(Star other) {
        super(other.getName(), other.getMass(), new Vector2D(other.getPosition()), new Vector2D(other.getVelocity()));
        this.temperature = other.getTemperature();
        defineStarColor();
    }

    public double getTemperature() {
        return temperature;
    }

    public Color getColor() {
        return color; // Color is an enum, so it's imutable once defined
    }

    public void defineStarColor() {
        if (temperature >= 10000) {
            // Very hot stars
            color = new Color(135, 206, 250); // Blue star
        } else if (temperature >= 6000) {
            // Hot stars
            color = Color.WHITE;
        } else {
            // cooler stars
            color = Color.YELLOW;
        }
    }

}
