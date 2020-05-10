Feature: user sets activity status

  Scenario: admin sets activity status
    Given that the current user is an admin
    And a project exists
    And an activity exists
    And user attempts to set activity status
    Then activity status is set

  Scenario: project manager sets activity status
    Given that the current user is a project manager
    And a project exists
    And an activity exists
    And user attempts to set activity status
    Then activity status is set

  Scenario: project bound employee sets activity status
    Given that the current user is a project bound employee
    And a project exists
    And an activity exists
    And user attempts to set activity status
    Then activity status is not set