/**
 * This class extends the Thread and represents a thread that prints letters "A", "B", "C", and "D",
 * to the default output device using a loop. Each of the threads created by this class is numbered and,
 * named using the name in the constructor.
 */
public class ThreadUsingExtends extends Thread {
    // Array containing the letters that will be printed
    private static String[] letters = {"A", "B", "C", "D"};

    //A static count variable to keep track of the number of threads that's created
    private static int count = 0;

    //Name of the current thread
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
     * It iterates('repeats') through the letters array and prints each letter along with the name of the thread.
     */
    public void run() {
        for (String letter : letters) {
            System.out.println(threadName + " " + letter);
        }
    }
}


