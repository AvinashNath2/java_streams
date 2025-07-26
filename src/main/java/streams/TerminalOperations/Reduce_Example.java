package src.main.java.streams.TerminalOperations;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

/**
 * Practice Problems for reduce():
 * 1. Sum all numbers in a list.
 * 2. Find the maximum value in a list.
 * 3. Concatenate all strings in a list.
 * 4. Advanced: Find the product of all numbers in a list.
 * 5. Advanced: Find the employee with the highest salary.
 */
public class Reduce_Example {
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

    // 1. Sum all numbers in a list.
    public static void sumNumbers(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Output (sum): " + sum);
    }

    // 2. Find the maximum value in a list.
    public static void findMax(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println("Output (max): " + (max.isPresent() ? max.get() : "N/A"));
    }

    // 3. Concatenate all strings in a list.
    public static void concatenateStrings(List<String> words) {
        System.out.println("Input: " + words);
        String result = words.stream().reduce("", (a, b) -> a + b);
        System.out.println("Output (concatenated): " + result);
    }

    // 4. Advanced: Find the product of all numbers in a list.
    public static void productNumbers(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Output (product): " + product);
    }

    // 5. Advanced: Find the employee with the highest salary.
    public static void employeeWithHighestSalary(List<Employee> employees) {
        System.out.println("Input: " + employees);
        Optional<Employee> result = employees.stream().reduce((e1, e2) -> e1.salary > e2.salary ? e1 : e2);
        System.out.println("Output (highest salary): " + (result.isPresent() ? result.get() : "N/A"));
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000),
            new Employee("Bob", 25, "Engineering", 80000),
            new Employee("Charlie", 28, "Engineering", 75000),
            new Employee("Diana", 35, "Finance", 90000)
        );
        sumNumbers(nums);
        findMax(nums);
        concatenateStrings(words);
        productNumbers(nums);
        employeeWithHighestSalary(employees);
    }
} 