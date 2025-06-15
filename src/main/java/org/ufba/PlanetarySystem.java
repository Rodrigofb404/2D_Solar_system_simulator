package org.ufba;

import java.util.ArrayList;
import java.util.List;

public class PlanetarySystem {
    private List<Planet> planets;
    private Star sun;

    public PlanetarySystem(Star sun) {
        this.sun = sun;
        this.planets = new ArrayList<>();
    }

    public void addBody(Planet planet) {
        planets.add(planet);
    }

    public List<Planet> getPlanets() {
        return new ArrayList<>(planets); 
    }

    public Star getStar() {
        return new Star(sun); 
    }

    public void update(double deltaTime) {
        for (Planet planet : planets) {
            Vector2D force = Physics.gravitationalForce(planet, sun); 
            Physics.updateBody(planet, force, deltaTime);
        }
    }
}
