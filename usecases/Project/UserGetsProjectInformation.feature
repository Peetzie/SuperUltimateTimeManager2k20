Feature: user gets project information

  Scenario: admin gets project information
    Given that the current user is an admin
    And a project exists
    And user attempts to get the project information
    Then user gets information


  Scenario: project manager gets project information
    Given that the current user is a project manager
    And a project exists
    And user attempts to get the project information
    Then user gets information


  Scenario: project bound gets project information
    Given that the current user is a project bound employee
    And a project exists
    Then user attempts to get the project information
    Then user gets information

  Scenario: employee gets project information
    Given that the current user is an employee
    And a project exists
    And user attempts to get the project information
    Then user gets information
