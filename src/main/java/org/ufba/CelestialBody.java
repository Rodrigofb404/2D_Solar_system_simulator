package org.ufba;

import java.awt.Color;

public class CelestialBody {
    String name;
    private double mass;
    private Vector2D position;
    private Vector2D velocity;
    private Vector2D acceleration; 

    public CelestialBody(String name, double mass, double par1, Vector2D position, Vector2D velocity) {
        if (mass <= 0) throw new IllegalArgumentException("Mass must be greater than zero");
        
        this.name = name;
        this.mass = mass; 
        this.position = position;
        this.velocity = velocity;
    }

    // Getters
    public double getMass() {return mass;}
    public Vector2D getPosition() {return new Vector2D(position);}
    public Vector2D getVelocity() {return new Vector2D(velocity);}
    public Vector2D getAcceleration() {return new Vector2D(acceleration);}
    public String getName() {return name;}

    // Setters
    public void setMass(double mass) {this.mass = mass;}
    public void setPosition(Vector2D position) {this.position = position;}
    public void setVelocity(Vector2D velocity) {this.velocity = velocity;}
    public void setAcceleration(Vector2D acceleration) {this.acceleration = acceleration;}
    public void setName(String name) {this.name = name;}
}





