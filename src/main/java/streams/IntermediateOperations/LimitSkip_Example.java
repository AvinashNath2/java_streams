package src.main.java.streams.IntermediateOperations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Practice Problems for limit() and skip():
 * 1. Get the first 3 elements of a list using limit.
 * 2. Skip the first 2 elements and process the rest.
 * 3. Advanced: Paginate a list using skip and limit.
 * 4. Custom: Get the top 2 highest paid employees.
 * 5. Custom: Skip the first employee in each department (grouped by department).
 */
public class LimitSkip_Example {
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

    // 1. Get the first 3 elements of a list using limit.
    public static void firstThree(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        List<Integer> result = numbers.stream().limit(3).collect(Collectors.toList());
        System.out.println("Output (first 3): " + result);
    }

    // 2. Skip the first 2 elements and process the rest.
    public static void skipTwo(List<String> words) {
        System.out.println("Input: " + words);
        List<String> result = words.stream().skip(2).collect(Collectors.toList());
        System.out.println("Output (skipped 2): " + result);
    }

    // 3. Advanced: Paginate a list using skip and limit.
    public static void paginate(List<Integer> numbers, int page, int pageSize) {
        System.out.println("Input: " + numbers);
        List<Integer> result = numbers.stream()
                .skip((page - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
        System.out.println("Output (page " + page + ", size " + pageSize + "): " + result);
    }

    // 4. Custom: Get the top 2 highest paid employees.
    public static void topTwoHighestPaid(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<Employee> result = employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                .limit(2)
                .collect(Collectors.toList());
        System.out.println("Output (top 2 highest paid): " + result);
    }

    // 5. Custom: Skip the first employee in each department (grouped by department).
    public static void skipFirstInEachDepartment(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<Employee> result = employees.stream()
                .collect(Collectors.groupingBy(e -> e.department))
                .values().stream()
                .flatMap(list -> list.stream().skip(1))
                .collect(Collectors.toList());
        System.out.println("Output (skipped first in each dept): " + result);
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
        firstThree(nums);
        skipTwo(words);
        paginate(nums, 2, 3);
        topTwoHighestPaid(employees);
        skipFirstInEachDepartment(employees);
    }
} 