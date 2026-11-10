package com.amigoscode._7_streams._7_statistics;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Exercise: Count, Min, and Max
 *
 * Learn to use counting operations and find minimum/maximum elements
 * using both stream methods and Collectors.
 */
public class CountMinMax {

    record Employee(String name, String department, double salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "Engineering", 95000),
                new Employee("Bob", "Engineering", 88000),
                new Employee("Charlie", "Marketing", 72000),
                new Employee("Diana", "Marketing", 78000),
                new Employee("Eve", "Sales", 68000),
                new Employee("Frank", "Engineering", 102000),
                new Employee("Grace", "Sales", 71000),
                new Employee("Henry", "Marketing", 82000)
        );

        // TODO: 1 - Count the number of employees with salary greater than 80000
        //           Use filter + count() and print the result
        System.out.println(employees.stream().mapToDouble(Employee::salary).filter(sal -> sal > 80_000).count());

        // TODO: 2 - Find the employee with the lowest salary
        //           Use min() with Comparator.comparingDouble(Employee::salary)
        //           Print the employee's name and salary

        Employee empMin = employees.stream().min(Comparator.comparingDouble(Employee::salary)).orElse(null);
        System.out.println(empMin.name + " " + empMin.salary);

        // TODO: 3 - Find the employee with the highest salary
        //           Use max() with an appropriate comparator
        //           Print the employee's name and salary

        Employee empMax = employees.stream().max(Comparator.comparingDouble(Employee::salary)).orElse(null);
        System.out.println(empMax.name + " " + empMax.salary);


        // TODO: 4 - Use the Collectors.counting() collector to count all employees
        //           Print the result
        System.out.println(employees.stream().collect(Collectors.counting()));

        // TODO: 5 - Combine count with groupingBy: count employees per department
        //           Use Collectors.groupingBy with Collectors.counting() as downstream
        //           Print each department and its count

        System.out.println(employees.stream().collect(Collectors.groupingBy(employee -> employee.department, Collectors.counting())));

        // TODO: 6 - Use Collectors.minBy and Collectors.maxBy to find the lowest
        //           and highest paid employees
        //           Print both results
        System.out.println();
        System.out.println(employees.stream().collect(Collectors.minBy(Comparator.comparingDouble(Employee::salary))).get());
        System.out.println(employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::salary))).get());

    }
}
