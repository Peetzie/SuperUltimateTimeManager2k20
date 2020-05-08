Feature: user assigns activity
  Description: user assigns activity
  Actor: admin/project manager/project bound employee

Scenario: admin assigns activity to project bound employee
  Given that the employee is logged in
  And is admin
  Then activity is assigned to project bound employee

Scenario: project manager assigns activity to project bound employee
  Given that the employee is logged in
  And is project manager
  Then activity is assigned to project bound employee

Scenario: admin assigns activity to project bound employee
  Given that the employee is logged in
  And is project bound employee
  Then activity is not assigned to project bound employee