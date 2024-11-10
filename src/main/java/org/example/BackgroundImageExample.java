package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BackgroundImageExample extends JPanel {
    private Image backgroundImage;

    public BackgroundImageExample(String imagePath) {
        try {
            // Load the image
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Ensure the image is drawn scaled to the panel size
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Background Image Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        // Use your actual image path
        BackgroundImageExample backgroundPanel = new BackgroundImageExample("src/main/java/org/example/background.jpg");

        // Set the layout and add the background panel
        frame.setContentPane(backgroundPanel);
        frame.setLayout(new BorderLayout());

        // Create a panel for components
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false); // Make the panel transparent
        contentPanel.setLayout(null); // Set layout to null for absolute positioning

        // Add components to the content panel
        JLabel label = new JLabel("Welcome to the Background Image Example!");
        label.setBounds(50, 50, 400, 30);
        label.setForeground(Color.WHITE); // Set text color to be visible on the background
        contentPanel.add(label);

        JButton button = new JButton("Click Me!");
        button.setBounds(50, 100, 150, 30);
        contentPanel.add(button);

        // Add action listener for button click
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Button Clicked!"));

        frame.add(contentPanel, BorderLayout.CENTER); // Add content panel to frame
        frame.setVisible(true); // Make the frame visible
    }
}

