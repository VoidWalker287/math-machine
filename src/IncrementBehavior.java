/**
 * Increments the input by one to create the output.
 * @author Kyle Smith
 */
@SuppressWarnings("unused") // all MathBehaviors are dynamically loaded
public class IncrementBehavior extends MathBehavior {
    @Override
    protected int delegateMath(int x) {
        return x + 1;
    }
}
