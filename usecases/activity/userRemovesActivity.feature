Feature: user removes activity
  Description: user removes activity
  Actor: admin/project manager/project bound employee

Scenario: admin removes an activity
  Given that the current user is a admin
  Then activity is removed

Scenario: project manager removes an activity
  Given that the current user is a project bound employee
  Then activity is removed

Scenario: project bound employee removes an activity
  Given that the current user is a project bound employee
  Then activity is not removed