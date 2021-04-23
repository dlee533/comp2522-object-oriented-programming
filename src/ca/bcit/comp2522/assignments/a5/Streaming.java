package ca.bcit.comp2522.assignments.a5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Question 1.
 * it creates a stream(sequence of elements) of list, filters out even integers,
 * calculates the sum of non even numbers
 *
 * Question 2.
 * it generates a million random numbers that are either 1 or 2, group them by
 * the integer value, and sums the number of said integer value/ count the
 * integer value by the value. At last, it will print the sides(values) 1, 2 with
 * their frequency(count) side by side
 *
 * Question 9.
 * Stream.of(values) returns stream with elements of values array, in order to get
 * int instead of stream, you need to flat map it to integer with flatMapToInt method.
 *
 * Contains methods with stream.
 *
 * @author Dongmin Lee A01165938
 * @version 2020
 */
public class Streaming {

    /**
     * Creates list of characters.
     *
     * @pre true
     * @post a list of 30 random characters is created
     * @return List<Character>
     */
    public static List<Character> words() {
        List<Character> word = new ArrayList<>();
        Random random = new Random();
        final int wordLength = 30;
        for (int i = 0; i < wordLength; i++) {
            String letters = "abcdefghijklmnopqrstuvwxyz";
            word.add(letters.charAt(random.nextInt(letters.length())));
        }
        return word;
    }

    /**
     * Sort the list of character in ascending order.
     *
     * @param word a list of characters
     * @pre list of characters in any order
     * @post list of characters in ascending order is created
     * @return List<Character> in ascending order
     */
    public static List<Character> ascendingSort(List<Character> word) {
        return word.stream()
                   .sorted()
                   .collect(Collectors.toList());
    }

    /**
     * Sort the list of character in descending order.
     *
     * @param word a list of character
     * @pre list of characters in any order
     * @post list of characters in descending order is created
     * @return List<Character> in descending order
     */
    public static List<Character> descendingSort(List<Character> word) {
        return word.stream()
                   .sorted(Comparator.reverseOrder())
                   .collect(Collectors.toList());
    }

    /**
     * Remove the duplicates and sort the list of character in descending order.
     *
     * @param word a list of character
     * @pre list of characters in any order
     * @post list of character without duplicates in descending order is created
     * @return List<Character> with distinct characters in descending order
     */
    public static List<Character> descendingSortNoDuplicates(List<Character> word) {
        return word.stream()
                   .distinct()
                   .sorted(Comparator.reverseOrder())
                   .collect(Collectors.toList());
    }

    /**
     * Logs the word as it streams the list of strings.
     *
     * @param wordList List<String>
     * @pre list of strings
     * @post prints strings before and after filtering
     */
    public static void lazyStream(List<String> wordList) {
        final int minimumWordLength = 10;
        wordList.stream()
                .filter(word -> {
                    System.out.println("Before filtering: " + word);
                    return word.length() > minimumWordLength;
                }).forEach(word -> System.out.println("After filtering: " + word));
    }

    /**
     * Turns a string into a stream of characters.
     *
     * @param input String input
     * @pre an input of string
     * @post creates a stream of characters
     * @return Stream<Character>
     */
    public static Stream<Character> characterStream(String input) {
        return input.chars().mapToObj(character -> (char) character);
    }
}
