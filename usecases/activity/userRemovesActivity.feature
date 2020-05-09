Feature: user removes activity

Scenario: admin removes an activity
  Given that the current user is an admin
  And the user removes the activity
  Then activity is removed

Scenario: project manager removes an activity
  Given that the current user is a project manager
  And the user removes the activity
  Then activity is removed

Scenario: project bound employee removes an activity
  Given that the current user is a project bound employee
  And the user removes the activity
  Then activity is not removed