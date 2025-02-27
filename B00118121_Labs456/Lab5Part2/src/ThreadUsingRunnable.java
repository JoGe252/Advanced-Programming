/**
 * This class implements the Runnable interface and represents a thread,
 * that prints numbers 1, 2, 3, and 4 to the default output device using a loop.
 */
public class ThreadUsingRunnable implements Runnable {
    // Static array containing the numbers to be printed
    private static int[] numbers = {1, 2, 3, 4};

    /**
     * This method represents the execution logic('run method') of the thread.
     * It sets the name of the current thread and prints the numbers along
     * with the thread name.
     */
    public void run() {
        // Set the name of the current thread
        String threadName = Thread.currentThread().getName();

        // Print numbers along with the thread name
        for (int number : numbers) {
            System.out.println(threadName + " " + number);
        }
    }
}

