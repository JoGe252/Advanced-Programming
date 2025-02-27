import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

// Class definition for the EmojiSoundGUI
public class EmojiSoundGUI extends JFrame implements ActionListener {
    private JButton laughingButton, cryingButton, rainingButton;

    // Constructor for the EmojiSoundGUI class
    public EmojiSoundGUI() {
        setTitle("Emoji Sound Player"); // Set the title of the frame
        setSize(400, 200); // Set the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
        setLayout(new FlowLayout()); // Set the layout manager for the frame

        // Create emoji buttons
        laughingButton = new JButton("\uD83D\uDE02 Laughing");
        cryingButton = new JButton("\uD83D\uDE22 Crying");
        rainingButton = new JButton("\uD83C\uDF27\uFE0F raining");

        // Add action listeners to buttons
        laughingButton.addActionListener(this);
        cryingButton.addActionListener(this);
        rainingButton.addActionListener(this);

        // Add buttons to the frame
        add(laughingButton);
        add(cryingButton);
        add(rainingButton);

        setVisible(true); // Make the frame visible
    }

    // ActionListener method for handling button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Checks which button was clicked and play the corresponding sound
        if (e.getSource() == laughingButton) {
            playSound("wav/laughing.wav");
        } else if (e.getSource() == cryingButton) {
            playSound("wav/crying.wav");
        } else if (e.getSource() == rainingButton) {
            playSound("wav/raining.wav");
        }
    }

    // Method to play a sound given the file name
    private void playSound(String fileName) {
        try {
            File soundFile = new File(fileName); // Create a File object with the sound file
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile); // Get an AudioInputStream from the sound file
            Clip clip = AudioSystem.getClip(); // Get a Clip object for playing the sound
            clip.open(audioIn); // Open the clip with the audio input stream
            clip.start(); // Start playing the sound
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace if an exception occurs
        }
    }

    // Main method to create an instance of EmojiSoundGUI
    public static void main(String[] args) {
        EmojiSoundGUI frame = new EmojiSoundGUI();
        frame.setVisible(true);
    }
}


