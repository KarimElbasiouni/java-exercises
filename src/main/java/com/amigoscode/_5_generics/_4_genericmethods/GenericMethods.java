package com.amigoscode._5_generics._4_genericmethods;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Generic Methods
 *
 * This exercise focuses on writing static generic methods.
 * Generic methods declare their own type parameters independently
 * of any generic class. The type parameter appears before the return type.
 *
 * Complete the TODOs below.
 */
public class GenericMethods {

    // TODO: 1 - Create a static generic method: <T> void printArray(T[] array)
    //  It should print each element of the array on the same line separated
    //  by spaces, then print a newline at the end.
    static <T> void printArray(T[] array){
        for (T t : array) {
            System.out.print(t + "  ");
        }
        System.out.println();
    }

    // TODO: 2 - Create a static generic method: <T> T getFirst(List<T> list)
    //  It should return the first element of the list.
    //  If the list is empty, return null.
    static <T> T getFirst(List<T> list){
        return list.isEmpty()? null: list.getFirst();
    }

    // TODO: 3 - Create a static generic method: <T> T getLast(List<T> list)
    //  It should return the last element of the list.
    //  If the list is empty, return null.
    static <T> T getLast(List<T> list){
        return list.isEmpty()? null: list.getLast();
    }

    // TODO: 4 - Create a static generic method: <T> List<T> filterNulls(List<T> list)
    //  It should return a new list containing only the non-null elements
    //  from the original list. Do not modify the original list.
    static <T> List<T> filterNulls(List<T> list){
        list.removeIf(num -> num == null);
        return list;
    }

    // TODO: 5 - Create a static generic method: <T> boolean contains(T[] array, T target)
    //  It should return true if the target is found in the array.
    //  Use the equals() method for comparison (handle null target).
    static <T> boolean contains (T[] array, T target){
        for (T t : array) {
            if (t.equals(target)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // TODO: 6 - Call all five methods above:
        //  (a) printArray with a String[] and an Integer[]
        //  (b) getFirst and getLast with a List<String> of names
        //  (c) filterNulls with a list that contains some null values
        //  (d) contains to search for an element in an array
            printArray(new String[]{"hello", "world"});
            printArray(new Integer[]{1,2});

            List<String> names = new ArrayList<>();
            names.add("Nelson");
            names.add("Ian");
            names.add("Yusuf");

            System.out.println(getFirst(names));
        System.out.println(getLast(names));
        names.add(null);
        names.add("YO");
        names.add(null);
        System.out.println(names);
        System.out.println(filterNulls(names));
        System.out.println();
        System.out.println(contains(new String[]{"a", "b", "c"}, "a"));

        // TODO: 7 - Demonstrate type inference: call printArray and contains
        //  WITHOUT explicitly specifying the type parameter (i.e., just call
        //  printArray(myArray) instead of GenericMethods.<String>printArray(myArray)).
        //  Add a comment explaining that the compiler infers T from the arguments.
        // No need to specify the type. At compile-time the compiler infers T from the arguments passed.
        String[] myArray = {"My", "array"};
        printArray(myArray);
    }
}
