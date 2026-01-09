@api
Feature: Get list of tags

  Scenario: Successfully get list of tags
    Given API is ready
    When I send request to get list of tags
    Then response status code should be 200
    And response should contain list of tags
