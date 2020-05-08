Feature: user edits own hours
  Description: user edits own hours
  Actor: project bound employee

Scenario: user edits own hours
  Given that the current user is a project bound employee
  Then edit is allowed