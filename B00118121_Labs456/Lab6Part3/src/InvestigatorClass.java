import javax.swing.*;
import java.awt.*;
import java.lang.reflect.*;
import mystery.MysteryJarClass;

public class InvestigatorClass extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextArea textArea;
    private JButton investigateButton;
    private MysteryJarClass mysteryJar;

    // Constructor to initialize the InvestigatorClass JFrame
    public InvestigatorClass() {
        setTitle("Mystery Jar Investigator"); // Sets the title of the frame
        setSize(400, 300); // Sets the size of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets default close operation

        // Initializes text area and button
        textArea = new JTextArea();
        investigateButton = new JButton("Investigate");
        investigateButton.addActionListener(e -> {
            investigateMysteryJar(); // Call method to investigate MysteryJarClass
        });

        // Adds text area and button to the frame
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(investigateButton, BorderLayout.SOUTH);
        add(panel);
    }

    // Method to investigate the MysteryJarClass using reflection
    private void investigateMysteryJar() {
        textArea.setText(""); // Clear the text area

        // Loads the MysteryJarClass from the JAR file
        try {
            mysteryJar = new MysteryJarClass();
            Method[] methods = mysteryJar.getClass().getDeclaredMethods(); // Gets all declared methods

            // Loops through each method
            for (Method method : methods) {
                // Gets method name
                String methodName = method.getName();
                // Gets parameter types
                Parameter[] parameters = method.getParameters();
                StringBuilder paramTypes = new StringBuilder();
                for (Parameter parameter : parameters) {
                    paramTypes.append(parameter.getType().getSimpleName()).append(" ");
                }

                // Appends method name and parameter types to text area
                textArea.append("Method: " + methodName + "(" + paramTypes + ")\n");
            }

            // Call the method with no parameters
            Method blankParamMethod = mysteryJar.getClass().getDeclaredMethod("methodWithNoParams");
            blankParamMethod.setAccessible(true); // Sets accessible to call private method
            blankParamMethod.invoke(mysteryJar);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        InvestigatorClass frame = new InvestigatorClass();
        frame.setVisible(true);
    }
}


