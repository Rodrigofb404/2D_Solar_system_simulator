# 2D Solar System Simulator

This project is a 2D simulator of our solar system, developed in Java. It demonstrates the orbit of the planets around the Sun, using Newton's law of gravitation for the physics calculations. This project was developed as part of the activities for the Object-Oriented Programming (OOP) course at the Federal University of Bahia (UFBA).

## Overview

The simulator presents a simple graphical interface where it is possible to view the Sun and the planets of our solar system. The simulation calculates and updates the positions of the planets in real-time, based on their masses, velocities, and the gravitational force exerted by the Sun.

## Units of Measurement

The simulation uses the International System of Units (SI) for most of its internal physics calculations to maintain consistency with scientific standards.

* **Mass**: Measured in kilograms (kg).
* **Distance/Position**: Measured in meters (m). The initial positions of the planets are set using their real-world distance from the sun in meters (multiplied by a scale to fit on the screen).
* **Velocity**: Measured in meters per second (m/s).
* **Temperature**: The temperature of a star is measured in Kelvin (K).
* **Gravitational Constant (G)**: The value is `6.67e-11` $m^3 kg^{-1} s^{-2}$.
* **Time Step (`deltaTime`)**: The base time step for the simulation is calculated in seconds (s). The `BASE_SIMULATION_TIME` constant is set to `60 * 60 * 24` seconds, representing one day.

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

* **`-`**: Slows down the simulation speed.
* **`+`**: Increases the simulation speed.
* **`⏸/▶`**: Pauses or resumes the simulation.

## Troubleshooting

If the code doens't run, try to install JDK 24.
