package org.ufba;

public class CelestialBody {
    private String name;
    private double mass;
    private Vector2D position;
    private Vector2D velocity;
    private Vector2D acceleration; 

    public CelestialBody(String name, double mass, Vector2D position, Vector2D velocity) {
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

enum Bodies {
    SUN("Sun", 0), 
    MERCURY("Mercury", 88),   
    VENUS("Venus", 225),      
    EARTH("Earth", 365),      
    MARS("Mars", 687),        
    JUPITER("Jupiter", 4333), 
    SATURN("Saturn", 10759),  
    URANUS("Uranus", 30687),  
    NEPTUNE("Neptune", 60190);

    private final String name;
    private final double period;

    private Bodies (String name, double period) {
        this.name = name;
        this.period = period;
    }

    public String getName() {
        return name;
    }

    public double getPeriod() {
        return period;
    }
}

class Sun extends CelestialBody {
    public Sun(double mass, Vector2D position, Vector2D velocity) {
        super(Bodies.SUN.getName(), mass, position, velocity);
    }
}

class Planets extends CelestialBody {
    public Planets(String name, double mass, Vector2D position, Vector2D velocity) {
        super(name, mass, position, velocity);
    }
}

