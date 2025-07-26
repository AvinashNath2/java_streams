# 🚀 Java Streams Tutorial & Reference

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Streams](https://img.shields.io/badge/Streams-API-007396?style=for-the-badge&logo=java&logoColor=white)
![Functional Programming](https://img.shields.io/badge/Functional-Programming-FF6B6B?style=for-the-badge)
![Tutorial](https://img.shields.io/badge/Tutorial-Complete-4CAF50?style=for-the-badge)

*A comprehensive guide from basics to advanced interview-level Java Streams operations* ✨

</div>

<div align="center">

**⚠️ IMPORTANT: This repository is protected by copyright. Please fork this repository instead of copying content directly.**

[![Fork](https://img.shields.io/badge/Fork-This%20Repo-FF6B6B?style=for-the-badge&logo=github)](https://github.com/yourusername/java_streams/fork)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://opensource.org/licenses/MIT)
[![Issues](https://img.shields.io/badge/Issues-Welcome-4CAF50?style=for-the-badge&logo=github)](https://github.com/yourusername/java_streams/issues)
[![Contributions](https://img.shields.io/badge/Contributions-Welcome-FF6B6B?style=for-the-badge&logo=github)](https://github.com/yourusername/java_streams/pulls)

**© 2024 Java Streams Tutorial. All rights reserved.**

</div>

---

## 📖 Introduction

Java Streams were introduced in **Java 8** as part of the `java.util.stream` package. They revolutionized data processing in Java by enabling **functional-style operations** on collections, such as filtering, mapping, and reducing, in a declarative and concise manner. Streams allow you to process data in a pipeline, making code more readable and expressive.

### 🎯 Why Streams?
- **🔄 Functional Programming:** Streams bring functional programming concepts (like map, filter, reduce) to Java, allowing you to write more declarative code.
- **📝 Conciseness:** Stream operations are often more concise than traditional loops.
- **👁️ Readability:** Stream pipelines clearly express the intent of data transformations.
- **⚡ Parallel Processing:** Streams can be easily parallelized for multicore performance gains.
- **🔗 Chaining:** Multiple operations can be chained together in a single pipeline.

### ⚠️ Limitations & Disadvantages
- **🚫 One-time Use:** Streams cannot be reused after a terminal operation.
- **🐛 Debugging Difficulty:** Stream pipelines can be harder to debug than imperative code.
- **📊 Performance:** In some cases, especially with small collections or simple operations, traditional loops may outperform streams.
- **🔄 Stateful/Imperative Logic:** Streams are not ideal for deeply imperative or stateful logic.
- **💥 Side Effects:** Streams are designed for stateless operations; using side effects can lead to bugs.

### 🎯 When to Use Streams
- ✅ When you need to transform, filter, or aggregate data in collections.
- ✅ For readable, declarative data processing pipelines.
- ✅ When you want to leverage parallel processing easily.

### ❌ When Not to Use Streams
- ❌ In performance-critical code where micro-optimization is required.
- ❌ When you need to reuse the same data pipeline multiple times.
- ❌ For deeply imperative, stateful, or side-effect-heavy logic.
- ❌ When debugging complex logic is a priority.

---

## 🔄 Stream Operations Overview

Stream operations are divided into two main types:

### 🔄 Intermediate Operations
- **Transform the stream** (return another stream)
- **Lazy** (executed only when a terminal operation is invoked)
- Examples: `map`, `filter`, `sorted`, `distinct`, `flatMap`, `peek`, `limit`, `skip`

### 🎯 Terminal Operations
- **Trigger processing** and produce a result or side effect
- **Close the stream** (cannot be reused)
- Examples: `collect`, `reduce`, `forEach`, `count`, `min`, `max`, `anyMatch`, `allMatch`, `noneMatch`, `findFirst`, `findAny`, `toArray`

---

## 📊 Sample Problems with Input/Output Examples

<div align="center">

### 🎯 How to use this table:
- Each row shows a sample problem, input, output, and the function name.
- The function is implemented in the corresponding Example class (linked in the Function Name column).
- The "Sample Problem" column matches the full practice problem name as listed in the Example class's comment section.
- Click the Example class link to see the full code and all related methods.

</div>

### 🔄 Map Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Convert a list of integers to their squares | `[1, 2, 3, 4, 5]` | `[1, 4, 9, 16, 25]` | [`squareIntegers()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Convert a list of strings to uppercase | `["apple", "banana", "cherry"]` | `["APPLE", "BANANA", "CHERRY"]` | [`toUpperCase()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Given a list of Employee objects, extract their names | `[Alice(30, HR, $60000), Bob(25, Engineering, $80000)]` | `["Alice", "Bob"]` | [`extractEmployeeNames()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Add 10 to each element in a list | `[1, 2, 3, 4, 5]` | `[11, 12, 13, 14, 15]` | [`addTen()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| Convert a list of strings to their lengths | `["apple", "banana", "cherry"]` | `[5, 6, 6]` | [`stringLengths()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| **Advanced:** Given a list of sentences, return a list of word counts for each sentence | `["Hello world", "Java streams are powerful"]` | `[2, 4]` | [`sentenceWordCounts()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| **Advanced:** Map Employee list to their department names in uppercase (interview-level) | `[Alice(HR), Bob(Engineering)]` | `["HR", "ENGINEERING"]` | [`employeeDepartmentsUpper()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| **Advanced:** Map Employee list to a stream of their name lengths (interview-level) | `[Alice, Bob]` | `[5, 3]` | [`employeeNameLengths()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| **Custom:** Map Employee list to their initials | `[Alice, Bob]` | `["A", "B"]` | [`employeeInitials()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| **Custom:** Map Employee list to salary bands (e.g., "Low", "Medium", "High") | `[Alice($60000), Bob($80000), Diana($90000)]` | `["Low", "Medium", "High"]` | [`employeeSalaryBands()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |
| **Custom:** Map Employee list to name-department pairs (e.g., "Alice-HR") | `[Alice(HR), Bob(Engineering)]` | `["Alice-HR", "Bob-Engineering"]` | [`employeeNameDepartmentPairs()`](src/main/java/streams/IntermediateOperations/Map_Example.java) |

### 🔍 Filter Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Filter even numbers from a list | `[1, 2, 3, 4, 5, 6]` | `[2, 4, 6]` | [`filterEvenNumbers()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| Filter strings that start with a specific letter | `["apple", "banana", "cherry", "avocado"]` | `["apple", "avocado"]` | [`filterByStartingLetter()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| Filter employees with salary > 50,000 | `[Alice($60000), Bob($80000), Charlie($75000)]` | `[Bob($80000), Charlie($75000)]` | [`filterHighSalaryEmployees()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| Remove null or empty strings from a list | `["apple", "", null, "banana"]` | `["apple", "banana"]` | [`removeNullOrEmpty()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| **Advanced:** Filter prime numbers from a list | `[1, 2, 3, 4, 5, 11, 13, 17, 20]` | `[2, 3, 5, 11, 13, 17]` | [`filterPrimes()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| **Advanced:** Filter employees in a specific department and above a certain age | `[Alice(HR), Bob(Engineering), Charlie(Engineering)]` | `[Bob(Engineering), Charlie(Engineering)]` | [`filterEmployeesByDeptAndAge()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| **Custom:** Filter employees whose name starts with a given letter | `[Alice, Bob, Charlie]` | `[Alice]` | [`filterEmployeesByNameStart()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| **Custom:** Filter employees in a salary band (e.g., Medium) | `[Alice($60000), Bob($80000), Diana($90000)]` | `[Bob($80000)]` | [`filterEmployeesBySalaryBand()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |
| **Custom:** Filter employees with age between 25 and 35 and in Engineering | `[Alice(30,HR), Bob(25,Engineering), Charlie(28,Engineering)]` | `[Bob(25,Engineering), Charlie(28,Engineering)]` | [`filterEmployeesByAgeAndDept()`](src/main/java/streams/IntermediateOperations/Filter_Example.java) |

### 📊 Sorted Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Sort a list of integers in ascending order | `[5, 2, 8, 1, 3]` | `[1, 2, 3, 5, 8]` | [`sortIntegers()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| Sort a list of strings alphabetically | `["banana", "apple", "cherry"]` | `["apple", "banana", "cherry"]` | [`sortStrings()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| Sort employees by age | `[Alice(30), Bob(25), Charlie(28)]` | `[Bob(25), Charlie(28), Alice(30)]` | [`sortEmployeesByAge()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| Sort a list in reverse order | `[1, 2, 3, 4, 5]` | `[5, 4, 3, 2, 1]` | [`sortIntegersDescending()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| **Advanced:** Sort employees by department, then by salary descending | `[Alice(HR,$60k), Bob(Eng,$80k), Charlie(Eng,$75k)]` | `[Charlie(Eng,$75k), Bob(Eng,$80k), Alice(HR,$60k)]` | [`sortEmployeesByDeptAndSalary()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| **Custom:** Sort employees by name alphabetically | `[Alice, Bob, Charlie]` | `[Alice, Bob, Charlie]` | [`sortEmployeesByName()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| **Custom:** Sort employees by salary ascending | `[Alice($60k), Bob($80k), Charlie($75k)]` | `[Alice($60k), Charlie($75k), Bob($80k)]` | [`sortEmployeesBySalary()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |
| **Custom:** Sort employees by age, then by name | `[Alice(30), Bob(25), Charlie(28)]` | `[Bob(25), Charlie(28), Alice(30)]` | [`sortEmployeesByAgeThenName()`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) |

### 🎯 Distinct Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Remove duplicates from a list of integers | `[1, 2, 2, 3, 4, 4, 5]` | `[1, 2, 3, 4, 5]` | [`removeDuplicates()`](src/main/java/streams/IntermediateOperations/Distinct_Example.java) |
| Remove duplicate strings (case-insensitive) | `["Apple", "Banana", "apple", "banana"]` | `["Apple", "Banana"]` | [`removeDuplicateStringsIgnoreCase()`](src/main/java/streams/IntermediateOperations/Distinct_Example.java) |
| **Advanced:** Remove duplicate Employee objects based on employee ID | `[Alice(ID:1), Bob(ID:2), Charlie(ID:1)]` | `[Alice(ID:1), Bob(ID:2)]` | [`removeDuplicateEmployeesById()`](src/main/java/streams/IntermediateOperations/Distinct_Example.java) |
| **Custom:** Remove duplicate Employee objects based on name | `[Alice(ID:1), Bob(ID:2), Alice(ID:3)]` | `[Alice(ID:1), Bob(ID:2)]` | [`removeDuplicateEmployeesByName()`](src/main/java/streams/IntermediateOperations/Distinct_Example.java) |
| **Custom:** Remove duplicate Employee objects based on both name and id | `[Alice(ID:1), Bob(ID:2), Alice(ID:1)]` | `[Alice(ID:1), Bob(ID:2)]` | [`removeDuplicateEmployeesByNameAndId()`](src/main/java/streams/IntermediateOperations/Distinct_Example.java) |

### 🔗 FlatMap Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Flatten a list of lists of integers | `[[1,2,3], [4,5], [6,7,8]]` | `[1, 2, 3, 4, 5, 6, 7, 8]` | [`flattenListOfLists()`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) |
| Split a list of sentences into words | `["Hello world", "Java streams"]` | `["Hello", "world", "Java", "streams"]` | [`splitSentencesToWords()`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) |
| **Advanced:** Flatten a list of Employee objects, each with a list of skills, into a list of skills | `[Alice([Java,Spring]), Bob([Java,React])]` | `[Java, Spring, Java, React]` | [`flattenEmployeeSkills()`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) |
| **Advanced:** Given a list of paragraphs (list of sentences), return a list of all unique words | `[["Java is great", "Streams are cool"], ["Practice Java streams"]]` | `["java", "is", "great", "streams", "are", "cool", "practice"]` | [`uniqueWordsFromParagraphs()`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) |
| **Custom:** Flatten all project names from a list of Employee objects | `[Alice([Payroll,Recruitment]), Bob([Inventory,Payroll])]` | `[Payroll, Recruitment, Inventory]` | [`flattenEmployeeProjects()`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) |
| **Custom:** Flatten all unique characters from a list of Employee names | `[Alice, Bob]` | `[A, l, i, c, e, B, o, b]` | [`flattenEmployeeNameCharacters()`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) |

### 👁️ Peek Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Log each element as it passes through the stream | `[1, 2, 3, 4, 5]` | `Peek: 1, Peek: 2, ...` + `[2, 4, 6, 8, 10]` | [`logElements()`](src/main/java/streams/IntermediateOperations/Peek_Example.java) |
| Debug transformations in a stream pipeline | `["apple", "banana"]` | `Original: apple, Uppercased: APPLE, ...` + `[APPLE, BANANA]` | [`debugPipeline()`](src/main/java/streams/IntermediateOperations/Peek_Example.java) |
| **Advanced:** Use peek to collect elements into a side list for auditing | `[1, 2, 3]` | `[2, 3, 4]` + `Audit trail: [1, 2, 3]` | [`auditElements()`](src/main/java/streams/IntermediateOperations/Peek_Example.java) |
| **Custom:** Use peek to count how many elements pass a certain stage | `[1, 2, 3, 4, 5]` | `[2, 4]` + `Count of evens: 2` | [`countPassingElements()`](src/main/java/streams/IntermediateOperations/Peek_Example.java) |

### ⏹️ Limit/Skip Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Get the first 3 elements of a list using limit | `[1, 2, 3, 4, 5, 6, 7]` | `[1, 2, 3]` | [`firstThree()`](src/main/java/streams/IntermediateOperations/LimitSkip_Example.java) |
| Skip the first 2 elements and process the rest | `["apple", "banana", "cherry", "date"]` | `["cherry", "date"]` | [`skipTwo()`](src/main/java/streams/IntermediateOperations/LimitSkip_Example.java) |
| **Advanced:** Paginate a list using skip and limit | `[1, 2, 3, 4, 5, 6, 7]` | `[4, 5, 6]` | [`paginate()`](src/main/java/streams/IntermediateOperations/LimitSkip_Example.java) |
| **Custom:** Get the top 2 highest paid employees | `[Alice($60k), Bob($80k), Charlie($75k), Diana($90k)]` | `[Diana($90k), Bob($80k)]` | [`topTwoHighestPaid()`](src/main/java/streams/IntermediateOperations/LimitSkip_Example.java) |
| **Custom:** Skip the first employee in each department (grouped by department) | `[Alice(HR), Bob(Eng), Charlie(Eng), Diana(Finance)]` | `[Charlie(Eng), Diana(Finance)]` | [`skipFirstInEachDepartment()`](src/main/java/streams/IntermediateOperations/LimitSkip_Example.java) |

### 📦 Collect Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Collect a list of integers into a Set | `[1, 2, 3, 4, 5, 6, 7, 8]` | `{1, 2, 3, 4, 5, 6, 7, 8}` | [`collectToSet()`](src/main/java/streams/TerminalOperations/Collect_Example.java) |
| Collect a list of strings into a single concatenated string | `["apple", "banana", "cherry", "date"]` | `"apple, banana, cherry, date"` | [`concatenateStrings()`](src/main/java/streams/TerminalOperations/Collect_Example.java) |
| Partition a list of numbers into even and odd | `[1, 2, 3, 4, 5, 6, 7, 8]` | `{false=[1,3,5,7], true=[2,4,6,8]}` | [`partitionEvenOdd()`](src/main/java/streams/TerminalOperations/Collect_Example.java) |
| Group a list of strings by their length | `["apple", "banana", "cherry", "date"]` | `{4=[date], 5=[apple], 6=[banana, cherry]}` | [`groupByLength()`](src/main/java/streams/TerminalOperations/Collect_Example.java) |
| **Advanced:** Group a list of Employee objects by department | `[Alice(HR), Bob(Eng), Charlie(Eng), Diana(Finance)]` | `{HR=[Alice], Engineering=[Bob,Charlie], Finance=[Diana]}` | [`groupEmployeesByDepartment()`](src/main/java/streams/TerminalOperations/Collect_Example.java) |
| **Advanced:** Partition employees by salary > 75000 | `[Alice($60k), Bob($80k), Charlie($75k), Diana($90k)]` | `{false=[Alice,Charlie], true=[Bob,Diana]}` | [`partitionEmployeesBySalary()`](src/main/java/streams/TerminalOperations/Collect_Example.java) |

### 🔄 Reduce Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Sum all numbers in a list | `[1, 2, 3, 4, 5]` | `15` | [`sumNumbers()`](src/main/java/streams/TerminalOperations/Reduce_Example.java) |
| Find the maximum value in a list | `[1, 2, 3, 4, 5]` | `5` | [`findMax()`](src/main/java/streams/TerminalOperations/Reduce_Example.java) |
| Concatenate all strings in a list | `["apple", "banana", "cherry"]` | `"applebananacherry"` | [`concatenateStrings()`](src/main/java/streams/TerminalOperations/Reduce_Example.java) |
| **Advanced:** Find the product of all numbers in a list | `[1, 2, 3, 4, 5]` | `120` | [`productNumbers()`](src/main/java/streams/TerminalOperations/Reduce_Example.java) |
| **Advanced:** Find the employee with the highest salary | `[Alice($60k), Bob($80k), Charlie($75k)]` | `Bob ($80k)` | [`employeeWithHighestSalary()`](src/main/java/streams/TerminalOperations/Reduce_Example.java) |

### 📈 Min/Max Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Find the minimum value in a list | `[5, 2, 8, 1, 3]` | `1` | [`findMin()`](src/main/java/streams/TerminalOperations/MinMax_Example.java) |
| Find the maximum value in a list | `[5, 2, 8, 1, 3]` | `8` | [`findMax()`](src/main/java/streams/TerminalOperations/MinMax_Example.java) |
| Find the employee with the highest salary | `[Alice($60k), Bob($80k), Charlie($75k)]` | `Bob ($80k)` | [`employeeWithHighestSalary()`](src/main/java/streams/TerminalOperations/MinMax_Example.java) |
| **Custom:** Find the employee with the lowest age | `[Alice(30), Bob(25), Charlie(28)]` | `Bob (25)` | [`employeeWithLowestAge()`](src/main/java/streams/TerminalOperations/MinMax_Example.java) |
| **Custom:** Find the string with the maximum length | `["banana", "apple", "cherry", "date"]` | `"banana"` | [`stringWithMaxLength()`](src/main/java/streams/TerminalOperations/MinMax_Example.java) |

### 🔢 Count Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Count the number of elements in a list | `[1, 2, 3, 4, 5, 6, 7]` | `7` | [`countElements()`](src/main/java/streams/TerminalOperations/Count_Example.java) |
| Count the number of strings longer than 5 characters | `["apple", "banana", "cherry", "date", "elderberry"]` | `3` | [`countLongStrings()`](src/main/java/streams/TerminalOperations/Count_Example.java) |
| **Custom:** Count the number of employees in Engineering | `[Alice(HR), Bob(Eng), Charlie(Eng), Diana(Finance)]` | `2` | [`countEngineeringEmployees()`](src/main/java/streams/TerminalOperations/Count_Example.java) |
| **Custom:** Count the number of employees with salary > 75000 | `[Alice($60k), Bob($80k), Charlie($75k), Diana($90k)]` | `3` | [`countHighSalaryEmployees()`](src/main/java/streams/TerminalOperations/Count_Example.java) |
| **Custom:** Count the number of unique departments | `[Alice(HR), Bob(Eng), Charlie(Eng), Diana(Finance)]` | `3` | [`countUniqueDepartments()`](src/main/java/streams/TerminalOperations/Count_Example.java) |

### 🔄 ForEach Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Print each element in a list | `[1, 2, 3, 4, 5]` | `Element: 1, Element: 2, ...` | [`printElements()`](src/main/java/streams/TerminalOperations/ForEach_Example.java) |
| Print each employee's name and salary | `[Alice($60k), Bob($80k)]` | `Alice: $60000, Bob: $80000` | [`printEmployeeNameSalary()`](src/main/java/streams/TerminalOperations/ForEach_Example.java) |
| **Advanced:** Print all strings in reverse order | `["apple", "banana", "cherry", "date"]` | `Reverse: date, Reverse: cherry, ...` | [`printReverse()`](src/main/java/streams/TerminalOperations/ForEach_Example.java) |
| **Custom:** Print all employees in a specific department | `[Alice(HR), Bob(Eng), Charlie(Eng)]` | `Bob (Engineering), Charlie (Engineering)` | [`printEmployeesInDepartment()`](src/main/java/streams/TerminalOperations/ForEach_Example.java) |
| **Custom:** Print all employees with salary above a threshold | `[Alice($60k), Bob($80k), Charlie($75k)]` | `Bob ($80k), Charlie ($75k)` | [`printHighSalaryEmployees()`](src/main/java/streams/TerminalOperations/ForEach_Example.java) |

### 🔍 Match/Find Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Check if any number in a list is even (anyMatch) | `[1, 3, 5, 7, 8]` | `true` | [`anyEven()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |
| Check if all strings are non-empty (allMatch) | `["Apple", "Banana", "", "Avocado"]` | `false` | [`allNonEmpty()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |
| Check if no employee is under 18 (noneMatch) | `[Alice(30), Bob(25), Charlie(28)]` | `true` | [`noneUnder18()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |
| Find the first string that starts with 'A' (findFirst) | `["Apple", "Banana", "Avocado"]` | `"Apple"` | [`findFirstA()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |
| Find any employee in Engineering (findAny) | `[Alice(HR), Bob(Engineering), Charlie(Engineering)]` | `Bob (Engineering)` | [`findAnyEngineering()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |
| **Custom:** Check if all employees in a department have salary > 70000 | `[Alice($60k), Bob($80k), Charlie($75k)]` | `false` | [`allSalaryAbove()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |
| **Custom:** Find the first employee with salary > 80000 | `[Alice($60k), Bob($80k), Charlie($75k)]` | `Bob ($80k)` | [`findFirstSalaryAbove()`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) |

### 📦 ToArray Operations

| Sample Problem (as in Example class) | Input | Output | Function Name |
|:------------------------------------:|:-----:|:------:|:-------------:|
| Convert a list of integers to an Integer array | `[1, 2, 3, 4, 5]` | `[1, 2, 3, 4, 5]` | [`toIntegerArray()`](src/main/java/streams/TerminalOperations/ToArray_Example.java) |
| Convert a list of strings to a String array | `["apple", "banana", "cherry"]` | `["apple", "banana", "cherry"]` | [`toStringArray()`](src/main/java/streams/TerminalOperations/ToArray_Example.java) |
| **Advanced:** Convert a list of Employee objects to an Employee array | `[Alice(30,HR,$60k), Bob(25,Eng,$80k)]` | `[Alice(30,HR,$60k), Bob(25,Eng,$80k)]` | [`toEmployeeArray()`](src/main/java/streams/TerminalOperations/ToArray_Example.java) |
| **Custom:** Convert a stream of uppercase strings to an array | `["apple", "banana", "cherry"]` | `["APPLE", "BANANA", "CHERRY"]` | [`uppercaseToArray()`](src/main/java/streams/TerminalOperations/ToArray_Example.java) |

---

## 📚 Example Classes & Practice Problems

Each example class in this project:
- 🎯 Focuses on a specific stream operation
- 📝 Begins with a detailed comment section listing practice problems (from basic to advanced/interview level, including custom object scenarios)
- 🔧 Contains methods that solve each problem, printing both the input and output to visualize the transformation
- 🚀 Includes a `main` method with sample input to demonstrate all examples

### 🔄 Intermediate Operations

| Operation | Class | Practice Problems |
|-----------|-------|-------------------|
| **Map** | [`Map_Example.java`](src/main/java/streams/IntermediateOperations/Map_Example.java) | Transform data, extract properties, convert types, create derived values |
| **Filter** | [`Filter_Example.java`](src/main/java/streams/IntermediateOperations/Filter_Example.java) | Filter by conditions, remove nulls, find primes, complex filtering |
| **Sorted** | [`Sorted_Example.java`](src/main/java/streams/IntermediateOperations/Sorted_Example.java) | Sort by single/multiple fields, reverse order, custom comparators |
| **Distinct** | [`Distinct_Example.java`](src/main/java/streams/IntermediateOperations/Distinct_Example.java) | Remove duplicates, case-insensitive distinct, custom deduplication |
| **FlatMap** | [`FlatMap_Example.java`](src/main/java/streams/IntermediateOperations/FlatMap_Example.java) | Flatten nested structures, split strings, extract collections |
| **Peek** | [`Peek_Example.java`](src/main/java/streams/IntermediateOperations/Peek_Example.java) | Debug pipelines, audit elements, count passing elements |
| **Limit/Skip** | [`LimitSkip_Example.java`](src/main/java/streams/IntermediateOperations/LimitSkip_Example.java) | Pagination, top N elements, skip elements, windowing |

### 🎯 Terminal Operations

| Operation | Class | Practice Problems |
|-----------|-------|-------------------|
| **Collect** | [`Collect_Example.java`](src/main/java/streams/TerminalOperations/Collect_Example.java) | Group by, partition, collect to different collections, join strings |
| **Reduce** | [`Reduce_Example.java`](src/main/java/streams/TerminalOperations/Reduce_Example.java) | Sum, product, concatenate, find max/min, custom reduction |
| **Min/Max** | [`MinMax_Example.java`](src/main/java/streams/TerminalOperations/MinMax_Example.java) | Find minimum/maximum values, custom comparators |
| **Count** | [`Count_Example.java`](src/main/java/streams/TerminalOperations/Count_Example.java) | Count elements, count by conditions, count unique values |
| **ForEach** | [`ForEach_Example.java`](src/main/java/streams/TerminalOperations/ForEach_Example.java) | Print elements, perform side effects, iterate with actions |
| **Match/Find** | [`MatchFind_Example.java`](src/main/java/streams/TerminalOperations/MatchFind_Example.java) | anyMatch, allMatch, noneMatch, findFirst, findAny |
| **ToArray** | [`ToArray_Example.java`](src/main/java/streams/TerminalOperations/ToArray_Example.java) | Convert streams to arrays of different types |

---

<div align="center">

### 🎉 Happy Learning! 

**Master Java Streams and level up your functional programming skills!** 🚀

![Java Streams](https://img.shields.io/badge/Java%20Streams-Mastered-4CAF50?style=for-the-badge&logo=java&logoColor=white)

</div>

---

<div align="center">

## 🔒 **Copyright Protection**

**© 2024 Java Streams Tutorial. All rights reserved.**

This repository and all its contents are protected by copyright law and international treaties. 
Unauthorized reproduction, distribution, or copying of this content may result in severe civil 
and criminal penalties, and will be prosecuted to the maximum extent possible under the law.

**✅ Proper Usage:** Fork this repository and give proper attribution  
**❌ Prohibited:** Direct copying without permission or attribution

**For licensing inquiries:** Contact the copyright holder

---

## 🤝 **Contributions & Feedback Welcome!**

### 💡 **Want to Improve This Tutorial?**

We'd love your help to make this Java Streams tutorial even better! Here's how you can contribute:

#### 🐛 **Report Issues**
- Found a bug in the examples?
- Spotted an error in the documentation?
- Have a suggestion for improvement?
- **→ [Raise an Issue](https://github.com/yourusername/java_streams/issues)**

#### ✨ **Contribute Examples**
- Add new stream operation examples
- Improve existing examples with better use cases
- Add more advanced interview-level problems
- **→ [Submit a Pull Request](https://github.com/yourusername/java_streams/pulls)**

#### 📚 **Enhance Documentation**
- Improve explanations and comments
- Add more practice problems
- Suggest better formatting or organization
- **→ [Fork and Contribute](https://github.com/yourusername/java_streams/fork)**

### 🙏 **Your Contributions Are Much Appreciated!**

Every contribution, no matter how small, helps make this tutorial better for the entire Java community. Thank you for your support! 🚀

---

**Thank you for respecting intellectual property rights!** 🙏

</div>