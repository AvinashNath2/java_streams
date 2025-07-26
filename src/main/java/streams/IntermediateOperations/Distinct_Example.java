package src.main.java.streams.IntermediateOperations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Practice Problems for distinct():
 * 1. Remove duplicates from a list of integers.
 * 2. Remove duplicate strings (case-insensitive).
 * 3. Advanced: Remove duplicate Employee objects based on employee ID.
 * 4. Custom: Remove duplicate Employee objects based on name.
 * 5. Custom: Remove duplicate Employee objects based on both name and id.
 */
public class Distinct_Example {
    public static class Employee {
        public String name;
        public int id;
        public Employee(String name, int id) {
            this.name = name;
            this.id = id;
        }
        public String toString() {
            return name + " (ID: " + id + ")";
        }
    }

    // 1. Remove duplicates from a list of integers.
    public static void removeDuplicates(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        List<Integer> result = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Output (distinct): " + result);
    }

    // 2. Remove duplicate strings (case-insensitive).
    public static void removeDuplicateStringsIgnoreCase(List<String> words) {
        System.out.println("Input: " + words);
        Set<String> seen = new HashSet<>();
        List<String> result = words.stream()
                .filter(w -> seen.add(w == null ? null : w.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("Output (distinct, ignore case): " + result);
    }

    // 3. Advanced: Remove duplicate Employee objects based on employee ID.
    public static void removeDuplicateEmployeesById(List<Employee> employees) {
        System.out.println("Input: " + employees);
        Set<Integer> seenIds = new HashSet<>();
        List<Employee> result = employees.stream()
                .filter(e -> seenIds.add(e.id))
                .collect(Collectors.toList());
        System.out.println("Output (distinct by ID): " + result);
    }

    // 4. Custom: Remove duplicate Employee objects based on name.
    public static void removeDuplicateEmployeesByName(List<Employee> employees) {
        System.out.println("Input: " + employees);
        Set<String> seenNames = new HashSet<>();
        List<Employee> result = employees.stream()
                .filter(e -> seenNames.add(e.name))
                .collect(Collectors.toList());
        System.out.println("Output (distinct by name): " + result);
    }

    // 5. Custom: Remove duplicate Employee objects based on both name and id.
    public static void removeDuplicateEmployeesByNameAndId(List<Employee> employees) {
        System.out.println("Input: " + employees);
        Set<String> seen = new HashSet<>();
        List<Employee> result = employees.stream()
                .filter(e -> seen.add(e.name + ":" + e.id))
                .collect(Collectors.toList());
        System.out.println("Output (distinct by name and id): " + result);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<String> words = Arrays.asList("Apple", "Banana", "apple", "banana", "Cherry");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 1),
            new Employee("Bob", 2),
            new Employee("Charlie", 1),
            new Employee("Diana", 3),
            new Employee("Alice", 4),
            new Employee("Bob", 2)
        );
        removeDuplicates(nums);
        removeDuplicateStringsIgnoreCase(words);
        removeDuplicateEmployeesById(employees);
        removeDuplicateEmployeesByName(employees);
        removeDuplicateEmployeesByNameAndId(employees);
    }
} 