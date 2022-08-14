# Mobiquity_RestAssured_Cucumber_Assignment
## **Overview:**
This API framework is developed using REST Assured and Cucumber.  REST Assured is a Java library that provides a domain-specific language (DSL) for writing powerful, maintainable tests for RESTful APIs. Cucumber is an open source library, which supports behavior driven development. To be more precise, Cucumber can be defined as a testing framework, driven by plain English text. It serves as documentation, automated tests, and a development aid – all in one.

All the test cases are done based on [JsonPlaceHolder](https://jsonplaceholder.typicode.com/).
Please note only positive scenario are covered as per requirement document

### **Some of the key features of this framework:**

1. It generates Cucumber report with all the step details.
2. This also has an example to validate response body using java pojo classes.
3. Test execution can be triggered from command line.
4. Easy integration to CI/CD pipeline (CircleCI)

## **Required Setup :**

- Java8 should be installed and configured.
- Maven should be installed and configured.

## **Running Test:**

Open the command prompt and navigate to the folder in which pom.xml file is present.
Run the below Maven command.

    mvn clean install


Once the execution completes report will be generated in below folder.

**Report:** 		*target/cucumber-report*<br>

Circle CI Test Execution:
https://app.circleci.com/pipelines/github/HKaur1108

