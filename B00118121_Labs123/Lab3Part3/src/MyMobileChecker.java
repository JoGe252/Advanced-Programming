import exception.BalanceTooLowException;
import exception.NotMyNetworkException;

public class MyMobileChecker {

    private static final String MY_NETWORK = "Tesco Mobile"; // Sets your mobile network
    private static final int MINIMUM_BALANCE = 1; // Sets the minimum balance

    /**
     * Verifies the mobile network.
     * @param inputNetwork The network to be verified.
     * @throws NotMyNetworkException If the network does not match.
     */
    public static void checkMyMobileNetwork(String inputNetwork) throws NotMyNetworkException {
        if (!inputNetwork.equals(MY_NETWORK)) {
            throw new NotMyNetworkException("Network does not match.");
        } else {
            System.out.println("Verified: Network is correct.");
        }
    }

    /**
     * Verifies the account balance.
     * @param balance The account balance to be verified.
     * @throws BalanceTooLowException If the balance is too low.
     */
    public static void checkMyBalance(int balance) throws BalanceTooLowException {
        if (balance < MINIMUM_BALANCE) {
            throw new BalanceTooLowException("Balance is too low.");
        } else {
            System.out.println("Verified: Balance is fine.");
        }
    }

    /**
     * Main method to test the MyMobileChecker class.
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Testing checkMyMobileNetwork method with incorrect network
            checkMyMobileNetwork("Three");
        } catch (NotMyNetworkException e) {
            e.printStackTrace();
        }

        try {
            // Testing checkMyBalance method with too low balance
            checkMyBalance(0);
        } catch (BalanceTooLowException e) {
            e.printStackTrace();
        }
    }
}
