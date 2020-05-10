Feature: user removes employee

Scenario: admin removes employee
  Given that the current user is an admin
  And a project with atleast one employee exists
  And user attempts to remove employee
  Then employee is removed

Scenario: project manager removes employee
  Given that the current user is a project manager
  And a project with atleast one employee exists
  And user attempts to remove employee
  Then employee is not removed

Scenario: project bound employee removes employee
  Given that the current user is a project bound employee
  And a project with atleast one employee exists
  And user attempts to remove employee
  Then employee is not removed

