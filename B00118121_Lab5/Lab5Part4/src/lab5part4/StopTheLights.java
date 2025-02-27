package lab5part4;

import javax.swing.*;
import java.awt.*;

// Class representing the main frame of the application
public class StopTheLights extends JFrame {
    private static final long serialVersionUID = 1L;

    private boolean running = false;
    private Thread lightsThread;
    private TrafficLightsPanel lightsPanel;

    // Constructor for the StopTheLights class
    public StopTheLights() {
        setTitle("Stop The Lights");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        lightsPanel = new TrafficLightsPanel();

        add(buttonPanel, BorderLayout.NORTH);
        add(lightsPanel, BorderLayout.CENTER);

        // Action listener for the start button
        startButton.addActionListener(e -> startLights());

        // Action listener for the stop button
        stopButton.addActionListener(e -> stopLights());
    }

    // Method to start the thread for the traffic lights animation
    private void startLights() {
        if (!running) {
            running = true;
            lightsThread = new Thread(() -> {
                while (running) {
                    lightsPanel.nextState();
                    lightsPanel.repaint();
                    try {
                        Thread.sleep(1000); // Adjusts time lapses as needed
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            lightsThread.start();
        }
    }

    // Method to stop the traffic lights animation
    private void stopLights() {
        running = false;
    }

    // Main method to start the application
    public static void main(String[] args) {
        StopTheLights frame = new StopTheLights();
        frame.setVisible(true);
    }
}

// Class representing the panel for the traffic lights
class TrafficLightsPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private int currentState = 0; // 0: Red, 1: Amber, 2: Green

    // Method to switch to the next state of the traffic lights
    public void nextState() {
        currentState = (currentState + 1) % 3;
    }

    // Method to paint the traffic lights on the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw traffic lights sequence
        g.setColor(currentState == 0 ? Color.RED : Color.GRAY);
        g.fillOval(100, 50, 100, 100);

        g.setColor(currentState == 1 ? Color.YELLOW : Color.GRAY);
        g.fillOval(100, 200, 100, 100);

        g.setColor(currentState == 2 ? Color.GREEN : Color.GRAY);
        g.fillOval(100, 350, 100, 100);
    }
}
