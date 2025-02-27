import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A GUI application for displaying elements of an array based on a user input.
 */
public class Provinces extends JFrame implements ActionListener {

    private String[] stringArray = {"Munster", "Ulster", "Connacht", "Leinster"}; // Array of strings
    private JLabel inputLabel; // Label for input instructions
    private JTextField inputField; // Text field for user input
    private JLabel outputLabel; // Label for displaying output
    private JButton inputButton; // Button for triggering the output

    /**
     * Constructor to initialize the GUI components.
     */
    public Provinces() {
        setTitle("Array Output GUI");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create and configure input label
        inputLabel = new JLabel("Please enter the array index you wish to output: ");

        // Create and configure input field
        inputField = new JTextField(5);

        // Create and configure output label
        outputLabel = new JLabel();

        // Create and configure input button
        inputButton = new JButton("Output");
        inputButton.addActionListener(this);

        // Add components to the frame
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(inputButton);

        getContentPane().add(panel, BorderLayout.NORTH); // Add panel to the top
        getContentPane().add(outputLabel, BorderLayout.CENTER); // Add output label to the center
    }

    /**
     * Entry point for the application.
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        Provinces frame = new Provinces();
        frame.setVisible(true);
    }

    /**
     * ActionListener implementation to handle button clicks.
     * @param e The action event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inputButton) { // If the source of the action is the input button
            try {
                int index = Integer.parseInt(inputField.getText()); // Convert the text to integer
                outputLabel.setText(stringArray[index]); // Set the text of the output label to the element at the specified index
            } catch (ArrayIndexOutOfBoundsException ex) { // Catch out of bounds exception
                JOptionPane.showMessageDialog(this, "You attempted to access beyond the limits of the array, please try again"); // Display error message
            } catch (NumberFormatException ex) { // Catch number format exception
                JOptionPane.showMessageDialog(this, "Please enter a valid index number"); // Display error message
            }
        }
    }
}

