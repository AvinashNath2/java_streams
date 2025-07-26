package src.main.java.streams.IntermediateOperations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Practice Problems for flatMap():
 * 1. Flatten a list of lists of integers.
 * 2. Split a list of sentences into words.
 * 3. Advanced: Flatten a list of Employee objects, each with a list of skills, into a list of skills.
 * 4. Advanced: Given a list of paragraphs (list of sentences), return a list of all unique words.
 * 5. Custom: Flatten all project names from a list of Employee objects (each with a list of projects).
 * 6. Custom: Flatten all unique characters from a list of Employee names.
 */
public class FlatMap_Example {
    public static class Employee {
        public String name;
        public List<String> skills;
        public List<String> projects;
        public Employee(String name, List<String> skills, List<String> projects) {
            this.name = name;
            this.skills = skills;
            this.projects = projects;
        }
        public String toString() {
            return name + " (skills: " + skills + ", projects: " + projects + ")";
        }
    }

    // 1. Flatten a list of lists of integers.
    public static void flattenListOfLists(List<List<Integer>> listOfLists) {
        System.out.println("Input: " + listOfLists);
        List<Integer> result = listOfLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Output (flattened): " + result);
    }

    // 2. Split a list of sentences into words.
    public static void splitSentencesToWords(List<String> sentences) {
        System.out.println("Input: " + sentences);
        List<String> result = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());
        System.out.println("Output (words): " + result);
    }

    // 3. Advanced: Flatten a list of Employee objects, each with a list of skills, into a list of skills.
    public static void flattenEmployeeSkills(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<String> result = employees.stream()
                .flatMap(e -> e.skills.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Output (all unique skills): " + result);
    }

    // 4. Advanced: Given a list of paragraphs (list of sentences), return a list of all unique words.
    public static void uniqueWordsFromParagraphs(List<List<String>> paragraphs) {
        System.out.println("Input: " + paragraphs);
        List<String> result = paragraphs.stream()
                .flatMap(List::stream)
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Output (unique words): " + result);
    }

    // 5. Custom: Flatten all project names from a list of Employee objects.
    public static void flattenEmployeeProjects(List<Employee> employees) {
        System.out.println("Input: " + employees);
        List<String> result = employees.stream()
                .flatMap(e -> e.projects.stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Output (all unique projects): " + result);
    }

    // 6. Custom: Flatten all unique characters from a list of Employee names.
    public static void flattenEmployeeNameCharacters(List<Employee> employees) {
        System.out.println("Input: " + employees);
        Set<Character> result = employees.stream()
                .flatMap(e -> e.name.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toSet());
        System.out.println("Output (unique name characters): " + result);
    }

    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8)
        );
        List<String> sentences = Arrays.asList(
            "Java streams are powerful",
            "Practice makes perfect"
        );
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", Arrays.asList("Java", "Spring", "SQL"), Arrays.asList("Payroll", "Recruitment")),
            new Employee("Bob", Arrays.asList("Java", "React", "AWS"), Arrays.asList("Inventory", "Payroll")),
            new Employee("Charlie", Arrays.asList("Python", "SQL", "AWS"), Arrays.asList("Analytics", "Inventory"))
        );
        List<List<String>> paragraphs = Arrays.asList(
            Arrays.asList("Java is great", "Streams are cool"),
            Arrays.asList("Practice Java streams", "Streams are powerful")
        );
        flattenListOfLists(listOfLists);
        splitSentencesToWords(sentences);
        flattenEmployeeSkills(employees);
        uniqueWordsFromParagraphs(paragraphs);
        flattenEmployeeProjects(employees);
        flattenEmployeeNameCharacters(employees);
    }
} 