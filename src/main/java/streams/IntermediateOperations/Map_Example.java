/*
 * Copyright (c) 2024 Java Streams Tutorial
 * 
 * This file is part of the Java Streams Tutorial project.
 * All rights reserved.
 * 
 * This source code is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this file, or any portion of it,
 * may result in severe civil and criminal penalties, and will be prosecuted
 * to the maximum extent possible under the law.
 * 
 * For licensing information, please contact the copyright holder.
 */

package src.main.java.streams.IntermediateOperations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.Map;
import java.util.Optional;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;

/**
 * ============================================================================
 * COMPREHENSIVE MAP OPERATIONS GUIDE
 * ============================================================================
 * 
 * This class demonstrates ALL types of map operations in Java Streams:
 * 
 * 1. map() - Generic transformation (Stream<T> → Stream<R>)
 * 2. flatMap() - Flatten nested collections (Stream<T> → Stream<R>)
 * 3. mapToInt() - Convert to primitive int stream (Stream<T> → IntStream)
 * 4. mapToLong() - Convert to primitive long stream (Stream<T> → LongStream)
 * 5. mapToDouble() - Convert to primitive double stream (Stream<T> → DoubleStream)
 * 6. mapToObj() - Convert primitive stream to object stream (IntStream → Stream<T>)
 * 
 * ============================================================================
 * WHEN TO USE MAP vs REDUCE
 * ============================================================================
 * 
 * MAP OPERATIONS:
 * ✅ Use when you want to transform each element independently
 * ✅ Use when you need a 1:1 mapping (one input → one output)
 * ✅ Use when you want to extract properties or apply functions
 * ✅ Use when you need to change data types
 * ✅ Use when you want to maintain the same number of elements
 * 
 * REDUCE OPERATIONS:
 * ✅ Use when you want to combine all elements into a single result
 * ✅ Use when you need aggregation (sum, product, concatenation)
 * ✅ Use when you want to find min/max values
 * ✅ Use when you need to build complex objects from multiple elements
 * ✅ Use when you want to reduce the collection to a single value
 * 
 * ============================================================================
 * INTERNAL WORKING OF MAP OPERATIONS
 * ============================================================================
 * 
 * 1. LAZY EVALUATION: Map operations are lazy - they don't execute until a 
 *    terminal operation is called.
 * 
 * 2. FUNCTION APPLICATION: Each element is passed through the mapping function
 *    independently, creating a new element for each input.
 * 
 * 3. IMMUTABILITY: Original stream remains unchanged; map creates a new stream.
 * 
 * 4. PARALLELIZATION: Map operations can be easily parallelized since each
 *    element transformation is independent.
 * 
 * ============================================================================
 * PRACTICE PROBLEMS BY MAP TYPE
 * ============================================================================
 * 
 * BASIC MAP() OPERATIONS:
 * 1. Convert integers to squares
 * 2. Convert strings to uppercase
 * 3. Extract employee names
 * 4. Add constant to numbers
 * 5. Get string lengths
 * 6. Create derived values (salary bands)
 * 7. Combine properties (name-department pairs)
 * 
 * FLATMAP() OPERATIONS:
 * 8. Flatten nested lists
 * 9. Split sentences into words
 * 10. Extract skills from employees
 * 11. Get unique words from paragraphs
 * 12. Flatten project lists
 * 13. Extract characters from names
 * 
 * PRIMITIVE STREAM OPERATIONS:
 * 14. mapToInt() - Convert to int stream for calculations
 * 15. mapToLong() - Convert to long stream for large numbers
 * 16. mapToDouble() - Convert to double stream for decimals
 * 17. mapToObj() - Convert primitive stream back to object stream
 * 
 * ADVANCED OPERATIONS:
 * 18. Chaining multiple map operations
 * 19. Conditional mapping
 * 20. Complex object transformations
 * 21. Performance comparisons with reduce
 * 22. Parallel stream mapping
 */
public class Map_Example {
    
    public static class Employee {
        public String name;
        public int age;
        public String department;
        public double salary;
        public List<String> skills;
        public List<String> projects;
        
        public Employee(String name, int age, String department, double salary) {
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
            this.skills = new ArrayList<>();
            this.projects = new ArrayList<>();
        }
        
        public Employee(String name, int age, String department, double salary, 
                       List<String> skills, List<String> projects) {
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
            this.skills = skills;
            this.projects = projects;
        }
        
        public String toString() {
            return name + " (" + age + ", " + department + ", $" + salary + ")";
        }
    }

    // ============================================================================
    // 1. BASIC MAP() OPERATIONS - Generic Transformations
    // ============================================================================
    
    /**
     * Basic map() - Transform each integer to its square
     * Use case: Mathematical transformations
     * Why not reduce: We want to keep all elements, not combine them
     */
    public static void squareIntegers(List<Integer> numbers) {
        System.out.println("\n=== BASIC MAP() - Square Integers ===");
        System.out.println("Input: " + numbers);
        
        List<Integer> result = numbers.stream()
                .map(n -> n * n)  // Transform each element independently
                .collect(Collectors.toList());
        
        System.out.println("Output (squared): " + result);
        System.out.println("Why map(): Each element transformed independently, maintaining count");
    }

    /**
     * Basic map() - Convert strings to uppercase
     * Use case: String transformations
     * Why not reduce: We want to transform each string, not concatenate them
     */
    public static void toUpperCase(List<String> words) {
        System.out.println("\n=== BASIC MAP() - To Uppercase ===");
        System.out.println("Input: " + words);
        
        List<String> result = words.stream()
                .map(String::toUpperCase)  // Method reference for cleaner code
                .collect(Collectors.toList());
        
        System.out.println("Output (uppercase): " + result);
        System.out.println("Why map(): Each string transformed independently");
    }

    /**
     * Basic map() - Extract property from objects
     * Use case: Property extraction
     * Why not reduce: We want to extract names, not combine employees
     */
    public static void extractEmployeeNames(List<Employee> employees) {
        System.out.println("\n=== BASIC MAP() - Extract Names ===");
        System.out.println("Input: " + employees);
        
        List<String> result = employees.stream()
                .map(e -> e.name)  // Extract name property
                .collect(Collectors.toList());
        
        System.out.println("Output (names): " + result);
        System.out.println("Why map(): Extract specific property from each object");
    }

    /**
     * Basic map() - Add constant value
     * Use case: Arithmetic operations
     * Why not reduce: We want to add to each element, not sum all elements
     */
    public static void addTen(List<Integer> numbers) {
        System.out.println("\n=== BASIC MAP() - Add Constant ===");
        System.out.println("Input: " + numbers);
        
        List<Integer> result = numbers.stream()
                .map(n -> n + 10)  // Add 10 to each element
                .collect(Collectors.toList());
        
        System.out.println("Output (+10): " + result);
        System.out.println("Why map(): Apply same operation to each element");
    }

    /**
     * Basic map() - Get string lengths
     * Use case: Property calculation
     * Why not reduce: We want length of each string, not total length
     */
    public static void stringLengths(List<String> words) {
        System.out.println("\n=== BASIC MAP() - String Lengths ===");
        System.out.println("Input: " + words);
        
        List<Integer> result = words.stream()
                .map(String::length)  // Get length of each string
                .collect(Collectors.toList());
        
        System.out.println("Output (lengths): " + result);
        System.out.println("Why map(): Calculate property for each element");
    }

    /**
     * Advanced map() - Conditional mapping
     * Use case: Business logic transformations
     * Why not reduce: We want to categorize each employee, not combine them
     */
    public static void employeeSalaryBands(List<Employee> employees) {
        System.out.println("\n=== ADVANCED MAP() - Salary Bands ===");
        System.out.println("Input: " + employees);
        
        List<String> result = employees.stream()
                .map(e -> {
                    if (e.salary < 70000) return "Low";
                    else if (e.salary < 85000) return "Medium";
                    else return "High";
                })
                .collect(Collectors.toList());
        
        System.out.println("Output (salary bands): " + result);
        System.out.println("Why map(): Apply business logic to each element");
    }

    /**
     * Advanced map() - Combine properties
     * Use case: Creating derived values
     * Why not reduce: We want to combine properties of each employee, not all employees
     */
    public static void employeeNameDepartmentPairs(List<Employee> employees) {
        System.out.println("\n=== ADVANCED MAP() - Name-Department Pairs ===");
        System.out.println("Input: " + employees);
        
        List<String> result = employees.stream()
                .map(e -> e.name + "-" + e.department)  // Combine properties
                .collect(Collectors.toList());
        
        System.out.println("Output (name-department pairs): " + result);
        System.out.println("Why map(): Create derived values from each object");
    }

    // ============================================================================
    // 2. FLATMAP() OPERATIONS - Flatten Nested Collections
    // ============================================================================
    
    /**
     * flatMap() - Flatten list of lists
     * Use case: When you have nested collections and want to flatten them
     * Why not map(): map() would return Stream<List<Integer>>, not Stream<Integer>
     * Why not reduce(): We want to flatten, not combine into single value
     */
    public static void flattenListOfLists(List<List<Integer>> listOfLists) {
        System.out.println("\n=== FLATMAP() - Flatten Nested Lists ===");
        System.out.println("Input: " + listOfLists);
        
        List<Integer> result = listOfLists.stream()
                .flatMap(list -> list.stream())  // Flatten each inner list
                .collect(Collectors.toList());
        
        System.out.println("Output (flattened): " + result);
        System.out.println("Why flatMap(): Need to flatten nested structure");
        System.out.println("Internal working: Each inner list becomes a stream, then all streams are merged");
    }

    /**
     * flatMap() - Split sentences into words
     * Use case: Text processing
     * Why not map(): map() would return Stream<String[]>, not Stream<String>
     * Why not reduce(): We want to split and flatten, not combine
     */
    public static void splitSentencesToWords(List<String> sentences) {
        System.out.println("\n=== FLATMAP() - Split Sentences to Words ===");
        System.out.println("Input: " + sentences);
        
        List<String> result = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))  // Split and flatten
                .collect(Collectors.toList());
        
        System.out.println("Output (words): " + result);
        System.out.println("Why flatMap(): Split produces arrays, need to flatten to individual words");
    }

    /**
     * flatMap() - Extract skills from employees
     * Use case: Extracting collections from objects
     * Why not map(): map() would return Stream<List<String>>, not Stream<String>
     * Why not reduce(): We want to extract and flatten skills, not combine employees
     */
    public static void flattenEmployeeSkills(List<Employee> employees) {
        System.out.println("\n=== FLATMAP() - Flatten Employee Skills ===");
        System.out.println("Input: " + employees);
        
        List<String> result = employees.stream()
                .flatMap(e -> e.skills.stream())  // Extract and flatten skills
                .collect(Collectors.toList());
        
        System.out.println("Output (all skills): " + result);
        System.out.println("Why flatMap(): Extract collections from objects and flatten them");
    }

    /**
     * Advanced flatMap() - Get unique words from paragraphs
     * Use case: Complex text processing with deduplication
     * Why not map(): Need to flatten and then apply distinct
     * Why not reduce(): We want to process each word, not combine them
     */
    public static void uniqueWordsFromParagraphs(List<List<String>> paragraphs) {
        System.out.println("\n=== ADVANCED FLATMAP() - Unique Words from Paragraphs ===");
        System.out.println("Input: " + paragraphs);
        
        List<String> result = paragraphs.stream()
                .flatMap(paragraph -> paragraph.stream())  // Flatten paragraphs
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))  // Split sentences
                .map(String::toLowerCase)  // Normalize
                .distinct()  // Remove duplicates
                .collect(Collectors.toList());
        
        System.out.println("Output (unique words): " + result);
        System.out.println("Why flatMap(): Multiple flattening operations needed");
    }

    // ============================================================================
    // 3. PRIMITIVE STREAM OPERATIONS
    // ============================================================================
    
    /**
     * mapToInt() - Convert to primitive int stream
     * Use case: When you need primitive int operations (better performance)
     * Why not map(): map() returns Stream<Integer>, not IntStream
     * Why not reduce(): We want to transform each element, not combine them
     */
    public static void mapToIntExample(List<String> words) {
        System.out.println("\n=== MAPTOINT() - Convert to IntStream ===");
        System.out.println("Input: " + words);
        
        // Using mapToInt() - returns IntStream
        int[] lengthsArray = words.stream()
                .mapToInt(String::length)  // Convert to primitive int stream
                .toArray();
        
        // Using map() - returns Stream<Integer>
        List<Integer> lengthsList = words.stream()
                .map(String::length)  // Returns Stream<Integer>
                .collect(Collectors.toList());
        
        System.out.println("Output (mapToInt): " + Arrays.toString(lengthsArray));
        System.out.println("Output (map): " + lengthsList);
        System.out.println("Why mapToInt(): Better performance for primitive operations");
        System.out.println("Internal working: Avoids boxing/unboxing overhead");
    }

    /**
     * mapToLong() - Convert to primitive long stream
     * Use case: Large number calculations
     * Why not map(): map() returns Stream<Long>, not LongStream
     * Why not reduce(): We want to transform each element, not combine them
     */
    public static void mapToLongExample(List<Integer> numbers) {
        System.out.println("\n=== MAPTOLONG() - Convert to LongStream ===");
        System.out.println("Input: " + numbers);
        
        long[] squares = numbers.stream()
                .mapToLong(n -> (long) n * n)  // Convert to long to avoid overflow
                .toArray();
        
        System.out.println("Output (squares as long): " + Arrays.toString(squares));
        System.out.println("Why mapToLong(): Handle large numbers without overflow");
    }

    /**
     * mapToDouble() - Convert to primitive double stream
     * Use case: Decimal calculations
     * Why not map(): map() returns Stream<Double>, not DoubleStream
     * Why not reduce(): We want to transform each element, not combine them
     */
    public static void mapToDoubleExample(List<Integer> numbers) {
        System.out.println("\n=== MAPTODOUBLE() - Convert to DoubleStream ===");
        System.out.println("Input: " + numbers);
        
        double[] squareRoots = numbers.stream()
                .mapToDouble(Math::sqrt)  // Calculate square root
                .toArray();
        
        System.out.println("Output (square roots): " + Arrays.toString(squareRoots));
        System.out.println("Why mapToDouble(): Perform mathematical operations with decimals");
    }

    /**
     * mapToObj() - Convert primitive stream back to object stream
     * Use case: When you need object operations after primitive operations
     * Why not map(): map() doesn't exist on primitive streams
     * Why not reduce(): We want to transform each element, not combine them
     */
    public static void mapToObjExample(List<String> words) {
        System.out.println("\n=== MAPTOOBJ() - Convert Primitive to Object Stream ===");
        System.out.println("Input: " + words);
        
        // Chain primitive and object operations
        List<String> result = words.stream()
                .mapToInt(String::length)  // Convert to IntStream
                .filter(len -> len > 3)    // Filter primitive stream
                .mapToObj(len -> "Length: " + len)  // Convert back to object stream
                .collect(Collectors.toList());
        
        System.out.println("Output: " + result);
        System.out.println("Why mapToObj(): Chain primitive and object operations");
    }

    // ============================================================================
    // 4. ADVANCED OPERATIONS & COMPARISONS
    // ============================================================================
    
    /**
     * Chaining multiple map operations
     * Use case: Complex transformations
     * Why not reduce(): We want to transform each element through multiple steps
     */
    public static void chainingMapOperations(List<Employee> employees) {
        System.out.println("\n=== CHAINING MAP OPERATIONS ===");
        System.out.println("Input: " + employees);
        
        List<String> result = employees.stream()
                .map(e -> e.name)                    // Extract name
                .map(String::toUpperCase)            // Convert to uppercase
                .map(name -> "Employee: " + name)    // Add prefix
                .collect(Collectors.toList());
        
        System.out.println("Output: " + result);
        System.out.println("Why chaining: Each step transforms the previous result");
    }

    /**
     * Performance comparison: map() vs reduce() for transformations
     * Use case: Understanding when to use each
     */
    public static void mapVsReduceComparison(List<Integer> numbers) {
        System.out.println("\n=== MAP() vs REDUCE() COMPARISON ===");
        System.out.println("Input: " + numbers);
        
        // Using map() - transforms each element
        List<Integer> mapResult = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        
        // Using reduce() - combines all elements (WRONG for this use case)
        Optional<Integer> reduceResult = numbers.stream()
                .reduce((a, b) -> a * 2 + b * 2);  // This is wrong!
        
        System.out.println("map() result (doubles each): " + mapResult);
        System.out.println("reduce() result (combines all): " + reduceResult.orElse(0));
        System.out.println("Why map() is correct: We want to transform each element independently");
        System.out.println("Why reduce() is wrong: We don't want to combine elements");
    }

    /**
     * Parallel stream mapping
     * Use case: Performance optimization for large datasets
     * Why not reduce(): We want to transform elements, not combine them
     */
    public static void parallelMapExample(List<Integer> numbers) {
        System.out.println("\n=== PARALLEL MAP OPERATIONS ===");
        System.out.println("Input: " + numbers);
        
        List<Integer> result = numbers.parallelStream()
                .map(n -> {
                    // Simulate expensive operation
                    try { Thread.sleep(10); } catch (InterruptedException e) {}
                    return n * n;
                })
                .collect(Collectors.toList());
        
        System.out.println("Output: " + result);
        System.out.println("Why parallel: Independent operations can be executed in parallel");
    }

    // ============================================================================
    // 5. COMPREHENSIVE EXAMPLE SHOWCASING ALL MAP TYPES
    // ============================================================================
    
    public static void comprehensiveMapExample() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("COMPREHENSIVE MAP OPERATIONS DEMONSTRATION");
        System.out.println("=".repeat(80));
        
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000, 
                        Arrays.asList("Java", "Spring"), 
                        Arrays.asList("Payroll", "Recruitment")),
            new Employee("Bob", 25, "Engineering", 80000, 
                        Arrays.asList("Java", "React", "Docker"), 
                        Arrays.asList("Inventory", "Payroll")),
            new Employee("Charlie", 28, "Engineering", 75000, 
                        Arrays.asList("Python", "Java"), 
                        Arrays.asList("Analytics")),
            new Employee("Diana", 35, "Finance", 90000, 
                        Arrays.asList("Excel", "SQL"), 
                        Arrays.asList("Budget", "Forecasting"))
        );
        
        // 1. Basic map() - Extract and transform
        System.out.println("\n1. BASIC MAP() - Employee initials:");
        List<String> initials = employees.stream()
                .map(e -> e.name.substring(0, 1))
                .collect(Collectors.toList());
        System.out.println("Result: " + initials);
        
        // 2. flatMap() - Flatten skills
        System.out.println("\n2. FLATMAP() - All skills:");
        List<String> allSkills = employees.stream()
                .flatMap(e -> e.skills.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Result: " + allSkills);
        
        // 3. mapToInt() - Age statistics
        System.out.println("\n3. MAPTOINT() - Age statistics:");
        IntSummaryStatistics ageStats = employees.stream()
                .mapToInt(e -> e.age)
                .summaryStatistics();
        System.out.println("Age stats: " + ageStats);
        
        // 4. mapToDouble() - Salary calculations
        System.out.println("\n4. MAPTODOUBLE() - Salary with bonus:");
        double[] salariesWithBonus = employees.stream()
                .mapToDouble(e -> e.salary * 1.1)  // 10% bonus
                .toArray();
        System.out.println("Salaries with bonus: " + Arrays.toString(salariesWithBonus));
        
        // 5. mapToObj() - Complex transformation
        System.out.println("\n5. MAPTOOBJ() - Complex transformation:");
        List<String> employeeInfo = employees.stream()
                .mapToInt(e -> e.age)
                .filter(age -> age > 25)
                .mapToObj(age -> "Senior employee (age: " + age + ")")
                .collect(Collectors.toList());
        System.out.println("Result: " + employeeInfo);
        
        // 6. Chaining multiple operations
        System.out.println("\n6. CHAINING - Complex pipeline:");
        List<String> result = employees.stream()
                .filter(e -> e.department.equals("Engineering"))
                .map(e -> e.name.toUpperCase())
                .map(name -> "ENG: " + name)
                .collect(Collectors.toList());
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        // Test data
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> sentences = Arrays.asList("Hello world", "Java streams are powerful");
        List<List<Integer>> nestedLists = Arrays.asList(
            Arrays.asList(1, 2, 3), 
            Arrays.asList(4, 5), 
            Arrays.asList(6, 7, 8)
        );
        List<List<String>> paragraphs = Arrays.asList(
            Arrays.asList("Java is great", "Streams are cool"),
            Arrays.asList("Practice Java streams")
        );
        
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000, 
                        Arrays.asList("Java", "Spring"), 
                        Arrays.asList("Payroll", "Recruitment")),
            new Employee("Bob", 25, "Engineering", 80000, 
                        Arrays.asList("Java", "React"), 
                        Arrays.asList("Inventory", "Payroll")),
            new Employee("Charlie", 28, "Engineering", 75000, 
                        Arrays.asList("Python", "Java"), 
                        Arrays.asList("Analytics")),
            new Employee("Diana", 35, "Finance", 90000, 
                        Arrays.asList("Excel", "SQL"), 
                        Arrays.asList("Budget", "Forecasting"))
        );

        // Run all examples
        squareIntegers(nums);
        toUpperCase(words);
        extractEmployeeNames(employees);
        addTen(nums);
        stringLengths(words);
        employeeSalaryBands(employees);
        employeeNameDepartmentPairs(employees);
        
        flattenListOfLists(nestedLists);
        splitSentencesToWords(sentences);
        flattenEmployeeSkills(employees);
        uniqueWordsFromParagraphs(paragraphs);
        
        mapToIntExample(words);
        mapToLongExample(nums);
        mapToDoubleExample(nums);
        mapToObjExample(words);
        
        chainingMapOperations(employees);
        mapVsReduceComparison(nums);
        parallelMapExample(nums);
        
        comprehensiveMapExample();
    }
} 