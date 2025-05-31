package org.ufba;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class GUI extends JPanel {
    static private int galaxyCenterX, galaxyCenterY;
    static private final double proportion = 0.85;
    static private final int sunRadius = 40;  
        
    static class Galaxy extends JPanel {

        // TODO: trocar pelo celestial body ou tornar essa o celestial body
        // ANALISAR: Talvez trocar o vetor de posição para 2 variáveis escalares individuais de posição (x e y) 
        //           seja mais simples do que lidar com o vetor.
        class Bodies {
            int x, y, radius;
            Color color;

            public Bodies(int x, int y, int radius, Color color) {
                this.x = x;
                this.y = y;
                this.radius = radius;
                this.color = color;
            }
        }

        private List<Bodies> solarSystem = new ArrayList<>();

        public Galaxy() {
            setBackground(Color.BLACK);
            solarSystem.add(new Bodies(-sunRadius, -sunRadius, 40, Color.YELLOW));  // Sol

            solarSystem.add(new Bodies(70, 0, 8, new Color(169, 169, 169)));   // Mercury
            solarSystem.add(new Bodies(110, 0, 12, new Color(255, 215, 0)));   // Venus
            solarSystem.add(new Bodies(150, 0, 12, new Color(0, 191, 255)));   // Earth
            solarSystem.add(new Bodies(190, 0, 10, new Color(255, 69, 0)));    // Mars
            solarSystem.add(new Bodies(260, 0, 22, new Color(255, 165, 0)));   // Jupiter
            solarSystem.add(new Bodies(330, 0, 18, new Color(210, 180, 140))); // Saturn
            solarSystem.add(new Bodies(390, 0, 16, new Color(173, 216, 230))); // Uranus
            solarSystem.add(new Bodies(450, 0, 16, new Color(0, 0, 139)));     // Neptune
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            // Clean panel
            super.paintComponent(g);                    
            
            // Move the origin to the middle of the frame
            g.translate(galaxyCenterX, galaxyCenterY); 
            
            // iterates over the bodies and paint the bodies
            for(Bodies bodies : solarSystem) {
                g.setColor(bodies.color);
                g.fillOval(bodies.x, bodies.y, bodies.radius * 2, bodies.radius * 2);
            }
        }  
    }

    static public void createGUI() {
        
        // Creates the frame, the super class
        JFrame frame = new JFrame("Teste");
        frame.setTitle("2D Solar System Simulator");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Creates the galaxy panel
        Galaxy galaxy = new Galaxy();
        galaxy.setLayout(null);
        galaxy.add(new JLabel("Planets will be here"));

        // Creates controls panel 
        Controls controls = new Controls();
        controls.setBackground(Color.GRAY);
        controls.add(new JLabel("controls will be here"));
        
        // Creates a component that will be used to split the window 
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, galaxy, controls);
        
        frame.add(splitPane);
        frame.setVisible(true);
        
        // Configures the divider
        splitPane.setDividerSize(5);
        splitPane.setResizeWeight(proportion); // When resized, 85% of the space go to galaxy and 15% to controls
        
        splitPane.setEnabled(false);           // Disable interaction with the splitPlane
        
        // These commands are executed only after the frame get visible
        SwingUtilities.invokeLater(() -> {
            int frameWidth = frame.getWidth();
            int frameHeight = frame.getHeight();
            int galaxyWidth = (int) (proportion * frameWidth);
            
            // Centers of the galaxy panel
            galaxyCenterX = galaxyWidth / 2;
            galaxyCenterY = frameHeight / 2;


            splitPane.setDividerLocation(galaxyWidth);
        });
    }
    
}
