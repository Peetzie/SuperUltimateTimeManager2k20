Feature: user assigns activity

Scenario: admin assigns activity to project bound employee
  Given that the current user is an admin
  And the user assigns the activity to project bound employee
  Then activity is assigned to project bound employee

Scenario: project manager assigns activity to project bound employee
  Given that the current user is a project manager
  And the user assigns the activity to project bound employee
  Then activity is assigned to project bound employee

Scenario: project bound employee assigns activity to project bound employee
  Given that the current user is a project bound employee
  And the user assigns the activity to project bound employee
  Then activity is not assigned to project bound employee