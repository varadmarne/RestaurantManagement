package org.example;

import javax.swing.*;
import java.awt.*;

import static org.example.Main.frame1;

public class CurvedPanelWithClockExample extends JPanel{

    CurvedPanelWithClockExample() {

        JPanel order = new CurvedClockPanel();
        order.setBounds(0, 0, 100, 50);
        this.setLayout(null);
        this.setBounds(450,25,100,50);
        this.add(order);
        frame1.repaint();
        frame1.revalidate();
    }

    static class CurvedClockPanel extends JPanel {
        private JLabel clockLabel;
        private int minutes = 0;
        private int seconds = 0;
        static String time;
        public CurvedClockPanel() {
            this.setLayout(null);
            initializeTimer();
        }

        private void initializeTimer() {
            // Create the timer label
            clockLabel = new JLabel();
            clockLabel.setForeground(Color.red);
            clockLabel.setFont(new Font("Arial", Font.PLAIN, 36)); // Set font size for the timer
            clockLabel.setBounds(5, 0, 100, 50); // Position within the JPanel
            this.add(clockLabel);

            // Timer to update the clock every second
            Timer timer = new Timer(1000, e -> updateTimer());
            timer.start();

            // Set the initial time to "00:00"
            updateTimer();
        }

        private void updateTimer() {
            // Increment the timer
            seconds++;
            if (seconds == 60) {
                seconds = 0;
                minutes++;
            }

            // Format the time as "MM:SS"
            time = String.format("%02d:%02d", minutes, seconds);
            clockLabel.setText(time);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            // Enable anti-aliasing for smoother edges
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Set the background color
            g2d.setColor(getBackground());

            // Draw a rounded rectangle with curved corners
            g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50); // 50 is the arc width and height

            g2d.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Set the border color and thickness
            g2d.setColor(Color.RED);
            g2d.setStroke(new BasicStroke(2));

            // Draw the border with curved corners
            g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 50, 50); // 50 is the arc width and height

            g2d.dispose();
        }
    }
}

