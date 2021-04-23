package ca.bcit.comp2522.assignments.a3;

import java.util.Objects;
import java.util.Scanner;

/**
 * Calculates numbers.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class RPNCalculator {

    /**
     * minimum stack size, constant int.
     */
    public static final int MIN_STACK_SIZE = 2;

    private Stack stack;

    /**
     * Initilize and sets the stackSize and stack.
     *
     * @param stackSize an integer greater than MIN_STACK_SIZE
     * @throws IllegalArgumentException if the stack size is smaller than MIN_STACK_SIZE
     */
    public RPNCalculator(final int stackSize) {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException();
        }
        stack = new Stack(stackSize);
    }

    /**
     * Processes formula.
     *
     * @param formula a string with operands and operators
     * @return the result, integer
     * @throws StackOverflowException if the stack has reached its maximum capacity
     * @throws InvalidOperationTypeException if the formula is null or an empty string
     * @throws StackUnderflowException if there are no operands
     * @throws IllegalArgumentException if the formula is null
     */
    public int processFormula(final String formula) throws StackOverflowException,
            InvalidOperationTypeException, StackUnderflowException {
        if (formula == null) {
            throw new IllegalArgumentException();
        } else if (formula.equals("")) {
            throw new StackUnderflowException();
        }
        Scanner scan = new Scanner(formula);
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                push(scan.nextInt());
            } else {
                Operation operation = getOperation(scan.next().charAt(0));
                perform(operation);
            }
        }
        return getResult();
    }

    /**
     * Returns the result of the operation.
     *
     * @return the result, the only number left in the stack
     * @throws StackUnderflowException when there are no operands
     */
    public int getResult() throws StackUnderflowException {
        if (stack.size() == 0) {
            throw new StackUnderflowException("There are no operands!");
        }
        return stack.peek();
    }

    /**
     * Performs the operation.
     *
     * @param operation operation
     * @throws StackUnderflowException if there are no operands
     * @throws StackOverflowException if the stack has reached its maximum capacity
     * @throws IllegalArgumentException if the formula is null
     */
    public void perform(final Operation operation)
            throws StackUnderflowException, StackOverflowException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null!");
        }
        int operandB = stack.pop();
        int operandA = stack.pop();
        int newOperand = operation.perform(operandA, operandB);
        push(newOperand);
    }

    /**
     * Push an operand.
     *
     * @param operand integer
     * @throws StackOverflowException if the stack has reached its maximum capacity
     */
    public void push(final int operand) throws StackOverflowException {
        stack.push(operand);
    }

    private Operation getOperation(final char symbol) throws InvalidOperationTypeException {
        switch (symbol) {
            case '+':
                return new AdditionOperation();
            case '-':
                return new SubtractionOperation();
            case '*':
                return new MultiplicationOperation();
            case '/':
                return new DivisionOperation();
            case '%':
                return new ModulusOperation();
            case '@':
                return new PrimeSumOperation();
            default:
                throw new InvalidOperationTypeException(symbol);
        }
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

        RPNCalculator that = (RPNCalculator) o;

        return Objects.equals(stack, that.stack);
    }

    /**
     * Returns description of the object.
     *
     * @return description of the object
     */
    @Override
    public String toString() {
        return "RPNCalculator{" + "stack=" + stack + '}';
    }

    /**
     * Calculates hashcode of the object.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return stack != null ? stack.hashCode() : 0;
    }

    /*** Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     * Example usage: RPNCalculator 10 "1 2 +"
     * Note that the formula MUST be placed inside of double quotes.
     * @param argv - the command line arguments are the size of the Stack
     *               to be created followed by the expression to evaluate.
     */
    public static void main(final String[] argv) {
        // Checks for correct number of command line arguments
        if (argv.length != 2) {
            System.err.println("Usage: Main <stack size> <formula>");
            System.exit(1);
        }
        // Initializes stack and RPNCalculator.
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);
        try {
            System.out.println("[" + argv[1] + "] = " + calculator.processFormula(argv[1]));
        } catch (final InvalidOperationTypeException ex) {
            System.err.println("formula can only contain integers, +, -, *, /, %, and @");
        } catch (final StackOverflowException ex) {
            System.err.println("too many operands in the formula, increase the stack size");
        } catch (final StackUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
    }
}
