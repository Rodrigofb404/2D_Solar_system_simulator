        // TODO 1: trocar pelo celestial body ou tornar essa o celestial body
        //OK! TODO 2: Verificar como utilizar o TIMER do Java Swing (ele provavelmente será o responsável por atualizar a tela) 
        // TODO 3: Definir quais parâmetros poderão ser alterados no simulador (Acho que vi algo parecido na internet, dá para usar de inspiração)
        // TODO 4: ("Opcional"): Se os parâmetros mudarem, decidir como será feita a seleção de qual planeta receberá as mudanças
        // TODO 5: Se confirmar o uso do TIMER, descobrir como aplicar a física aos planetas e ligar isso à taxa de atualização do TIMER 
        //OK! ANALISAR: Talvez trocar o vetor de posição para 2 variáveis escalares individuais de posição (x e y) seja mais simples do que lidar com o vetor.

package org.ufba;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GUI extends JPanel {
    static private int galaxyCenterX, galaxyCenterY;
    static private final double proportion = 0.85;
    static private final int sunRadius = 40;  
        
    static class Galaxy extends JPanel {
    private SolarSystem<CelestialBody> system;
    private Sun sun;

    private final double deltaTime = 60 * 60 * 24; // 1 dia em segundos

    Galaxy(SolarSystem<CelestialBody> system1, Sun sun) {
        this.system = system1;
        this.sun = sun;
        setBackground(Color.BLACK);

        // Timer de atualização a cada 50ms (~20 FPS)
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePhysics(); // Atualiza posições
                repaint();       
            }
        });
        timer.start();
    }

    private void updatePhysics() {

        // HashMap with key (Planet) and value (Force)
        Map<CelestialBody, Vector2D> totalForce = new HashMap<>();

        // Loop with all bodies to calculate total force
        for (CelestialBody bodyA : system.getBodies()) {
            Vector2D totalForceBodyA = new Vector2D(0, 0);

            // Gravitational force for Sun on BodyA
            totalForceBodyA = totalForceBodyA.add(Physics.gravitationalForce(bodyA, sun));

            // Loop with all bodies (except bodyA) to calculate total force on BodyA
            for (CelestialBody bodyB : system.getBodies()) {
                if (bodyB != bodyA) {
                    totalForceBodyA = totalForceBodyA.add(Physics.gravitationalForce(bodyA, bodyB));

                }
            }
            // Add totalForceBodyA to HashMap with key (Planet bodyA) and value (Force)
            totalForce.put(bodyA, totalForceBodyA);
        }

        // Loop with all bodies to update their physics
        for (CelestialBody body : system.getBodies()) {
            if (body instanceof Planets) {
                Planets planet = (Planets) body;

                Vector2D force = totalForce.get(body);
                Physics.updateBody(planet, force, deltaTime);
            }
        }
    }

        @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.YELLOW);

        int sunX = galaxyCenterX - sunRadius / 2;
        int sunY = galaxyCenterY - sunRadius / 2;
        g2d.fillOval(sunX, sunY, sunRadius, sunRadius);

        for (CelestialBody body : system.getBodies()) {
            Vector2D pos = body.getPosition();
            Vector2D relativePos = pos.sub(sun.getPosition());

            double distReal = relativePos.magnitude();
            double distVisual = Math.sqrt(distReal);

            Vector2D direction = relativePos.normalize();
            Vector2D posVisual = direction.multiply(distVisual);

            double scale = 3e-4; // Ajuste para caber na tela

            int x = (int) (galaxyCenterX + posVisual.getX() * scale);
            int y = (int) (galaxyCenterY + posVisual.getY() * scale);

            if (body instanceof Planets) {
                g2d.setColor(((Planets) body).getColor());
            } else {
                g2d.setColor(Color.WHITE);
            }

            g2d.fillOval(x - 5, y - 5, 10, 10);
        }
    }

    }



    static class Controls extends JPanel {

        public Controls() {
            setBackground(Color.LIGHT_GRAY);
            add(new JLabel("controls will be here"));
            JSlider ChangeWeightSlider = new JSlider();
            add(ChangeWeightSlider);
        } 
    }

    public static void createGUI(SolarSystem system, Sun sun) {
    JFrame frame = new JFrame("2D Solar System Simulator");
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    SwingUtilities.invokeLater(() -> {
        Galaxy galaxy = new Galaxy(system, sun);
        Controls controls = new Controls();
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, galaxy, controls);

        frame.add(splitPane);
        frame.setVisible(true);

        splitPane.setDividerSize(5);
        splitPane.setResizeWeight(proportion);
        splitPane.setEnabled(false);
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        int galaxyWidth = (int) (proportion * frameWidth);

        galaxyCenterX = galaxyWidth / 2;
        galaxyCenterY = frameHeight / 2;

        splitPane.setDividerLocation(galaxyWidth);
    });
}

    
}
