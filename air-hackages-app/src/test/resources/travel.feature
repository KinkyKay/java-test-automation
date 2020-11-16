
Feature: Get all the travels
  Scenario: client make call to GET /travels
    When the client calls /travels
    Then the client receives status code of 404