package src.main.java.streams.IntermediateOperations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Practice Problems for peek():
 * 1. Log each element as it passes through the stream.
 * 2. Debug transformations in a stream pipeline.
 * 3. Advanced: Use peek to collect elements into a side list for auditing.
 * 4. Custom: Use peek to count how many elements pass a certain stage.
 */
public class Peek_Example {
    // 1. Log each element as it passes through the stream.
    public static void logElements(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        List<Integer> result = numbers.stream()
                .peek(n -> System.out.println("Peek: " + n))
                .map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Output (doubled): " + result);
    }

    // 2. Debug transformations in a stream pipeline.
    public static void debugPipeline(List<String> words) {
        System.out.println("Input: " + words);
        List<String> result = words.stream()
                .peek(w -> System.out.println("Original: " + w))
                .map(String::toUpperCase)
                .peek(w -> System.out.println("Uppercased: " + w))
                .collect(Collectors.toList());
        System.out.println("Output: " + result);
    }

    // 3. Advanced: Use peek to collect elements into a side list for auditing.
    public static void auditElements(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        List<Integer> audit = new java.util.ArrayList<>();
        List<Integer> result = numbers.stream()
                .peek(audit::add)
                .map(n -> n + 1)
                .collect(Collectors.toList());
        System.out.println("Output (incremented): " + result);
        System.out.println("Audit trail: " + audit);
    }

    // 4. Custom: Use peek to count how many elements pass a certain stage.
    public static void countPassingElements(List<Integer> numbers) {
        System.out.println("Input: " + numbers);
        final int[] count = {0};
        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .peek(n -> count[0]++)
                .collect(Collectors.toList());
        System.out.println("Output (evens): " + result);
        System.out.println("Count of evens: " + count[0]);
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        logElements(nums);
        debugPipeline(words);
        auditElements(nums);
        countPassingElements(nums);
    }
} 