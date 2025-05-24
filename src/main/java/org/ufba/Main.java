package org.ufba;

public class Main {

    public static void main(String[] args) {
        Vector2D v = new Vector2D(4,5);
        Vector2D v2 = new Vector2D(4,2);

        double mag = v.magnitude();
        double d = v.euclideanDistance(v2);
        System.out.println("Magnitude of v: " + mag + "\nEuclidean distance between v and v2: " + d);
    }
}