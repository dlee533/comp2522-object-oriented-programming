package ca.bcit.comp2522.assignments.a3;

/**
 * Operation class for addition.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class AdditionOperation extends AbstractOperation {
    private static final char ADDITION_CODE = '+';

    /**
     * Sets the addition code.
     */
    public AdditionOperation() {
        super(ADDITION_CODE);
    }

    /**
     * Performs the addition.
     *
     * @param operandA an integer, first operand
     * @param operandB an integer, second operand
     * @return the sum of two operands
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA + operandB;
    }

    /**
     * Returns description of the object.
     *
     * @return the description of the object
     */
    @Override
    public String toString() {
        return "AdditionOperation{" + "operationType=" + operationType + '}';
    }
}
