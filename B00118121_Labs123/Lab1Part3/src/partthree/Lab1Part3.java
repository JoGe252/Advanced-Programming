package partthree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static partone.Lab1Part1.getStudentNameFromInitial;

 public class Lab1Part3 extends JFrame implements ActionListener {
  private JTextField inputName;
  private JLabel resultLabel;

  public Lab1Part3() {
   setTitle("Lab1Part3");
   setSize(400, 200);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   setLayout(new BorderLayout());

   // Label and TextField
   JLabel inputLabel = new JLabel("Input Initials:");
   inputName = new JTextField(20);
   JPanel inputPanel = new JPanel();
   inputPanel.add(inputLabel);
   inputPanel.add(inputName);
   add(inputPanel, BorderLayout.CENTER);

   // Result Label
   resultLabel = new JLabel("Result of method call will appear here", SwingConstants.CENTER);
   add(resultLabel, BorderLayout.NORTH);

   // Button
   JButton button = new JButton("Click here to retrieve student name from initials");
   button.addActionListener(this);
   add(button, BorderLayout.SOUTH);
  }

 public void actionPerformed(ActionEvent e) {
  String studentName = getStudentNameFromInitial(inputName.getText());
  resultLabel.setText(studentName);
 }

 public static void main(String[] args) {
  Lab1Part3 Lab1Part3= new Lab1Part3();
  Lab1Part3.setVisible(true);
 }
}


