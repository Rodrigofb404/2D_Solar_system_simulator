package org.ufba;

public class CelestialBody {
    private String name;
    private double mass;
    private Vector2D position;
    private Vector2D velocity;
    private Vector2D acceleration;

    public CelestialBody(String name, double mass, Vector2D position, Vector2D velocity) {
        this.name = name;
        if (mass <= 0) throw new IllegalArgumentException("Mass must be greater than zero");
        this.mass = mass;
        this.position = position;
        this.velocity = velocity;
    }

    // Getters
    public double getMass() {return mass;}
    public Vector2D getPosition() {return position;}
    public Vector2D getVelocity() {return velocity;}
    public Vector2D getAcceleration() {return acceleration;}
    public String getName() {return name;}

    // Setters
    public void setMass(double mass) {this.mass = mass;}
    public void setPosition(Vector2D position) {this.position = position;}
    public void setVelocity(Vector2D velocity) {this.velocity = velocity;}
    public void setAcceleration(Vector2D acceleration) {this.acceleration = acceleration;}
    public void setName(String name) {this.name = name;}


}

