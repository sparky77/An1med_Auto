Feature: Animed POC - CI[Jenkins || BrowserStack || Cucumber || WebHook]

  Background:
    Given Customer visits Animeddirect website and verifs page title

  Scenario: Animed Direct Customer performs search
    Given Customer performs search for pet stock
    When Scrape product Data and Serialise product data
    #Then TearDown