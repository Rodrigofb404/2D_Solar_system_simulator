package org.ufba;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
// import java.awt.geom.Ellipse2D;

public class GUI extends JPanel {
    static private int frameWidth;
    static private int frameHeight;
    static private final double proportion = 0.85;
    static private final int sunRadius = 50;  


    static class Galaxy extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // limpa o painel
            
            this.setBackground(Color.BLACK);
            g.setColor(Color.YELLOW); // Sun color
            g.fillOval(0, 0, sunRadius*2, sunRadius*2); // Draw the sun
        }  
    }

    static public void createGUI() {

        // Create the frame, the super class
        JFrame frame = new JFrame("Teste");
        frame.setTitle("2D Solar System Simulator");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frameWidth = frame.getWidth();
        frameHeight = frame.getHeight();
        
        // Create two different panels 
        Galaxy galaxy = new Galaxy();
        galaxy.setLayout(null);
        galaxy.add(new JLabel("Planets will be here"));
        
        JPanel controls = new JPanel();
        controls.setBackground(Color.GRAY);
        controls.add(new JLabel("controls will be here"));
        
        // Create a component that will be used to split the window 
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, galaxy, controls);
        
        frame.add(splitPane);
        frame.setVisible(true);
        
        // Configure the divider
        splitPane.setDividerSize(5);
        splitPane.setResizeWeight(proportion); // When resized, 85% of the space go to galaxy and 15% to controls
        
        splitPane.setEnabled(false); // Disable interaction with the splitPlane
        
        // These commands are executed only after the frame get visible
        SwingUtilities.invokeLater(() -> {
            int frameWidth = frame.getWidth();
            int galaxyWidth = (int) (proportion * frameWidth);
            splitPane.setDividerLocation(galaxyWidth);
        });
    }
    
}
