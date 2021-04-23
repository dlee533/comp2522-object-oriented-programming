package ca.bcit.comp2522.assignments.a3;

/**
 * Custom exception for stack underflow.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class StackUnderflowException extends Exception {
    /**
     * Empty constructor.
     */
    public StackUnderflowException() {

    }

    /**
     * Constructor with messager.
     *
     * @param message a character representing operation type
     */
    public StackUnderflowException(final String message) {
        super(message);
    }
}
