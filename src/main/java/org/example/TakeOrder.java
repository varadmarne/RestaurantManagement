package org.example;

import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import static org.example.Chefside.orders;
import static org.example.Main.*;
import static org.example.TableGrid.table;

class RoundedBorder implements Border {
    private int radius;

    RoundedBorder(int radius) {
        this.radius = radius;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 1, this.radius + 1);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw a rounded rectangle border
        g2d.setColor(Color.GRAY); // Set the border color
        g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}

public class TakeOrder extends JPanel{

    private void addFixedSizeComponent(JPanel panel, JComponent component, int width, int height) {
        component.setMaximumSize(new Dimension(width, height));
        component.setPreferredSize(new Dimension(width, height));
        component.setMinimumSize(new Dimension(width, height));
        panel.add(component);
    }
    static String items = "";
    static int total = 0;
    static int height = 10;
    static JPanel order = new JPanel();
    TakeOrder(){


        this.setBounds(0,0,800,800);
        this.setVisible(true);
        this.setLayout(null);
        JPanel headPanel = new JPanel(null);
        headPanel.setBounds(0,0,800,100);
        headPanel.setBackground(new Color(59, 73, 164));

        JLabel label = new JLabel("Restaurant Management System");
        label.setBounds(170,30,450,40);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setForeground(Color.white);
        headPanel.add(label);

        JPanel menu = new JPanel(new GridLayout(8,1,0,10));
        menu.setBounds(20,120,200,600);


        JButton btn1 = new JButton("Pohe");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(items, "")){
                    items="Pohe";
                    total = total + 20;
                    System.out.println(total);

                    JLabel label = new JLabel("Pohe");
                    label.setBounds(10,height,380,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();

                } else {

                    items=items+",Pohe";
                    total = total + 20;

                    JLabel label = new JLabel("Pohe");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                }
            }
        });
        JButton btn2 = new JButton("Upma");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(items, "")){
                    items="Upma";
                    total = total + 20;
                    JLabel label = new JLabel("Upma");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                } else {

                    items=items+",Upma";
                    total = total + 20;
                    JLabel label = new JLabel("Upma");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                }
            }
        });
        JButton btn3 = new JButton("Idli Sambar");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(items, "")){
                    items="Idli Sambar";
                    total = total + 30;
                    JLabel label = new JLabel("Idli Sambar");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                } else {

                    items=items+",Idli Sambar";
                    total = total + 30;
                    JLabel label = new JLabel("Idli Sambar");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                }
            }
        });
        JButton btn4 = new JButton("Medu Vada");
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(items, "")){
                    items="Medu Vada";
                    total = total + 30;
                    JLabel label = new JLabel("Medu Vada");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                } else {

                    items=items+",Medu Vada";
                    total = total + 30;
                    JLabel label = new JLabel("Medu Vada");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                }
            }
        });
        JButton btn5 = new JButton("Sandwich");
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(items, "")){
                    items="Sandwich";
                    total = total + 45;
                    JLabel label = new JLabel("Sandwich");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                } else {

                    items=items+",Sandwich";
                    total = total + 45;
                    JLabel label = new JLabel("Medu Vada");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                }
            }
        });
        JButton btn6 = new JButton("Paratha");
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(items, "")){
                    items="Paratha";
                    total = total + 50;
                    JLabel label = new JLabel("Paratha");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                } else {

                    items=items+",Paratha";
                    total = total + 50;
                    JLabel label = new JLabel("Paratha");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                }
            }
        });
        JButton btn7 = new JButton("Dosa");
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(items, "")){
                    items="Dosa";
                    total = total + 60;
                    JLabel label = new JLabel("Dosa");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                } else {

                    items=items+",Dosa";
                    total = total + 60;
                    JLabel label = new JLabel("Dosa");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                }
            }
        });
        JButton btn8 = new JButton("Cold Drink");
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Objects.equals(items, "")){
                    items="Cold Drink";
                    total = total + 20;
                    JLabel label = new JLabel("Cold Drink");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                } else {

                    items=items+",Cold Drink";
                    total = total + 20;
                    JLabel label = new JLabel("Cold Drink");
                    label.setBounds(10,height,370,70);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);
                    label.setFont(new Font("Arial", Font.PLAIN,20));
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    label.setVerticalAlignment(SwingConstants.CENTER);
                    height = height+80;
                    order.add(label);
                    order.repaint();
                    System.out.println(total);
                }
            }
        });

        Font buttonFont = new Font("Arial", Font.PLAIN, 25);

        for (JButton button : new JButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8}) {
            button.setFont(buttonFont); // Set font
            button.setBackground(new Color(102, 109, 165)); // Set background color
            button.setForeground(Color.WHITE); // Set font color to white
        }
        menu.add(btn1); menu.add(btn2); menu.add(btn3);
        menu.add(btn4); menu.add(btn5); menu.add(btn6);
        menu.add(btn7); menu.add(btn8);


        JPanel price = new JPanel(new GridLayout(8,1,0,10));
        price.setBounds(240,120,50,600);

        int[] numbers = {20, 20, 30, 30, 45, 50, 60, 20};
        for (int i = 0; i < numbers.length; i++) {
            JLabel label1 = new JLabel("₹"+String.valueOf(numbers[i]), SwingConstants.CENTER) {
                @Override
                protected void paintComponent(Graphics g) {
                    // Enable anti-aliasing for smoother edges
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                    // Create a rounded rectangle shape
                    RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
                    g2d.setClip(roundedRectangle);

                    // Call super to paint the label normally
                    super.paintComponent(g);
                }
            };
            label1.setFont(new Font("Arial", Font.PLAIN, 20));
            label1.setOpaque(true);
            label1.setBackground(new Color(102, 109, 165));
            label1.setForeground(Color.WHITE);
            price.add(label1);
        }



        order.setBounds(350,120,400,550);
        order.setBackground(Color.lightGray);
        order.setBorder(new RoundedBorder(20));

        JButton submit = new JButton("Give Order");
        submit.setBounds(350,680,400,50);
        submit.setOpaque(true);
        submit.setBackground(Color.green);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = currentDateTime.format(formatter);
                Document doc = new Document("date",formattedDateTime)
                        .append("table number",table)
                        .append("items",items)
                        .append("total",total);
                col.insertOne(doc);
                addFixedSizeComponent(orders, new OrderData(items,table,total), 750, 100);
                items="";
                total=0;
                order.removeAll();
                height=10;
                Main.cardLayoutPanel.removeAll();
                Main.cardLayoutPanel.add(new MainInterface(), "1");
                Main.cardLayout.show(Main.cardLayoutPanel, "1");
                Main.cardLayoutPanel.revalidate();
                Main.cardLayoutPanel.repaint();
                frame1.repaint();
                frame1.revalidate();

            }
        });


        this.add(order);
        this.add(headPanel);
        this.add(menu);
        this.add(price);
        this.add(submit);
        frame.repaint();
        frame.revalidate();
    }
}
