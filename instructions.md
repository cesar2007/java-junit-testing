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

## 4.1 Functional Requirements
* Conduct transfers with validations:
  * Validate that the source account has enough funds before performing a transfer.
  * Ensure that transfers cannot be made with a negative or zero amount.
  * Withdraw funds with validations:

* Ensure withdrawals cannot exceed the available balance.
  * Allow a maximum withdrawal limit (e.g., $1000).

* Check transaction history:
  * Enable users to view a history of all completed transactions (deposits, withdrawals, and transfers).

## 4.2 Business Rules
* Transfers should fail if the source account lacks sufficient funds.
* Withdrawals should not exceed the account balance or the maximum limit.
* Each transaction should be recorded in a transaction history.

## 4.3 Technical Requirements
* Add a Transaction class to represent each transaction (type, amount, date, etc.).
* Update the Account class to include a transaction history.
* Implement methods in the Account class to handle withdrawal and transfer validations

# 5. Testing and Validation Requisites
* Unit tests should be written for each new method in the Account class, including:
  * Verification of sufficient funds for transfers.
  * Validation of withdrawals that exceed the balance or maximum limit.
  * Verification of transaction history after each operation.

# 6. Acceptance Criteria
## 6.1 Evaluation criteria
* Functionality: All new functions must be implemented and functional as defined.
* Code Quality: Code should adhere to best programming practices.
* Testing: At least 90% test coverage is required.

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
