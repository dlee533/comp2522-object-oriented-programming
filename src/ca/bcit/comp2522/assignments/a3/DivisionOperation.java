package ca.bcit.comp2522.assignments.a3;

/**
 * Operation class for division.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class DivisionOperation extends AbstractOperation {
    private static final char DIVISION_CODE = '/';

    /**
     * Sets the division code.
     */
    public DivisionOperation() {
        super(DIVISION_CODE);
    }

    /**
     * Performs the division.
     *
     * @param operandA an integer, first operand
     * @param operandB an integer, second operand
     * @return the result of the operation
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA / operandB;
    }

    /**
     * Returns description of the object.
     *
     * @return the description of the object
     */
    @Override
    public String toString() {
        return "DivisionOperation{" + "operationType=" + operationType + '}';
    }
}
