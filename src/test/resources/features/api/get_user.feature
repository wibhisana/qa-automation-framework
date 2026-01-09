@api
Feature: Get user by id

  Scenario: Successfully get user data
    Given API is ready
    When I send request get user by id "60d0fe4f5311236168a109ca"
    Then response status code should be 200
    And response body should contain valid user data
    And response schema should be valid

