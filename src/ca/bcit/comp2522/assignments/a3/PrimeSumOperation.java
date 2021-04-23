package ca.bcit.comp2522.assignments.a3;

import static java.lang.Math.sqrt;

/**
 * Operation class for prime sum.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class PrimeSumOperation extends AbstractOperation {
    private static final char PRIME_SUM_CODE = '@';

    /**
     * Sets the prime sum code.
     */
    public PrimeSumOperation() {
        super(PRIME_SUM_CODE);
    }

    /**
     * Performs the prime sum.
     *
     * @param operandA an integer, first operand
     * @param operandB an integer, second operand
     * @return the result of the operation
     */
    @Override
    public int perform(final int operandA, final int operandB) {
        int result = 0;
        int upperBound = Math.max(operandA, operandB);
        int lowerBound = Math.min(operandA, operandB);
        if (upperBound < 2) {
            return 0;
        }
        for (int num = Math.max(lowerBound, 2); num <= upperBound; num++) {
            boolean isPrime = true;
            for (int i = 2; i <= sqrt(upperBound); i++) {
                if (num != i && num % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                result += num;
            }
        }
        return result;
    }

    /**
     * Returns description of the object.
     *
     * @return the description of the object
     */
    @Override
    public String toString() {
        return "PrimeSumOperation{" +
                "operationType=" + operationType +
                '}';
    }
}