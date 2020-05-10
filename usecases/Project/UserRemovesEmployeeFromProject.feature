Feature: user removes employee from project

  Scenario: admin removes employee from project
    Given that the current user is an admin
    And a project with atleast one employee exists
    And user attempts to removes employee from project
    Then employee is removed from project

  Scenario: project manager removes employee
    Given that the current user is a project manager
    And a project with atleast one employee exists
    And user attempts to removes employee from project
    Then employee is removed from project

  Scenario: project bound employee removes employee
    Given that the current user is a project bound employee
    And a project with atleast one employee exists
    And user attempts to removes employee from project
    Then employee is not removed from project