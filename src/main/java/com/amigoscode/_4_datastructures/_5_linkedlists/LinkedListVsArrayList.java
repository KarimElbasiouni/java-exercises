package com.amigoscode._4_datastructures._5_linkedlists;

// Exercise: LinkedList vs ArrayList Performance Comparison
// Understand when to use LinkedList vs ArrayList by measuring operation times.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListVsArrayList {

    public static void main(String[] args) {

        // TODO: 1 - Create both an ArrayList<Integer> and a LinkedList<Integer>
        //           Fill each with 10000 elements (0 to 9999) using a for loop
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10_000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }


        // TODO: 2 - Measure time to add an element at the beginning (index 0) for both lists
        //           Use System.nanoTime() before and after the operation
        //           Perform the add(0, value) operation 1000 times for each list
        //           Print the time taken for each in milliseconds
        //           (divide nanoseconds by 1_000_000 to get milliseconds)

        System.out.println(System.nanoTime() /100_000);
        for (int i = 0; i < 1000; i++) {
            arrayList.add(0, i-1000);
        }
        System.out.println(System.nanoTime()/100_000);
        System.out.println();
        System.out.println(System.nanoTime()/100_000);
        for (int i = 0; i < 1000; i++) {
            linkedList.add(0, i-1000);
        }
        System.out.println(System.nanoTime()/100_000);

        // TODO: 3 - Measure time to add an element at the end for both lists
        //           Perform the add(value) operation 1000 times for each list
        //           Print the time taken for each
        System.out.println();
        System.out.println(System.nanoTime() / 100_000);
        for (int i = 0; i < 1000; i++) {
            arrayList.add(10_000 + i);
        }
        System.out.println(System.nanoTime()/100_000);
        System.out.println();
        System.out.println(System.nanoTime()/100_000);
        for (int i = 0; i < 1000; i++) {
            linkedList.add(10_000 + i);
        }
        System.out.println(System.nanoTime()/100_000);

        // TODO: 4 - Measure time to get an element at the middle index for both lists
        //           Perform get(list.size() / 2) operation 1000 times for each list
        //           Print the time taken for each
        System.out.println();
        System.out.println(System.nanoTime() / 100_000);
        for (int i = 0; i < 1000; i++) {
            arrayList.get(arrayList.size()/2);
        }
        System.out.println(System.nanoTime()/100_000);
        System.out.println();
        System.out.println(System.nanoTime()/100_000);
        for (int i = 0; i < 1000; i++) {
            linkedList.get(linkedList.size()/2);
        }
        System.out.println(System.nanoTime()/100_000);

        // TODO: 5 - Print a summary explaining the differences
        //           Use System.out.println() to explain:
        //           - Why LinkedList is faster for insertions at the beginning
        //           - Why ArrayList is faster for random access (get by index)
        //           - When you would choose one over the other

        System.out.println("1 - LinkedList is faster for insertions at the beginning since all it has to do is change the prev pointer of the previously first " +
                "node and make the next pointer for the insertion node point to the previously first node. ArrayList on the other hand would require a complete shift (dynamic" +
                "resizing and moving items around to make space for insertion at the beginning");
        System.out.println("2 - ArrayList is faster for random access due to indexing. We can easily retrieve an item by index. While for LinkedList, you would have to " +
                "traverse through the entire array until you have reached the i-th item.");
        System.out.println("3 - Use a Linked List when you want to insert items anywhere other than the end of the List. Use an ArrayList for fast retrieval using indexing");
    }
}
