package com.amigoscode._5_generics._5_boundedtypes;

import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Upper Bounded Type Parameters
 *
 * This exercise demonstrates bounded type parameters using "extends".
 * When you write <T extends Number>, T can only be Number or its subclasses
 * (Integer, Double, Long, etc.). This lets you call Number methods like
 * doubleValue() on values of type T.
 *
 * Complete the TODOs below.
 */
public class UpperBound {

    // TODO: 1 - Create a static generic method: <T extends Number> double sum(List<T> list)
    //  It should return the sum of all elements as a double.
    //  Use the doubleValue() method on each element (available because T extends Number).
    static <T extends Number> double sum (List<T> list){
        double sum = 0;
        for (T t : list) {
            sum+=t.doubleValue();
        }
        return sum;
    }

    // TODO: 2 - Create a static generic method: <T extends Number> T findMax(List<T> list)
    //  It should return the largest element in the list.
    //  Compare elements using doubleValue(). If the list is empty, return null.
    static <T extends Number> T findMax(List<T> list){
        if(list.isEmpty()){
            return null;
        }
        T largest = list.getFirst() ;
        for (T t : list) {
            if (Double.compare(t.doubleValue(),largest.doubleValue())>0){
                largest = t;
            }
        }
        return largest;
    }

    // TODO: 3 - Create a generic class NumberBox<T extends Number> with a private T field
    //  called "number" and a constructor that takes T.
    public static class NumberBox<T extends Number>{
        private T number;

        public NumberBox(T number) {
            this.number = number;
        }

    // TODO: 4 - In NumberBox, add an isPositive() method that returns true if the
    //  stored number's doubleValue() is greater than 0.

        public boolean isPositive(){

            return this.number.doubleValue()>0;
        }
    // TODO: 5 - In NumberBox, add toInt() and toDouble() conversion methods that
    //  return the stored number as an int (using intValue()) and as a double
    //  (using doubleValue()) respectively.
        public int toInt(){
            return this.number.intValue();
        }
        public double toDouble(){
            return this.number.doubleValue();
        }
    }

    public static void main(String[] args) {

        // TODO: 6 - Test sum() and findMax() with:
        //  (a) A List<Integer> e.g., Arrays.asList(1, 2, 3, 4, 5)
        //  (b) A List<Double> e.g., Arrays.asList(1.5, 2.5, 3.5)
        //  Print the results for each.
        //  Also create a NumberBox<Integer> and NumberBox<Double> and test
        //  isPositive(), toInt(), and toDouble().
        List<Integer> intList = Arrays.asList(1,2,3,4,5);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);
        System.out.println(sum(intList));
        System.out.println(findMax(intList));

        System.out.println(sum(doubleList));
        System.out.println(findMax(doubleList));

        NumberBox<Integer> integerNumberBox = new NumberBox<>(4);
        NumberBox<Double> doubleNumberBox = new NumberBox<>(-2.0);

        System.out.println(integerNumberBox.isPositive());
        System.out.println(doubleNumberBox.isPositive());
        System.out.println(integerNumberBox.toDouble());
        System.out.println(doubleNumberBox.toInt());

        // TODO: 7 - Uncomment the line below and observe the compile error.
        //  Then comment it back out and add a comment explaining why it fails.
        //
         List<String> strings = Arrays.asList("a", "b");
         //double result = sum(strings);  // Why does this not compile?
        // This is because the method has an upperbound on it, being that it can only be a Number or any of the sub-classes of Number

    }
}
