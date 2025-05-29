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
        galaxy.add(new JLabel("Galaxy where planets will be"));
        
        JPanel controls = new JPanel();
        controls.setBackground(Color.GRAY);
        controls.add(new JLabel("Galaxy controllers"));
        
        frame.add(galaxy);
        frame.add(controls);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, galaxy, controls);
        
        int frameWidth = frame.getWidth();
        int galaxyWidth = (int) (0.7 * frameWidth);
        // int controlsWidth = (int) (0.3 * frameWidth);
        
        splitPane.setDividerLocation(galaxyWidth);
        
        // splitPane.setResizeWeight(0.7);

        frame.add(splitPane);
        
        frame.setVisible(true);
    }   
    public static void main(String[] args) {
        createGUI();
    }
}