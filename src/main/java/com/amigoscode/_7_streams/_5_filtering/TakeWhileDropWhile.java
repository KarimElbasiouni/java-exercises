package com.amigoscode._7_streams._5_filtering;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Exercise: takeWhile and dropWhile
 *
 * Learn how to use takeWhile() and dropWhile() (Java 9+) to process
 * elements from ordered streams. Unlike filter(), these operations
 * are order-dependent and stop/start based on when the predicate changes.
 */
public class TakeWhileDropWhile {

    public static void main(String[] args) {
        List<Integer> sortedNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> unsortedNumbers = List.of(1, 3, 2, 5, 4, 7, 6, 8);
        List<String> logLevels = List.of("DEBUG", "DEBUG", "INFO", "INFO", "WARN", "ERROR", "ERROR");
        List<String> words = List.of("apple", "avocado", "apricot", "banana", "blueberry", "cherry");

        // TODO: 1 - Use takeWhile to take numbers from 'sortedNumbers' while they are < 5
        //           Print the result (should be 1, 2, 3, 4)
        System.out.println(sortedNumbers.stream().takeWhile(num-> num<5).toList());

        // TODO: 2 - Use dropWhile to skip numbers from 'sortedNumbers' while they are < 5
        //           Print the result (should be 5, 6, 7, 8, 9, 10)
        System.out.println(sortedNumbers.stream().dropWhile(num->num<5).toList());

        // TODO: 3 - Combine takeWhile with other operations:
        //           From 'sortedNumbers', take numbers while < 7, then filter to keep
        //           only even numbers, and collect to a list
        //           Print the result
        System.out.println(sortedNumbers.stream().takeWhile(num-> num<7).filter(num -> num%2==0).collect(Collectors.toUnmodifiableList()));

        // TODO: 4 - Use takeWhile on 'words' to take words while they start with "a"
        //           Print each word taken
        System.out.println(words.stream().takeWhile(word->word.startsWith("a")).toList());

        // TODO: 5 - Compare takeWhile vs filter on 'unsortedNumbers':
        //           First, use takeWhile(n -> n < 5) and print the result
        //           Then, use filter(n -> n < 5) and print the result
        //           Notice the different outputs - takeWhile stops at first non-match
        System.out.println();
        System.out.println(unsortedNumbers.stream().takeWhile(n -> n < 5).toList());
        System.out.println(unsortedNumbers.stream().filter(n -> n < 5).toList());
        System.out.println();

        // TODO: 6 - Use dropWhile on 'logLevels' to skip all DEBUG entries,
        //           then collect the remaining entries to a list
        //           Print the result
        System.out.println(logLevels.stream().dropWhile(level -> level.equals("DEBUG")).collect(Collectors.toUnmodifiableList()));
    }
}
