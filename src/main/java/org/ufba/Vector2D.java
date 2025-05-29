package org.ufba;

import java.util.Vector;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(Vector2D other) {
        this.x = other.x;
        this.y = other.y;
    }

    // Getters
    public double getX() {return x;}
    public double getY() {return y;}

    // Setters
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}

    // Vector Operations
    // Addition
    public Vector2D add(Vector2D v) {
        return new Vector2D(x + v.getX(), y + v.getY());
    }

    // Subtraction
    public Vector2D sub(Vector2D v) {
        return new Vector2D(x - v.getX(), y - v.getY());
    }

    // Scalar multiplication
    public Vector2D multiply(double scalar) {
        return new Vector2D(x * scalar, y * scalar);
    }

    // Scalar division
    public Vector2D divide(double scalar) {
        if (scalar == 0) throw new ArithmeticException("Division by zero");
        return new Vector2D(x / scalar, y / scalar);
    }

    // Dot Product
    public Vector2D dotProduct(Vector2D v) {
        return new Vector2D(x * v.getX(), y * v.getY());
    }

    // Magnitude
    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }

    // Normalization
    public Vector2D normalize() {
        if (x == 0 && y == 0) return new Vector2D(0, 0);
        return new Vector2D(x / magnitude(), y / magnitude());
    }

    // Euclidean Distance
    public double euclideanDistance(Vector2D v) {
        return sub(v).magnitude();
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Vector2D)) return false;

        Vector2D v = (Vector2D) obj;
        return x == v.getX() && y == v.getY();
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }
}
