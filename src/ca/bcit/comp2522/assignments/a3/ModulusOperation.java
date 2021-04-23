package ca.bcit.comp2522.assignments.a3;

/**
 * Operation class for modulus.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class ModulusOperation extends AbstractOperation {

    private static final char MODULUS_CODE = '%';

    /**
     * Sets the operation type.
     */
    public ModulusOperation() {
        super(MODULUS_CODE);
    }

    /**
     * Performs the modulus.
     *
     * @param operandA an integer, first operand
     * @param operandB an integer, second operand
     * @return the result of the operation
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        return operandA % operandB;
    }

    /**
     * Returns description of the object.
     *
     * @return the description of the object
     */
    @Override
    public String toString() {
        return "ModulusOperation{" + "operationType=" + operationType + '}';
    }
}
