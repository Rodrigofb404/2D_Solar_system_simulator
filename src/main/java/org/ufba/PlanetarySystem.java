package org.ufba;

import java.util.ArrayList;
import java.util.List;

public class PlanetarySystem {
    private List<Planet> planets; // DECLARAR COMO CELESTIAL BODY PARA PODER ADICIONAR TANTO O SOL COMO PLANETAS
    private Star sun;

    public PlanetarySystem(Star sun) {
        planets = new ArrayList<>();
        this.sun = sun; 
    }

    public void addBody(Planet planet) {
        planets.add(planet);
    }

    public List<Planet> getPlanets() {
        return new ArrayList<>(planets); // return a copy
    }

    public Star getStar() {
        return new Star(sun);
    }
}
