# Trello API Test Automation Framework

A modern test automation framework designed for Trello API testing, built with Java and following industry best practices.

## Overview

This framework provides a robust solution for testing Trello's REST APIs with:

- **Page Object Pattern**: Separates test logic from API operations
- **Facade Pattern**: Simplifies complex API interactions
- **Builder Pattern**: Creates clean and maintainable test data
- **Custom Matchers**: Enables readable and maintainable assertions
- **Dynamic Test Data**: Generates realistic test data using Faker

## Key Benefits

- **Maintainability**: Well-structured code with clear separation of concerns
- **Reusability**: Common functionalities centralized in utility classes
- **Readability**: Clean code practices with meaningful naming conventions
- **Reliability**: Consistent test execution with proper validation
- **Scalability**: Easy to extend for new API endpoints and test scenarios

## Project Structure 
<pre>
src/test/java/
├── data/                                  
│   ├── BoardTestData.java                 [Generates dynamic test data using Faker for Board operations]
│   └── CardTestData.java                  [Generates dynamic test data using Faker for Card operations]
├── matchers/                              
│   ├── BoardMatchers.java                 [Custom Hamcrest matchers for Board response validation]
│   └── CardMatchers.java                  [Custom Hamcrest matchers for Card response validation]
├── models/
│   ├── request/                           [Request models with Builder pattern]
│   │   ├── BoardRequest.java              [POJO for Board creation/update requests]
│   │   └── CardRequest.java               [POJO for Card creation/update requests]
│   └── response/                          
│       ├── BoardResponse.java             [POJO for Board API responses with JsonIgnore]
│       └── CardResponse.java              [POJO for Card API responses with JsonIgnore]
├── pages/                                 
│   └── trello/
│       ├── BoardPage.java                 [Facade pattern implementation for Board operations]
│       └── CardPage.java                  [Facade pattern implementation for Card operations]
├── services/                              
│   └── trello/
│       ├── BoardService.java              [REST API calls for Board endpoints]
│       └── CardService.java               [REST API calls for Card endpoints]
├── tests/
│   ├── base/
│   │   └── BaseTest.java                 [Base test configuration and common test utilities]
│   └── trello/
│       └── TrelloBoardTest.java          [End-to-end test scenarios for Board operations]
└── utils/                                 
    ├── BaseHelper.java                    [Core REST API configuration and request management]
    └── ResponseHelper.java                [Centralized response validation utilities]

resources/
└── testng.xml                            [TestNG suite configuration for test execution]
</pre>

## Test Execution

### Run Test

```bash
mvn clean test
```

### Run Specific Tests

```bash
mvn clean test -Dtest="TrelloBoardTest"
```

## Test Categories

- Board Operations
  - Create Board
  - Get Default List
  - Delete Board
  
- Card Operations
  - Create Multiple Cards
  - Update Card Details
  - Delete Cards

## Dependencies

- RestAssured: API testing library
- TestNG: Test framework
- Lombok: Reduce boilerplate code
- Faker: Generate test data
- Jackson: JSON processing
- Hamcrest: Assertion matchers