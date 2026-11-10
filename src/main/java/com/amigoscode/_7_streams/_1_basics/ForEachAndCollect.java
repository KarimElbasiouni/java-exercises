package com.amigoscode._7_streams._1_basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Exercise: forEach and collect
 *
 * Learn the two most common terminal operations: forEach for performing
 * an action on each element, and collect for gathering results into
 * a collection.
 */
public class ForEachAndCollect {

    public static void main(String[] args) {
        List<String> languages = List.of("Java", "Python", "JavaScript", "Go", "Rust", "Java", "Python");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // TODO: 1 - Use forEach to print each element of 'languages' on a separate line
        //           Use a lambda expression
        languages.stream().forEach(language -> System.out.println(language));

        // TODO: 2 - Use forEach with a method reference to print each element of 'numbers'
        //           Use System.out::println
        numbers.stream().forEach(System.out::println);

        // TODO: 3 - Filter 'numbers' to keep even numbers, then collect the results to a List
        //           Print the resulting list
        System.out.println(numbers.stream().filter(num -> num%2 ==0).toList());

        // TODO: 4 - Collect 'languages' stream results to a Set (removes duplicates automatically)
        //           Print the resulting set
        System.out.println(languages.stream().collect(Collectors.toSet()));

        // TODO: 5 - Collect 'numbers' stream to an unmodifiable list
        //           Use Collectors.toUnmodifiableList() or .toList()
        //           Print the result
        System.out.println(numbers.stream().collect(Collectors.toUnmodifiableList()));

        // TODO: 6 - Use Collectors.toCollection() to collect 'languages' into a LinkedList
        //           Print the resulting LinkedList and its class name to verify the type
        //           Hint: Collectors.toCollection(LinkedList::new)
        System.out.println(languages.stream().collect((Collector<? super String, Object, LinkedList<Object>>) Collectors.toCollection(LinkedList::new)));

    }
}
