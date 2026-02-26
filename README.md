# dotesthere-automation-java21

# ☕ Nespresso – QA Architect Case Study

End-to-End Test Automation Framework for **[https://dotesthere.com/](https://dotesthere.com/)**

---

## 📌 Objective

Design and implement a clean, maintainable, and scalable automation solution that covers:

* ✅ UI automation (dynamic interactions)
* ✅ API automation (CRUD operations)
* ✅ CI pipeline execution
* ✅ Automated test reporting
* ✅ Clear architectural documentation

The focus is **architecture and quality of design**, not quantity of tests.

---

# 🏗 Architecture Overview

This project follows a **layered test automation architecture**:

```
src
 ├── main
 │   ├── api           → API client layer
 │   ├── pages         → Page Object Model (UI abstraction)
 │   ├── base          → Base test setup (Playwright config)
 │   └── reports       → Extent report manager & listener
 │
 └── test
     ├── tests
     │   ├── ui        → UI test scenarios
     │   └── api       → API CRUD scenarios
```

---

# 🧩 Technology Stack

| Layer          | Technology     |
| -------------- | -------------- |
| Language       | Java 17        |
| UI Automation  | Playwright     |
| API Automation | RestAssured    |
| Test Framework | TestNG         |
| Build Tool     | Maven          |
| Reporting      | Extent Reports |
| CI             | GitHub Actions |

---

# 🖥 UI Test Coverage

Website: [https://dotesthere.com/](https://dotesthere.com/)

### ✔ Test 1 – Add/Remove Elements

* Click **Add Element**
* Verify button appears dynamically
* Remove element
* Verify element disappears

### ✔ Test 2 – Challenging DOM

* Interact with dynamic table
* Perform delete operation
* Validate DOM update

✔ Demonstrates:

* Dynamic element handling
* Assertion validation
* Page Object abstraction
* Stable selector strategy

---

# 🔌 API Test Coverage

Using public API endpoints from the application.

### ✔ Create User

* POST request
* Validate status 201
* Capture ID

### ✔ Read User

* GET request
* Validate response body

### ✔ Update User

* PUT request
* Validate updated fields

### ✔ Delete User

* DELETE request
* Validate 204 response

✔ Demonstrates:

* Full CRUD lifecycle
* Response validation
* Status code verification
* Reusable API client abstraction

---

# 🧱 Framework Design Decisions

### 1️⃣ Separation of Concerns

* Page Objects handle UI logic only.
* API Client handles HTTP operations.
* Tests contain only validation logic.

### 2️⃣ Reusability

* BaseTest centralizes Playwright setup.
* Thread-safe reporting.
* Shared configuration.

### 3️⃣ Maintainability

* Clear package structure.
* No hardcoded test logic inside utilities.
* Minimal duplication.

### 4️⃣ Reliability

* Explicit waits handled by Playwright.
* Independent test execution.
* Clean setup & teardown lifecycle.

---

# 📊 Reporting

Reporting is implemented using **Extent Reports**.

After each run:

```
test-output/ExtentReport.html
```

Report includes:

* Test summary
* Pass/Fail status
* Exception details
* Execution timeline

---

# 🚀 How To Run Tests Locally

### 1️⃣ Install Dependencies

```bash
mvn clean install
```

### 2️⃣ Run All Tests

```bash
mvn clean test
```

### 3️⃣ Open Report

Open:

```
test-output/ExtentReport.html
```

---

# 🔄 CI Pipeline (GitHub Actions)

The CI pipeline performs:

1. Checkout repository
2. Set up Java
3. Install dependencies
4. Run tests
5. Generate report
6. Upload report artifact

### Example Workflow

`.github/workflows/ci.yml`

```yaml
name: Automation CI

on:
  push:
  pull_request:

jobs:
  test:
    runs-on: windows-latest

    steps:
      - uses: actions/checkout@v4

      - name: Setup Java
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'

      - name: Install Dependencies
        run: mvn clean install -DskipTests

      - name: Run Tests
        run: mvn clean test

      - name: Upload Report
        uses: actions/upload-artifact@v4
        with:
          name: extent-report
          path: test-output/ExtentReport.html
```

---

# 📈 Scalability Considerations

This framework can be extended to support:

* Parallel execution
* Cross-browser execution
* Environment configuration
* Docker execution
* Test data management
* Retry analyzer
* Advanced logging
* Allure reporting (optional upgrade)

---

# 🧠 Architectural Justification

The solution emphasizes:

✔ Clean abstraction layers
✔ Clear separation between UI & API
✔ CI-ready structure
✔ Deterministic test execution
✔ Maintainable code organization
✔ Reporting integration

The design supports scaling to enterprise-level automation with minimal refactoring.

---

# 📦 Deliverables

* GitHub repository
* CI pipeline configuration
* Automated test report generation
* Documentation (this README)

---

# 🏁 Conclusion

This automation solution demonstrates:

* Structured automation architecture
* Proper test abstraction
* Reliable execution
* CI integration
* Professional reporting

Example test reporting

<img width="3795" height="1777" alt="image" src="https://github.com/user-attachments/assets/82aaaa79-7d6a-467d-87de-71c6d69e2c34" />
<img width="3762" height="1925" alt="image" src="https://github.com/user-attachments/assets/289af29a-cf2a-45a1-9602-7ae15558b20e" />
