# JUnit 5 and Mockito in Java 🚀

# 1. Overview
This repository contains practical examples of unit testing using JUnit 5 and Mockito in a Java 21 environment. Through various test cases, it demonstrates how to integrate JUnit to validate business logic and how to use Mockito to create mocks and perform isolated dependency testing.

## 🌟 Main Features

- **JUnit 5**:
    - Full lifecycle support (`@BeforeAll`, `@AfterEach`).
    - Exception validation and multiple conditions with `assertThrows` and `assertAll`.
    - Parameterized tests to validate different cases with a single method.
    - Enhanced test documentation with `@DisplayName`.

- **Mockito**:
    - Creation of mocks to isolate dependencies in tests.
    - Behavior setup with `when(...).thenReturn(...)`.
    - Interaction verification with `verify(...)`.

---

## 📌 What is JUnit?

JUnit is a unit testing framework for Java, used to validate that each unit of code (e.g., methods and classes) functions as expected. It facilitates the creation of automated tests, improving software quality and catching errors early in the development process.

The lifecycle of tests in JUnit is organized with **annotations** such as:

## 📝 JUnit 5 Annotations
| Annotation                 | Description                                         |
|----------------------------|-----------------------------------------------------|
| `@Test`                    | Marks a method as a test case.                      |
| `@BeforeAll`               | Runs code **once** before all tests.                |
| `@AfterAll`                | Runs code **once** after all tests.                 |
| `@BeforeEach`              | Runs code before **each** test.                     |
| `@AfterEach`               | Runs code after **each** test.                      |
| `@DisplayName`             | Assigns a user-friendly name to the test.           |
| `@Disabled`                | Temporarily disables a test.                        |
| `@EnabledIfSystemProperty` | Enables test execution if a system property matches. |

---

## 🔍 What is Mockito?

Mockito is a library for **mocking objects** in unit tests. Its primary purpose is to isolate the component under test by creating **mocks** of its dependencies, ensuring that only the internal logic of the component is evaluated without involving other parts of the system.

Mockito is used to:

- **Simulate complex or slow dependencies** like databases or external services.
- **Define behavior** with `when(...).thenReturn(...)` to return expected values.
- **Verify interactions** between objects with `verify(...)`.

---

## IntelliJ and JUnit
IntelliJ IDEA offers powerful integration with JUnit, making it an ideal environment for writing, running, and debugging unit tests. Key benefits include:

- **Automatic Test Recognition**: IntelliJ automatically detects JUnit test classes and methods, allowing for easy test execution with a right-click.
- **Test Code Generation**: Quickly generate test classes and assertions, reducing setup time.
- **Detailed Test Output**: See results for passed, failed, and ignored tests, with direct links to failures in code.
- **Advanced Debugging**: Set breakpoints in test methods to examine code behavior in real-time.
- **Integration with Build Tools**: Works seamlessly with Maven and Gradle for managing dependencies and consistent builds.
- **Version Control Support**: Integrated Git support helps track and sync test code changes across teams.

IntelliJ’s JUnit integration simplifies testing and debugging, making it easier to maintain high-quality code in Java projects.

---

# 2. Environment Prerequisites
- **Java**: 11 or superior
- **JUnit**: 5.x
- **Mockito**: 4.x or superior
- **Maven** o **Gradle** (optional por dependency management)
- **Git**: manage repository

# 3. Build Instructions
1. **Clone the Repository**

   Clone the repository to your local machine:

   ```bash
   git clone https://github.com/cesar2007/java-junit-testing

2. **Navigate to the Project Directory**

   ```bash
   cd java-junit-testing

# 4. Instructions
The provided repository contains two separate packages for hands-on exercises with JUnit and Mockito. Each package focuses on different aspects of unit and mock testing, and you must work in the respective test classes as specified below.

## 4.1 Instructions for JUnit Exercise
In this exercise, you will be implementing a banking system that allows users to manage their accounts and perform fund transfers. This simulation mimics the functionalities found in real-world banking applications, emphasizing the importance of validation, error handling, and transaction logging.

As users perform transactions, it is crucial to ensure that various business rules are adhered to, such as preventing self-transfers and enforcing transfer limits. Additionally, maintaining a transaction history not only enhances user experience but also aids in auditing and tracking account activities.

You will implement unit tests to validate that your application behaves correctly under various scenarios. These tests will ensure that all business rules are enforced and that the system handles exceptional cases gracefully.

Your task will involve enhancing the existing account management functionality with new rules, logging mechanisms, and testing protocols. By the end of this exercise, you will have a robust banking application capable of managing accounts and processing transactions while adhering to defined business rules.

**Assigned test class**: `AccountTest` in the package `com.challenge.junit5app.models`.

### 4.1.1 Functional Requirements
1. **Transfer to the Same Account**: The system must validate and prevent a user from transferring funds to their own account, throwing a custom exception `SelfTransferException` when this occurs.
2. **Transfer Amount Limits**: There should be a rule limiting the maximum amount that can be transferred in a single transaction (e.g., $1000). If the amount exceeds this limit, an exception `TransferLimitExceededException` must be thrown.
3. **Transfer Between Accounts**:  The system must allow transfers between different accounts, ensuring both accounts exist in the database and are valid.
4. **Transaction History**: Every transaction must be recorded in the `Account` class. The transaction details should include the amount, date, transaction type, and for transfers, the recipient account holder's identity.

### 4.1.2 Business Rules
- **Prohibition of Transfers to the Same Account**: If the source account is the same as the destination account, a `SelfTransferException` must be thrown.
- **Transfer Amount Limits**: Transfers must not exceed a specified limit (e.g., $1000). If the limit is exceeded, `TransferLimitExceededException` should be thrown.
- **Transaction Logging**: All transactions (transfers) must be logged in the account history for auditing purposes.

### 4.1.3 Technical Requirements
- Add a `Transaction` class to represent each transaction (type, amount, date, etc.).
- Update the `Account` class to include a transaction history.
- Add methods to throw the exceptions `SelfTransferException` and `TransferLimitExceededException` where appropriate.
- Implement a method `getTransactionHistory()` in `Account` that returns the transaction history.
- Use `assertAll` and other JUnit validations to verify multiple conditions in tests.


## 4.2 Instructions for Mockito Exercise
This exercise is focused on applying mock testing techniques using the Mockito framework. The package simulates a layered architecture model for an exam system, complete with service, model, and repository layers. The system manages exams and their corresponding questions, providing a structured simulation of real-world service-oriented applications.

Your task is to write unit tests that mock the behavior of these layers to validate that the system can handle various edge cases and error scenarios, such as handling exceptions, simulating delays in database operations, and managing null responses from external services. The goal is to ensure that the `ExamServiceImpl` class operates reliably and robustly under different simulated conditions.

The layered architecture approach separates concerns clearly, allowing for more maintainable and testable code. You will leverage Mockito to mock the dependencies in the service layer and test the system's behavior without needing a fully functioning database or external services.

**Assigned test class**: `ExamServiceImplTest` in the package `com.challenge.mockito.services`.

### 4.2.1 Functional Requirements
1. **Exception Handling for No Questions**: The system must handle cases where no questions are available for a given exam. If the `questionsRepository.findQuestionsByExamId()` method returns an empty list, the service should throw a custom exception `QuestionsNotFoundException`. This ensures that the application can properly notify the caller that no questions exist for the specified exam.
2. **Simulate Delays and Failures in the Database**: The system must simulate scenarios where database operations experience significant delays. When the `repository.findAll()` method takes too long to respond, a custom `DatabaseTimeoutException` should be thrown. This ensures that the service can gracefully handle performance issues or timeouts in communication with the database.
3. **Simulate Conditional Exceptions**: The system should throw specific exceptions under certain conditions. For example, when the `questionsRepository.findQuestionsByExamId()` method is called with an exam ID of 7L (corresponding to the "History" exam), it should throw a custom exception. The service must handle this exception properly and should only behave differently for this specific case, while all other exams should continue without errors.
4. **Simulate Null Responses from External Service**: The system must account for situations where external services return `null` responses. If `questionsRepository.findQuestionsByExamId()` returns `null`, the service should handle this case by ensuring the exam is marked as having no questions without causing a failure. This ensures that the service can robustly handle unexpected null values from external systems.

### 4.2.2 Business Rules
- **Handling Missing Questions**: If no questions are found for an exam, the system must throw a `QuestionsNotFoundException`. This ensures that exams cannot be returned with an empty set of questions, preserving the integrity of the data.
- **Timeout Management for Database Delays**: When the `repository.findAll()` operation experiences a delay beyond an acceptable threshold, a `DatabaseTimeoutException` must be thrown. This rule ensures that the service can handle slow database responses gracefully and avoid prolonged waiting times that could impact system performance.
- **Conditional Exception for Specific Exams**: When querying for questions for the "History" exam (exam ID 7L), a specific exception must be thrown to simulate errors under predefined conditions. The system must only apply this behavior to the "History" exam and continue normally for all other cases.
- **Handling Null Responses**: If an external service (like questionsRepository) returns a null value, the service must treat the exam as having no questions. This rule ensures that null values from external systems are properly handled without causing unexpected failures or crashes in the application.

# 5. Testing and Validation Requisites
## 5.1 JUnit
* Tests required to validate that:
  - Transfers to the same account generate the `SelfTransferException`.
  - Transfers that exceed the maximum limit generate the `TransferLimitExceededException`.
  - Each transfer is logged in the account history, including details about the transaction.

## 5.2 Mockito
* Tests required to validate that:
  - Exception Handling for No Questions: The `QuestionsNotFoundException` is thrown when `questionsRepository.findQuestionsByExamId()` returns an empty list.
  - Simulated Delays and Failures: The `DatabaseTimeoutException` is properly thrown when `repository.findAll()` simulates a timeout.
  - Conditional Exceptions: The exception for the "History" exam (exam ID 7L) is correctly triggered, and other exams do not throw this exception.
  - Null Responses Handling: When `questionsRepository.findQuestionsByExamId()` returns null, the exam is handled as having no questions without causing system errors.

# 6. Acceptance Criteria
## 6.1 Evaluation criteria
- All tests, including those for both JUnit and Mockito, must pass on the first execution.
- For JUnit:
  - Validations for transfers to the same account and transfer amount limits must function correctly in all test cases.
  - The test coverage must encompass the new workflow for account transfers, ensuring that exceptions like `SelfTransferException` and `TransferLimitExceededException` are handled appropriately.
- For Mockito:
  - The system must correctly throw `QuestionsNotFoundException` when there are no questions for an exam. 
  - Database delay simulations should trigger `DatabaseTimeoutException` as expected. 
  - Conditional exceptions for specific cases (like the "History" exam) should be handled appropriately. 
  - Null responses from external services must be managed gracefully, without causing system errors.

## 6.2 Expected documentation and deliverables
* Source Code: GitHub repository with the implemented code.
* Documentation: A README.md file explaining how to run the project and execute unit tests.
* Test Results: Report showing unit test results and coverage.

# 7. Resources
## Official Language/Framework/Library Documentation
* [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
* [Mockito Official Documentation](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)

## Main concepts 
Unit Testing, JUnit5, Mockito

## Blog articles, samples
* [JUnit Series by Baeldung](https://www.baeldung.com/junit)
* [Mockito Series by Baeldung](https://www.baeldung.com/mockito-series)

## Public repositories
* [JUnit 5 starter configuration by JUnit Team](https://github.com/junit-team/junit5-samples)
