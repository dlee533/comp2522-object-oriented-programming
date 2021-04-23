package ca.bcit.comp2522.labs.lab09;

/**
 * Sorts number with two different algorithms.
 *
 * @author https://www.geeksforgeeks.org/insertion-sort/
 * @author https://www.geeksforgeeks.org/iterative-quick-sort/
 * @version 2020
 */
public class SortTester {

    /**
     * insertion sort method.
     *
     * @param numbers array of ints
     */
    public void quadraticSort(int[] numbers) {
        int length = numbers.length;
        for (int i = 1; i < length; ++i) {
            int key = numbers[i];
            int j = i - 1;

            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j = j - 1;
            }
            numbers[j + 1] = key;
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {

            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * sort the array using quick sort.
     *
     * @param numbers array of ints
     * @param l first index
     * @param h last index
     */
    public void logarithmicSort(int[] numbers, int l, int h) {
        int[] stack = new int[h - l + 1];

        int top = -1;

        stack[++top] = l;
        stack[++top] = h;

        while (top >= 0) {
            h = stack[top--];
            l = stack[top--];

            int p = partition(numbers, l, h);

            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    }
}
