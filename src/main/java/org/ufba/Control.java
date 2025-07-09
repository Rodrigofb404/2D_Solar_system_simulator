package org.ufba;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Control extends JPanel {
    public Control(ActionListener controlListener) {
        // Creates the three buttons that will control the simulation.
        JButton slowBtn = new JButton("➖");
        JButton pauseBtn = new JButton("⏸/▶");
        JButton speedBtn = new JButton("➕");
        
        // Visual settings for the panel
        setBackground(Color.BLACK);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setPreferredSize(new Dimension(160, 30));

        // Visual settings for the buttons
        slowBtn.setPreferredSize(new Dimension(50, 20));
        pauseBtn.setPreferredSize(new Dimension(70, 20));
        speedBtn.setPreferredSize(new Dimension(50, 20));

        // Set the string that identify what each button should do
        slowBtn.setActionCommand("slow");
        pauseBtn.setActionCommand("pause");
        speedBtn.setActionCommand("speed");
        
        // Set the ActionListener of each button. When a button is clicked
        // the ActionListener will read the ActionCommand and will trigger
        // the event according it. 
        slowBtn.addActionListener(controlListener);
        pauseBtn.addActionListener(controlListener);
        speedBtn.addActionListener(controlListener);

        add(slowBtn);
        add(pauseBtn);
        add(speedBtn);
    }
}

