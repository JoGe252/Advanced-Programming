package recursive;

/**
 * This class has the methods for performing the recursive operations.
 */
public class Recursion {

    /**
     * Recursively calculates the sum of numbers from n down to 1.
     *
     * @param n The number to start the summation from.
     * @return The sum of numbers from n down to 1.
     */
    public int recursiveSum(int n) {
        // Base case: if n is 1, return 1
        if (n == 1) {
            return 1;
        }
        // Recursive case: add n to the sum of numbers from n-1 down to 1
        return n + recursiveSum(n - 1);
    }

    /**
     * Recursively builds an alphabet string starting from the given character up to the letter 'z'.
     *
     * @param startChar The starting character of the alphabet string.
     * @return The alphabet string starting from startChar up to 'z'.
     */
    public String buildAlphabetString(char startChar) {
        // Base case: if startChar is 'z', return "z"
        if (startChar == 'z') {
            return "z";
        }
        // Recursive case: append startChar to the alphabet string starting from the next character
        return startChar + buildAlphabetString((char) (startChar + 1));
    }

    // Main method for testing
    public static void main(String[] args) {
        Recursion lab = new Recursion();

        // Testing recursiveSum method
        int sum = lab.recursiveSum(3);
        System.out.println("Sum of numbers from 10 down to 1: " + sum);

        // Testing buildAlphabetString method
        String alphabet = lab.buildAlphabetString('a');
        System.out.println("Alphabet string starting from 'a': " + alphabet);
    }
}

