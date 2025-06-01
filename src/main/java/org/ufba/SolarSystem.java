package org.ufba;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem<bodies> {
    private List<CelestialBody> bodies;
    private Physics physics;

    public SolarSystem() {
        this.bodies = new ArrayList<>();
        this.physics = new Physics();
    }


    public void addbody(CelestialBody body) {
        bodies.add(body);
    }

    public List<CelestialBody> getBodies() {
        return bodies;
    }

}