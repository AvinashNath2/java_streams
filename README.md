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

## Sample Problems with Input/Output Examples

**How to use this table:**
- Each row shows a sample problem, input, output, and the function name.
- The function is implemented in the corresponding Example class (linked in the Function Name column).
- The "Sample Problem" column matches the full practice problem name as listed in the Example class's comment section.
- Click the Example class link to see the full code and all related methods.

### Map Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Convert a list of integers to their squares | `[1, 2, 3, 4, 5]` | `[1, 4, 9, 16, 25]` | [`squareIntegers()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Convert a list of strings to uppercase | `["apple", "banana", "cherry"]` | `["APPLE", "BANANA", "CHERRY"]` | [`toUpperCase()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Given a list of Employee objects, extract their names | `[Alice(30, HR, $60000), Bob(25, Engineering, $80000)]` | `["Alice", "Bob"]` | [`extractEmployeeNames()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Add 10 to each element in a list | `[1, 2, 3, 4, 5]` | `[11, 12, 13, 14, 15]` | [`addTen()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Convert a list of strings to their lengths | `["apple", "banana", "cherry"]` | `[5, 6, 6]` | [`stringLengths()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Advanced: Given a list of sentences, return a list of word counts for each sentence | `["Hello world", "Java streams are powerful"]` | `[2, 4]` | [`sentenceWordCounts()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Advanced: Map Employee list to their department names in uppercase (interview-level) | `[Alice(HR), Bob(Engineering)]` | `["HR", "ENGINEERING"]` | [`employeeDepartmentsUpper()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Advanced: Map Employee list to a stream of their name lengths (interview-level) | `[Alice, Bob]` | `[5, 3]` | [`employeeNameLengths()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Custom: Map Employee list to their initials | `[Alice, Bob]` | `["A", "B"]` | [`employeeInitials()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Custom: Map Employee list to salary bands (e.g., "Low", "Medium", "High") | `[Alice($60000), Bob($80000), Diana($90000)]` | `["Low", "Medium", "High"]` | [`employeeSalaryBands()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Custom: Map Employee list to name-department pairs (e.g., "Alice-HR") | `[Alice(HR), Bob(Engineering)]` | `["Alice-HR", "Bob-Engineering"]` | [`employeeNameDepartmentPairs()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |

### Filter Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Filter even numbers from a list | `[1, 2, 3, 4, 5, 6]` | `[2, 4, 6]` | [`filterEvenNumbers()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| Filter strings that start with a specific letter | `["apple", "banana", "cherry", "avocado"]` | `["apple", "avocado"]` | [`filterByStartingLetter()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| Filter employees with salary > 50,000 | `[Alice($60000), Bob($80000), Charlie($75000)]` | `[Bob($80000), Charlie($75000)]` | [`filterHighSalaryEmployees()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| Remove null or empty strings from a list | `["apple", "", null, "banana"]` | `["apple", "banana"]` | [`removeNullOrEmpty()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| Advanced: Filter prime numbers from a list | `[1, 2, 3, 4, 5, 11, 13, 17, 20]` | `[2, 3, 5, 11, 13, 17]` | [`filterPrimes()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| Advanced: Filter employees in a specific department and above a certain age | `[Alice(HR), Bob(Engineering), Charlie(Engineering)]` | `[Bob(Engineering), Charlie(Engineering)]` | [`filterEmployeesByDeptAndAge()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| Custom: Filter employees whose name starts with a given letter | `[Alice, Bob, Charlie]` | `[Alice]` | [`filterEmployeesByNameStart()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| Custom: Filter employees in a salary band (e.g., Medium) | `[Alice($60000), Bob($80000), Diana($90000)]` | `[Bob($80000)]` | [`filterEmployeesBySalaryBand()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| Custom: Filter employees with age between 25 and 35 and in Engineering | `[Alice(30,HR), Bob(25,Engineering), Charlie(28,Engineering)]` | `[Bob(25,Engineering), Charlie(28,Engineering)]` | [`filterEmployeesByAgeAndDept()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |

### Sorted Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Sort a list of integers in ascending order | `[5, 2, 8, 1, 3]` | `[1, 2, 3, 5, 8]` | [`sortIntegers()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| Sort a list of strings alphabetically | `["banana", "apple", "cherry"]` | `["apple", "banana", "cherry"]` | [`sortStrings()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| Sort employees by age | `[Alice(30), Bob(25), Charlie(28)]` | `[Bob(25), Charlie(28), Alice(30)]` | [`sortEmployeesByAge()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| Sort a list in reverse order | `[1, 2, 3, 4, 5]` | `[5, 4, 3, 2, 1]` | [`sortIntegersDescending()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| Advanced: Sort employees by department, then by salary descending | `[Alice(HR,$60k), Bob(Eng,$80k), Charlie(Eng,$75k)]` | `[Charlie(Eng,$75k), Bob(Eng,$80k), Alice(HR,$60k)]` | [`sortEmployeesByDeptAndSalary()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| Custom: Sort employees by name alphabetically | `[Alice, Bob, Charlie]` | `[Alice, Bob, Charlie]` | [`sortEmployeesByName()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| Custom: Sort employees by salary ascending | `[Alice($60k), Bob($80k), Charlie($75k)]` | `[Alice($60k), Charlie($75k), Bob($80k)]` | [`sortEmployeesBySalary()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| Custom: Sort employees by age, then by name | `[Alice(30), Bob(25), Charlie(28)]` | `[Bob(25), Charlie(28), Alice(30)]` | [`sortEmployeesByAgeThenName()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |

### Distinct Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Remove duplicates from a list of integers | `[1, 2, 2, 3, 4, 4, 5]` | `[1, 2, 3, 4, 5]` | [`removeDuplicates()`](src/main/java/streams/IntermediateOperations/Distinct_Example.java) |
| Remove duplicate strings (case-insensitive) | `["Apple", "Banana", "apple", "banana"]` | `["Apple", "Banana"]` | [`removeDuplicateStringsIgnoreCase()`](src/main/java/streams/IntermediateOperations/Distinct_Example.java) |
| Advanced: Remove duplicate Employee objects based on employee ID | `[Alice(ID:1), Bob(ID:2), Charlie(ID:1)]` | `[Alice(ID:1), Bob(ID:2)]` | [`removeDuplicateEmployeesById()`](src/main/java/streams/IntermediateOperations/Distinct_Example.java) |
| Custom: Remove duplicate Employee objects based on name | `[Alice(ID:1), Bob(ID:2), Alice(ID:3)]` | `[Alice(ID:1), Bob(ID:2)]` | [`removeDuplicateEmployeesByName()`](src/main/java/streams/IntermediateOperations/Distinct_Example.java) |
| Custom: Remove duplicate Employee objects based on both name and id | `[Alice(ID:1), Bob(ID:2), Alice(ID:1)]` | `[Alice(ID:1), Bob(ID:2)]` | [`removeDuplicateEmployeesByNameAndId()`](src/main/java/streams/IntermediateOperations/Distinct_Example.java) |

### FlatMap Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Flatten a list of lists of integers | `[[1,2,3], [4,5], [6,7,8]]` | `[1, 2, 3, 4, 5, 6, 7, 8]` | [`flattenListOfLists()`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) |
| Split a list of sentences into words | `["Hello world", "Java streams"]` | `["Hello", "world", "Java", "streams"]` | [`splitSentencesToWords()`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) |
| Advanced: Flatten a list of Employee objects, each with a list of skills, into a list of skills | `[Alice([Java,Spring]), Bob([Java,React])]` | `[Java, Spring, Java, React]` | [`flattenEmployeeSkills()`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) |
| Advanced: Given a list of paragraphs (list of sentences), return a list of all unique words | `[["Java is great", "Streams are cool"], ["Practice Java streams"]]` | `["java", "is", "great", "streams", "are", "cool", "practice"]` | [`uniqueWordsFromParagraphs()`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) |
| Custom: Flatten all project names from a list of Employee objects | `[Alice([Payroll,Recruitment]), Bob([Inventory,Payroll])]` | `[Payroll, Recruitment, Inventory]` | [`flattenEmployeeProjects()`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) |
| Custom: Flatten all unique characters from a list of Employee names | `[Alice, Bob]` | `[A, l, i, c, e, B, o, b]` | [`flattenEmployeeNameCharacters()`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) |

### Peek Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Log each element as it passes through the stream | `[1, 2, 3, 4, 5]` | `Peek: 1, Peek: 2, ...` + `[2, 4, 6, 8, 10]` | [`logElements()`](src/main/java/streams/IntermediateOperations/Peek_Example.java) |
| Debug transformations in a stream pipeline | `["apple", "banana"]` | `Original: apple, Uppercased: APPLE, ...` + `[APPLE, BANANA]` | [`debugPipeline()`](src/main/java/streams/IntermediateOperations/Peek_Example.java) |
| Advanced: Use peek to collect elements into a side list for auditing | `[1, 2, 3]` | `[2, 3, 4]` + `Audit trail: [1, 2, 3]` | [`auditElements()`](src/main/java/streams/IntermediateOperations/Peek_Example.java) |
| Custom: Use peek to count how many elements pass a certain stage | `[1, 2, 3, 4, 5]` | `[2, 4]` + `Count of evens: 2` | [`countPassingElements()`](src/main/java/streams/IntermediateOperations/Peek_Example.java) |

### Limit/Skip Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Get the first 3 elements of a list using limit | `[1, 2, 3, 4, 5, 6, 7]` | `[1, 2, 3]` | [`firstThree()`](src/main/java/streams/IntermediateOperations/LimitSkip_Example.java) |
| Skip the first 2 elements and process the rest | `["apple", "banana", "cherry", "date"]` | `["cherry", "date"]` | [`skipTwo()`](src/main/java/streams/IntermediateOperations/LimitSkip_Example.java) |
| Advanced: Paginate a list using skip and limit | `[1, 2, 3, 4, 5, 6, 7]` | `[4, 5, 6]` | [`paginate()`](src/main/java/streams/IntermediateOperations/LimitSkip_Example.java) |
| Custom: Get the top 2 highest paid employees | `[Alice($60k), Bob($80k), Charlie($75k), Diana($90k)]` | `[Diana($90k), Bob($80k)]` | [`topTwoHighestPaid()`](src/main/java/streams/IntermediateOperations/LimitSkip_Example.java) |
| Custom: Skip the first employee in each department (grouped by department) | `[Alice(HR), Bob(Eng), Charlie(Eng), Diana(Finance)]` | `[Charlie(Eng), Diana(Finance)]` | [`skipFirstInEachDepartment()`](src/main/java/streams/IntermediateOperations/LimitSkip_Example.java) |

### Collect Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Collect a list of integers into a Set | `[1, 2, 3, 4, 5, 6, 7, 8]` | `{1, 2, 3, 4, 5, 6, 7, 8}` | [`collectToSet()`](src/main/java/streams/TerminalOperations/Collect_Example.java) |
| Collect a list of strings into a single concatenated string | `["apple", "banana", "cherry", "date"]` | `"apple, banana, cherry, date"` | [`concatenateStrings()`](src/main/java/streams/TerminalOperations/Collect_Example.java) |
| Partition a list of numbers into even and odd | `[1, 2, 3, 4, 5, 6, 7, 8]` | `{false=[1,3,5,7], true=[2,4,6,8]}` | [`partitionEvenOdd()`](src/main/java/streams/TerminalOperations/Collect_Example.java) |
| Group a list of strings by their length | `["apple", "banana", "cherry", "date"]` | `{4=[date], 5=[apple], 6=[banana, cherry]}` | [`groupByLength()`](src/main/java/streams/TerminalOperations/Collect_Example.java) |
| Advanced: Group a list of Employee objects by department | `[Alice(HR), Bob(Eng), Charlie(Eng), Diana(Finance)]` | `{HR=[Alice], Engineering=[Bob,Charlie], Finance=[Diana]}` | [`groupEmployeesByDepartment()`](src/main/java/streams/TerminalOperations/Collect_Example.java) |
| Advanced: Partition employees by salary > 75000 | `[Alice($60k), Bob($80k), Charlie($75k), Diana($90k)]` | `{false=[Alice,Charlie], true=[Bob,Diana]}` | [`partitionEmployeesBySalary()`](src/main/java/streams/TerminalOperations/Collect_Example.java) |

### Reduce Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Sum all numbers in a list | `[1, 2, 3, 4, 5]` | `15` | [`sumNumbers()`](src/main/java/streams/TerminalOperations/Reduce_Example.java) |
| Find the maximum value in a list | `[1, 2, 3, 4, 5]` | `5` | [`findMax()`](src/main/java/streams/TerminalOperations/Reduce_Example.java) |
| Concatenate all strings in a list | `["apple", "banana", "cherry"]` | `"applebananacherry"` | [`concatenateStrings()`](src/main/java/streams/TerminalOperations/Reduce_Example.java) |
| Advanced: Find the product of all numbers in a list | `[1, 2, 3, 4, 5]` | `120` | [`productNumbers()`](src/main/java/streams/TerminalOperations/Reduce_Example.java) |
| Advanced: Find the employee with the highest salary | `[Alice($60k), Bob($80k), Charlie($75k)]` | `Bob ($80k)` | [`employeeWithHighestSalary()`](src/main/java/streams/TerminalOperations/Reduce_Example.java) |

### Min/Max Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Find the minimum value in a list | `[5, 2, 8, 1, 3]` | `1` | [`findMin()`](src/main/java/streams/TerminalOperations/MinMax_Example.java) |
| Find the maximum value in a list | `[5, 2, 8, 1, 3]` | `8` | [`findMax()`](src/main/java/streams/TerminalOperations/MinMax_Example.java) |
| Find the employee with the highest salary | `[Alice($60k), Bob($80k), Charlie($75k)]` | `Bob ($80k)` | [`employeeWithHighestSalary()`](src/main/java/streams/TerminalOperations/MinMax_Example.java) |
| Custom: Find the employee with the lowest age | `[Alice(30), Bob(25), Charlie(28)]` | `Bob (25)` | [`employeeWithLowestAge()`](src/main/java/streams/TerminalOperations/MinMax_Example.java) |
| Custom: Find the string with the maximum length | `["banana", "apple", "cherry", "date"]` | `"banana"` | [`stringWithMaxLength()`](src/main/java/streams/TerminalOperations/MinMax_Example.java) |

### Count Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Count the number of elements in a list | `[1, 2, 3, 4, 5, 6, 7]` | `7` | [`countElements()`](src/main/java/streams/TerminalOperations/Count_Example.java) |
| Count the number of strings longer than 5 characters | `["apple", "banana", "cherry", "date", "elderberry"]` | `3` | [`countLongStrings()`](src/main/java/streams/TerminalOperations/Count_Example.java) |
| Custom: Count the number of employees in Engineering | `[Alice(HR), Bob(Eng), Charlie(Eng), Diana(Finance)]` | `2` | [`countEngineeringEmployees()`](src/main/java/streams/TerminalOperations/Count_Example.java) |
| Custom: Count the number of employees with salary > 75000 | `[Alice($60k), Bob($80k), Charlie($75k), Diana($90k)]` | `3` | [`countHighSalaryEmployees()`](src/main/java/streams/TerminalOperations/Count_Example.java) |
| Custom: Count the number of unique departments | `[Alice(HR), Bob(Eng), Charlie(Eng), Diana(Finance)]` | `3` | [`countUniqueDepartments()`](src/main/java/streams/TerminalOperations/Count_Example.java) |

### ForEach Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Print each element in a list | `[1, 2, 3, 4, 5]` | `Element: 1, Element: 2, ...` | [`printElements()`](src/main/java/streams/TerminalOperations/ForEach_Example.java) |
| Print each employee’s name and salary | `[Alice($60k), Bob($80k)]` | `Alice: $60000, Bob: $80000` | [`printEmployeeNameSalary()`](src/main/java/streams/TerminalOperations/ForEach_Example.java) |
| Advanced: Print all strings in reverse order | `["apple", "banana", "cherry", "date"]` | `Reverse: date, Reverse: cherry, ...` | [`printReverse()`](src/main/java/streams/TerminalOperations/ForEach_Example.java) |
| Custom: Print all employees in a specific department | `[Alice(HR), Bob(Eng), Charlie(Eng)]` | `Bob (Engineering), Charlie (Engineering)` | [`printEmployeesInDepartment()`](src/main/java/streams/TerminalOperations/ForEach_Example.java) |
| Custom: Print all employees with salary above a threshold | `[Alice($60k), Bob($80k), Charlie($75k)]` | `Bob ($80k), Charlie ($75k)` | [`printHighSalaryEmployees()`](src/main/java/streams/TerminalOperations/ForEach_Example.java) |

### Match/Find Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Check if any number in a list is even (anyMatch) | `[1, 3, 5, 7, 8]` | `true` | [`anyEven()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |
| Check if all strings are non-empty (allMatch) | `["Apple", "Banana", "", "Avocado"]` | `false` | [`allNonEmpty()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |
| Check if no employee is under 18 (noneMatch) | `[Alice(30), Bob(25), Charlie(28)]` | `true` | [`noneUnder18()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |
| Find the first string that starts with 'A' (findFirst) | `["Apple", "Banana", "Avocado"]` | `"Apple"` | [`findFirstA()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |
| Find any employee in Engineering (findAny) | `[Alice(HR), Bob(Engineering), Charlie(Engineering)]` | `Bob (Engineering)` | [`findAnyEngineering()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |
| Custom: Check if all employees in a department have salary > 70000 | `[Alice($60k), Bob($80k), Charlie($75k)]` | `false` | [`allSalaryAbove()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |
| Custom: Find the first employee with salary > 80000 | `[Alice($60k), Bob($80k), Charlie($75k)]` | `Bob ($80k)` | [`findFirstSalaryAbove()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |

### ToArray Operations
| Sample Problem (as in Example class) | Input | Output | Function Name |
|--------------------------------------|-------|--------|---------------|
| Convert a list of integers to an Integer array | `[1, 2, 3, 4, 5]` | `[1, 2, 3, 4, 5]` | [`toIntegerArray()`](src/main/java/streams/TerminalOperations/ToArray_Example.java) |
| Convert a list of strings to a String array | `["apple", "banana", "cherry"]` | `["apple", "banana", "cherry"]` | [`toStringArray()`](src/main/java/streams/TerminalOperations/ToArray_Example.java) |
| Advanced: Convert a list of Employee objects to an Employee array | `[Alice(30,HR,$60k), Bob(25,Eng,$80k)]` | `[Alice(30,HR,$60k), Bob(25,Eng,$80k)]` | [`toEmployeeArray()`](src/main/java/streams/TerminalOperations/ToArray_Example.java) |
| Custom: Convert a stream of uppercase strings to an array | `["apple", "banana", "cherry"]` | `["APPLE", "BANANA", "CHERRY"]` | [`uppercaseToArray()`](src/main/java/streams/TerminalOperations/ToArray_Example.java) |

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
- Given a list of Employee objects, extract their names
- Add 10 to each element in a list
- Convert a list of strings to their lengths
- Advanced: Word counts for sentences, mapping Employee departments, name lengths
- Custom: Map Employee list to their initials
- Custom: Map Employee list to salary bands (e.g., "Low", "Medium", "High")
- Custom: Map Employee list to name-department pairs (e.g., "Alice-HR")

#### [Filter_Example.java](src/main/java/streams/IntermediateOperations/Filter_Example.java)
**Demonstrates:** Filtering elements based on predicates (e.g., even numbers, string patterns, custom object fields, advanced Employee filtering)

**Practice Problems:**
- Filter even numbers from a list
- Filter strings that start with a specific letter
- Filter employees with salary > 50,000
- Remove null or empty strings from a list
- Advanced: Filter prime numbers from a list
- Advanced: Filter employees in a specific department and above a certain age
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
- Print each employee's name and salary
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