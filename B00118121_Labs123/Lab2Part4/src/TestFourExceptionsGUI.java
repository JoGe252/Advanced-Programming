import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestFourExceptionsGUI extends JFrame implements ActionListener {

    //Constructor for the TestFourExceptionsGUI class.
    public TestFourExceptionsGUI() { //Sets the frame properties.
        setTitle("Test Four Exceptions GUI");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Creates buttons.
        JButton testIOExceptionBtn = new JButton("Test IO Exception");
        JButton testNullPointerExceptionBtn = new JButton("Test Null Pointer Exception");
        JButton testURLExceptionBtn = new JButton("Test URL Exception");
        JButton testGeneralExceptionBtn = new JButton("Test General Exception");

        //Adds action listeners to the buttons.
        testIOExceptionBtn.addActionListener(this);
        testNullPointerExceptionBtn.addActionListener(this);
        testURLExceptionBtn.addActionListener(this);
        testGeneralExceptionBtn.addActionListener(this);

        //Adds buttons to the frame.
        setLayout(new FlowLayout());
        add(testIOExceptionBtn);
        add(testNullPointerExceptionBtn);
        add(testURLExceptionBtn);
        add(testGeneralExceptionBtn);
    }

    //Main method to create and display the frame.
    public static void main(String[] args) {
        TestFourExceptionsGUI frame = new TestFourExceptionsGUI();
        frame.setVisible(true);
    }

    // Method to handle button clicks.
    @Override
    public void actionPerformed(ActionEvent e) { //Determine which button was clicked and call the testException method.
        if (e.getActionCommand().equals("Test IO Exception")) {
            testException("Hi", "Whatever.txt", "http://www.itb.ie", false);
        } else if (e.getActionCommand().equals("Test Null Pointer Exception")) {
            testException(null, "Real.txt", "http://www.itb.ie", false);
        } else if (e.getActionCommand().equals("Test URL Exception")) {
            testException("Hi", "Real.txt", "ht//www.itb.ie", false);
        } else if (e.getActionCommand().equals("Test General Exception")) {
            testException("Hi", "Real.txt", "http://www.itb.ie", true);
        }
    }

    //Method to test various exceptions.
    public void testException(String string, String filename, String url, boolean generalExceptionActivated) {
        try {// Test potential errors.
            string.toCharArray(); //Null string potential error.
            new FileReader(filename); //Unknown filename potential error.
            new URL(url); //Badly written URL potential error.
            if (generalExceptionActivated) { //Potential error.
                this.clone(); //Will be caught as a general error!
            }
        } catch (MalformedURLException e) { //Catch MalformedURLException and show the message.
            JOptionPane.showMessageDialog(this, "The URL passed is not correctly formatted: " + e.getMessage());
        } catch (IOException e) { //Catch IOException and show the message.
            JOptionPane.showMessageDialog(this, "There has been an input/output error: " + e.getMessage());
        } catch (NullPointerException e) { //Catch NullPointerException and show the message.
            JOptionPane.showMessageDialog(this, "A null object has been passed to the method: " + e.getMessage());
        } catch (Exception e) { //Catch any other Exception and show the message.
            JOptionPane.showMessageDialog(this, "An unidentified error has occurred: " + e.getMessage());
        } finally { //Display a message when the "finally block" is executed.
            JOptionPane.showMessageDialog(this, "The finally block has been called.");
        }
    }
}

