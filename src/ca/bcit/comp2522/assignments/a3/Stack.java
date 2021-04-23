package ca.bcit.comp2522.assignments.a3;

import java.util.Arrays;

/**
 * Stores the operands for operations.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class Stack {

    private int[] stackValues;
    private int count;

    /**
     * Initialize the stackValues with passed argument.
     *
     * @param size an integer greater or equal to 1
     * @throws IllegalArgumentException if the argument is small than 1
     */
    public Stack(final int size) {
        if (size < 1) {
            throw new IllegalArgumentException();
        }
        stackValues = new int[size];
        count = 0;
    }

    /**
     * Gets the total length of the stackValue array.
     *
     * @return the capacity of the stackValues in integer
     */
    public int capacity() {
        return stackValues.length;
    }

    /**
     * Gets the number of integers in stackValue.
     *
     * @return the number of integers in stackValue
     */
    public int size() {
        return count;
    }

    /**
     * Gets the number of unused space in stackValue.
     *
     * @return the number of unused space in stackValue in integer
     */
    public int unused() {
        return capacity() - count;
    }

    /**
     * Insert a number at the top of the stack.
     *
     * @param value an integer, an operand
     * @throws StackOverflowException if there is no more space left in stackValue
     */
    public void push(final int value) throws StackOverflowException {
        if (unused() == 0) {
            throw new StackOverflowException("This stack is full!");
        }
        stackValues[count++] = value;
    }

    /**
     * Removes and returns the integer on the top of the stack.
     *
     * @return the integer on the top of the stack
     * @throws StackUnderflowException if there's no integer stored in the stackValue
     */
    public int pop() throws StackUnderflowException {
        if (count == 0) {
            throw new StackUnderflowException("Cannot call Stack.pop() on an empty stack!");
        }
        int poppedInt = stackValues[--count];
        stackValues[count] = 0;
        return poppedInt;
    }

    /**
     * Returns the integer on the top of the stack.
     *
     * @return the integer on the top of the stack
     * @throws StackUnderflowException if there's no integer stored in the stackValue
     */
    public int peek() throws StackUnderflowException {
        if (count == 0) {
            throw new StackUnderflowException("Cannot call Stack.peek() on an empty stacks!");
        }
        return stackValues[count - 1];
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

        Stack stack = (Stack) o;

        if (count != stack.count) {
            return false;
        }
        return Arrays.equals(stackValues, stack.stackValues);
    }

    /**
     * Calculates hashcode of the object.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int num = 31;
        int result = Arrays.hashCode(stackValues);
        result = num * result + count;
        return result;
    }

    /**
     * Returns description of the object.
     *
     * @return description of the object
     */
    @Override
    public String toString() {
        return "Stack{" + "stackValues=" + Arrays.toString(stackValues) + ", count=" + count + '}';
    }
}
