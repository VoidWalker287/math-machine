/**
 * Store synchronous data between Modifiers in the math machine.
 *
 * @author Kyle Smith
 */
public class Buffer {
    private int data;

    /**
     * Read from the buffer.
     *
     * @return the next int in the buffer
     */
    public synchronized int read() {
        return data;
    }

    /**
     * Write to the buffer.
     *
     * @param data the int we should store
     */
    public synchronized void write(int data) {
        this.data = data;
    }
}
