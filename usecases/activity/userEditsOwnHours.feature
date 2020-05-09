Feature: user edits own hours

Scenario: user edits own hours
  Given that the current user is a project bound employee
  And the user edits the hours
  Then edit is allowed