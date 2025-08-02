# Web Automation Framework

A comprehensive web automation testing framework built with Selenium WebDriver and Cucumber, implementing the Page Object Model pattern for maintainable and scalable automated testing.

## Business Functionality

This framework automates web application testing with a focus on e-commerce functionality:

### Core Features
1. **User Account Management**
   - New user registration and account creation
   - Login authentication with both valid and invalid credentials
   - Account information management
   - Newsletter subscription handling

2. **Shopping Experience**
   - Product browsing and listing
   - Shopping cart management
   - Multi-product selection and quantity handling

3. **Payment Processing**
   - Secure payment information handling
   - Credit card detail validation
   - Order confirmation verification

### Data Management
- JSON-based test data handling
- POJO (Plain Old Java Objects) implementation for data modeling
- Support for data-driven testing using Cucumber DataTables

## Project Structure

```
src/
├── main/
│   └── java/
│       ├── org.example/
│       │   └── Main.java
│       └── runner/
│           └── TestRunner.java
├── test/
│   ├── java/
│   │   ├── AutomationExercise/
│   │   │   ├── AccountInformationPage.java
│   │   │   ├── LoginPage.java
│   │   │   ├── PaymentPage.java
│   │   │   ├── ProductPage.java
│   │   │   └── SignUpPage.java
│   │   ├── Hooks/
│   │   │   └── Hooks.java
│   │   ├── Pojo/
│   │   │   ├── PaymentData.java
│   │   │   └── SignUpData.java
│   │   └── StepDefinitions/
│   │       ├── PaymentPageStepDef.java
│   │       └── ProductPageStepDefinition.java
│   └── resources/
       ├── features/      # Create this directory for feature files
       │   ├── login.feature
       │   ├── payment.feature
       │   ├── product.feature
       │   └── signup.feature
       └── DataFolder/
           ├── payment.json
           └── signup.json
```

## Technology Stack

- Java (JDK 24)
- Selenium WebDriver
- Cucumber (BDD)
- JUnit/TestNG
- Maven
- Jackson (JSON processing)
- Chrome/Edge WebDriver

## Key Components

### Page Objects
- **LoginPage**: Handles authentication flows
- **SignUpPage**: Manages user registration
- **AccountInformationPage**: Handles user profile data
- **ProductPage**: Manages product listing and cart operations
- **PaymentPage**: Processes payment information

### Data Models
- **SignUpData**: User registration data structure
- **PaymentData**: Payment information structure

### Test Infrastructure
- **Hooks**: Manages WebDriver lifecycle
- **StepDefinitions**: Implements Cucumber step definitions
- **TestRunner**: Configures and executes test suites

## Getting Started

### Prerequisites
1. Java JDK 24
2. Maven 3.x
3. Chrome or Edge browser
4. WebDriver executable (ChromeDriver/EdgeDriver)

### Installation
```bash
# Clone the repository
git clone https://github.com/SangeethaPriya1991/web_automation.git

# Navigate to project directory
cd web_automation

# Install dependencies
mvn clean install
```

### Configuration
1. Place WebDriver executables in `src/test/resources/driver.edgedriver_win64/`
2. Update test data in JSON files under `src/test/resources/DataFolder/`

### Running Tests
```bash
# Run all tests
mvn test

# Run specific feature
mvn test -Dcucumber.features="src/test/resources/features/login.feature"

# Run tests with specific tags
mvn test -Dcucumber.filter.tags="@smoke"
```

## Test Data Management

The framework uses JSON files for test data management:
- `payment.json`: Payment processing test data
- Other JSON files can be added for different test scenarios

Example payment.json structure:
```json
{
  "cardName": "Test User",
  "cardNumber": 1234567890123456,
  "cvc": 123,
  "expiryMonth": 12,
  "expiryYear": 2025
}
```

---
Last Updated: 2025-08-02 06:19:04 UTC
