public class TestThread {
    public static void main(String[] args) {
        // Creates at least five instances of ThreadUsingRunnable
        ThreadUsingRunnable runnable1 = new ThreadUsingRunnable();
        ThreadUsingRunnable runnable2 = new ThreadUsingRunnable();
        ThreadUsingRunnable runnable3 = new ThreadUsingRunnable();
        ThreadUsingRunnable runnable4 = new ThreadUsingRunnable();
        ThreadUsingRunnable runnable5 = new ThreadUsingRunnable();

        // Wraps each instance in a Thread and starts it
        new Thread(runnable1, "George").start();
        new Thread(runnable2, "George").start();
        new Thread(runnable3, "George").start();
        new Thread(runnable4, "George").start();
        new Thread(runnable5, "George").start();
    }
}

