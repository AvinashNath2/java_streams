# Java Streams Tutorial & Reference

## Introduction

Java Streams were introduced in **Java 8** as part of the java.util.stream package. They revolutionized data processing in Java by enabling **functional-style operations** on collections, such as filtering, mapping, and reducing, in a declarative and concise manner. Streams allow you to process data in a pipeline, making code more readable and expressive.

## Why Streams?
- **Functional Programming:** Streams bring functional programming concepts (like map, filter, reduce) to Java, allowing you to write more declarative code.
- **Conciseness:** Stream operations are often more concise than traditional loops.
- **Readability:** Stream pipelines clearly express the intent of data transformations.
- **Parallel Processing:** Streams can be easily parallelized for multicore performance gains.
- **Chaining:** Multiple operations can be chained together in a single pipeline.

## Limitations & Disadvantages
- **One-time Use:** Streams cannot be reused after a terminal operation.
- **Debugging Difficulty:** Stream pipelines can be harder to debug than imperative code.
- **Performance:** In some cases, especially with small collections or simple operations, traditional loops may outperform streams.
- **Stateful/Imperative Logic:** Streams are not ideal for deeply imperative or stateful logic.
- **Side Effects:** Streams are designed for stateless operations; using side effects can lead to bugs.

## When to Use Streams
- When you need to transform, filter, or aggregate data in collections.
- For readable, declarative data processing pipelines.
- When you want to leverage parallel processing easily.

## When Not to Use Streams
- In performance-critical code where micro-optimization is required.
- When you need to reuse the same data pipeline multiple times.
- For deeply imperative, stateful, or side-effect-heavy logic.
- When debugging complex logic is a priority.

---

## Stream Operations Overview

Stream operations are divided into two main types:

### 1. Intermediate Operations
- **Transform the stream** (return another stream)
- **Lazy** (executed only when a terminal operation is invoked)
- Examples: `map`, `filter`, `sorted`, `distinct`, `flatMap`, `peek`, `limit`, `skip`

### 2. Terminal Operations
- **Trigger processing** and produce a result or side effect
- **Close the stream** (cannot be reused)
- Examples: `collect`, `reduce`, `forEach`, `count`, `min`, `max`, `anyMatch`, `allMatch`, `noneMatch`, `findFirst`, `findAny`, `toArray`

---

## Example Classes & Practice Problems

Each example class in this project:
- Focuses on a specific stream operation
- Begins with a detailed comment section listing practice problems (from basic to advanced/interview level, including custom object scenarios)
- Contains methods that solve each problem, printing both the input and output to visualize the transformation
- Includes a `main` method with sample input to demonstrate all examples

### Intermediate Operations

#### [Map_Example.java](src/main/java/streams/IntermediateOperations/Map_Example.java)
**Demonstrates:** Mapping elements (e.g., squaring numbers, uppercasing strings, extracting fields from objects, mapping custom Employee objects to various properties)

**Practice Problems:**
- Convert a list of integers to their squares
- Convert a list of strings to uppercase
- Extract names from a list of Employee objects
- Add 10 to each element in a list
- Convert a list of strings to their lengths
- Advanced: Word counts for sentences, mapping Employee departments, name lengths
- Custom: Map Employee list to their initials
- Custom: Map Employee list to salary bands (e.g., "Low", "Medium", "High")
- Custom: Map Employee list to name-department pairs (e.g., "Alice-HR")

#### [Filter_Example.java](src/main/java/streams/IntermediateOperations/Filter_Example.java)
**Demonstrates:** Filtering elements based on predicates (e.g., even numbers, string patterns, custom object fields, advanced Employee filtering)

**Practice Problems:**
- Filter even numbers
- Filter strings by starting letter
- Filter employees by salary
- Remove null/empty strings
- Advanced: Filter primes, filter employees by department and age
- Custom: Filter employees whose name starts with a given letter
- Custom: Filter employees in a salary band (e.g., Medium)
- Custom: Filter employees with age between 25 and 35 and in Engineering

#### [Sorted_Example.java](src/main/java/streams/IntermediateOperations/Sorted_Example.java)
**Demonstrates:** Sorting elements (natural order, custom comparators, multi-field sort, custom Employee sorting)

**Practice Problems:**
- Sort integers ascending
- Sort strings alphabetically
- Sort employees by age
- Sort integers descending
- Advanced: Sort employees by department and salary
- Custom: Sort employees by name alphabetically
- Custom: Sort employees by salary ascending
- Custom: Sort employees by age, then by name

#### [Distinct_Example.java](src/main/java/streams/IntermediateOperations/Distinct_Example.java)
**Demonstrates:** Removing duplicates (including custom object deduplication, Employee deduplication by various fields)

**Practice Problems:**
- Remove duplicates from integers
- Remove duplicate strings (case-insensitive)
- Advanced: Remove duplicate employees by ID
- Custom: Remove duplicate employees by name
- Custom: Remove duplicate employees by both name and id

#### [FlatMap_Example.java](src/main/java/streams/IntermediateOperations/FlatMap_Example.java)
**Demonstrates:** Flattening nested structures (lists of lists, splitting sentences, extracting skills and projects from Employee objects, unique character extraction)

**Practice Problems:**
- Flatten a list of lists
- Split sentences into words
- Advanced: Flatten employee skills, unique words from paragraphs
- Custom: Flatten all project names from a list of Employee objects
- Custom: Flatten all unique characters from a list of Employee names

#### [Peek_Example.java](src/main/java/streams/IntermediateOperations/Peek_Example.java)
**Demonstrates:** Using `peek` for debugging, logging, auditing, and counting elements in a stream pipeline.

**Practice Problems:**
- Log each element as it passes through the stream
- Debug transformations in a stream pipeline
- Advanced: Use peek to collect elements into a side list for auditing
- Custom: Use peek to count how many elements pass a certain stage

#### [LimitSkip_Example.java](src/main/java/streams/IntermediateOperations/LimitSkip_Example.java)
**Demonstrates:** Using `limit` and `skip` for slicing, pagination, and custom object scenarios.

**Practice Problems:**
- Get the first 3 elements of a list using limit
- Skip the first 2 elements and process the rest
- Advanced: Paginate a list using skip and limit
- Custom: Get the top 2 highest paid employees
- Custom: Skip the first employee in each department (grouped by department)

### Terminal Operations

#### [Collect_Example.java](src/main/java/streams/TerminalOperations/Collect_Example.java)
**Demonstrates:** Collecting results (to Set, String, grouping, partitioning)

**Practice Problems:**
- Collect integers to Set
- Concatenate strings
- Partition numbers even/odd
- Group strings by length
- Advanced: Group employees by department, partition by salary

#### [Reduce_Example.java](src/main/java/streams/TerminalOperations/Reduce_Example.java)
**Demonstrates:** Reducing streams to a single value (sum, max, product, custom object reduction)

**Practice Problems:**
- Sum numbers
- Find max
- Concatenate strings
- Advanced: Product of numbers, employee with highest salary

#### [MinMax_Example.java](src/main/java/streams/TerminalOperations/MinMax_Example.java)
**Demonstrates:** Finding minimum and maximum values in collections, including custom objects and advanced scenarios.

**Practice Problems:**
- Find the minimum value in a list
- Find the maximum value in a list
- Find the employee with the highest salary
- Custom: Find the employee with the lowest age
- Custom: Find the string with the maximum length

#### [Count_Example.java](src/main/java/streams/TerminalOperations/Count_Example.java)
**Demonstrates:** Counting elements in collections, including custom objects and advanced scenarios.

**Practice Problems:**
- Count the number of elements in a list
- Count the number of strings longer than 5 characters
- Custom: Count the number of employees in Engineering
- Custom: Count the number of employees with salary > 75000
- Custom: Count the number of unique departments

#### [ForEach_Example.java](src/main/java/streams/TerminalOperations/ForEach_Example.java)
**Demonstrates:** Iterating over elements, printing, and performing actions on custom objects and advanced scenarios.

**Practice Problems:**
- Print each element in a list
- Print each employee’s name and salary
- Advanced: Print all strings in reverse order
- Custom: Print all employees in a specific department
- Custom: Print all employees with salary above a threshold

#### [MatchFind_Example.java](src/main/java/streams/TerminalOperations/MatchFind_Example.java)
**Demonstrates:** Using `anyMatch`, `allMatch`, `noneMatch`, `findFirst`, and `findAny` for matching and searching, including custom object scenarios.

**Practice Problems:**
- Check if any number in a list is even (anyMatch)
- Check if all strings are non-empty (allMatch)
- Check if no employee is under 18 (noneMatch)
- Find the first string that starts with 'A' (findFirst)
- Find any employee in Engineering (findAny)
- Custom: Check if all employees in a department have salary > 70000
- Custom: Find the first employee with salary > 80000

#### [ToArray_Example.java](src/main/java/streams/TerminalOperations/ToArray_Example.java)
**Demonstrates:** Using `toArray` to convert streams to arrays for primitives, strings, and custom objects.

**Practice Problems:**
- Convert a list of integers to an Integer array
- Convert a list of strings to a String array
- Advanced: Convert a list of Employee objects to an Employee array
- Custom: Convert a stream of uppercase strings to an array

---

## How to Use This Project

- Browse each example class for detailed explanations and practice problems
- Run the `main` method in any class to see input/output for each example
- Use the practice problems to master both basic and advanced/interview-level stream usage

---

## Contributing

Feel free to add more example classes, expand practice problems, or improve documentation to help others learn Java Streams!