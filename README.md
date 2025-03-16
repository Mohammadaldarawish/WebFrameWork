# Web Automation Framework

## Overview

This is a Web UI Test Automation Framework built using Java, Selenium WebDriver, TestNG, and Maven. It follows best practices like Page Object Model (POM) and supports data-driven testing. The goal is to enable easy, maintainable, and scalable web UI test automation.

## Features

- 🧪 TestNG-based test structure
- 🌐 Selenium WebDriver for browser automation
- 🧱 Page Object Model for scalable design
- 📊 TestNG reports and logs for test results
- 📁 External test data support via Excel or other sources
- 🔄 CI/CD ready for Jenkins, GitHub Actions, etc.
- 💬 Easy assertions and validations
- 🔍 Screenshot capture on failure

## Technologies Used

| Tool           | Purpose                     |
|----------------|-----------------------------|
| Java           | Programming language        |
| Selenium       | Browser automation          |
| TestNG         | Test management             |
| Maven          | Build and dependency tool   |
| Apache POI     | Reading test data from Excel|
| Log4j / SLF4J  | Logging                     |

## Project Structure

WebFrameWork/ ├── src/ │ ├── main/ │ │ └── java/ │ │ └── base/ # Base classes and drivers │ │ └── pages/ # Page classes (POM) │ ├── test/ │ │ └── java/ │ │ └── tests/ # Test classes │ │ └── utils/ # Utilities (Excel reader, logger, etc.) ├── testng.xml # TestNG suite file ├── pom.xml # Maven config └── README.md # Project documentation


## Getting Started

### 🔧 Prerequisites

- Java 8 or higher
- Maven 3.x
- Chrome/Firefox Browser
- IDE (e.g., IntelliJ IDEA or Eclipse)

### 🚀 Setup

1. **Clone the repository**  
   git clone https://github.com/Mohammadaldarawish/WebFrameWork.git
   cd WebFrameWork
2.Build the project with Maven : 
mvn clean install

3. Run Tests
- Using Maven:
mvn test
- Or using TestNG suite:
Right-click testng.xml > Run

Configuration
Update browser and environment details in config.properties
Test data is read from /resources/testdata/ (Excel files or JSON)
Logs and reports are saved in /test-output/

Reporting
TestNG default reports (/test-output/index.html)
Screenshots saved in /screenshots/ for failed tests

Continuous Integration
You can integrate this framework with:

Jenkins
GitHub Actions
Azure DevOps
Add a Maven build step and execute mvn clean test


