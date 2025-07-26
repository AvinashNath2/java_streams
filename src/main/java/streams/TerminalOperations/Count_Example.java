package src.main.java.streams.TerminalOperations;

import java.util.List;
import java.util.Arrays;

/**
 * Practice Problems for count():
 * 1. Count the number of elements in a list.
 * 2. Count the number of strings longer than 5 characters.
 * 3. Custom: Count the number of employees in Engineering.
 * 4. Custom: Count the number of employees with salary > 75000.
 * 5. Custom: Count the number of unique departments.
 */
public class Count_Example {
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

    // 1. Count the number of elements in a list.
    public static void countElements(List<?> elements) {
        System.out.println("Input: " + elements);
        long count = elements.stream().count();
        System.out.println("Output (count): " + count);
    }

    // 2. Count the number of strings longer than 5 characters.
    public static void countLongStrings(List<String> words) {
        System.out.println("Input: " + words);
        long count = words.stream().filter(w -> w.length() > 5).count();
        System.out.println("Output (strings > 5 chars): " + count);
    }

    // 3. Custom: Count the number of employees in Engineering.
    public static void countEngineeringEmployees(List<Employee> employees) {
        System.out.println("Input: " + employees);
        long count = employees.stream().filter(e -> "Engineering".equals(e.department)).count();
        System.out.println("Output (Engineering employees): " + count);
    }

    // 4. Custom: Count the number of employees with salary > 75000.
    public static void countHighSalaryEmployees(List<Employee> employees) {
        System.out.println("Input: " + employees);
        long count = employees.stream().filter(e -> e.salary > 75000).count();
        System.out.println("Output (salary > 75000): " + count);
    }

    // 5. Custom: Count the number of unique departments.
    public static void countUniqueDepartments(List<Employee> employees) {
        System.out.println("Input: " + employees);
        long count = employees.stream().map(e -> e.department).distinct().count();
        System.out.println("Output (unique departments): " + count);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000),
            new Employee("Bob", 25, "Engineering", 80000),
            new Employee("Charlie", 28, "Engineering", 75000),
            new Employee("Diana", 35, "Finance", 90000),
            new Employee("Eve", 32, "HR", 65000),
            new Employee("Frank", 29, "Finance", 85000)
        );
        countElements(nums);
        countLongStrings(words);
        countEngineeringEmployees(employees);
        countHighSalaryEmployees(employees);
        countUniqueDepartments(employees);
    }
} 