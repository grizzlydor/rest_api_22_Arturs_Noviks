Feature: This feature will test ClickUp API

  Scenario: Creating a new folder in ClickUp space
    Given The TestSpace exists
    When I create a new folder called "MyFolder" and verify that the name is correct
    Then I create list in "MyFolder"
    And I verify that the list name is "MyList" and that it is added to "MyFolder"