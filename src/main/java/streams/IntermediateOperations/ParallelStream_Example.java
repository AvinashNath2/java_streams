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
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * ============================================================================
 * PARALLEL STREAM PROCESSING COMPREHENSIVE GUIDE
 * ============================================================================
 * 
 * This class demonstrates parallel stream processing in Java:
 * 
 * 1. Basic parallel stream operations
 * 2. Performance comparisons (sequential vs parallel)
 * 3. When to use parallel streams
 * 4. Common pitfalls and best practices
 * 5. Thread safety considerations
 * 6. Custom thread pool configuration
 * 7. Real-world parallel processing scenarios
 * 
 * ============================================================================
 * WHEN TO USE PARALLEL STREAMS
 * ============================================================================
 * 
 * ✅ USE PARALLEL STREAMS WHEN:
 * - Large datasets (typically > 10,000 elements)
 * - CPU-intensive operations (complex calculations)
 * - Independent operations (no shared state)
 * - I/O operations (with proper thread management)
 * - Multiple cores available
 * 
 * ❌ AVOID PARALLEL STREAMS WHEN:
 * - Small datasets (< 1,000 elements)
 * - Operations with shared mutable state
 * - Sequential dependencies between elements
 * - Simple operations (overhead > benefit)
 * - Memory-constrained environments
 * 
 * ============================================================================
 * INTERNAL WORKING OF PARALLEL STREAMS
 * ============================================================================
 * 
 * 1. FORK-JOIN FRAMEWORK: Uses Java's ForkJoinPool for work distribution
 * 2. WORK STEALING: Threads can steal work from other threads' queues
 * 3. SPLITTING: Data is split into chunks for parallel processing
 * 4. MERGING: Results are merged back together
 * 5. THREAD POOL: Uses common ForkJoinPool by default
 * 
 * ============================================================================
 * PRACTICE PROBLEMS
 * ============================================================================
 * 
 * BASIC PARALLEL OPERATIONS:
 * 1. Parallel filtering of large datasets
 * 2. Parallel mapping with CPU-intensive operations
 * 3. Parallel reduction operations
 * 4. Parallel sorting and distinct operations
 * 
 * PERFORMANCE ANALYSIS:
 * 5. Sequential vs parallel performance comparison
 * 6. Impact of data size on parallel performance
 * 7. CPU-intensive vs I/O-intensive operations
 * 8. Memory usage analysis
 * 
 * ADVANCED SCENARIOS:
 * 9. Custom thread pool configuration
 * 10. Thread-safe parallel operations
 * 11. Parallel processing with shared state
 * 12. Real-world parallel processing examples
 * 13. Debugging parallel stream issues
 * 14. Best practices and optimization tips
 */
public class ParallelStream_Example {
    
    public static class Employee {
        public String name;
        public int age;
        public String department;
        public double salary;
        public List<String> skills;
        
        public Employee(String name, int age, String department, double salary, List<String> skills) {
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
            this.skills = skills;
        }
        
        public String toString() {
            return name + " (" + age + ", " + department + ", $" + salary + ")";
        }
    }

    // ============================================================================
    // 1. BASIC PARALLEL STREAM OPERATIONS
    // ============================================================================
    
    /**
     * Basic parallel filtering
     * Use case: Filtering large datasets
     * Why parallel: Large dataset with independent filtering operations
     */
    public static void parallelFiltering(List<Integer> numbers) {
        System.out.println("\n=== PARALLEL FILTERING ===");
        System.out.println("Input size: " + numbers.size());
        
        long startTime = System.currentTimeMillis();
        List<Integer> result = numbers.parallelStream()
                .filter(n -> n % 2 == 0)  // Independent operation
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        
        System.out.println("Parallel filtering time: " + (endTime - startTime) + "ms");
        System.out.println("Result size: " + result.size());
        System.out.println("Why parallel: Independent filtering operations on large dataset");
    }

    /**
     * Parallel mapping with CPU-intensive operations
     * Use case: Complex calculations on each element
     * Why parallel: CPU-intensive operations benefit from multiple cores
     */
    public static void parallelMapping(List<Integer> numbers) {
        System.out.println("\n=== PARALLEL MAPPING (CPU-INTENSIVE) ===");
        System.out.println("Input size: " + numbers.size());
        
        long startTime = System.currentTimeMillis();
        List<Double> result = numbers.parallelStream()
                .map(n -> {
                    // Simulate CPU-intensive operation
                    double sum = 0;
                    for (int i = 0; i < 100000; i++) {
                        sum += Math.sqrt(n + i);
                    }
                    return sum;
                })
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        
        System.out.println("Parallel mapping time: " + (endTime - startTime) + "ms");
        System.out.println("Result size: " + result.size());
        System.out.println("Why parallel: CPU-intensive operations benefit from multiple cores");
    }

    /**
     * Parallel reduction operations
     * Use case: Aggregating large datasets
     * Why parallel: Independent reduction operations
     */
    public static void parallelReduction(List<Integer> numbers) {
        System.out.println("\n=== PARALLEL REDUCTION ===");
        System.out.println("Input size: " + numbers.size());
        
        long startTime = System.currentTimeMillis();
        int sum = numbers.parallelStream()
                .reduce(0, Integer::sum);  // Associative operation
        long endTime = System.currentTimeMillis();
        
        System.out.println("Parallel reduction time: " + (endTime - startTime) + "ms");
        System.out.println("Sum: " + sum);
        System.out.println("Why parallel: Associative reduction operation on large dataset");
    }

    /**
     * Parallel sorting and distinct operations
     * Use case: Processing large datasets with sorting
     * Why parallel: Sorting can benefit from parallel processing
     */
    public static void parallelSorting(List<Integer> numbers) {
        System.out.println("\n=== PARALLEL SORTING ===");
        System.out.println("Input size: " + numbers.size());
        
        long startTime = System.currentTimeMillis();
        List<Integer> result = numbers.parallelStream()
                .sorted()  // Parallel sorting
                .distinct()  // Parallel distinct
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        
        System.out.println("Parallel sorting time: " + (endTime - startTime) + "ms");
        System.out.println("Result size: " + result.size());
        System.out.println("Why parallel: Sorting and distinct operations on large dataset");
    }

    // ============================================================================
    // 2. PERFORMANCE COMPARISONS
    // ============================================================================
    
    /**
     * Sequential vs Parallel performance comparison
     * Use case: Understanding when parallel is beneficial
     */
    public static void sequentialVsParallelComparison(List<Integer> numbers) {
        System.out.println("\n=== SEQUENTIAL vs PARALLEL COMPARISON ===");
        System.out.println("Input size: " + numbers.size());
        
        // Sequential processing
        long startTime = System.currentTimeMillis();
        List<Integer> sequentialResult = numbers.stream()
                .map(n -> {
                    // Simulate work
                    try { Thread.sleep(1); } catch (InterruptedException e) {}
                    return n * 2;
                })
                .collect(Collectors.toList());
        long sequentialTime = System.currentTimeMillis() - startTime;
        
        // Parallel processing
        startTime = System.currentTimeMillis();
        List<Integer> parallelResult = numbers.parallelStream()
                .map(n -> {
                    // Simulate work
                    try { Thread.sleep(1); } catch (InterruptedException e) {}
                    return n * 2;
                })
                .collect(Collectors.toList());
        long parallelTime = System.currentTimeMillis() - startTime;
        
        System.out.println("Sequential time: " + sequentialTime + "ms");
        System.out.println("Parallel time: " + parallelTime + "ms");
        System.out.println("Speedup: " + String.format("%.2fx", (double) sequentialTime / parallelTime));
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
    }

    /**
     * Impact of data size on parallel performance
     * Use case: Understanding the threshold for parallel benefits
     */
    public static void dataSizeImpact() {
        System.out.println("\n=== DATA SIZE IMPACT ON PARALLEL PERFORMANCE ===");
        
        int[] sizes = {100, 1000, 10000, 100000, 1000000};
        
        for (int size : sizes) {
            List<Integer> numbers = IntStream.range(0, size).boxed().collect(Collectors.toList());
            
            // Sequential
            long startTime = System.currentTimeMillis();
            numbers.stream()
                    .map(n -> n * 2)
                    .collect(Collectors.toList());
            long sequentialTime = System.currentTimeMillis() - startTime;
            
            // Parallel
            startTime = System.currentTimeMillis();
            numbers.parallelStream()
                    .map(n -> n * 2)
                    .collect(Collectors.toList());
            long parallelTime = System.currentTimeMillis() - startTime;
            
            System.out.printf("Size: %7d | Sequential: %3dms | Parallel: %3dms | Speedup: %.2fx%n", 
                            size, sequentialTime, parallelTime, (double) sequentialTime / parallelTime);
        }
    }

    /**
     * CPU-intensive vs I/O-intensive operations
     * Use case: Understanding different types of parallel operations
     */
    public static void cpuVsIoIntensive(List<Integer> numbers) {
        System.out.println("\n=== CPU-INTENSIVE vs I/O-INTENSIVE PARALLEL OPERATIONS ===");
        System.out.println("Input size: " + numbers.size());
        
        // CPU-intensive operation
        long startTime = System.currentTimeMillis();
        List<Double> cpuResult = numbers.parallelStream()
                .map(n -> {
                    // CPU-intensive: mathematical calculations
                    double result = 0;
                    for (int i = 0; i < 10000; i++) {
                        result += Math.sqrt(n + i) * Math.sin(i);
                    }
                    return result;
                })
                .collect(Collectors.toList());
        long cpuTime = System.currentTimeMillis() - startTime;
        
        // I/O-intensive operation
        startTime = System.currentTimeMillis();
        List<String> ioResult = numbers.parallelStream()
                .map(n -> {
                    // I/O-intensive: simulated network call
                    try { Thread.sleep(10); } catch (InterruptedException e) {}
                    return "Processed: " + n;
                })
                .collect(Collectors.toList());
        long ioTime = System.currentTimeMillis() - startTime;
        
        System.out.println("CPU-intensive time: " + cpuTime + "ms");
        System.out.println("I/O-intensive time: " + ioTime + "ms");
        System.out.println("CPU-intensive benefits more from parallel processing");
    }

    // ============================================================================
    // 3. ADVANCED PARALLEL SCENARIOS
    // ============================================================================
    
    /**
     * Custom thread pool configuration
     * Use case: Controlling parallel processing resources
     */
    public static void customThreadPool(List<Integer> numbers) {
        System.out.println("\n=== CUSTOM THREAD POOL CONFIGURATION ===");
        System.out.println("Input size: " + numbers.size());
        
        // Create custom ForkJoinPool
        ForkJoinPool customPool = new ForkJoinPool(4); // 4 threads
        
        long startTime = System.currentTimeMillis();
        List<Integer> result = customPool.submit(() -> 
            numbers.parallelStream()
                    .map(n -> {
                        try { Thread.sleep(10); } catch (InterruptedException e) {}
                        return n * 2;
                    })
                    .collect(Collectors.toList())
        ).join();
        long endTime = System.currentTimeMillis();
        
        System.out.println("Custom thread pool time: " + (endTime - startTime) + "ms");
        System.out.println("Thread pool size: 4");
        System.out.println("Why custom pool: Control resource usage and thread count");
        
        customPool.shutdown();
    }

    /**
     * Thread-safe parallel operations
     * Use case: Parallel processing with shared state
     */
    public static void threadSafeParallelOperations(List<Integer> numbers) {
        System.out.println("\n=== THREAD-SAFE PARALLEL OPERATIONS ===");
        System.out.println("Input size: " + numbers.size());
        
        // Thread-safe counter using AtomicInteger
        AtomicInteger counter = new AtomicInteger(0);
        
        long startTime = System.currentTimeMillis();
        List<Integer> result = numbers.parallelStream()
                .map(n -> {
                    // Thread-safe increment
                    int current = counter.incrementAndGet();
                    return n + current;
                })
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        
        System.out.println("Thread-safe parallel time: " + (endTime - startTime) + "ms");
        System.out.println("Final counter value: " + counter.get());
        System.out.println("Why thread-safe: Shared state accessed by multiple threads");
    }

    /**
     * Parallel processing with shared state (DANGEROUS EXAMPLE)
     * Use case: Understanding what NOT to do
     */
    public static void dangerousSharedState(List<Integer> numbers) {
        System.out.println("\n=== DANGEROUS SHARED STATE (WHAT NOT TO DO) ===");
        System.out.println("Input size: " + numbers.size());
        
        // DANGEROUS: Non-thread-safe shared state
        List<Integer> sharedList = new ArrayList<>();
        
        try {
            numbers.parallelStream()
                    .forEach(n -> {
                        // DANGEROUS: Non-thread-safe operation
                        sharedList.add(n * 2);
                    });
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
        
        System.out.println("Expected size: " + numbers.size());
        System.out.println("Actual size: " + sharedList.size());
        System.out.println("Why dangerous: Non-thread-safe operations on shared state");
    }

    /**
     * Real-world parallel processing example
     * Use case: Processing employee data in parallel
     */
    public static void realWorldParallelExample(List<Employee> employees) {
        System.out.println("\n=== REAL-WORLD PARALLEL PROCESSING ===");
        System.out.println("Input size: " + employees.size());
        
        long startTime = System.currentTimeMillis();
        
        // Parallel processing pipeline
        List<String> result = employees.parallelStream()
                .filter(e -> e.salary > 70000)  // Parallel filtering
                .map(e -> {
                    // Simulate complex employee processing
                    try { Thread.sleep(5); } catch (InterruptedException ex) {}
                    return e.name.toUpperCase() + " - " + e.department;
                })
                .sorted()  // Parallel sorting
                .collect(Collectors.toList());
        
        long endTime = System.currentTimeMillis();
        
        System.out.println("Real-world parallel processing time: " + (endTime - startTime) + "ms");
        System.out.println("Result size: " + result.size());
        System.out.println("Sample results: " + result.subList(0, Math.min(3, result.size())));
    }

    /**
     * Debugging parallel stream issues
     * Use case: Understanding parallel stream behavior
     */
    public static void debuggingParallelStreams(List<Integer> numbers) {
        System.out.println("\n=== DEBUGGING PARALLEL STREAMS ===");
        System.out.println("Input size: " + numbers.size());
        
        // Debug parallel processing order
        System.out.println("Parallel processing order (may vary):");
        numbers.parallelStream()
                .limit(10)
                .forEach(n -> {
                    System.out.println("Thread: " + Thread.currentThread().getName() + 
                                     " | Processing: " + n);
                });
        
        // Debug thread pool information
        System.out.println("\nThread pool information:");
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Default parallelism: " + ForkJoinPool.getCommonPoolParallelism());
    }

    /**
     * Best practices and optimization tips
     * Use case: Guidelines for effective parallel processing
     */
    public static void bestPractices() {
        System.out.println("\n=== PARALLEL STREAM BEST PRACTICES ===");
        
        System.out.println("✅ DO:");
        System.out.println("  - Use for large datasets (> 10,000 elements)");
        System.out.println("  - Use for CPU-intensive operations");
        System.out.println("  - Ensure operations are stateless");
        System.out.println("  - Use associative operations for reduction");
        System.out.println("  - Test performance with your specific data");
        
        System.out.println("\n❌ DON'T:");
        System.out.println("  - Use for small datasets");
        System.out.println("  - Use with shared mutable state");
        System.out.println("  - Use for operations with side effects");
        System.out.println("  - Assume parallel is always faster");
        System.out.println("  - Use for operations with dependencies");
        
        System.out.println("\n🔧 OPTIMIZATION TIPS:");
        System.out.println("  - Profile your specific use case");
        System.out.println("  - Consider custom thread pools for I/O operations");
        System.out.println("  - Use appropriate data structures");
        System.out.println("  - Monitor memory usage");
        System.out.println("  - Test with realistic data sizes");
    }

    // ============================================================================
    // 4. COMPREHENSIVE PARALLEL PROCESSING DEMONSTRATION
    // ============================================================================
    
    public static void comprehensiveParallelDemo() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("COMPREHENSIVE PARALLEL STREAM PROCESSING DEMONSTRATION");
        System.out.println("=".repeat(80));
        
        // Generate large dataset
        List<Integer> largeNumbers = IntStream.range(0, 100000)
                .boxed()
                .collect(Collectors.toList());
        
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000, Arrays.asList("Java", "Spring")),
            new Employee("Bob", 25, "Engineering", 80000, Arrays.asList("Java", "React")),
            new Employee("Charlie", 28, "Engineering", 75000, Arrays.asList("Python", "Java")),
            new Employee("Diana", 35, "Finance", 90000, Arrays.asList("Excel", "SQL")),
            new Employee("Eve", 27, "Marketing", 65000, Arrays.asList("Photoshop", "Analytics")),
            new Employee("Frank", 32, "Engineering", 85000, Arrays.asList("Java", "Docker")),
            new Employee("Grace", 29, "HR", 62000, Arrays.asList("Communication", "Leadership")),
            new Employee("Henry", 31, "Finance", 88000, Arrays.asList("Excel", "PowerBI"))
        );
        
        // 1. Basic parallel operations
        System.out.println("\n1. BASIC PARALLEL OPERATIONS:");
        parallelFiltering(largeNumbers.subList(0, 10000));
        parallelMapping(largeNumbers.subList(0, 1000));
        parallelReduction(largeNumbers.subList(0, 10000));
        
        // 2. Performance comparisons
        System.out.println("\n2. PERFORMANCE COMPARISONS:");
        sequentialVsParallelComparison(largeNumbers.subList(0, 1000));
        dataSizeImpact();
        cpuVsIoIntensive(largeNumbers.subList(0, 100));
        
        // 3. Advanced scenarios
        System.out.println("\n3. ADVANCED SCENARIOS:");
        customThreadPool(largeNumbers.subList(0, 1000));
        threadSafeParallelOperations(largeNumbers.subList(0, 1000));
        dangerousSharedState(largeNumbers.subList(0, 1000));
        
        // 4. Real-world examples
        System.out.println("\n4. REAL-WORLD EXAMPLES:");
        realWorldParallelExample(employees);
        debuggingParallelStreams(largeNumbers.subList(0, 20));
        
        // 5. Best practices
        System.out.println("\n5. BEST PRACTICES:");
        bestPractices();
    }

    public static void main(String[] args) {
        // Generate test data
        List<Integer> smallNumbers = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        List<Integer> mediumNumbers = IntStream.range(0, 10000).boxed().collect(Collectors.toList());
        List<Integer> largeNumbers = IntStream.range(0, 100000).boxed().collect(Collectors.toList());
        
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 30, "HR", 60000, Arrays.asList("Java", "Spring")),
            new Employee("Bob", 25, "Engineering", 80000, Arrays.asList("Java", "React")),
            new Employee("Charlie", 28, "Engineering", 75000, Arrays.asList("Python", "Java")),
            new Employee("Diana", 35, "Finance", 90000, Arrays.asList("Excel", "SQL"))
        );

        // Run comprehensive demonstration
        comprehensiveParallelDemo();
    }
} 