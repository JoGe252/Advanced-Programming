package partone;

public class Lab1Part1 {

    /**
     * Outputs the name and student number.
     */
    public static void main(String[] args) {
        System.out.print("Joel George - B00118121");
    }
    /**
     * Gets the full name from initials.
     *
     * @param initials The initials of the student's name.
     * @return The full name from initials.
     */

    public static String getStudentNameFromInitial(String initials) {
        if (initials.equalsIgnoreCase("JG")) {
            return "Joel George";
        } else {
            return "INPUT INITIAL NOT CORRECT";
        }
    }

    public static String getInitialFromStudentName(String fullName) {
        if (fullName.equalsIgnoreCase("Joel George")) {
            return "JG";
        }else{
            return "INPUT FULLNAME NOT CORRECT";
        }
    }
}