public class MultipleCatchBlocks {

    public static void main(String[] args) {
        try { // The Test code to make exceptions.
            int[] arr = new int[4];
            //each of the lines tests the different exceptions(uncomment it)
            //int result = arr[4]; // An ArrayIndexOutOfBoundsException.
            //int result = 10 / 0; // An ArithmeticException -(divide by zero)
            throw new Exception(); // Exception.
        } catch (ArrayIndexOutOfBoundsException e) { //Catch block for ArrayIndexOutOfBoundsException.
            System.out.println("You are trying to access beyond the array bounds."); //Output message.
            e.printStackTrace(); //Print stack trace for the caught exception.
        } catch (ArithmeticException e) { //Catch block for ArithmeticException.
            System.out.println("Arithmetic exception occurred."); //Output message.
            e.printStackTrace(); //Print stack trace for the caught exception.
        } catch (Exception e) { //Catch block for any other Exception.
            System.out.println("Generic exception occurred."); //Output message.
            e.printStackTrace(); //Print stack trace for the caught exception.
        }
    }
}


