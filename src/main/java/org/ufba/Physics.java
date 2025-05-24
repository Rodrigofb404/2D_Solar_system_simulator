package org.ufba;

public class Physics {
    public static final double G = 6.67e-11;

    // Force exerted by particle B on particle A
    public static Vector2D gravitationalForce(CelestialBody a, CelestialBody b) {
        if (a.getPosition().equals(b.getPosition())) return new Vector2D(0, 0);

        double distance = a.getPosition().euclideanDistance(b.getPosition());
        double magnitudeForce = G * (a.getMass() * b.getMass()) / (distance * distance);

        // Points from A to B (vector normalized)
        Vector2D direction = b.getPosition().sub(a.getPosition()).normalize();

        // Force = direction * magnitudeForce
        return direction.multiply(magnitudeForce);
    }

    public static void updateBody(CelestialBody body, Vector2D totalForce, double deltaTime) {
        // newAcceleration = Force / mass
        Vector2D newAcceleration = totalForce.divide(body.getMass());

        /*
        Backward Euler Method
        velocity[i+1] = velocity[i] + acceleration[i+1]*deltaTime
        position[i+1] = position[i] + velocity[i+1]*deltaTime
        */
        Vector2D newVelocity = body.getVelocity().add(newAcceleration.multiply(deltaTime));
        Vector2D newPosition = body.getPosition().add(newVelocity.multiply(deltaTime));

        body.setAcceleration(newAcceleration);
        body.setVelocity(newVelocity);
        body.setPosition(newPosition);
    }
}
