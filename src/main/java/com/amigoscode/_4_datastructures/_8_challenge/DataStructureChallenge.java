package com.amigoscode._4_datastructures._8_challenge;

// Exercise: Data Structure Challenge
// Combine multiple data structures to solve a real-world problem.
// Manage a collection of students, group them, track recently viewed, and generate reports.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DataStructureChallenge {

    // TODO: 1 - Create a Student record (or class) with three fields:
    //           String name, int grade, String subject
    //           If using a record: record Student(String name, int grade, String subject) {}
    //           If using a class: include constructor, getters, and a toString() method
    record Student(String name, int grade, String subject){}


    public static void main(String[] args) {

        // TODO: 2 - Create a List of 10 students with various names, grades, and subjects
        //           Use at least 3 different subjects (e.g., "Math", "Science", "English")
        //           Example: new Student("Alice", 92, "Math")
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 99, "Math"));
        students.add(new Student("Aaron", 97, "Math"));
        students.add(new Student("Jeremiah", 98, "Science"));
        students.add(new Student("Wong", 96, "Computing"));
        students.add(new Student("Nelson", 100, "Computing"));

        students.add(new Student("Rogers", 92, "Science"));
        students.add(new Student("Steve", 93, "Computing"));
        students.add(new Student("Tony", 95, "Science"));
        students.add(new Student("Parker", 91, "Computing"));
        students.add(new Student("Peter", 94, "Math"));

        // TODO: 3 - Use a Map<String, List<Student>> to group students by subject
        //           Iterate through the student list
        //           For each student, use computeIfAbsent() to get or create the list for their subject
        //           Then add the student to that list
        //           Print each subject and its students
        Map<String, List<Student>> groupedStudents = new HashMap<>();
        for (Student student : students) {
            groupedStudents.computeIfAbsent(student.subject(),
                    grade -> new ArrayList<>()
                    ).add(student);
        }
        groupedStudents.entrySet().forEach(System.out::println);
        System.out.println();

        // TODO: 4 - Use a Set<String> to find all unique subjects
        //           Iterate through the students and add each subject to the set
        //           Print the unique subjects
        Set<String> uniqueSubjects = new HashSet<>();
        students.forEach(student -> uniqueSubjects.add(student.subject()));
        System.out.println(uniqueSubjects);
        System.out.println();

        // TODO: 5 - Use a Stack<Student> to track the last 3 students "viewed"
        //           Push any 3 students from the list onto the stack
        //           Then pop and print them to show the viewing history (most recent first)
        Stack<Student> lastThree = new Stack<>();
        lastThree.push(students.get(0));
        lastThree.push(students.get(3));
        lastThree.push(students.get(6));
        System.out.println(lastThree.pop());
        System.out.println(lastThree.pop());
        System.out.println(lastThree.pop());
        System.out.println();
        // TODO: 6 - Sort the student list by grade in descending order using a Comparator
        //           Use list.sort() with Comparator.comparingInt() and .reversed()
        //           Print the sorted list
        students.sort(Comparator.comparingInt(Student::grade).reversed());
        System.out.println(students);
        System.out.println();
        // TODO: 7 - Print a summary report:
        //           - Total number of students
        //           - Number of unique subjects (from the Set)
        //           - Highest grade student (first in sorted list)
        //           - Number of students per subject (from the Map)
        System.out.println("SUMMARY REPORT");
        System.out.println("--------------");
        System.out.println("Total number of students: " + students.size());
        System.out.println("Number of unique subjects (from the Set): " +uniqueSubjects.size());
        System.out.println("Highest grade student (first in sorted list): " + students.getFirst());
        System.out.print("Number of students per subject (from the Map): ");
        groupedStudents.forEach((subject,personList)
                -> System.out.println(subject + ": " + personList.size()));

    }
}
