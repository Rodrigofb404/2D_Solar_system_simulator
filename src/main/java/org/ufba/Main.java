package org.ufba;

import java.awt.Color;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Sempre rode GUIs no Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            GUI.createGUI(); // agora vai chamar corretamente
        });
    }
}