import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

// OuterFrame class representing the main frame of the application
public class OuterFrame extends JFrame {
    private JTextArea textArea; // Text area to display information
    private JButton outerButton; // Button to trigger display of inner class information
    private String outerClassString;// String to hold outer class information
    private String outerClassString2;
    private String outerClassString3;

    // Constructor for the OuterFrame class
    public OuterFrame() {
        setTitle("Inner Class Info");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        textArea = new JTextArea();
        outerButton = new JButton("Get Inner Class Info");

        // Add an anonymous inner class listener to the outer button
        outerButton.addActionListener(e -> {
            InnerInfoClass innerInfo = new InnerInfoClass();
            innerInfo.displayInfo();
        });

        // Create panel and add components
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(outerButton, BorderLayout.SOUTH);

        add(panel);
    }

    // Inner class for displaying inner class information
    private class InnerInfoClass {
        // Method to display information about inner and outer classes
        public void displayInfo() {
            // 1. Add the names of the inner and outer classes to the text area
            outerClassString2 = OuterFrame.this.getClass().getSimpleName();
            String innerClassString = InnerInfoClass.this.getClass().getSimpleName();
            addToTextArea("Inner Class Name: " + innerClassString);
            addToTextArea("Outer Class Name: " + outerClassString);

            // 2. Add the names of the fields found in the outer class to the text area
            Field[] fields = OuterFrame.this.getClass().getDeclaredFields();
            for (Field field : fields) {
                addToTextArea("Outer Class Field: " + field.getName());
            }
        }

        // Method to add text to the text area
        private void addToTextArea(String text) {
            outerClassString += text + "\n";
            textArea.setText(outerClassString);
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        OuterFrame frame = new OuterFrame();
        frame.setVisible(true);
    }
}


