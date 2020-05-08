Feature: user gets project information

  Scenario: Admin gets project information
    Given that current user is admin
    And a project exists
    Then user gets the project information

  Scenario: Project manager gets project information
    Given that current user is a project manager
    And a project exists
    Then user gets the project information

  Scenario: Project bound gets project information
    Given that the current user is a project bound employee
    And a project exists
    Then user gets the project information

  Scenario: Employee gets project information
    Given that the current user is an employee
    And a project exists
    Then user gets the project information