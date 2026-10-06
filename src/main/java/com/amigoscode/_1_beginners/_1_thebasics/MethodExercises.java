package com.amigoscode._1_beginners._1_thebasics;

/**
 * Exercise: Methods
 *
 * Learn how to define and call methods in Java.
 * Methods allow you to organize code into reusable blocks, each performing a specific task.
 */
public class MethodExercises {

    // TODO: 1 - Create a method called greet that takes a String parameter 'name'
    // and prints "Hello, {name}!"
    // Hint: public static void greet(String name) { ... }
    public static void greet(String name){
        System.out.printf("Hello, %s!\n", name);
    }

    // TODO: 2 - Create a method called add that takes two int parameters (a, b)
    // and returns their sum
    // Hint: public static int add(int a, int b) { ... }
    public static int add(int a, int b){
        return (a+b);
    }


    // TODO: 3 - Create a method called isEven that takes an int parameter 'number'
    // and returns true if the number is even, false otherwise
    // Hint: Use the modulus operator (%)
    public static boolean isEven(int number){
        if (number%2 == 0){
            return true;
        }else{
            return false;
        }
    }

    // TODO: 4 - Create a method called max that takes two int parameters (a, b)
    // and returns the larger of the two
    // Hint: Use an if statement or the ternary operator
    public static int max(int a, int b){
        return (a>b) ? a: b;
    }

    // TODO: 5 - Create a method called factorial that takes an int parameter 'n'
    // and returns n! (n factorial) using a loop
    // Hint: 5! = 5 * 4 * 3 * 2 * 1 = 120. Use a long return type for larger values.
    public static long factorial(int n){
        int num = n;
        for(int i = n - 1; i>0; i--){
            num *=(i);
        }
        return num;
    }

    // TODO: 6 - Create two overloaded methods called multiply:
    //   - One that takes 2 int parameters and returns their product
    //   - One that takes 3 int parameters and returns their product
    // Overloading means having multiple methods with the same name but different parameters.
    public static int multiply(int a, int b){
        return a*b;
    }
    public static int multiply(int a, int b, int c){
        return a*b*c;
    }

    public static void main(String[] args) {

        // TODO: 7 - Call all the methods above and print their results
        greet("Karim");
        System.out.println("add: "+ add(3,4));
        System.out.println("isEven: "+isEven(10));
        System.out.println("max: "+max(3,17));
        System.out.println("factorial: "+ factorial(4));
        System.out.println("multiplyx2: " +multiply(2,4));
        System.out.println("multiplyx3: " +multiply(4,3,2));
        // - Call greet with your name
        // - Call add with two numbers and print the result
        // - Call isEven with a number and print whether it is even
        // - Call max with two numbers and print the larger one
        // - Call factorial with 5 and print the result
        // - Call both multiply methods and print their results

    }
}
