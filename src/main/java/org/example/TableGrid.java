package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Main.frame;

public class TableGrid extends JPanel{
    static int table=0;
    TableGrid(){

        this.setLayout(null);
        this.setVisible(true);
        this.setBounds(170,120,610,640);
        JPanel tables = new JPanel();
        JButton btn1 = new JButton("101");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table =101;
                Main.cardLayoutPanel.add(new TakeOrder(), "1");
                Main.cardLayout.show(Main.cardLayoutPanel, "1");
                Main.cardLayoutPanel.revalidate();
                Main.cardLayoutPanel.repaint();
            }
        });
        JButton btn2 = new JButton("102");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table =102;
                Main.cardLayoutPanel.add(new TakeOrder(), "1");
                Main.cardLayout.show(Main.cardLayoutPanel, "1");
                Main.cardLayoutPanel.revalidate();
                Main.cardLayoutPanel.repaint();
            }
        });
        JButton btn3 = new JButton("103");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table =103;
                Main.cardLayoutPanel.add(new TakeOrder(), "1");
                Main.cardLayout.show(Main.cardLayoutPanel, "1");
                Main.cardLayoutPanel.revalidate();
                Main.cardLayoutPanel.repaint();
            }
        });
        JButton btn4 = new JButton("104");
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table =104;
                Main.cardLayoutPanel.add(new TakeOrder(), "1");
                Main.cardLayout.show(Main.cardLayoutPanel, "1");
                Main.cardLayoutPanel.revalidate();
                Main.cardLayoutPanel.repaint();
            }
        });
        JButton btn5 = new JButton("105");
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table =105;
                Main.cardLayoutPanel.add(new TakeOrder(), "1");
                Main.cardLayout.show(Main.cardLayoutPanel, "1");
                Main.cardLayoutPanel.revalidate();
                Main.cardLayoutPanel.repaint();
            }
        });
        JButton btn6 = new JButton("106");
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table =106;
                Main.cardLayoutPanel.add(new TakeOrder(), "1");
                Main.cardLayout.show(Main.cardLayoutPanel, "1");
                Main.cardLayoutPanel.revalidate();
                Main.cardLayoutPanel.repaint();
            }
        });
        JButton btn7 = new JButton("107");
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table =107;
                Main.cardLayoutPanel.add(new TakeOrder(), "1");
                Main.cardLayout.show(Main.cardLayoutPanel, "1");
                Main.cardLayoutPanel.revalidate();
                Main.cardLayoutPanel.repaint();
            }
        });
        JButton btn8 = new JButton("108");
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table =108;
                Main.cardLayoutPanel.add(new TakeOrder(), "1");
                Main.cardLayout.show(Main.cardLayoutPanel, "1");
                Main.cardLayoutPanel.revalidate();
                Main.cardLayoutPanel.repaint();
            }
        });
        JButton btn9 = new JButton("109");
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table =109;
                Main.cardLayoutPanel.add(new TakeOrder(), "1");
                Main.cardLayout.show(Main.cardLayoutPanel, "1");
                Main.cardLayoutPanel.revalidate();
                Main.cardLayoutPanel.repaint();
            }
        });


        tables.setLayout(new GridLayout(3,3,20,20));
        tables.setBounds(0,0,610, 640);
        tables.setVisible(true);
        tables.add(btn1); tables.add(btn2); tables.add(btn3);
        tables.add(btn4); tables.add(btn5); tables.add(btn6);
        tables.add(btn7); tables.add(btn8); tables.add(btn9);

        Font buttonFont = new Font("Arial", Font.PLAIN, 25);
        Color backgroundColor = new Color(102, 109, 165);
        for (JButton button : new JButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9}) {

            button.setFont(buttonFont); // Set font
            button.setBackground(new Color(102, 109, 165));
            button.setForeground(Color.WHITE);
        }
        this.add(tables);
        frame.repaint();
        frame.revalidate();
    }
}
