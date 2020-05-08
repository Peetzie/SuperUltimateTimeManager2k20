Feature: Create employee
  Description: Employees creates new employees
  Actor: employee

  Scenario: admin make new employee
    Given that the admin is logged in
    Then admin created new employee
    And a new employee exist

  Scenario: employee make new employee
    Given that the admin is logged in
    Then admin created new employee
    And a new employee exist
    And new employee signs in
    And employee created new employee fails

  Scenario: admin make new admin
    Given that the admin is logged in
    Then admin created new admin
    And a new admin exist

  Scenario: employee make new admin
    Given that the admin is logged in
    Then admin created new employee
    And a new employee exist
    And new employee signs in
    And employee created new admin fails