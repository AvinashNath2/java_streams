package src.main.java.streams.TerminalOperations;

import java.util.List;
import java.util.Arrays;

/**
 * Practice Problems for forEach():
 * 1. Print each element in a list.
 * 2. Print each employee’s name and salary.
 * 3. Advanced: Update a field in each object (e.g., set a flag).
 * 4. Custom: Print all employees in a specific department.
 * 5. Custom: Print all strings in reverse order.
 */
public class ForEach_Example {
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

    // 1. Print each element in a list.
    public static void printElements(List<?> elements) {
        System.out.println("Input: " + elements);
        elements.forEach(e -> System.out.println("Element: " + e));
    }

    // 2. Print each employee’s name and salary.
    public static void printEmployeeNameSalary(List<Employee> employees) {
        System.out.println("Input: " + employees);
        employees.forEach(e -> System.out.println(e.name + ": $" + e.salary));
    }

    // 3. Advanced: Print all strings in reverse order.
    public static void printReverse(List<String> words) {
        System.out.println("Input: " + words);
        for (int i = words.size() - 1; i >= 0; i--) {
            System.out.println("Reverse: " + words.get(i));
        }
    }

    // 4. Custom: Print all employees in a specific department.
    public static void printEmployeesInDepartment(List<Employee> employees, String dept) {
        System.out.println("Input: " + employees);
        employees.stream().filter(e -> dept.equals(e.department)).forEach(System.out::println);
    }

    // 5. Custom: Print all employees with salary above a threshold.
    public static void printHighSalaryEmployees(List<Employee> employees, double threshold) {
        System.out.println("Input: " + employees);
        employees.stream().filter(e -> e.salary > threshold).forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000),
            new Employee("Bob", 25, "Engineering", 80000),
            new Employee("Charlie", 28, "Engineering", 75000),
            new Employee("Diana", 35, "Finance", 90000)
        );
        printElements(nums);
        printEmployeeNameSalary(employees);
        printReverse(words);
        printEmployeesInDepartment(employees, "Engineering");
        printHighSalaryEmployees(employees, 75000);
    }
} 