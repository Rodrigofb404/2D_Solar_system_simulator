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
        return new ArrayList<>(planets); // Retorna uma cópia para evitar modificações externas
    }

    public Star getStar() {
        return new Star(sun); // Retorna uma cópia do Sol
    }

    public void update(double deltaTime) {
        for (Planet planet : planets) {
            Vector2D force = Physics.gravitationalForce(planet, sun); // Corrigido de 'star' para 'sun'
            Physics.updateBody(planet, force, deltaTime);
        }
    }
}
