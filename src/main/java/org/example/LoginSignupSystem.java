package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath)); // Load the image
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
public class LoginSignupSystem {
    private static MongoCollection<Document> userCollection;

    public static void main(String[] args) {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb+srv://varadmarne22:hello123@hell.bqcfu.mongodb.net/?retryWrites=true&w=majority&appName=HELL");
            MongoDatabase db = mongoClient.getDatabase("RestaurantManagement");
            userCollection = db.getCollection("users");

            JFrame frame = new JFrame("Login and Signup System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);

            // Create background panel
            BackgroundPanel backgroundPanel = new BackgroundPanel("src/main/java/org/example/background.jpg");
            backgroundPanel.setLayout(new BorderLayout());

            // Create login and signup panels
            JPanel loginPanel = createLoginPanel(frame);
            JPanel signupPanel = createSignupPanel(frame);

            // Add the login and signup panels to the frame
            backgroundPanel.add(loginPanel, BorderLayout.CENTER);
            backgroundPanel.add(signupPanel, BorderLayout.CENTER);

            // Add the background panel to the frame
            frame.setContentPane(backgroundPanel);
            frame.setLayout(new CardLayout());
            frame.add(loginPanel, "Login");
            frame.add(signupPanel, "Signup");

            // Show the login panel first
            CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
            cl.show(frame.getContentPane(), "Signup");

            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static JPanel createSignupPanel(JFrame frame) {
        JPanel panel = new JPanel(null);
        panel.setOpaque(false);
        BackgroundImageExample backgroundPanel = new BackgroundImageExample("src/main/java/org/example/background.jpg");
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(100, 200, 150, 35);
        panel.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(300, 200, 300, 35);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 280, 150, 35);
        panel.add(passwordLabel);
        userLabel.setForeground(Color.WHITE);passwordLabel.setForeground(Color.WHITE);
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(300, 280, 300, 35);
        panel.add(passwordText);

        JButton signupButton = new JButton("Signup");
        signupButton.setBounds(300, 360, 100, 40);
        panel.add(signupButton);

        JButton switchToLoginButton = new JButton("Login");
        switchToLoginButton.setBounds(500, 360, 100, 40);
        panel.add(switchToLoginButton);

        signupButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            if (registerUser(username, password)) {
                JOptionPane.showMessageDialog(frame, "Signup successful!");
                CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
                cl.show(frame.getContentPane(), "Login");
            } else {
                JOptionPane.showMessageDialog(frame, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        switchToLoginButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
            cl.show(frame.getContentPane(), "Login");
        });

        JPanel panel1 = new JPanel(null);
        panel1.setBounds(0,0,800,100);
        panel1.setBackground(new Color(59, 73, 164));

        JLabel label = new JLabel("Restaurant Management System");
        label.setBounds(170,30,450,40);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setForeground(Color.white);
        panel1.add(label);

        panel.add(panel1);

        return panel;
    }

    private static JPanel createLoginPanel(JFrame frame) {
        JPanel panel = new JPanel(null);
        panel.setOpaque(false);
        BackgroundImageExample backgroundPanel = new BackgroundImageExample("src/main/java/org/example/background.jpg");

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(100, 200, 150, 35);
        panel.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(300, 200, 300, 35);

        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 280, 150, 35);
        panel.add(passwordLabel);
        userLabel.setForeground(Color.WHITE);passwordLabel.setForeground(Color.WHITE);
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(300, 280, 300, 35);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(300, 360, 100, 40);
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            if (authenticateUser(username, password)) {
                JOptionPane.showMessageDialog(frame, "Login successful!");
                showRoleSelection(frame);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panel1 = new JPanel(null);
        panel1.setBounds(0,0,800,100);
        panel1.setBackground(new Color(59, 73, 164));

        JLabel label = new JLabel("Restaurant Management System");
        label.setBounds(170,30,450,40);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setForeground(Color.white);
        panel1.add(label);

        panel.add(panel1);
        return panel;
    }

    private static void showRoleSelection(JFrame frame) {
        JPanel rolePanel = new JPanel(null);
        rolePanel.setOpaque(false);
        rolePanel.setSize(800, 800);

        BackgroundImageExample backgroundPanel = new BackgroundImageExample("src/main/java/org/example/background.jpg");
        JLabel roleLabel = new JLabel("Select your role:");
        roleLabel.setForeground(Color.white);
        roleLabel.setBounds(100, 200, 300, 35);
        rolePanel.add(roleLabel);

        JButton waiterButton = new JButton("Waiter");
        waiterButton.setBounds(100, 300, 150, 40);
        rolePanel.add(waiterButton);

        JButton chefButton = new JButton("Chef");
        chefButton.setBounds(300, 300, 150, 40);
        rolePanel.add(chefButton);

        frame.getContentPane().add(rolePanel, "Role");
        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
        cl.show(frame.getContentPane(), "Role");

        waiterButton.addActionListener(e -> showWaiterForm(frame));
        chefButton.addActionListener(e -> showChefForm(frame));

        JPanel panel1 = new JPanel(null);
        panel1.setBounds(0,0,800,100);
        panel1.setBackground(new Color(59, 73, 164));

        JLabel label = new JLabel("Restaurant Management System");
        label.setBounds(170,30,450,40);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setForeground(Color.white);
        panel1.add(label);

        rolePanel.add(panel1);
    }

    private static void showWaiterForm(JFrame frame) {
        JPanel waiterPanel = new JPanel(null);
        waiterPanel.setOpaque(false);
        waiterPanel.setSize(800, 800);

        JLabel tableLabel = new JLabel("Table Number:");
        tableLabel.setForeground(Color.white);
        tableLabel.setBounds(100, 200, 150, 35);
        waiterPanel.add(tableLabel);

        BackgroundImageExample backgroundPanel = new BackgroundImageExample("src/main/java/org/example/background.jpg");
        JTextField tableText = new JTextField();
        tableText.setBounds(300, 200, 300, 35);
        waiterPanel.add(tableText);

        JLabel orderLabel = new JLabel("Order Details:");
        orderLabel.setForeground(Color.white);
        orderLabel.setBounds(100, 280, 150, 35);
        waiterPanel.add(orderLabel);

        JTextField orderText = new JTextField();
        orderText.setBounds(300, 280, 300, 35);
        waiterPanel.add(orderText);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(300, 360, 100, 40);
        waiterPanel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                Main.main(null);
            }
        });

        JPanel panel1 = new JPanel(null);
        panel1.setBounds(0,0,800,100);
        panel1.setBackground(new Color(59, 73, 164));

        JLabel label = new JLabel("Restaurant Management System");
        label.setBounds(170,30,450,40);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setForeground(Color.white);
        panel1.add(label);

        waiterPanel.add(panel1);
        //Main.main(null);
        frame.getContentPane().add(waiterPanel, "Waiter");
        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
        cl.show(frame.getContentPane(), "Waiter");
        //frame.dispose();
    }

    private static void showChefForm(JFrame frame) {
        JPanel chefPanel = new JPanel(null);
        chefPanel.setOpaque(false);
        chefPanel.setSize(800, 800);

        BackgroundImageExample backgroundPanel = new BackgroundImageExample("src/main/java/org/example/background.jpg");
        JLabel dishLabel = new JLabel("Dish Name:");
        dishLabel.setForeground(Color.white);
        dishLabel.setBounds(100, 200, 150, 35);
        chefPanel.add(dishLabel);

        JTextField dishText = new JTextField();
        dishText.setBounds(300, 200, 300, 35);
        chefPanel.add(dishText);

        JLabel timeLabel = new JLabel("Preparation Time:");
        timeLabel.setForeground(Color.white);
        timeLabel.setBounds(100, 280, 150, 35);
        chefPanel.add(timeLabel);

        JTextField timeText = new JTextField();
        timeText.setBounds(300, 280, 300, 35);
        chefPanel.add(timeText);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(300, 360, 100, 40);
        chefPanel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                Main.main(null);
            }
        });

        JPanel panel1 = new JPanel(null);
        panel1.setBounds(0,0,800,100);
        panel1.setBackground(new Color(59, 73, 164));

        JLabel label = new JLabel("Restaurant Management System");
        label.setBounds(170,30,450,40);
        label.setFont(new Font("Arial", Font.PLAIN, 30));
        label.setForeground(Color.white);
        panel1.add(label);

        chefPanel.add(panel1);
        //Main.main(null);
        frame.getContentPane().add(chefPanel, "Chef");
        CardLayout cl = (CardLayout) frame.getContentPane().getLayout();
        cl.show(frame.getContentPane(), "Chef");
        //frame.dispose();
    }

    private static boolean authenticateUser(String username, String password) {
        Document query = new Document("username", username).append("password", password);
        Document user = userCollection.find(query).first();
        return user != null;
    }

    private static boolean registerUser(String username, String password) {
        Document existingUser = userCollection.find(new Document("username", username)).first();
        if (existingUser != null) {
            return false;
        }
        Document newUser = new Document("username", username).append("password", password);
        userCollection.insertOne(newUser);
        return true;
    }
}




