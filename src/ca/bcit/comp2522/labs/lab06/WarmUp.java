package ca.bcit.comp2522.labs.lab06;

public class WarmUp {
    public static int getSumOfLargest(int[] arrayOfInts) {
        int largest = arrayOfInts[0];
        int secondLargest = arrayOfInts[1];
        for (int index = 1; index < arrayOfInts.length; index++) {
            if (arrayOfInts[index] > largest) {
                secondLargest = largest;
                largest = arrayOfInts[index];
            } else if (arrayOfInts[index] > secondLargest) {
                secondLargest = arrayOfInts[index];
            }
        }
        return largest + secondLargest;
    }
    public static void main(String[] args) {
        int[] test1 = {2, 1};
        int[] test2 = {2, 4, 6, 8, 10, 12, 14};
        int[] test3 = {14, 12, 10, 8, 10, 12, 14};
        int[] test4 = {8, 8, 8, 8, 8, 8, 8};
        System.out.println(getSumOfLargest(test1));
        System.out.println(getSumOfLargest(test2));
        System.out.println(getSumOfLargest(test3));
        System.out.println(getSumOfLargest(test4));
    }
}
