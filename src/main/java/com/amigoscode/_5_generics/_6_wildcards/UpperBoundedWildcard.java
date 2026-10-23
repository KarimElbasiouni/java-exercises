package com.amigoscode._5_generics._6_wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Upper Bounded Wildcards (? extends T)
 *
 * An upper bounded wildcard <? extends Number> accepts Number and all its
 * subclasses. This is useful when you want to READ from a generic structure
 * but do not need to WRITE to it.
 *
 * PECS principle: Producer Extends, Consumer Super.
 * When a list PRODUCES values (you read from it), use "extends".
 *
 * Complete the TODOs below.
 */
public class UpperBoundedWildcard {

    // TODO: 1 - Create a static method: double sumOfList(List<? extends Number> list)
    //  It should iterate through the list and sum all elements using doubleValue().
    //  Return the total sum.
    static double sumOfList(List<? extends Number> list){
        double sum = 0;
        for (Number number : list) {
            sum+= number.doubleValue();
        }
        return sum;
    }

    // TODO: 2 - Create a static method:
    //  void copyToNumberList(List<? extends Number> source, List<Number> destination)
    //  It should copy all elements from source into destination.
    //  This works because anything that extends Number IS-A Number.
    static void copyToNumberList(List<? extends Number> source, List<Number> destination){
        destination.addAll(source);
    }

    public static void main(String[] args) {

        // TODO: 3 - Create three lists and call sumOfList() with each:
        //  (a) List<Integer> with values 1, 2, 3, 4, 5
        //  (b) List<Double> with values 1.5, 2.5, 3.5
        //  (c) List<Long> with values 100L, 200L, 300L
        //  Print the sum for each.
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.5);
        doubleList.add(2.5);
        doubleList.add(3.5);
        List<Long> longList = new ArrayList<>(List.of(100L, 200L, 300L));
        System.out.println(sumOfList(intList));
        System.out.println(sumOfList(doubleList));
        System.out.println(sumOfList(longList));

        // TODO: 4 - Demonstrate that you CANNOT add to List<? extends Number>.
        //  Uncomment the code below, observe the compile error, then comment
        //  it back out. Add a comment explaining why.
        //
         List<? extends Number> numbers = new ArrayList<Integer>();
        // numbers.add(1);       // Why doesn't this compile?
        // numbers.add(1.0);     // Why doesn't this compile?
        // Hint: The compiler doesn't know the actual type. The list could be
        // List<Integer>, List<Double>, or any other Number subclass.
        // Compiler doesn't know the actual type. The list could be List<Integer>, List<Double> or List<Long>. It doesn't compile because there is no type-safety


        List<Number> numList = new ArrayList<>();
        // TODO: 5 - Use copyToNumberList() to copy a List<Integer> into a
        //  List<Number>. Print the destination list to verify it worked.
        copyToNumberList(intList, numList);
        System.out.println(numList);

        // TODO: 6 - Add a comment below explaining the PECS principle
        //  (Producer Extends, Consumer Super) as it applies to this exercise.
        //  Why is "extends" appropriate when the list is a PRODUCER (we read from it)?
        // When reading, we are unaware of whether or not we are reading a Integer, a Double, or a Float. By saying <? extends Number>, we are essentially allow you to read
        // elements of the list, as Number values, so long as they are a Number or one of it's subtypes. While having <? super Number> could , and will compile, it does not
        // provide the guardrail that is appropriate for this exercise. This is because we could pass List<Object> as an argument, meaning it could contain any Object including
        // it's subtypes. So Strings and other non-numeric objects are all objects. If we wanted to call sumOfList (and use doubleValue() directly on an Object)
        // this would lead to a compilation error since the compiler cannot guarantee that it is a Number. However, if we put the guardrail <? extends Number> then
        // we only allow lists whose element type is Number or its subtypes to be passed as an argument to the method, and if we try to pass List<String> then we would get
        // a compile-time error.
    }
}
