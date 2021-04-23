package ca.bcit.comp2522.assignments.a3;

/**
 * Operation class for subtraction.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class SubtractionOperation extends AbstractOperation {
    private static final char SUBTRACTION_CODE = '-';

    /**
     * Sets the subtraction code.
     */
    public SubtractionOperation() {
        super(SUBTRACTION_CODE);
    }

    /**
     * Performs the subtraction.
     *
     * @param operandA an integer, first operand
     * @param operandB an integer, second operand
     * @return the result of the operation
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA - operandB;
    }

    /**
     * Returns description of the object.
     *
     * @return description of the object
     */
    @Override
    public String toString() {
        return "SubtractionOperation{" + "operationType=" + operationType + '}';
    }
}
