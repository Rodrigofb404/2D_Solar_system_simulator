# 2D Solar System Simulator

This project is a 2D simulator of our solar system, developed in Java. It demonstrates the orbit of the planets around the Sun, using Newton's law of gravitation for the physics calculations. This project was developed as part of the activities for the Object-Oriented Programming (OOP) course at the Federal University of Bahia (UFBA).

## Overview

The simulator presents a simple graphical interface where it is possible to view the Sun and the planets of our solar system. The simulation calculates and updates the positions of the planets in real-time, based on their masses, velocities, and the gravitational force exerted by the Sun.

## Units

This projects is using the SI Units.

* Velocity [m/s]
* Accelaration [m^2/s]
* Mass [M]
* Force [N]
* Position [m]

## Features

* **Physics Simulation:** The movement of the planets is governed by Newton's gravitational force formula. The simulation uses the Euler method to update the position and velocity of the bodies.
* **Speed Control:** It is possible to speed up, slow down, and pause the simulation to observe the orbits in more detail.
* **Visual Representation:** Each planet is represented by a distinct color. The Sun also has a color that varies according to its temperature.

## Project Structure

The source code is divided into the following Java classes:

* **`Main.java`**: It is responsible for instantiating the solar system, the planets, and the graphical interface.
* **`CelestialBody.java`**: Base class that defines the common properties for all celestial bodies, such as name, mass, position, and velocity.
* **`Planet.java`**: Extends `CelestialBody` and represents a planet, adding properties like orbital period and color.
* **`Star.java`**: Extends `CelestialBody` and represents a star (the Sun, in this case), with attributes like temperature and color.
* **`PlanetarySystem.java`**: Manages the set of planets and the central star. It is responsible for updating the state of each planet in the simulation.
* **`Physics.java`**: Contains the logic for the physics calculations, including the gravitational force and updating the position and velocity of the bodies.
* **`Vector2D.java`**: A utility class to represent and perform operations with 2D vectors (position, velocity, acceleration, etc.).
* **`GUI.java`**: Responsible for creating and managing the graphical interface window, using the Swing library.
* **`Galaxy.java`**: A panel (JPanel) that draws the planetary system on the screen.
* **`Control.java`**: A panel (JPanel) that contains the simulation control buttons.

## Simulation Controls

The graphical interface offers the following controls at the bottom of the screen:

* **`➖`**: Slows down the simulation speed.
* **`➕`**: Increases the simulation speed.
* **`⏸/▶`**: Pauses or resumes the simulation.

## Troubleshooting

If the code doens't run, try to install JDK 24.
