package EmojiSoundGUI;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.Image;
import java.io.*;
import java.util.*;

public class EmojiSoundGUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private ResourceBundle messages;
    private JButton laughingButton;
    private JButton cryingButton;
    private JButton rainingButton;
    private JButton startButton;
    private JButton stopButton;
    private JComboBox<Locale> localeComboBox;
    private Clip clip;

    /**
     * Constructor for EmojiSoundGUI.
     * Initializes the GUI components and sets up the frame.
     */
    public EmojiSoundGUI() {
        // Initialize messages with the default locale
        messages = ResourceBundle.getBundle("resources.messages", Locale.getDefault());

        // Set up the JFrame
        setTitle(getLocalizedString("frameTitle"));
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create GUI components
        createButtons();
        createComboBox();

        // Add components to the panel
        JPanel panel = new JPanel();
        panel.add(laughingButton);
        panel.add(cryingButton);
        panel.add(rainingButton);
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(localeComboBox);

        add(panel);
    }

    /**
     * Creates buttons for the GUI and adds action listeners.
     */
    private void createButtons() {
        laughingButton = resizeAndCreateButton("laughingButton", "images/us.jpg");
        cryingButton = resizeAndCreateButton("cryingButton", "images/us.jpg");
        rainingButton = resizeAndCreateButton("rainingButton", "images/us.jpg");
        startButton = new JButton(getLocalizedString("startButton"));
        stopButton = new JButton(getLocalizedString("stopButton"));

        // Add action listeners for start and stop buttons
        startButton.addActionListener(e -> startSound("wav/laughing.wav"));
        stopButton.addActionListener(e -> stopSound());
    }

    // Create combo box for selecting language
    private void createComboBox() {
        localeComboBox = new JComboBox<>(new Locale[]{Locale.ENGLISH, Locale.FRENCH, new Locale("es")});
        localeComboBox.addActionListener(e -> changeLanguage((Locale) localeComboBox.getSelectedItem()));
    }


    /**
     * Resizes an image and creates a button with the resized image as its icon.
     *
     * @param key The key used to retrieve the button's text from the resource bundle.
     * @param imagePath The path to the image file.
     * @return The created JButton.
     */
    private JButton resizeAndCreateButton(String key, String imagePath) {
        // Resize the image and set it as the button icon
        Image resizedImage = resizeImage(new ImageIcon(imagePath).getImage(), 50, 50);
        JButton button = new JButton(getLocalizedString(key), new ImageIcon(resizedImage));

        // Add action listener for the button
        button.addActionListener(e -> {
            if ("laughingButton".equals(key)) {
                startSound("wav/laughing.wav");
            } else if ("cryingButton".equals(key)) {
                startSound("wav/crying.wav");
            } else if ("rainingButton".equals(key)) {
                startSound("wav/raining.wav");
            }
        });

        return button;
    }

    /**
     * Resizes an image to the specified dimensions.
     *
     * @param originalImage The original image to be resized.
     * @param scaledWidth The width to resize to.
     * @param scaledHeight The height to resize to.
     * @return The resized Image.
     */
    private Image resizeImage(Image originalImage, int scaledWidth, int scaledHeight) {
        return originalImage.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
    }

    /**
     * Changes the language of the GUI depending on the language locale you select.
     *
     * @param locale The selected locale.
     */
    private void changeLanguage(Locale locale) {
        messages = ResourceBundle.getBundle("resources.messages", locale);
        setTitle(getLocalizedString("frameTitle"));

        laughingButton.setText(getLocalizedString("laughingButton"));
        cryingButton.setText(getLocalizedString("cryingButton"));
        rainingButton.setText(getLocalizedString("rainingButton"));
        startButton.setText(getLocalizedString("startButton"));
        stopButton.setText(getLocalizedString("stopButton"));
    }

    /**
     * Retrieves the localized string for a given key from the resource bundle.
     *
     * @param key The key for the localized string.
     * @return The localized string.
     */
    private String getLocalizedString(String key) {
        return messages.getString(key);
    }

    /**
     * Plays a sound file.
     *
     * @param soundFileName The path to the sound file.
     */

    private void playSound(String soundFileName) {
        try {
            File soundFile = new File(soundFileName);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts playing the sound file.
     *
     * @param soundFileName The path to the sound file to start.
     */
    private void startSound(String soundFileName) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
        playSound(soundFileName);
    }

    /**
     * Stops playing the sound.
     */
    private void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
    /**
     * Main method to start the EmojiSoundGUI application.
     *
     * @param args Command-line arguments (unused).
     */
    // Main method to create and display the GUI
    public static void main(String[] args) {
        EmojiSoundGUI frame = new EmojiSoundGUI();
        frame.setVisible(true);
    }
}




