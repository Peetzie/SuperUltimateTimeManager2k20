Feature: user sets project deadline

  Scenario: admin sets project deadline
    Given that the current user is an admin
    And a project exists
    And user attempts to set deadline
    Then project deadline is set

  Scenario: project manager sets project deadline
    Given that the current user is a project manager
    And a project exists
    And user attempts to set deadline
    Then project deadline is set

  Scenario: project bound employee sets project deadline
    Given that the current user is a project bound employee
    And a project exists
    And user attempts to set deadline
    Then project deadline is not set
