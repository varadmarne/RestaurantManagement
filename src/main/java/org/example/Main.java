package org.example;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import javax.swing.*;
import java.awt.*;

public class Main {

    static String uri = "mongodb://localhost:27017";
    static MongoClient client= MongoClients.create(uri);
    //static MongoClient client= MongoClients.create("mongodb+srv://varadmarne22:hello123@hell.bqcfu.mongodb.net/?retryWrites=true&w=majority&appName=HELL");
    static MongoDatabase db = client.getDatabase("RestaurantManagement");
    static MongoCollection col = db.getCollection("hotel");
    public static JFrame frame = new JFrame("Restaurant Management System");
    public static JFrame frame1 = new JFrame("Restaurant Management System");
    static CardLayout cardLayout=new CardLayout();
    static JPanel cardLayoutPanel=new JPanel();
    static JPanel cardLayoutPanel1=new JPanel();
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        MongoClient client= MongoClients.create("mongodb+srv://varadmarne22:hello123@hell.bqcfu.mongodb.net/?retryWrites=true&w=majority&appName=HELL");
        MongoDatabase db = client.getDatabase("RestaurantManagement");
        MongoCollection col = db.getCollection("hotel");

        //Document doc = new Document("_id","1").append("name","nilesh");
        //col.insertOne(doc);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        cardLayoutPanel.setLayout(cardLayout);
        cardLayoutPanel.setSize(800,800);
        cardLayoutPanel.add(new MainInterface(),0);
        frame.add(cardLayoutPanel);
        frame.repaint();
        frame.revalidate();



        frame1.setLayout(null);
        frame1.setVisible(true);
        frame1.setSize(800,800);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayoutPanel1.setLayout(cardLayout);
        cardLayoutPanel1.setSize(800,800);
        cardLayoutPanel1.add(new Chefside(),0);
        frame1.add(cardLayoutPanel1);
        frame1.repaint();
        frame1.revalidate();
    }
}