import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Simple GUI to input the radius of a circle and output its circumference.
 */
public class CircleGUI extends JFrame {
    private JTextField radiusField; // Text field to input the radius
    private JLabel resultLabel; // Label to display the calculated circumference

    /**
     * Constructor for CircleGUI class.
     * Sets up the GUI components and initializes the frame.
     */
    public CircleGUI() {
        setTitle("Circle Circumference Calculator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creates components
        JLabel radiusLabel = new JLabel("Enter Radius:");
        radiusField = new JTextField(10);
        JButton calculateButton = new JButton("Calculate");
        resultLabel = new JLabel();

        // Adds components to content pane
        JPanel panel = new JPanel();
        panel.add(radiusLabel);
        panel.add(radiusField);
        panel.add(calculateButton);
        panel.add(resultLabel);
        add(panel);

        // Sets button action using lambda expression
        calculateButton.addActionListener((ActionEvent e) -> {
            calculateCircumference();
        });
    }

    /**
     * Method to calculate the circumference of a circle based on the inputed radius.
     * Displays the result in the resultLabel.
     * Handles NumberFormatException if the input is not a valid number.
     */
    private void calculateCircumference() {
        try {
            double radius = Double.parseDouble(radiusField.getText());
            double circumference = CircleUtility.calculateCircumference(radius);
            resultLabel.setText("Circumference: " + circumference);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid radius! Please enter a valid number.");
        }
    }

    /**
     * Main method to create and display the CircleGUI frame.
     * Uses the lambda expression to run the GUI in the event dispatch thread.
     */
    public static void main(String[] args) {
        CircleGUI CircleGUI = new CircleGUI();
        CircleGUI.setVisible(true);
    }
}

