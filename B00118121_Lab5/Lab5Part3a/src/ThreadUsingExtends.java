/**
 * This class extends Thread and represents a thread that prints letters "A", "B", "C", and "D"
 * to the default output device using a loop. This version ensures the correct order of printing
 * by synchronizing the critical section where the letters are printed.
 */
public class ThreadUsingExtends extends Thread{
    // Array containing the letters to be printed
    private static String[] letters = {"A", "B", "C", "D"};

    // Static count variable to keep track of the number of threads created
    private static int count = 0;

    // Name of the current thread
    private String threadName;

    /**
     * Constructor for ThreadUsingExtends class.
     * It increments the count of threads created, assigns a name to the thread based on the
     * count, and sets the name of the thread.
     */
    public ThreadUsingExtends() {
        count = count + 1;
        this.threadName = "George " + count;
        this.setName(threadName);
    }

    /**
     * This method represents the execution logic('run method') of the thread.
     * It synchronizes the critical section where the letters are printed to ensure thread safety.
     */
    public void run() {
        synchronized (ThreadUsingExtends.class) {
            for (String letter : letters) {
                System.out.println(threadName + " " + letter);
            }
        }
    }
}

