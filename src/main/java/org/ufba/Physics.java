package org.ufba;

public class Physics {
    public static final double G = 6.67e-11;

    // Force exerted by particle B on particle A
    public static Vector2D gravitationalForce(CelestialBody body1, CelestialBody body2) {
        if (body1.getPosition().equals(body2.getPosition())) return new Vector2D(0, 0);

        double distance = body1.getPosition().euclideanDistance(body2.getPosition());
        double magnitudeForce = G * (body1.getMass() * body2.getMass()) / (distance * distance);

        // Points from A to B (vector normalized)
        Vector2D direction = body2.getPosition().sub(body1.getPosition()).normalize();

        // Force = direction * magnitudeForce
        return direction.multiply(magnitudeForce);
    }

    public static void updateBody(Planets body, Vector2D totalForce, double deltaTime) {
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
