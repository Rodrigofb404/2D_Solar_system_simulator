package org.ufba;

import java.awt.Color;
import javax.swing.*;

public class Main {

    static public void createGUI() {
        // Create the frame, the super class
        JFrame frame = new JFrame("Teste");
        frame.setSize(1500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create two different panels 
        JPanel galaxy = new JPanel();
        galaxy.setBackground(Color.BLACK);
        galaxy.add(new JLabel("Planets will be here"));
        
        JPanel controls = new JPanel();
        controls.setBackground(Color.GRAY);
        controls.add(new JLabel("controls will be here"));
        
        frame.add(galaxy);
        frame.add(controls);

        // Calculate the divider location
        int frameWidth = frame.getWidth();
        int galaxyWidth = (int) (0.85 * frameWidth);
        
        // Create a component that will be used to split the window 
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, galaxy, controls);

        // Configure the divider
        splitPane.setDividerSize(8);
        splitPane.setDividerLocation(galaxyWidth);
        splitPane.setResizeWeight(0.85); // When resized, 85% of the space go to galaxy and 15% to controls
        
        splitPane.setOneTouchExpandable(true);

        frame.add(splitPane);
        
        frame.setVisible(true);
    }   
    public static void main(String[] args) {
        createGUI();
    }
}