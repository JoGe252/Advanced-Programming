package parttwo;

import partone.Lab1Part1;

/**
 *calls the methods from Lab1Part1 and adds a new method.
 */
public class Lab1Part2 {

    /**
     * Main method to test the calling methods from Lab1Part1 and the new method.
     */
    public static void main(String[] args) {
        // Call the method from Lab1Part1 to get the full name from initials
        String fullName = Lab1Part1.getStudentNameFromInitial("JG");
        System.out.println("Full Name: " + fullName);

        // Call the new method from Lab1Part1 to get initials from full name
        String initials = Lab1Part1.getInitialFromStudentName("Joel George");
        System.out.println("Initials: " + initials);
    }
}
