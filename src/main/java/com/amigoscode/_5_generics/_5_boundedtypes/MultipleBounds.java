package com.amigoscode._5_generics._5_boundedtypes;

import javax.print.attribute.standard.PrinterURI;
import javax.swing.plaf.ComponentInputMapUIResource;
import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise: Multiple Bounds
 *
 * This exercise demonstrates how a type parameter can have multiple bounds.
 * The syntax is: <T extends ClassBound & InterfaceBound1 & InterfaceBound2>
 * If a class is included, it must come first.
 *
 * Complete the TODOs below.
 */
public class MultipleBounds {

    // TODO: 1 - Create an interface called Printable with a single method:
    //  void print();
    interface Printable{
        void print();
    }

    // TODO: 2 - Create a static generic method:
    //  <T extends Comparable<T> & Printable> T findMin(List<T> list)
    //  It should return the smallest element using compareTo().
    //  If the list is empty, return null.
    //  This method requires T to be both Comparable AND Printable.
    static <T extends Comparable<T> & Printable> T findMin(List<T> list){
        if(list.isEmpty()){
            return null;
        }
        T smallest = list.getFirst() ;
        for (T t : list) {
            if (t.compareTo(smallest)<0){
                smallest = t;
            }
        }
        return smallest;
    }

    // TODO: 3 - Create a static inner class Student that implements both
    //  Comparable<Student> and Printable.
    //  Student should have a "name" (String) and "grade" (double) field,
    //  a constructor, compareTo() based on grade (ascending),
    //  and print() that prints "Student{name='...', grade=...}".
    //  Also override toString() with the same format as print().
    static class Student implements Comparable<Student>, Printable{

        String name;
        double grade;

        public Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public void print() {
            System.out.printf("Student{name=%s, grade=%.2f\n}", this.name, this.grade);
        }

        @Override
        public int compareTo(Student student) {
            return Double.compare(this.grade, student.grade);
        }
    }

    public static void main(String[] args) {

        // TODO: 4 - Create a List<Student> with at least 3 students having
        //  different grades. Call findMin() to find the student with the
        //  lowest grade. Print the result using the print() method.
        List<Student> students = new ArrayList<>();
        students.add(new Student("Karim", 100.0));
        students.add(new Student("Moustafa", 98.0));
        students.add(new Student("Rayan", 99.0));
        System.out.println(findMin(students));

        // TODO: 5 - Add a comment below explaining:
        //  (a) Why must a class bound come before interface bounds?
        //      e.g., <T extends SomeClass & SomeInterface> is valid
        //      but  <T extends SomeInterface & SomeClass> is NOT valid
        //  (b) Can you have multiple class bounds? Why or why not?
        //  (c) How many interface bounds can you have?
        // a) this is because we can only have one class bound but many interface bounds (contracts that we have to follow)
        // b) No. This is because we can only have ONE parent class, and not many. We can have many subclass though
        // c) as many as you like so long as you can adhere to the contract
    }
}
