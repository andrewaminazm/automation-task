# Katalon Web Project

This repository contains a Katalon Studio project designed for automating web tests for the [Magento Software Testing Board](https://magento.softwaretestingboard.com/). The project includes tests for various user interactions, such as logging in, navigating through the site, adding items to the cart, and verifying the checkout process.

## Prerequisites

Before you start, ensure you have the following installed:

- [Katalon Studio](https://www.katalon.com/)
- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- A browser driver (e.g., ChromeDriver, GeckoDriver) corresponding to the browser you want to test.

## Project Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/andrewaminazm/automation-task.git
    cd automation-task
    ```

2. **Open the project in Katalon Studio:**

    - Launch Katalon Studio.
    - Click on **File > Open Project**.
    - Select the folder where you cloned the repository.

3. **Configure the browser driver:**

    - Ensure you have the correct WebDriver for your browser (e.g., `chromedriver` for Chrome, `geckodriver` for Firefox).
    - Set the path to the WebDriver in the **Project Settings** under **Execution > WebDriver**.

## Project Structure

- **Include:** This folder contains reusable functions, keywords, and test data.
- **Object Repository:** This folder contains all the Web UI test objects.
- **Scripts:** Contains test cases and test suites.
- **Reports:** After test execution, reports will be generated here.
- **Data Files:** Includes data files (e.g., CSV, Excel) used in test cases.
- **Global Variables:** This folder contains global variables used across test cases.

## Running Tests

1. **Execute individual test cases:**

    - Right-click on a test case in Katalon Studio.
    - Select **Run** to execute the test.

2. **Run test suites:**

    - Right-click on a test suite in Katalon Studio.
    - Select **Run** to execute the entire suite of tests.

3. **Run all tests:**

    - To execute all tests in the project, you can use the **Run** button in the Test Suite Collection.

## Test Execution on CI/CD

You can integrate Katalon Studio tests with CI/CD pipelines using tools like Jenkins, GitHub Actions, GitLab CI, etc. 

For example, in Jenkins:

1. Install the Katalon Jenkins plugin.
2. Set up the Katalon project as a Jenkins job.
3. Configure your job to run Katalon tests using the Katalon command-line interface.

### Example Command:
```bash
katalon -noExit -runMode=console -projectPath="automation-task.prj" -retry=0 -testSuitePath="Test Suites/completetask"
