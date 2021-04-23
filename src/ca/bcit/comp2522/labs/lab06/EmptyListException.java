package ca.bcit.comp2522.labs.lab06;

/**
 * Represents an EmptyListException.
 *
 * @author Amy Tan A01175168
 * @author Mina Lee A01165938
 * @version March 5, 2020
 */
public class EmptyListException extends Exception {
    /**
     * Constructs an EmptyListException.
     */
    public EmptyListException() {

    }

    /**
     * Constructs an EmptyListException with an error message.
     *
     * @param message a String
     */
    public EmptyListException(final String message) {
        super(message);
    }
}
