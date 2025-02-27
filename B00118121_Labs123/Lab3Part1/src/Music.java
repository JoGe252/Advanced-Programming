
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * A GUI application to display a list of favorite music.
 */
public class Music extends JFrame implements ActionListener {

    private JTextArea textArea; // Text area to display the list of favorite music

    /**
     * Constructor to initialize the GUI components.
     */
    public Music() {
        setTitle("My Favorite Music List");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create text area
        textArea = new JTextArea();
        textArea.setEditable(false);

        // Create button
        JButton printButton = new JButton("Print Music List");
        printButton.addActionListener(this);

        //Adds a components to the frame
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER); //Adds text area with a scroll bar
        add(printButton, BorderLayout.SOUTH); //Adds a print button at the bottom
    }

    /**
     * The Entry point for the application.
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        Music frame = new Music();
        frame.setVisible(true);
    }

    /**
     * ActionListener implementation to handle button clicks.
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Print Music List")) {
            printMusicList(); // Calls the  method to print music list when button is clicked
        }
    }

    /**
     * Reads the music list from the file and displays it in the text area.
     */
    private void printMusicList() {
        // Using try-with-resources to automatically close the BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader("myFavMusic.txt"))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n"); // Append each line to the content
            }
            textArea.setText(content.toString()); // Set the content to the text area
        } catch (IOException ex) {
            ex.printStackTrace(); // Print stack trace for any IOException
            JOptionPane.showMessageDialog(this, "An error occurred while reading the file."); // Show error message
        }
    }
}


