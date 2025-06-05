package org.ufba;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {
    private List<CelestialBody> bodies; // DECLARAR COMO CELESTIAL BODY PARA PODER ADICIONAR TANTO O SOL COMO PLANETAS

    public SolarSystem() {
        bodies = new ArrayList<>();
    }

    public void addBody(CelestialBody body) {
        bodies.add(body);
    }

    public List<CelestialBody> getBodies() {
        return new ArrayList<>(bodies); // return a copy
    }
}
