Feature: user assigns new employee to project

Scenario: Admin assigns new employee to project
    Given that the current user is an admin
    And a project exists
    And a new employee exist
    Then user assigns a new employee to the project

  Scenario: projectmanager assigns new employee to project
    Given that the current user is a project manager
    And a project exists
    And a new employee exist
    Then user assigns a new employee to the project

  Scenario: Projectbound employee assigns new employee to project
    Given that the current user is a project bound employee
    And a project exists
    And a new employee exist
    Then user fails to assign a new employee to the project
