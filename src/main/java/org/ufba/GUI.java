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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class GUI extends JPanel {
    static private double galaxyCenterX, galaxyCenterY;
    private JFrame frame;

    public GUI(SolarSystem solarSystem) {
        configFrame();
        calcFrameParameters();
        Control control = new Control();
        Galaxy galaxy = new Galaxy(solarSystem);
        galaxy.add(control);
        frame.add(galaxy);
    }

    // Configures the frame's initial state
    public void configFrame() {
        frame = new JFrame("2D Solar System Simulator");
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1150, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Initialize the frame centralized on the screen

    }
    
    // Calculates useful frame's parameters
    public void calcFrameParameters() {
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();

        galaxyCenterX = frameWidth / 2;
        galaxyCenterY = frameHeight / 2;
    }

    // Shows the GUI on screen
    public void openGUI() {
        frame.setVisible(true);
    }

    // Gets the galaxy center coordinates
    static public Vector2D getGalaxyCenter() {
        Vector2D galaxyCenter = new Vector2D(galaxyCenterX, galaxyCenterY);

        return galaxyCenter; 
    }
}
