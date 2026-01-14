@web
Feature: Login Swag Labs

  Scenario: Login success with standard_user
    Given user open login page
    When user login with username "standard_user" and password "secret_sauce"
    Then user should see product page

  Scenario: Login failed with locked_out_user
    Given user open login page
    When user login with username "locked_out_user" and password "secret_sauce"
    Then error message "Epic sadface: Sorry, this user has been locked out." should be displayed

  Scenario: Login with problem_user shows broken images
    Given user open login page
    When user login with username "problem_user" and password "secret_sauce"
    Then product images should be incorrect
