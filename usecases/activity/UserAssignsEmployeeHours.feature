Feature: user assigns employee hours

  Scenario: admin assigns employee hours
    Given that the current user is an admin
    And another employee exists
    And user attempts to assign employee hours
    Then user assigns employee hours

  Scenario: project manager assigns employee hours
    Given that the current user is a project manager
    And another employee exists
    And user attempts to assign employee hours
    Then user assigns employee hours

  Scenario: project bound assigns employee hours
    Given that the current user is a project bound employee
    And another employee exists
    And user attempts to assign employee hours
    Then user does not assigns employee hours