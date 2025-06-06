package org.ufba;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;


// Falta ajustar os botões, posicionar eles no na tela e adicionar os eventos a eles (ajustar deltaTime)

/* No momento este painel está sendo adicionado ao painel "Galaxy" pq não está funcionando no frame.
   Mas acredito que adicionar direto ao frame pode ser melhor, uma vez que não precisaria mudar o layout
   do resto*/ 
public class Control extends JPanel {

    public Control() {
        // Definir um icone (ver se tem como fazer ele buscar do google sem ter que baixar a imagem)
        JButton slowBtn = new JButton("➖");
        JButton pauseBtn = new JButton("⏸");
        JButton speedBtn = new JButton("➕");
        setBackground(Color.BLACK);

        // Define o layout do painel
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        setPreferredSize(new Dimension(160, 30));  // Largura 300px, altura 50px

        slowBtn.setPreferredSize(new Dimension(50, 20));  // Largura 50px, altura 20px
        pauseBtn.setPreferredSize(new Dimension(50,20));
        speedBtn.setPreferredSize(new Dimension(50,20));

        // Adiciona os botões ao painel
        add(slowBtn);
        add(pauseBtn);
        add(speedBtn);
    }
}
