package src.main.java.streams.IntermediateOperations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Arrays;

/**
 * Practice Problems for sorted():
 * 1. Sort a list of integers in ascending order.
 * 2. Sort a list of strings alphabetically.
 * 3. Sort employees by age.
 * 4. Sort a list in reverse order.
 * 5. Advanced: Sort employees by department, then by salary descending.
 * 6. Custom: Sort employees by name alphabetically.
 * 7. Custom: Sort employees by salary ascending.
 * 8. Custom: Sort employees by age, then by name.
 */
public class Sorted_Example {
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

    // 1. Sort a list of integers in ascending order.
    public static void sortIntegers(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        List<Integer> result = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Output (sorted ascending): " + result);
    }

    // 2. Sort a list of strings alphabetically.
    public static void sortStrings(List<String> words) {
        System.out.println("Input: " + words);
        List<String> result = words.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Output (sorted alphabetically): " + result);
    }

    // 3. Sort employees by age.
    public static void sortEmployeesByAge(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<Employee> result = employees.stream()
                .sorted(Comparator.comparingInt(e -> e.age))
                .collect(Collectors.toList());
        System.out.println("Output (sorted by age): " + result);
    }

    // 4. Sort a list in reverse order.
    public static void sortIntegersDescending(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        List<Integer> result = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Output (sorted descending): " + result);
    }

    // 5. Advanced: Sort employees by department, then by salary descending.
    public static void sortEmployeesByDeptAndSalary(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<Employee> result = employees.stream()
                .sorted(Comparator.comparing((Employee e) -> e.department)
                        .thenComparing(Comparator.comparingDouble((Employee e) -> e.salary).reversed()))
                .collect(Collectors.toList());
        System.out.println("Output (sorted by dept, salary desc): " + result);
    }

    // 6. Custom: Sort employees by name alphabetically.
    public static void sortEmployeesByName(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<Employee> result = employees.stream()
                .sorted(Comparator.comparing(e -> e.name))
                .collect(Collectors.toList());
        System.out.println("Output (sorted by name): " + result);
    }

    // 7. Custom: Sort employees by salary ascending.
    public static void sortEmployeesBySalary(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<Employee> result = employees.stream()
                .sorted(Comparator.comparingDouble(e -> e.salary))
                .collect(Collectors.toList());
        System.out.println("Output (sorted by salary): " + result);
    }

    // 8. Custom: Sort employees by age, then by name.
    public static void sortEmployeesByAgeThenName(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<Employee> result = employees.stream()
                .sorted(Comparator.comparingInt((Employee e) -> e.age)
                        .thenComparing(e -> e.name))
                .collect(Collectors.toList());
        System.out.println("Output (sorted by age, then name): " + result);
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
        sortIntegers(nums);
        sortStrings(words);
        sortEmployeesByAge(employees);
        sortIntegersDescending(nums);
        sortEmployeesByDeptAndSalary(employees);
        sortEmployeesByName(employees);
        sortEmployeesBySalary(employees);
        sortEmployeesByAgeThenName(employees);
    }
} 