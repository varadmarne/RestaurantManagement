package org.example;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

import static org.example.Main.frame;

public class MainInterface extends JPanel{

    MainInterface(){

        this.setLayout(null);
        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,800,100);
        panel.setBackground(new Color(59, 73, 164));

        JLabel label = new JLabel("Restaurant Management System");
        label.setBounds(170,30,450,40);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setForeground(Color.white);
        panel.add(label);

        JPanel sidePanel = new JPanel();
        sidePanel.setBounds(0,100,150,700);
        sidePanel.setBackground(new Color(102, 109, 165, 255));

        this.add(sidePanel);
        this.add(panel);
        this.add(new TableGrid());
        frame.repaint();
        frame.revalidate();
    }
}
