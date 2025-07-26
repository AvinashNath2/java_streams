/*
 * Copyright (c) 2024 Java Streams Tutorial
 * 
 * This file is part of the Java Streams Tutorial project.
 * All rights reserved.
 * 
 * This source code is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this file, or any portion of it,
 * may result in severe civil and criminal penalties, and will be prosecuted
 * to the maximum extent possible under the law.
 * 
 * For licensing information, please contact the copyright holder.
 */

package src.main.java.streams.IntermediateOperations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Map;

/**
 * Practice Problems for map():
 * 1. Convert a list of integers to their squares.
 * 2. Convert a list of strings to uppercase.
 * 3. Given a list of Employee objects, extract their names.
 * 4. Add 10 to each element in a list.
 * 5. Convert a list of strings to their lengths.
 * 6. Advanced: Given a list of sentences, return a list of word counts for each sentence.
 * 7. Advanced: Map Employee list to their department names in uppercase (interview-level)
 * 8. Advanced: Map Employee list to a stream of their name lengths (interview-level)
 * 9. Custom: Map Employee list to their initials.
 * 10. Custom: Map Employee list to salary bands (e.g., "Low", "Medium", "High").
 * 11. Custom: Map Employee list to name-department pairs (e.g., "Alice-HR").
 */
public class Map_Example {
    public static class Employee {
        public String name;
        public int age;
        public String department;
        public double salary;
        public Employee(String name, int age, String department, double salary) {
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
        }
        public String toString() {
            return name + " (" + age + ", " + department + ", $" + salary + ")";
        }
    }

    // 1. Convert a list of integers to their squares.
    public static void squareIntegers(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        List<Integer> result = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Output (squared): " + result);
    }

    // 2. Convert a list of strings to uppercase.
    public static void toUpperCase(List<String> words) {
        System.out.println("Input: " + words);
        List<String> result = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Output (uppercase): " + result);
    }

    // 3. Given a list of Employee objects, extract their names.
    public static void extractEmployeeNames(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<String> result = employees.stream()
                .map(e -> e.name)
                .collect(Collectors.toList());
        System.out.println("Output (names): " + result);
    }

    // 4. Add 10 to each element in a list.
    public static void addTen(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        List<Integer> result = numbers.stream()
                .map(n -> n + 10)
                .collect(Collectors.toList());
        System.out.println("Output (+10): " + result);
    }

    // 5. Convert a list of strings to their lengths.
    public static void stringLengths(List<String> words) {
        System.out.println("Input: " + words);
        List<Integer> result = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Output (lengths): " + result);
    }

    // 6. Advanced: Given a list of sentences, return a list of word counts for each sentence.
    public static void sentenceWordCounts(List<String> sentences) {
        System.out.println("Input: " + sentences);
        List<Integer> result = sentences.stream()
                .map(s -> s.split(" ").length)
                .collect(Collectors.toList());
        System.out.println("Output (word counts): " + result);
    }

    // 7. Advanced: Map Employee list to their department names in uppercase (interview-level)
    public static void employeeDepartmentsUpper(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<String> result = employees.stream()
                .map(e -> e.department.toUpperCase())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Output (departments uppercase): " + result);
    }

    // 8. Advanced: Map Employee list to a stream of their name lengths (interview-level)
    public static void employeeNameLengths(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<Integer> result = employees.stream()
                .map(e -> e.name.length())
                .collect(Collectors.toList());
        System.out.println("Output (name lengths): " + result);
    }

    // 9. Custom: Map Employee list to their initials.
    public static void employeeInitials(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<String> result = employees.stream()
                .map(e -> e.name.substring(0, 1))
                .collect(Collectors.toList());
        System.out.println("Output (initials): " + result);
    }

    // 10. Custom: Map Employee list to salary bands ("Low", "Medium", "High").
    public static void employeeSalaryBands(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<String> result = employees.stream()
                .map(e -> {
                    if (e.salary < 70000) return "Low";
                    else if (e.salary < 85000) return "Medium";
                    else return "High";
                })
                .collect(Collectors.toList());
        System.out.println("Output (salary bands): " + result);
    }

    // 11. Custom: Map Employee list to name-department pairs.
    public static void employeeNameDepartmentPairs(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<String> result = employees.stream()
                .map(e -> e.name + "-" + e.department)
                .collect(Collectors.toList());
        System.out.println("Output (name-department pairs): " + result);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> sentences = Arrays.asList("Hello world", "Java streams are powerful", "Practice makes perfect");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000),
            new Employee("Bob", 25, "Engineering", 80000),
            new Employee("Charlie", 28, "Engineering", 75000),
            new Employee("Diana", 35, "Finance", 90000)
        );
        squareIntegers(nums);
        toUpperCase(words);
        extractEmployeeNames(employees);
        addTen(nums);
        stringLengths(words);
        sentenceWordCounts(sentences);
        employeeDepartmentsUpper(employees);
        employeeNameLengths(employees);
        employeeInitials(employees);
        employeeSalaryBands(employees);
        employeeNameDepartmentPairs(employees);
    }
} 