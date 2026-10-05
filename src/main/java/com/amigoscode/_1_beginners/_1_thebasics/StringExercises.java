package com.amigoscode._1_beginners._1_thebasics;

import java.util.Locale;

/**
 * Exercise: Strings
 *
 * Learn how to work with Strings in Java.
 * Strings are objects that represent sequences of characters and come with
 * many useful built-in methods.
 */
public class StringExercises {

    public static void main(String[] args) {

        String message = "Hello, Welcome to Amigoscode!";
        String padded = "   Hello World   ";
        String csv = "apple,banana,cherry,date,elderberry";

        // TODO: 1 - Get the length of the 'message' string and print it
        // Hint: Use the .length() method
        int todoOne = message.length();
        System.out.println("todoOne = " + todoOne);


        // TODO: 2 - Convert 'message' to uppercase and lowercase, and print both
        // Hint: Use .toUpperCase() and .toLowerCase()
        String todoTwoUpperCase = message.toUpperCase();
        String todoTwoLowerCase = message.toLowerCase();
        System.out.println("todoTwoUpperCase = " + todoTwoUpperCase);
        System.out.println("todoTwoLowerCase = " + todoTwoLowerCase);

        // TODO: 3 - Get a substring of 'message' containing the first 5 characters and print it
        // Hint: Use .substring(startIndex, endIndex)
        String todoThree = message.substring(0,5);
        System.out.println("todoThree = " + todoThree);

        // TODO: 4 - Check if 'message' contains the word "Amigoscode" and print the result
        // Hint: Use .contains()
        boolean containsAmigoscode = message.contains("Amigoscode");
        System.out.println("containsAmigoscode = " + containsAmigoscode);


        // TODO: 5 - Replace "Amigoscode" with "Java" in 'message' and print the new string
        // Hint: Use .replace(oldValue, newValue)
        String todoFive = message.replace("Amigoscode", "Java");
        System.out.println("todoFive = " + todoFive);


        // TODO: 6 - Trim the whitespace from the 'padded' string and print the result
        // Hint: Use .trim()
        String todoSix = padded.trim();
        System.out.println("todoSix = " + todoSix);


        // TODO: 7 - Split the 'csv' string by commas into a String array and print each element
        // Hint: Use .split(",") then loop through the resulting array
        String[] fruits = csv.split(",");
        for (String fruit: fruits){
            System.out.println(fruit);
        }

        // TODO: 8 - Check if two strings are equal using .equals() (not ==)
        // Create two String variables with the same text content and compare them.
        // Print the result of .equals() and explain why == may not work for Strings.
        String str1 = new String("abc");
        String str2 = new String ("abc");
        System.out.println(".equals(): "+ (str1.equals(str2)));
        System.out.println("str1==str2: " + (str1==str2));
        System.out.println("== compares the value that would be stored on the memory stack, which is the reference location. .equals() will bypass that and compare the value stored");

    }
}
