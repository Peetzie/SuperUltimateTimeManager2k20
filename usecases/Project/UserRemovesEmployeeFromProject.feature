Feature: user removes employee from project

Scenario: Admin removes employee from project
  Given that the current user is an admin
  And a project with atleast one employee exists
  Then user removes employee from project

Scenario: Project manager removes employee from project
  Given that the current user is a project manager
  And a project with atleast one employee exists
  Then user removes employee from project

Scenario: Project bound employee removes employee from project
  Given that the current user is a project bound employee
  And a project with atleast one employee exists
  Then user removes employee from project

