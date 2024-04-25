/**
 * @author Kyle Smith
 */
public class Starter {

    /**
     * the number of iterations each behavior should do
     */
    public static final int NUMBER_OF_TRIALS = 10000;

    /**
     * Run the math machine
     */
    public void run() {
        // list the math behavior names to use in order
        String[] behaviors = {
                "IncrementBehavior",
                "IncrementBehavior",
                "IncrementBehavior",
                "IncrementBehavior",
                "IncrementBehavior"
        };

        // Create a thread for each MathBehavior
        Thread[] threads = new Thread[behaviors.length];
        Buffer buffer = new Buffer();
        buffer.write(1);

        // Catch any unexpected Exceptions
        try {
            for (int i = 0; i < behaviors.length; i++) {
                Class<?> behavior = Class.forName(behaviors[i]);

                threads[i] = new Modifier(i, buffer, buffer, (MathBehavior) behavior.getConstructor().newInstance());
                threads[i].start();
            }

            for (Thread thread : threads) {
                thread.join();
            }
            Checker checker = new Checker(buffer, NUMBER_OF_TRIALS * (behaviors.length) + 1);
            checker.check();
        } catch (Exception e) {
            if (e.toString().contains("ClassNotFoundException")) {
                System.err.printf("Error: \"%s\" is not a MathBehavior. Please check your list of behaviors.\n",
                        e.toString().split(" ")[1]);
            } else {
                System.err.println("An unexpected error occurred. Caught following exception:");
                System.err.printf("%s", e);
            }
        }
    }

    /**
     * @param args ignored
     */
    public static void main(String[] args) {
        new Starter().run();
    }

}
