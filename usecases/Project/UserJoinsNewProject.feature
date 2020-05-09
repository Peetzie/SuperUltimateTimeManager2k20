Feature: user joins new project

  Scenario: Admin joins new project
    Given that the current user is an admin
    And another project exists
    Then user joins project

  Scenario: Employee joins a project
    Given that the current user is an employee
    And a project exists
    Then user joins project