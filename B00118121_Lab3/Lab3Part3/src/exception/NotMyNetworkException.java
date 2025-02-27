package exception;

/**
 * Custom exception class for indicating that the network does not match.
 */
public class NotMyNetworkException extends Exception {
    /**
     * Constructs a new NotMyNetworkException with the specified detail message.
     * @param message The detail message.
     */
    public NotMyNetworkException(String message) {
        super(message);
    }
}
