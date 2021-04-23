package ca.bcit.comp2522.assignments.a3;

/**
 * Custom exception for stack overflow.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class StackOverflowException extends Exception {
    /**
     * Empty constructor.
     */
    public StackOverflowException() {

    }

    /**
     * Constructor with messager.
     *
     * @param message a character representing operation type
     */
    public StackOverflowException(final String message) {
        super(message);
    }
}
