package ca.bcit.comp2522.assignments.a3;

/**
 * Custom exception for invalid operation type.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class InvalidOperationTypeException extends Exception {
    /**
     * Empty constructor.
     */
    public InvalidOperationTypeException() { }

    /**
     * Constructor with symbol as parameter.
     *
     * @param symbol a character representing operation type
     */
    public InvalidOperationTypeException(char symbol) {
        super(symbol + " is invalid!");
    }
}
