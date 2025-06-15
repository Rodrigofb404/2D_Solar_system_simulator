package org.ufba;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Control extends JPanel {
    public Control(ActionListener controlListener) {
        JButton slowBtn = new JButton("➖");
        JButton pauseBtn = new JButton("⏸/▶");
        JButton speedBtn = new JButton("➕");

        setBackground(Color.BLACK);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setPreferredSize(new Dimension(160, 30));

        slowBtn.setPreferredSize(new Dimension(50, 20));
        pauseBtn.setPreferredSize(new Dimension(70, 20));
        speedBtn.setPreferredSize(new Dimension(50, 20));

        slowBtn.setActionCommand("slow");
        pauseBtn.setActionCommand("pause");
        speedBtn.setActionCommand("speed");

        slowBtn.addActionListener(controlListener);
        pauseBtn.addActionListener(controlListener);
        speedBtn.addActionListener(controlListener);

        add(slowBtn);
        add(pauseBtn);
        add(speedBtn);
    }
}

