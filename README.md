# TestNG Annotations & Data Driven Practice 🚀

This repository contains practical examples of core **TestNG Annotations** and **Data Driven Testing** using Selenium WebDriver. It focuses on structuring test execution flows and running tests with multiple sets of data.

---

## 🛠️ Key Concepts Implemented

Here are the core TestNG features practiced and implemented in this project:

* **`@BeforeMethod`**: Used to set up pre-requisites before **every** test case (e.g., launching the browser, maximizing the window, and navigating to the URL).
* **`@Test`**: Contains the actual automation test logic and validation steps.
* **`@AfterMethod`**: Used to clean up post-test activities after **every** test case finishes (e.g., closing the browser using `driver.quit()`).
* **`@DataProvider`**: Implements **Data-Driven Testing** to pass multiple inputs (like different search keywords or login credentials) to a single `@Test` method without rewriting code.

---

## 🏃 Execution Flow of this Project

When you run any test class in this project, TestNG executes the methods in this exact sequential order:

1. **`@BeforeMethod`** ➡️ Opens the browser & sets up the environment.
2. **`@Test` (with `@DataProvider` data)** ➡️ Runs the core test script.
3. **`@AfterMethod`** ➡️ Closes the browser safely.

*(Note: If the DataProvider has 3 rows of data, this entire loop of 1, 2, and 3 will repeat 3 times automatically!)*

---

## 💻 How to Run

1. Open the project in IntelliJ IDEA.
2. Right-click on the test class and select **Run**.
3. To execute via Maven terminal:
   ```bash
   mvn test