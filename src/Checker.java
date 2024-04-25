/**
 * Verifies the output of the math machine.
 *
 * @author Kyle Smith
 */
public class Checker {
    private final Buffer buffer;
    private final int expectedValue;

    /**
     * Set the target buffer and expect value of the ConstantChecker.
     * @param buffer the output buffer of the final step in the math machine
     * @param expectedValue  the value we expect it to have
     */
    public Checker(Buffer buffer, int expectedValue) {
        this.buffer = buffer;
        this.expectedValue = expectedValue;
    }

    /**
     * Checks the value received from the math machine with the expected value.
     */
    public void check() {
        int data = buffer.read();
        if (data != expectedValue) {
            System.err.printf("Check failed. Expected %d but got %d", expectedValue, data);
        } else {
            System.out.println("Check passed: target " + expectedValue + " data " + data);
        }
    }
}
