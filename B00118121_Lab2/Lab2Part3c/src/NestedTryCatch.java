public class NestedTryCatch {

    public static void main(String[] args) {
        try { //The Test code to create exceptions.
            String s = null;
            // each of the lines tests the different exceptions
            //s.charAt(0); // NullPointerException
            //s.charAt(7); // StringIndexOutOfBoundsException
        } catch (NullPointerException e) { //Outer catch block for catching NullPointerException.
            System.out.println("NullPointerException caught:"); //Output message.
            try { //Nested try block for catching the StringIndexOutOfBoundsException.
                System.out.println("Attempting to catch StringIndexOutOfBoundsException..."); //Output message
                // each line to tests the different exceptions(uncomment it)
                // String s = null;
                // s.charAt(7); // StringIndexOutOfBoundsException
            } catch (StringIndexOutOfBoundsException nestedE) { //Inner catch block for catching the StringIndexOutOfBoundsException.
                System.out.println("StringIndexOutOfBoundsException caught:"); //Output message.
                nestedE.printStackTrace(); //Print stack trace for the caught exception.
            }
            e.printStackTrace(); //Print stack trace for the caught exception.
        }
    }
}

