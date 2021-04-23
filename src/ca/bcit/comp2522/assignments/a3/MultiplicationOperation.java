package ca.bcit.comp2522.assignments.a3;

/**
 * Operation class for multiplication.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class MultiplicationOperation extends AbstractOperation {
    private static final char MULTIPLICATION_CODE = '*';

    /**
     * Sets the multiplication code.
     */
    public MultiplicationOperation() {
        super(MULTIPLICATION_CODE);
    }

    /**
     * Performs the multiplication.
     *
     * @param operandA an integer, first operand
     * @param operandB an integer, second operand
     * @return the result of the operation
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA * operandB;
    }

    /**
     * Returns description of the object.
     *
     * @return the description of the object
     */
    @Override
    public String toString() {
        return "MultiplicationOperation{" + "operationType=" + operationType + '}';
    }
}
