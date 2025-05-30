package org.ufba;

public class Physics {
    public static final double G = 6.67e-11;

    // Force exerted by particle B on particle A
    public static Vector2D gravitationalForce(CelestialBody body, Sun sun) {
        if (body.getPosition().equals(sun.getPosition())) return new Vector2D(0, 0);

        double distance = body.getPosition().euclideanDistance(sun.getPosition());
        double magnitudeForce = G * (body.getMass() * sun.getMass()) / (distance * distance);

        // Points from A to B (vector normalized)
        Vector2D direction = sun.getPosition().sub(body.getPosition()).normalize();

        // Force = direction * magnitudeForce
        return direction.multiply(magnitudeForce);
    }

    public static Vector2D centrifugalForce(CelestialBody body, Sun sun, double period) {
        if (period == 0) throw new IllegalArgumentException("The period can't be 0");

        double distance = body.getPosition().euclideanDistance(sun.getPosition());
        double angularVelocity = (2 * Math.PI) / period;
        double mass = body.getMass();

        Vector2D direction = body.getPosition().sub(sun.getPosition()).normalize().multiply(-1);

        return direction.multiply(mass * Math.pow(angularVelocity, 2) * distance);
    }
    
    public static Vector2D totalForce(CelestialBody body, Sun sun, double period) {
        Vector2D gravitationalForce = gravitationalForce(body, sun); 
        Vector2D centrifugalForce = centrifugalForce(body, sun, period);
        
        Vector2D totalForce = gravitationalForce.add(centrifugalForce);

        return totalForce;  
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
