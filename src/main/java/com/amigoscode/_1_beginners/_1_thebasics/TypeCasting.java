package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Type Casting
 *
 * Learn how to convert between different data types in Java.
 * Widening (implicit): smaller type -> larger type (e.g., int -> double)
 * Narrowing (explicit): larger type -> smaller type (e.g., double -> int)
 */
public class TypeCasting {

    public static void main(String[] args) {

        // TODO: 1 - Widen an int to a double (implicit casting)
        // Declare an int variable with any value, then assign it to a double variable.
        // Print both variables to see the result.
        int intVal = 5;
        double doubleVal = intVal;
        System.out.println("intVal = " + intVal);
        System.out.println("doubleVal = " + doubleVal);


        // TODO: 2 - Narrow a double to an int (explicit casting)
        // Declare a double variable (e.g., 9.78), then cast it to an int.
        // Print both variables to see what happens to the decimal part.
        double varOne = 9.78;
        int varTwo = (int)varOne;
        System.out.println("varOne = " + varOne);
        System.out.println("varTwo = " + varTwo);

        // TODO: 3 - Cast an int to a char to get the character it represents
        // Hint: int value 65 corresponds to 'A' in ASCII
        // Print the resulting char.
        intVal = 65;
        char charVal = (char)intVal;
        System.out.println("charVal = " + charVal);


        // TODO: 4 - Cast a char to an int to get its ASCII value
        // Hint: char 'Z' has an ASCII value of 90
        // Print the resulting int.
        charVal = 'Z';
        intVal = charVal;
        System.out.println("intVal = " + intVal);


        // TODO: 5 - Convert a String "42" to an int using Integer.parseInt()
        // Declare a String variable with the value "42", then parse it to an int.
        // Print the result.
        String str = "42";
        int num = Integer.parseInt(str);
        System.out.println(num);


        // TODO: 6 - Convert an int 42 to a String using String.valueOf()
        // Declare an int variable with the value 42, then convert it to a String.
        // Print the result.
        num = 42;
        str = String.valueOf(num);
        System.out.println(str);

    }
}
