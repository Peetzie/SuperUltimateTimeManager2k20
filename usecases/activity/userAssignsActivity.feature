Feature: user assigns activity
  Description: user assigns activity
  Actor: admin/project manager/project bound employee

Scenario: admin assigns activity to project bound employee
  Given that the current user is a admin
  Then activity is assigned to project bound employee

Scenario: project manager assigns activity to project bound employee
  Given that the current user is a project manager
  Then activity is assigned to project bound employee

Scenario: project bound employee assigns activity to project bound employee
  Given that the current user is a project bound employee
  Then activity is not assigned to project bound employee