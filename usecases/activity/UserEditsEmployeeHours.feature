Feature: user edits employee hours

  Scenario: admin edits employee hours
    Given that the current user is an admin
    And another employee exists
    And employee has assigned employee hours
    And user attempts to edits employee hours
    Then user edits employee hours

  Scenario: project manager edits employee hours
    Given that the current user is a project manager
    And another employee exists
    And employee has assigned employee hours
    And user attempts to edits employee hours
    Then user edits employee hours

  Scenario: project bound employee edits employee hours
    Given that the current user is a project bound employee
    And another employee exists
    And employee has assigned employee hours
    And user attempts to edits employee hours
    Then user does not edits employee hours