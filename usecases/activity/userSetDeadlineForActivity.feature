Feature: user sets deadline for activity
  Description: user sets deadline for activity
  Actor: admin/project manager/project bound employee

  Scenario: admin sets deadline for activity
    Given that the employee is logged in
    And is admin
    Then deadline is added

  Scenario: project manager sets deadline for activity
    Given that the employee is logged in
    And is project bound employee
    Then deadline is added

  Scenario: project bound sets deadline for activity
    Given that the employee is logged in
    And is project bound employee
    Then deadline is not added