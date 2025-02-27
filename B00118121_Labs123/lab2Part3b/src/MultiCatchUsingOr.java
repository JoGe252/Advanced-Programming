public class MultiCatchUsingOr {

    public static void main(String[] args) {
        try { //The Test code to generate exceptions.
            String s = null;
            //each of the lines tests the different exceptions(uncomment it when needed)
            //s.charAt(0); // NullPointerException
            //s.charAt(7); // StringIndexOutOfBoundsException
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {// Catch block for catching both NullPointerException and StringIndexOutOfBoundsException using '|'.
            System.out.println("Exception caught:"); //Output message when the exception was caught.
            e.printStackTrace(); //Print stack trace for the caught exception.
        }
    }
}

