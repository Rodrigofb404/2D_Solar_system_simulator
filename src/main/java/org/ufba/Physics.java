package org.ufba;

public class Physics {
    public static final double G = 6.67e-11;

    // Force exerted by particle B on particle A
    public static Vector2D gravitationalForce(CelestialBody bodyA, CelestialBody bodyB) {
        if (bodyA.getPosition().equals(bodyB.getPosition())) return new Vector2D(0, 0);

        double distance = bodyA.getPosition().euclideanDistance(bodyB.getPosition());
        double magnitudeForce = G * (bodyA.getMass() * bodyB.getMass()) / (distance * distance);

        // Points from A to B (vector normalized)
        Vector2D direction = bodyB.getPosition().sub(bodyA.getPosition()).normalize();

        // Force = direction * magnitudeForce
        return direction.multiply(magnitudeForce);
    }

//    public static Vector2D centrifugalForce(CelestialBody body, Sun sun, double period) {
//        if (period == 0) throw new IllegalArgumentException("The period can't be 0");
//        double periodSeconds = period * 24 * 60 * 60; // Convert days to seconds
//
//        double distance = body.getPosition().euclideanDistance(sun.getPosition());
//        double angularVelocity = (2 * Math.PI) / periodSeconds;
//        double mass = body.getMass();
//
//        Vector2D direction = body.getPosition().sub(sun.getPosition()).normalize();
//
//        return direction.multiply(mass * Math.pow(angularVelocity, 2) * distance);
//    }
    
//    public static Vector2D totalForce(CelestialBody body, Sun sun, double period) {
//    Vector2D gravitationalForce = gravitationalForce(body, sun);
//    Vector2D centrifugalForce = centrifugalForce(body, sun, period);
//
//    return gravitationalForce.add(centrifugalForce);
//}


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
