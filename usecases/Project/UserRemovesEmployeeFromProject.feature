Feature: user removes employee from project

Scenario: Admin removes employee from project
  Given that the current user is an admin
  And a project with atleast one employee exists
  And user attempts to removes employee from project
  Then employee is removed

Scenario: Project manager removes employee from project
  Given that the current user is a project manager
  And a project with atleast one employee exists
  And user attempts to removes employee from project
  Then employee is removed

Scenario: Project bound employee removes employee from project
  Given that the current user is a project bound employee
  And a project with atleast one employee exists
  And user attempts to removes employee from project
  Then employee is not removed

