import java.io.File;
import java.io.IOException;

public class CheckedVUncheckedExceptions {

    public static void main(String[] args) {
        try {
            capitalizeString(null); //Throws NullPointerException.
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught."); //Catch block for the NullPointerException.
        }
//In the main method, both of the methods are called.Because the capitalizeString throws a checked exception(NullPointerException),
        try {
            openFile("nonexistentfile.txt"); //Throws IOException.
        } catch (IOException e) {
            System.out.println("IOException caught."); //Catch block for IOException.
        }
    }

    public static void capitalizeString(String s) throws NullPointerException{ //Method that capitalises the string,throws NullPointerException.
        if (s == null) {
            throw new NullPointerException("Input string is null."); //Throws a NullPointerException if the input string is null.
        }
        System.out.println(s.toUpperCase()); //Input string becomes Upper Case.
    }

    public static void openFile(String fileName) throws IOException{ //Method openfile,throws an IOException.
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IOException("File does not exist: " + fileName); //Throws an IOException if the file doesn't exist.
        }
        System.out.println("File exists: " + fileName); //Prints a message if the file exists.
    }
}





