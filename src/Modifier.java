/**
 * Applies the function of a MathBehavior concurrently.
 * If the Modifier is first in the math machine, its input buffer will not be used.
 *
 * @author Kyle Smith
 */
public class Modifier extends Thread {
    private final int threadNumber;
    private final Buffer inBuffer;
    private final Buffer outBuffer;
    private final MathBehavior behavior;
    private final String behaviorName;

    private void writeAction(String action) {
        System.out.printf("Thread %d: %s %s Behavior\n", this.threadNumber, action, this.behaviorName);
    }

    /**
     * Associate a MathBehavior with a thread to create a Modifier.
     *
     * @param threadNumber the place the thread is in the machine (ignored unless it is zero)
     * @param bufferIn     the buffer to read from
     * @param bufferOut    the buffer to write to
     */
    public Modifier(int threadNumber, Buffer bufferIn, Buffer bufferOut, MathBehavior behavior) {
        this.threadNumber = threadNumber;
        this.inBuffer = bufferIn;
        this.outBuffer = bufferOut;
        this.behavior = behavior;
        this.behaviorName = behavior.toString().split("Behavior")[0];

        writeAction("Initialized");
    }

    /**
     * Apply the function of the MathBehavior to the input buffer for the specified number of trials.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        writeAction("Running");
        for (int i = 0; i < Starter.NUMBER_OF_TRIALS; i++) {
            behavior.calculate(this.inBuffer, this.outBuffer);
        }
    }

    /**
     * Get a string representation of the Modifier.
     * @return a string representing the Modifier
     */
    @Override
    public String toString() {
        return String.format("Thread %d: %s Behavior", this.threadNumber, this.behaviorName);
    }
}
