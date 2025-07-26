package src.main.java.streams.TerminalOperations;

import java.util.List;
import java.util.Optional;
import java.util.Comparator;
import java.util.Arrays;

/**
 * Practice Problems for min() and max():
 * 1. Find the minimum value in a list.
 * 2. Find the maximum value in a list.
 * 3. Find the employee with the highest salary.
 * 4. Custom: Find the employee with the lowest age.
 * 5. Custom: Find the string with the maximum length.
 */
public class MinMax_Example {
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

    // 1. Find the minimum value in a list.
    public static void findMin(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        System.out.println("Output (min): " + (min.isPresent() ? min.get() : "N/A"));
    }

    // 2. Find the maximum value in a list.
    public static void findMax(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("Output (max): " + (max.isPresent() ? max.get() : "N/A"));
    }

    // 3. Find the employee with the highest salary.
    public static void employeeWithHighestSalary(List<Employee> employees) {
        System.out.println("Input: " + employees);
        Optional<Employee> result = employees.stream().max(Comparator.comparingDouble(e -> e.salary));
        System.out.println("Output (highest salary): " + (result.isPresent() ? result.get() : "N/A"));
    }

    // 4. Custom: Find the employee with the lowest age.
    public static void employeeWithLowestAge(List<Employee> employees) {
        System.out.println("Input: " + employees);
        Optional<Employee> result = employees.stream().min(Comparator.comparingInt(e -> e.age));
        System.out.println("Output (lowest age): " + (result.isPresent() ? result.get() : "N/A"));
    }

    // 5. Custom: Find the string with the maximum length.
    public static void stringWithMaxLength(List<String> words) {
        System.out.println("Input: " + words);
        Optional<String> result = words.stream().max(Comparator.comparingInt(String::length));
        System.out.println("Output (max length): " + (result.isPresent() ? result.get() : "N/A"));
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(5, 2, 8, 1, 3);
        List<String> words = Arrays.asList("banana", "apple", "cherry", "date");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000),
            new Employee("Bob", 25, "Engineering", 80000),
            new Employee("Charlie", 28, "Engineering", 75000),
            new Employee("Diana", 35, "Finance", 90000)
        );
        findMin(nums);
        findMax(nums);
        employeeWithHighestSalary(employees);
        employeeWithLowestAge(employees);
        stringWithMaxLength(words);
    }
} 