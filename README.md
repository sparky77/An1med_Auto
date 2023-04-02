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

## Tests 

- HOMEPAGE PREP :: Customer Visits Animie direct website, and asserts against the page title, performs per-conditional steps
- SEARCH :: Customer performs a customisable search against 'Doggie treats'
- PRODUCT DATA :: Scrape and Serialise Product Data (OL >> LI >> Product Name and Price) 

## Technicial Task List

- [x] Create Cucumber file and use test runner for configuration and glue / setup
- [x] Ensure Background tasks stable and documented
- [x] Create remote connection to BrowserStack instance (Chrome and Win 11)
- [x] Configure AWS instance (Install Java, Jenkins, Maven, GIT and setup AWS for CI)
- [x] Configure Jenkins & Jobs
- [x] GITHUB Project creation, with Webhooks, connecting to Jenkins configuration
- [x] Create tear down method to close all driver instances
- [x] Create test cases (Background, Search, Product Page Scrape and parsing) :tada:
- [ ] Basic reporting (TODO - ALLURE with server OR Cucumber basic)
- [ ] Implement POM (Page Object Modelling) and refactor code
- [ ] Implement Property files for CSS / Data / Customer 
- [ ] Split pipelines into NAVIGATION / PRODUCT / CUSTOMER / PURCHASE / ERRORS 

## Non Functional Requirements

### Device Coverage

![Screenshot of coverage diagram for a bit of sizzle.](https://cdn-icons-png.flaticon.com/512/17/17470.png)

# DEVICE TESTING COVERAGE
|**DESKTOP (Chrome latest + Windows 11)**|
|--|
|REGRESSION / SMOKE| |[Date %]()|
|LIVE||[]()|
|**DESKTOP COMPATIBILITY**||
|Windows (OS:11 Browser:Edge)| |[Date %]()|
|Windows (OS:11 Browser:Firefox)| |[Date %]()|
|Mac (OS:14 (Big Sur) Browser:Safari)| |[Date %]()|
|**MOBILE**||
|iPhone 12 Pro (OS:14.3 Browser:Safari)| |[Date %]()|
|iPhone 13 (OS:15 Browser:Safari)| |[Date %]()|
|iPhone 14 (OS:16 Browser:Safari)| |[Date %]()|
|Samaung Galaxy S20 (OS:10 Browser:Chrome)| |[Date %]()|
|Samaung Galaxy S22 + (OS:12 Browser:Samsung)| |[Date %]()|
|**TABLET**||
|Samsung Galaxy Tab S7 (OS:10 Browser:Chrome)| |[Date %]()|
|iPad Air 4 (OS:14 Browser:Safari)||[Date %]()|

## Get the code

Git:
    git clone https://github.com/sparky77/An1med_Auto.git

Open a command window and run:
mvn test

This runs Cucumber features using Cucumber's JUnit Platform Engine. The `Suite`
annotation on the `RunCucumberTest` class tells JUnit to kick off Cucumber.
