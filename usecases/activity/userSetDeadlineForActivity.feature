Feature: user sets deadline for activity

Scenario: admin sets deadline for activity
  Given that the current user is an admin
  And the user sets a deadline for the activity
  Then deadline is added

Scenario: project manager sets deadline for activity
  Given that the current user is a project manager
  And the user sets a deadline for the activity
  Then deadline is added

Scenario: project bound sets deadline for activity
  Given that the current user is a project bound employee
  And the user sets a deadline for the activity
  Then deadline is not added