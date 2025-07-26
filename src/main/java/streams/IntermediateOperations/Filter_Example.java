package src.main.java.streams.IntermediateOperations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Practice Problems for filter():
 * 1. Filter even numbers from a list.
 * 2. Filter strings that start with a specific letter.
 * 3. Filter employees with salary > 50,000.
 * 4. Remove null or empty strings from a list.
 * 5. Advanced: Filter prime numbers from a list.
 * 6. Advanced: Filter employees in a specific department and above a certain age.
 * 7. Custom: Filter employees whose name starts with a given letter.
 * 8. Custom: Filter employees in a salary band (e.g., Medium).
 * 9. Custom: Filter employees with age between 25 and 35 and in Engineering.
 */
public class Filter_Example {
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

    // 1. Filter even numbers from a list.
    public static void filterEvenNumbers(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Output (even numbers): " + result);
    }

    // 2. Filter strings that start with a specific letter.
    public static void filterByStartingLetter(List<String> words, char letter) {
        System.out.println("Input: " + words);
        List<String> result = words.stream()
                .filter(w -> w != null && !w.isEmpty() && w.charAt(0) == letter)
                .collect(Collectors.toList());
        System.out.println("Output (start with '" + letter + "'): " + result);
    }

    // 3. Filter employees with salary > 50,000.
    public static void filterHighSalaryEmployees(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<Employee> result = employees.stream()
                .filter(e -> e.salary > 50000)
                .collect(Collectors.toList());
        System.out.println("Output (salary > 50000): " + result);
    }

    // 4. Remove null or empty strings from a list.
    public static void removeNullOrEmpty(List<String> words) {
        System.out.println("Input: " + words);
        List<String> result = words.stream()
                .filter(w -> w != null && !w.isEmpty())
                .collect(Collectors.toList());
        System.out.println("Output (non-empty): " + result);
    }

    // 5. Advanced: Filter prime numbers from a list.
    public static void filterPrimes(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        List<Integer> result = numbers.stream()
                .filter(Filter_Example::isPrime)
                .collect(Collectors.toList());
        System.out.println("Output (primes): " + result);
    }
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 6. Advanced: Filter employees in a specific department and above a certain age.
    public static void filterEmployeesByDeptAndAge(List<Employee> employees, String dept, int minAge) {
        System.out.println("Input: " + employees);
        List<Employee> result = employees.stream()
                .filter(e -> e.department.equals(dept) && e.age > minAge)
                .collect(Collectors.toList());
        System.out.println("Output (" + dept + " & age > " + minAge + "): " + result);
    }

    // 7. Custom: Filter employees whose name starts with a given letter.
    public static void filterEmployeesByNameStart(List<Employee> employees, char letter) {
        System.out.println("Input: " + employees);
        List<Employee> result = employees.stream()
                .filter(e -> e.name.charAt(0) == letter)
                .collect(Collectors.toList());
        System.out.println("Output (name starts with '" + letter + "'): " + result);
    }

    // 8. Custom: Filter employees in a salary band (e.g., Medium).
    public static void filterEmployeesBySalaryBand(List<Employee> employees, String band) {
        System.out.println("Input: " + employees);
        List<Employee> result = employees.stream()
                .filter(e -> {
                    if (band.equals("Low")) return e.salary < 70000;
                    else if (band.equals("Medium")) return e.salary >= 70000 && e.salary < 85000;
                    else return e.salary >= 85000;
                })
                .collect(Collectors.toList());
        System.out.println("Output (salary band '" + band + "'): " + result);
    }

    // 9. Custom: Filter employees with age between 25 and 35 and in Engineering.
    public static void filterEmployeesByAgeAndDept(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<Employee> result = employees.stream()
                .filter(e -> e.age >= 25 && e.age <= 35 && "Engineering".equals(e.department))
                .collect(Collectors.toList());
        System.out.println("Output (age 25-35, Engineering): " + result);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 11, 13, 17, 20);
        List<String> words = Arrays.asList("apple", "", null, "banana", "cherry", "avocado");
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000),
            new Employee("Bob", 25, "Engineering", 80000),
            new Employee("Charlie", 28, "Engineering", 75000),
            new Employee("Diana", 35, "Finance", 90000)
        );
        filterEvenNumbers(nums);
        filterByStartingLetter(words, 'a');
        filterHighSalaryEmployees(employees);
        removeNullOrEmpty(words);
        filterPrimes(nums);
        filterEmployeesByDeptAndAge(employees, "Engineering", 26);
        filterEmployeesByNameStart(employees, 'A');
        filterEmployeesBySalaryBand(employees, "Medium");
        filterEmployeesByAgeAndDept(employees);
    }
} 