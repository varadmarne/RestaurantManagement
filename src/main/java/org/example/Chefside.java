package org.example;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.CurvedPanelWithClockExample.CurvedClockPanel.time;
import static org.example.Main.*;
import static org.example.TableGrid.table;


class OrderData extends JPanel{

    OrderData(String items,int table,int total){

        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setBounds(15,0,750,100);
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        JPanel list = new JPanel();
        list.setLayout(new GridLayout(0,3,10,10));
        list.setBounds(5,5,400,90);

        String[] data = items.split(",");
        for (String s : data) {

            JLabel jLabel = new JLabel(s);
            jLabel.setFont(new Font("Arial",Font.PLAIN,20));
            list.add(jLabel);
        }

        JLabel tableNum = new JLabel("Table:"+(table));
        tableNum.setFont(new Font("Arial",Font.PLAIN,20));
        tableNum.setBounds(600,10,100,40);

        JButton completeButton = new JButton("Complete");
        completeButton.setBounds(575,50,150,50);
        completeButton.setBackground(Color.green);
        completeButton.setForeground(Color.white);
        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove the panel itself (the one containing the button)
                JPanel thisPanel = (JPanel) SwingUtilities.getAncestorOfClass(JPanel.class, completeButton);
                if (thisPanel != null) {
                    Container parent = thisPanel.getParent(); // Get the parent container
                    parent.remove(thisPanel); // Remove the panel
                    parent.revalidate(); // Refresh the layout
                    parent.repaint();    // Repaint the parent container
                }
                MongoCollection col = db.getCollection("completedOrders");
                LocalDateTime currentDateTime = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = currentDateTime.format(formatter);
                Document doc = new Document("date",formattedDateTime)
                        .append("table number",table)
                        .append("items",items)
                        .append("total",total)
                .append("completion time",time);
                col.insertOne(doc);
            }
        });
        this.add(list);
        this.add(completeButton);
        this.add(new CurvedPanelWithClockExample());
        this.add(tableNum);
    }
}
public class Chefside extends JPanel {

    static JPanel orders = new JPanel();
    static JScrollPane scrollPane = new JScrollPane(orders);
    Chefside(){

        this.setLayout(null);
        JPanel panel = new JPanel(null);
        panel.setBounds(0,0,800,100);
        panel.setBackground(new Color(59, 73, 164));

        JLabel label = new JLabel("Restaurant Management System");
        label.setBounds(170,30,450,40);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setForeground(Color.white);
        panel.add(label);

        JPanel panel1 = new JPanel(null);
        panel1.setBounds(0,100,800,50);
        panel1.setBackground(Color.gray);

        JLabel label1 = new JLabel("Current Orders");
        label1.setBounds(320,5,450,40);
        label1.setFont(new Font("Arial", Font.PLAIN, 20));
        label1.setForeground(Color.white);
        panel1.add(label1);

        orders.setLayout(new BoxLayout(orders, BoxLayout.Y_AXIS));
        orders.setBounds(10,160,780,600);
        orders.setBackground(Color.lightGray);


        scrollPane.setBounds(10, 160, 780, 600);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane);
        this.add(panel1);
        this.add(panel);
        frame1.repaint();
        frame1.revalidate();
    }
}
