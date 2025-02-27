public class ExceptionTryCatchTest {

    public static void main(String[] args){
        try{
            String s = "Surname";
            char c = s.charAt(6); //Accesses the index 6 of the string "Surname", which then throws the StringIndexOutOfBoundsException.
        }
        catch (StringIndexOutOfBoundsException e){
            e.printStackTrace(); //Prints the stack trace for the caught exception.
        }
        finally {
            System.out.println("finally block has been called"); //Executes regardless of whether an exception is caught or not.
            System.out.println ("George"); //Prints "George" after executing the 'finally block'.
        }
        try{
            System.out.println("Test try with out catch");
        }
        finally{
            System.out.println("There's no catch"); //Executes without a corresponding catch block.
        }

    }
}
