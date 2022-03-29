Feature: This feature will test ClickUp API

  Scenario: Creating a new folder in ClickUp space
    Given The TestSpace exists
    When I create a new folder called "MyFolder" and verify that the name is correct
    Then I add a list