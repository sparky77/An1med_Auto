# Animed :: Cucumber-Java Automation Framework  

## Introduction
Automation Framework GOAL: demonstrate CI using Java, Selenium & Cucumber.  The Framework's repo, when commit detected, a webhook will then envoke a Maven Jenkins job to run a remote driver connected to BrowserStack to run some basic tests.


## TOOLS
JAVA, MAVEN, CUCUMBER, JUNIT, SELENIUM, AWS EC2, JENKINS, GITHUB REPO (W/WebHooks), BROWSERSTACK

## TESTS

## Preconditions / Background

- Accept Cookies
- Close marketing form
- Click searh trigger (prime search method)

## Test Task List

- [x] Create Cucumber file and use test runner for configuration and glue / setup
- [x] Ensure Background tasks stable and documented
- [x] Create remote connection to BrowserStack instance (Chrome and Win 11 for demo)
- [x] Configure AWS instance
- [x] Install Java, Jenkins, Maven, GIT and setup AWS for CI
- [x] GITHUB Project creation, with Webhooks, connecting to Jenkins configuration
- [x] Create test cases (Background, Search, Product Page Scrape and parsing) :tada:
- [ ] Basic reporting (TODO - ALLURE with server OR Cucumber basic)
- [ ] Implement POM (Page Object Modelling) and refactor code
- [ ] Implement Property files for CSS / Data / Customer 
- [ ] Split pipelines into NAVIGATION / PRODUCT / CUSTOMER / PURCHASE / ERRORS 

## Non Functional Requirements

### Device Coverage

![Screenshot of a comment on a GitHub issue showing an image, added in the Markdown, of an Octocat smiling and raising a tentacle.](https://myoctocat.com/assets/images/base-octocat.svg)

## Get the code

Git:

    git clone https://github.com/sparky77/An1med_Auto.git

Open a command window and run:
mvn test

This runs Cucumber features using Cucumber's JUnit Platform Engine. The `Suite`
annotation on the `RunCucumberTest` class tells JUnit to kick off Cucumber.
