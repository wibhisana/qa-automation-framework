@api
Feature: User CRUD

  Scenario: Create, update and delete user
    Given API is ready

    When I create a new user
    Then response status code should be 200
    And user id should be returned

    When I update the user first name to "UpdatedName"
    Then response status code should be 200

    When I delete the user
    Then response status code should be 200
