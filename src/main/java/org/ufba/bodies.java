package org.ufba;

public enum bodies {
    SUN,
    MERCURY,
    VENUS,
    EARTH,
    MARS,
    JUPITER,
    SATURN,
    URANUS,
    NEPTUNE,
    PLUTO;

    public static bodies fromString(String name) {
        return bodies.valueOf(name.toUpperCase());
    }
}
