@Login
Feature: Login

  Background:
    Given User launch Chrome browser for login
    And User opens URL "https://www.saucedemo.com/" in login

  @HappyPath
  Scenario: Successful login
    When User enters Username as "standard_user"
    And User enters Password as "secret_sauce"
    And User clicks on LOGIN button
    Then User should be logged and first screen should appear

  Scenario: Login with performance glitch
    When User enters Username as "performance_glitch_user"
    And User enters Password as "secret_sauce"
    And User clicks on LOGIN button
    Then User should be logged and first screen should appear

  Scenario: Unsuccessful login
    When User enters Username as "standard_user"
    And User enters Password as "test"
    And User clicks on LOGIN button
    Then User won't be logged and warning will appear

  Scenario: Locked out login
    When User enters Username as "locked_out_user"
    And User enters Password as "secret_sauce"
    And User clicks on LOGIN button
    Then User won't be logged and warning will appear