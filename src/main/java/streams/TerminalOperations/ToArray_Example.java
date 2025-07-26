package src.main.java.streams.TerminalOperations;

import java.util.List;
import java.util.Arrays;

/**
 * Practice Problems for toArray():
 * 1. Convert a list of integers to an Integer array.
 * 2. Convert a list of strings to a String array.
 * 3. Advanced: Convert a list of Employee objects to an Employee array.
 * 4. Custom: Convert a stream of uppercase strings to an array.
 */
public class ToArray_Example {
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

    // 1. Convert a list of integers to an Integer array.
    public static void toIntegerArray(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        Integer[] arr = numbers.stream().toArray(Integer[]::new);
        System.out.println("Output (Integer[]): " + Arrays.toString(arr));
    }

    // 2. Convert a list of strings to a String array.
    public static void toStringArray(List<String> words) {
        System.out.println("Input: " + words);
        String[] arr = words.stream().toArray(String[]::new);
        System.out.println("Output (String[]): " + Arrays.toString(arr));
    }

    // 3. Advanced: Convert a list of Employee objects to an Employee array.
    public static void toEmployeeArray(List<Employee> employees) {
        System.out.println("Input: " + employees);
        Employee[] arr = employees.stream().toArray(Employee[]::new);
        System.out.println("Output (Employee[]): " + Arrays.toString(arr));
    }

    // 4. Custom: Convert a stream of uppercase strings to an array.
    public static void uppercaseToArray(List<String> words) {
        System.out.println("Input: " + words);
        String[] arr = words.stream().map(String::toUpperCase).toArray(String[]::new);
        System.out.println("Output (Uppercase String[]): " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000),
            new Employee("Bob", 25, "Engineering", 80000),
            new Employee("Charlie", 28, "Engineering", 75000)
        );
        toIntegerArray(nums);
        toStringArray(words);
        toEmployeeArray(employees);
        uppercaseToArray(words);
    }
} 