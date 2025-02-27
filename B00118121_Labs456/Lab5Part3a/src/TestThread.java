public class TestThread {
    public static void main(String[] args) {
        // Creates at least five instances of ThreadUsingExtends
        ThreadUsingExtends thread1 = new ThreadUsingExtends();
        ThreadUsingExtends thread2 = new ThreadUsingExtends();
        ThreadUsingExtends thread3 = new ThreadUsingExtends();
        ThreadUsingExtends thread4 = new ThreadUsingExtends();
        ThreadUsingExtends thread5 = new ThreadUsingExtends();

        // Starts all the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}

