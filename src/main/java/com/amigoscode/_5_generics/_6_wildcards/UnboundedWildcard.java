package com.amigoscode._5_generics._6_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Unbounded Wildcards (?)
 *
 * The unbounded wildcard <?> represents an unknown type.
 * A List<?> can refer to a list of any type, but you cannot add elements
 * to it (except null) because the compiler does not know the actual type.
 *
 * Complete the TODOs below.
 */
public class UnboundedWildcard {

    // TODO: 1 - Create a static method: void printList(List<?> list)
    //  It should iterate through the list and print each element.
    //  Note: elements come out as Object since the type is unknown.
    static void printList(List<?> list){
        for (Object o : list) {
            System.out.print(o + " ");
        }
    }

    // TODO: 2 - Create a static method: int getSize(List<?> list)
    //  It should return the size of any list, regardless of its type.
    static int getSize(List<?> list){
        return list.size();
    }

    public static void main(String[] args) {

        // TODO: 3 - Create three lists:
        //  (a) List<String> with values "Hello", "World"
        //  (b) List<Integer> with values 1, 2, 3
        //  (c) List<Double> with values 1.1, 2.2, 3.3
        //  Call printList() and getSize() with each of them.
        List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("World");
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);
        printList(strList);
        printList(intList);
        printList(doubleList);
        System.out.println(getSize(strList));
        System.out.println(getSize(intList));
        System.out.println(getSize(doubleList));

        // TODO: 4 - Demonstrate that you CANNOT add elements to a List<?>.
        //  Uncomment the code below, observe the compile error, then comment
        //  it back out. Add a comment explaining why adding is not allowed.
        //
        List<?> unknownList = Arrays.asList("a", "b", "c");
//         unknownList.add("d");       // Why does this not compile?
//         unknownList.add(1);         // Why does this not compile either?


        // TODO: 5 - Demonstrate what you CAN do with List<?>:
        //  (a) Get the size
        //  (b) Check if it is empty
        //  (c) Read elements as Object
        //  (d) Remove elements (by index or using clear())
        //  Write code showing at least two of these operations on a List<?>.
        System.out.println(getSize(unknownList));
        System.out.println(unknownList.isEmpty());
        printList(unknownList);
        Object o = unknownList.get(1);
        System.out.println(o);
    }
}
