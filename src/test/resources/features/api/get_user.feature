@api
Feature: Get user by id

  Scenario: Get user data
    Given API is ready
    When I request user by id "60d0fe4f5311236168a109ca"
