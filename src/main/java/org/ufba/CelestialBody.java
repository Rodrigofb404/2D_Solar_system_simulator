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

// enum Bodies {
//     SUN("Sun", 0, 0.0),
//     MERCURY("Mercury", 88, 57.9),
//     VENUS("Venus", 225, 108.2),
//     EARTH("Earth", 365, 149.6),
//     MARS("Mars", 687, 227.9),
//     JUPITER("Jupiter", 4333, 778.5),
//     SATURN("Saturn", 10759, 1433.5),
//     URANUS("Uranus", 30687, 2872.5),
//     NEPTUNE("Neptune", 60190, 4495.1);

//     private final String name;
//     private final double period; 
//     private final double distanceToSun; // [10^6 Km]

//     private Bodies(String name, double period, double distanceToSun) {
//         this.name = name;
//         this.period = period;
//         this.distanceToSun = distanceToSun;
//     }

//     public String getName() {
//         return name;
//     }

//     public double getPeriod() { // Getter renomeado
//         return period;
//     }

//     public double getDistanceToSun() { // Getter para o novo campo
//         return distanceToSun;
//     }
// }

class Sun extends CelestialBody {
    public Sun(double mass, Vector2D position, Vector2D velocity) {
        super("Sun", mass, position, velocity);
    }
}

class Planets extends CelestialBody {
    private double distanceFromSun;
    private int orbitalPeriod;

    public Planets(String name, double distanceFromSun, int orbitalPeriod, double mass, Vector2D position, Vector2D velocity) {
        super(name, mass, position, velocity);
        this.distanceFromSun = distanceFromSun;
        this.orbitalPeriod = orbitalPeriod;
    }

    public double getDistanceToSun () {
        return distanceFromSun;
    }

    public int getOrbitalPeriod () {
        return orbitalPeriod;
    }
}

