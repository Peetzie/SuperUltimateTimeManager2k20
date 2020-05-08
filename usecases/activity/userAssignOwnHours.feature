Feature: user assigns own hours

Scenario: user assign own hours
  Given that the current user is a project bound employee
  Then hours are assigned
