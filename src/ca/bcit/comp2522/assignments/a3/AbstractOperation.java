package ca.bcit.comp2522.assignments.a3;

/**
 * Abstract class for operation classes.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public abstract class AbstractOperation implements Operation {
    /**
     * Stores operation type as a character.
     */
    protected char operationType;

    /**
     * Sets the operation type.
     *
     * @param operationType character that represents the operation type
     */
    public AbstractOperation(char operationType) {
        this.operationType = operationType;
    }

    /**
     * Returns the symbol for the operation.
     *
     * @return the symbol representing the operation type
     */
    @Override
    public final char getSymbol() {
        return operationType;
    }

    /**
     * Checks if two objects are equal.
     *
     * @param o object
     * @return boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractOperation that = (AbstractOperation) o;

        return operationType == that.operationType;
    }

    /**
     * Calculates hashcode of the object.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return operationType;
    }

    /**
     * Returns description of the object.
     *
     * @return description of the object
     */
    @Override
    public String toString() {
        return "AbstractOperation{"
                + "operationType=" + operationType + '}';
    }
}
