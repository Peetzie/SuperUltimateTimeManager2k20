Feature: user joins new project

  Scenario: Admin joins new project
    Given current user is admin
    And another project exists
    Then user joins project

  Scenario: Employee joins a project
    Given current user is employee
    And a project exists
    Then user joins project