package src.main.java.streams.TerminalOperations;

import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Practice Problems for collect():
 * 1. Collect a list of integers into a Set.
 * 2. Collect a list of strings into a single concatenated string.
 * 3. Partition a list of numbers into even and odd.
 * 4. Group a list of strings by their length.
 * 5. Advanced: Group a list of Employee objects by department.
 * 6. Advanced: Partition employees by salary > 75000.
 */
public class Collect_Example {
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

    // 1. Collect a list of integers into a Set.
    public static void collectToSet(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        Set<Integer> result = numbers.stream().collect(Collectors.toSet());
        System.out.println("Output (Set): " + result);
    }

    // 2. Collect a list of strings into a single concatenated string.
    public static void concatenateStrings(List<String> words) {
        System.out.println("Input: " + words);
        String result = words.stream().collect(Collectors.joining(", "));
        System.out.println("Output (concatenated): " + result);
    }

    // 3. Partition a list of numbers into even and odd.
    public static void partitionEvenOdd(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        Map<Boolean, List<Integer>> result = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Output (partitioned even/odd): " + result);
    }

    // 4. Group a list of strings by their length.
    public static void groupByLength(List<String> words) {
        System.out.println("Input: " + words);
        Map<Integer, List<String>> result = words.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Output (grouped by length): " + result);
    }

    // 5. Advanced: Group a list of Employee objects by department.
    public static void groupEmployeesByDepartment(List<Employee> employees) {
        System.out.println("Input: " + employees);
        Map<String, List<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department));
        System.out.println("Output (grouped by department): " + result);
    }

    // 6. Advanced: Partition employees by salary > 75000.
    public static void partitionEmployeesBySalary(List<Employee> employees) {
        System.out.println("Input: " + employees);
        Map<Boolean, List<Employee>> result = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.salary > 75000));
        System.out.println("Output (partitioned by salary > 75000): " + result);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000),
            new Employee("Bob", 25, "Engineering", 80000),
            new Employee("Charlie", 28, "Engineering", 75000),
            new Employee("Diana", 35, "Finance", 90000)
        );
        collectToSet(nums);
        concatenateStrings(words);
        partitionEvenOdd(nums);
        groupByLength(words);
        groupEmployeesByDepartment(employees);
        partitionEmployeesBySalary(employees);
    }
} 