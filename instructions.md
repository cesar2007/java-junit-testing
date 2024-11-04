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
   git clone https://github.com/your-username/your-repo-name.git

2. **Navigate to the Project Directory**

   ```bash
   cd your-repo-name


# 4. Instructions

## 4.1 Functional Requirements
## 4.2 Business Rules
## 4.3 Technical Requirements

# 5. Testing and Validation Requisites

# 6. Acceptance Criteria

## 6.1 Evaluation criteria
## 6.2 Expected documentation and deliverables

# 7. Resources

## Official Language/Framework/Library Documentation
## Main concepts (Databases, Object Oriented Programming, Classes, Polymorphism, etc)
## Blog articles, samples
## Public repositories
## Video tutorials