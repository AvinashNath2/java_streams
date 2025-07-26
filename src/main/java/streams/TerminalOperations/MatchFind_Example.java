package src.main.java.streams.TerminalOperations;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;

/**
 * Practice Problems for anyMatch, allMatch, noneMatch, findFirst, findAny:
 * 1. Check if any number in a list is even (anyMatch).
 * 2. Check if all strings are non-empty (allMatch).
 * 3. Check if no employee is under 18 (noneMatch).
 * 4. Find the first string that starts with 'A' (findFirst).
 * 5. Find any employee in Engineering (findAny).
 * 6. Custom: Check if all employees in a department have salary > 70000.
 * 7. Custom: Find the first employee with salary > 80000.
 */
public class MatchFind_Example {
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

    // 1. anyMatch: Check if any number in a list is even.
    public static void anyEven(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        boolean result = numbers.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("Any even? " + result);
    }

    // 2. allMatch: Check if all strings are non-empty.
    public static void allNonEmpty(List<String> words) {
        System.out.println("Input: " + words);
        boolean result = words.stream().allMatch(w -> w != null && !w.isEmpty());
        System.out.println("All non-empty? " + result);
    }

    // 3. noneMatch: Check if no employee is under 18.
    public static void noneUnder18(List<Employee> employees) {
        System.out.println("Input: " + employees);
        boolean result = employees.stream().noneMatch(e -> e.age < 18);
        System.out.println("No employee under 18? " + result);
    }

    // 4. findFirst: Find the first string that starts with 'A'.
    public static void findFirstA(List<String> words) {
        System.out.println("Input: " + words);
        Optional<String> result = words.stream().filter(w -> w.startsWith("A")).findFirst();
        System.out.println("First starting with 'A': " + result.orElse("None"));
    }

    // 5. findAny: Find any employee in Engineering.
    public static void findAnyEngineering(List<Employee> employees) {
        System.out.println("Input: " + employees);
        Optional<Employee> result = employees.stream().filter(e -> "Engineering".equals(e.department)).findAny();
        System.out.println("Any in Engineering: " + (result.isPresent() ? result.get() : "None"));
    }

    // 6. Custom: Check if all employees in a department have salary > 70000.
    public static void allSalaryAbove(List<Employee> employees, String dept, double threshold) {
        System.out.println("Input: " + employees);
        boolean result = employees.stream()
                .filter(e -> dept.equals(e.department))
                .allMatch(e -> e.salary > threshold);
        System.out.println("All in " + dept + " have salary > " + threshold + "? " + result);
    }

    // 7. Custom: Find the first employee with salary > 80000.
    public static void findFirstSalaryAbove(List<Employee> employees, double threshold) {
        System.out.println("Input: " + employees);
        Optional<Employee> result = employees.stream().filter(e -> e.salary > threshold).findFirst();
        System.out.println("First with salary > " + threshold + ": " + (result.isPresent() ? result.get() : "None"));
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 3, 5, 7, 8);
        List<String> words = Arrays.asList("Apple", "Banana", "", "Avocado");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000),
            new Employee("Bob", 25, "Engineering", 80000),
            new Employee("Charlie", 28, "Engineering", 75000),
            new Employee("Diana", 35, "Finance", 90000)
        );
        anyEven(nums);
        allNonEmpty(words);
        noneUnder18(employees);
        findFirstA(words);
        findAnyEngineering(employees);
        allSalaryAbove(employees, "Engineering", 70000);
        findFirstSalaryAbove(employees, 80000);
    }
} 