Feature: user assigns new employee to project

Scenario: admin assigns new employee to project
    Given that the current user is an admin
    And a project exists
    And another employee exists
    And user attempts to assign a new employee to the project
    Then new employee is bound to the project

  Scenario: project manager assigns new employee to project
    Given that the current user is a project manager
    And a project exists
    And another employee exists
    And user attempts to assign a new employee to the project
    Then new employee is bound to the project

  Scenario: project bound employee assigns new employee to project
    Given that the current user is a project bound employee
    And a project exists
    And another employee exists
    And user attempts to assign a new employee to the project
    Then new employee is not bound to the project



