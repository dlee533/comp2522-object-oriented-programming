package ca.bcit.comp2522.assignments.a3;

/**
 * Interface for operation classes.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public interface Operation {
    /**
     * Abstract interface for returning symbol.
     *
     * @return Symbol represented as a char
     */
    char getSymbol();

    /**
     * Abstract interface for perform method.
     *
     * @param operandA an integer, first operand
     * @param operandB an integer, second operand
     * @return an integer, the result
     */
    int perform(int operandA, int operandB);
}
