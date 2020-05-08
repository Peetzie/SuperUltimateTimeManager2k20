Feature: user edits own hours
  Description: user edits own hours
  Actor: project bound employee

Scenario: user edits own hours
  Given that the employee is logged in
  And is project bound employee
  Then edit is allowed