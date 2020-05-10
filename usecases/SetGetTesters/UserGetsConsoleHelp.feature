Feature: user gets help in console

  Scenario: admin gets help in console
    Given that the current user is an admin
    And user attempts gets help in console
    Then user gets help in console

  Scenario: project manager gets help in console
    Given that the current user is a project manager
    And user attempts gets help in console
    Then user gets help in console

  Scenario: project bound employee gets help in console
    Given that the current user is a project bound employee
    And user attempts gets help in console
    Then user gets help in console

  Scenario: employee gets help in console
    Given that the current user is an employee
    And user attempts gets help in console
    Then user gets help in console