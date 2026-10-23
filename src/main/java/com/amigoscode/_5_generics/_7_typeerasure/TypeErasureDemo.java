package com.amigoscode._5_generics._7_typeerasure;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Type Erasure
 *
 * Java generics use "type erasure" -- the compiler enforces type safety at
 * compile time, then removes (erases) all generic type information at runtime.
 * This means List<String> and List<Integer> are both just List at runtime.
 *
 * This exercise explores the consequences and limitations of type erasure.
 *
 * Complete the TODOs below.
 */
public class TypeErasureDemo {

    public static void main(String[] args) {

        // TODO: 1 - Create a List<String> and a List<Integer>.
        //  Add some elements to each. Then compare their getClass() values
        //  using == and print the result.
        //  Example: System.out.println(stringList.getClass() == intList.getClass());
        //  Are they the same class at runtime? Add a comment explaining why.
        List<String> stringList = new ArrayList<>(List.of("Hello", "World"));
        List<Integer> integerList = new ArrayList<>(List.of(1,2,3));
        System.out.println(stringList.getClass() == integerList.getClass());

        // TODO: 2 - Demonstrate that generic type info is lost at runtime.
        //  Print the getClass().getName() of both lists from TODO 1.
        //  Add a comment explaining what you see -- do the class names
        //  include <String> or <Integer>? Why not?
        System.out.println(stringList.getClass().getName());
        System.out.println(integerList.getClass().getName());
        Object o = new ArrayList<>();

        // TODO: 3 - Show that instanceof works with raw types but NOT with
        //  parameterized types. Uncomment the code below, observe the error,
        //  then comment it back out. Write the correct version using the raw type.

        // System.out.println((o instanceof ArrayList<String>));
        System.out.println((o instanceof ArrayList));
        System.out.println((stringList instanceof ArrayList<String>)); // Does this compile?
        //
        //  Write the working version:
        //  if (stringList instanceof ArrayList) { ... }
        //  Add a comment explaining why you cannot use instanceof with generics.
        System.out.println((stringList instanceof ArrayList));


        // TODO: 4 - Show that you cannot create a generic array.
        //  Uncomment the line below and observe the compile error.
        //  Comment it back out and add an explanation.
        //
//         public static <T> T[] createArray(int size) {
//             return new T[size];  // Why doesn't this compile?
//         }
        //
        //  Explain: Since T is erased at runtime, the JVM would not know
        //  what type of array to create. What workaround exists?
        // T is erased at runtime, so there is no way for the JVM to know what kind of array to create.
        // By passing Class<T> componentType, we are using an already existing object with an existing reference to then pass the type
        // into the Array. we use Array.newInstance() to create the Array object, then explicitly cast it to T[] so that we can safely
        // refernce that Array Object (of type T array) using a T[] reference rather than an object reference

        // TODO: 5 - Add a comment below summarizing:
        //  (a) What is type erasure?
        //  (b) When does it happen (compile-time or runtime)?
        //  (c) What are the main limitations it causes?
        //      (List at least 3: instanceof, array creation, and one more)
        //  (d) Why did Java choose type erasure? (Hint: backward compatibility)

        // a)Type erasure is the process where the compiler removes generic types and replaces them with their bounds (Object for unbounded T)
        // b)Compile-time
        // c) 1- Cannot use intsanceof to check an object's generic type, since type erasure removes the genertic type information at run-time
        //    2- Cannot directly create generic arrays with
        //    3- Cannot create generic type parameter instances
        // d) Maintaining backward compatibility with pre-generics Java code and existing libraries
        // allowing existing code to work with older code that used raw types
    }
    public static <T> T[] createArray(Class<T> componentType, int size) {
        return (T[]) Array.newInstance(componentType, size);
    }
}
