package ca.bcit.comp2522.labs.lab02;

import java.util.Random;

/**
 * Mathematics class.
 *
 * @author Dongmin Lee
 * @version 2020
 */
public class Mathematics {

    /**
     * Constant for PI.
     */
    public static final double PI = 3.14159;

    /**
     * Conversion rate from a foot to km.
     */
    public static final double ONE_FOOT_TO_KILOMETRE_RATIO = 0.0003048;

    /**
     * Calculates the area of the circle with given radius.
     *
     * @param radius of a circle in double form
     * @return the area of a circle in double type
     */
    public final double getCircleArea(final double radius) {
        return radius * radius * PI;
    }

    /**
     * Calculates the area of a square with given width.
     *
     * @param width of a square in double type
     * @return the area of a square in double type
     */
    public final double getSquareArea(final double width) {
        return width * width;
    }

    /**
     * Adds two numbers.
     *
     * @param firstNumber a double
     * @param secondNumber a double
     * @return the sum of two numbers
     */
    public final double add(final double firstNumber, final double secondNumber) {
        return firstNumber + secondNumber;
    }

    /**
     * Multiplies two numbers.
     *
     * @param firstNumber a double
     * @param secondNumber a double
     * @return the product of two numbers
     */
    public final double multiply(final double firstNumber, final double secondNumber) {
        return firstNumber * secondNumber;
    }

    /**
     * Subtracts two numbers.
     *
     * @param firstNumber a double
     * @param secondNumber a double
     * @return firstNumber - secondNumber
     */
    public final double subtract(final double firstNumber, final double secondNumber) {
        return firstNumber - secondNumber;
    }

    /**
     * Divides a number by divisor.
     *
     * @param firstNumber a double
     * @param secondNumber a double
     * @return firstNumber/second number if secondNumber is not a zero, else a zero
     */
    public final double divide(final double firstNumber, final double secondNumber) {
        if (secondNumber == 0) {
            return 0;
        }
        return firstNumber / secondNumber;
    }

    /**
     * Calculates the absolute value of a number.
     *
     * @param number an int
     * @return the absolute number in int
     */
    public final int absoluteValue(final int number) {
        if (number < 0) {
            return -number;
        }
        return number;
    }

    /**
     * Gets a random number between ten and twenty but not fifteen.
     *
     * @return the random number in int
     */
    public final int getRandomNumberBetweenTenAndTwentyButNotFifteen() {
        final Random rand = new Random();
        final byte startsAtTen = 10;
        final byte rangeOfTen = 11;
        final byte numberException = 15;
        while (true) {
            int randomNumber = rand.nextInt(rangeOfTen) + startsAtTen;
            if (randomNumber != numberException) {
                return randomNumber;
            }
        }
    }

    /**
     * Converts feet to kilometres.
     *
     * @param feet a number in double type
     * @return feet converted to km
     */
    public final double convertFeetToKilometres(final double feet) {
        return feet * ONE_FOOT_TO_KILOMETRE_RATIO;
    }

    /**
     * Calculates the sum of positive integers from zero up to the given upper bound.
     *
     * @param number an integer
     * @return the sum of positive integers
     */
    public final int sumOfInts(int number) {
        int sum = 0;
        for (int currentNumber = number; currentNumber > 0; currentNumber--) {
            sum += currentNumber;
        }
        return sum;
    }

    /**
     * Checks if the number is positive.
     *
     * @param number a double
     * @return the boolean value indicating the status of number
     */
    public final boolean isPositive(final double number) {
        return number > 0;
    }

    /**
     * Checks if the number is even.
     *
     * @param number an integer
     * @return the boolean value indicating whether the number is even or not
     */
    public final boolean isEven(final int number) {
        return number % 2 == 0;
    }

    /**
     * Sums the even numbers from zero to the number given.
     *
     * @param number an integer
     * @return the sum of evens
     */
    public final int sumOfEvens(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number;
            if (number < 0) {
                number += 2;
            } else {
                number -= 2;
            }
        }
        return sum;
    }

    /**
     * Sums the multiples of secondNumber from zero to the firstNumber.
     *
     * @param firstNumber an integer
     * @param secondNumber an integer
     * @return the sum of products
     */
    public final int sumOfProducts(final int firstNumber, final int secondNumber) {
        int sum = 0;
        int currentNumber = firstNumber > 0 ? secondNumber : -secondNumber;
        while (firstNumber > 0 ? firstNumber >= currentNumber : firstNumber <= currentNumber) {
            sum += currentNumber;
            if (firstNumber > 0) {
                currentNumber += secondNumber;
            } else {
                currentNumber -= secondNumber;
            }
        }
        return sum;
    }
}
