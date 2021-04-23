package ca.bcit.comp2522.labs.lab09;

import java.util.Random;

/**
 * Driver class.
 *
 * @author dongmin lee (A01165938)
 * @version 2020
 */
public class Driver {

    private static void fillArray(int[] numbers, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(size);
        }
    }

    /**
     * Executes the program.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SortTester sortTester = new SortTester();
        final int numOfDifferentNSize = 7;
        final int numRounds = 10;
        final int base = 10;

        for (int i = 1; i <= numOfDifferentNSize; i++) {
            int numElements = (int) Math.pow(base, i);
            int[] arr = new int[numElements];
            int[] arr1 = new int[numElements];
            long totalDurationQuadratic = 0;
            long totalDurationLogarithmic = 0;
            System.out.println("arr of size " + numElements);
            for (int round = 0; round < numRounds; round++) {
                fillArray(arr, numElements);
                long beforeQuadratic = System.nanoTime();
                sortTester.quadraticSort(arr);
                totalDurationQuadratic += (System.nanoTime() - beforeQuadratic);
                fillArray(arr1, numElements);
                long beforeLogarithmic = System.nanoTime();
                sortTester.logarithmicSort(arr1, 0, numElements - 1);
                totalDurationLogarithmic += (System.nanoTime() - beforeLogarithmic);
            }
            System.out.println("Insertion sort duration: " + (totalDurationQuadratic / numRounds));
            System.out.println("Quick sort duration: " + (totalDurationLogarithmic / numRounds));
            System.out.println();
        }
    }
}
