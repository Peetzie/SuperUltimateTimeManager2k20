Feature: user gets project information

  Scenario: Admin gets project information
    Given that the current user is an admin
    And a project exists
    And user attempts to get the project information
    Then user gets information


  Scenario: Project manager gets project information
    Given that the current user is a project manager
    And a project exists
    And user attempts to get the project information
    Then user gets information


  Scenario: Project bound gets project information
    Given that the current user is a project bound employee
    And a project exists
    Then user gets the project information
    Then user gets information

  Scenario: Employee gets project information
    Given that the current user is an employee
    And a project exists
    And user attempts to get the project information
    Then user does not get information