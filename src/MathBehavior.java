/**
 * A function in the math machine.
 * @author Kyle Smith
 */
@SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter") // synchronization is not an issue here
public abstract class MathBehavior {
    public synchronized void calculate(Buffer input, Buffer output) {
        synchronized (input) {
            int inputData = input.read();
            int outputData = delegateMath(inputData);
            output.write(outputData);
        }
    }

    protected abstract int delegateMath(int inputData);
}