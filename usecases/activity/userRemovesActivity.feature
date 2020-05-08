Feature: user removes activity

Scenario: admin removes an activity
  Given that the current user is an admin
  Then activity is removed

Scenario: project manager removes an activity
  Given that the current user is a project bound employee
  Then activity is removed

Scenario: project bound employee removes an activity
  Given that the current user is a project bound employee
  Then activity is not removed