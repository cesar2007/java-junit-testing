# JUnit 5 and Mockito in Java 21 🚀

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
| Annotation                 | Description                                                            |
|----------------------------|------------------------------------------------------------------------|
| `@Test`                    | Marks a method as a test case.                                        |
| `@BeforeAll`               | Runs code **once** before all tests.                                  |
| `@AfterAll`                | Runs code **once** after all tests.                                   |
| `@BeforeEach`              | Runs code before **each** test.                                       |
| `@AfterEach`               | Runs code after **each** test.                                        |
| `@DisplayName`             | Assigns a user-friendly name to the test.                             |
| `@Disabled`                | Temporarily disables a test.                                          |
| `@EnabledIfSystemProperty` | Enables test execution if a system property matches.                  |

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
- **Java**: 21 or superior
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
In this exercise, you will be implementing a banking system that allows users to manage their accounts and perform fund transfers. This simulation mimics the functionalities found in real-world banking applications, emphasizing the importance of validation, error handling, and transaction logging.

As users perform transactions, it is crucial to ensure that various business rules are adhered to, such as preventing self-transfers and enforcing transfer limits. Additionally, maintaining a transaction history not only enhances user experience but also aids in auditing and tracking account activities.

You will implement unit tests to validate that your application behaves correctly under various scenarios. These tests will ensure that all business rules are enforced and that the system handles exceptional cases gracefully.

Your task will involve enhancing the existing account management functionality with new rules, logging mechanisms, and testing protocols. By the end of this exercise, you will have a robust banking application capable of managing accounts and processing transactions while adhering to defined business rules.

## 4.1 Functional Requirements
1. **Transfer to the Same Account**: Implement a validation that prevents a user from transferring funds to their own account, generating a custom exception `SelfTransferException`.
2. **Transfer Amount Limits**: Introduce a rule that limits the maximum amount that can be transferred in a single transaction (e.g., a maximum of $1000). If the transfer amount exceeds this limit, an exception `TransferLimitExceededException` should be thrown.
3. **Transfer Between Accounts**: Allow transfers between different accounts, verifying that both accounts exist in the system.
4. **Transaction History**: Record each transaction in the `Account` class, including details such as amount, date, transaction type, and for transfers, the identity of the account holder.

## 4.2 Business Rules
- **Prohibition of Transfers to the Same Account**: If the source account is the same as the destination account, a `SelfTransferException` must be thrown.
- **Transfer Amount Limits**: Transfers must not exceed a specified limit (e.g., $1000). If the limit is exceeded, `TransferLimitExceededException` should be thrown.
- **Transaction Logging**: All transactions (transfers) must be logged in the account history for auditing purposes.

## 4.3 Technical Requirements
- Add a Transaction class to represent each transaction (type, amount, date, etc.).
- Update the Account class to include a transaction history.
- Add methods to throw the exceptions `SelfTransferException` and `TransferLimitExceededException` where appropriate.
- Implement a method `getTransactionHistory()` in `Account` that returns the transaction history.
- Use `assertAll` and other JUnit validations to verify multiple conditions in tests.

# 5. Testing and Validation Requisites
* Tests required to validate that:
  - Transfers to the same account generate the `SelfTransferException`.
  - Transfers that exceed the maximum limit generate the `TransferLimitExceededException`.
  - Each transfer is logged in the account history, including details about the transaction.

# 6. Acceptance Criteria
## 6.1 Evaluation criteria
- All tests must pass on the first execution.
- The validations for transfers to the same account and transfer amount limits must function correctly in all test cases.
- The test coverage must include the new workflow for account transfers, ensuring exceptions are managed appropriately.

## 6.2 Expected documentation and deliverables
* Source Code: GitHub repository with the implemented code.
* Documentation: A README.md file explaining how to run the project and execute unit tests.
* Test Results: Report showing unit test results and coverage.

# 7. Resources
## Official Language/Framework/Library Documentation
* [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)

## Main concepts 
Unit Testing, JUnit5, Mockito

## Blog articles, samples
* [JUnit Series by Baeldung](https://www.baeldung.com/junit)

## Public repositories
* [JUnit 5 starter configuration by JUnit Team](https://github.com/junit-team/junit5-samples)
