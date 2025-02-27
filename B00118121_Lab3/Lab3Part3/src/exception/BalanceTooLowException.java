package exception;

/**
 * Custom exception class for indicating that the balance is too low.
 */
public class BalanceTooLowException extends Exception {
    /**
     * Constructs a new BalanceTooLowException with the specified detail message.
     * @param message The detail message.
     */
    public BalanceTooLowException(String message) {
        super(message);
    }
}
