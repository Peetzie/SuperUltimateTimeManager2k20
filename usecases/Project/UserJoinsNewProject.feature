Feature: user joins new project

  Scenario: Admin joins new project
    Given that the current user is an admin
    And another project exists
    And user joins project
    Then user has joined project

  Scenario: Employee joins a project
    Given that the current user is an employee
    And a project exists
    And user joins project
    Then user has joined project