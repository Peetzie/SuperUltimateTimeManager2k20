Feature: user deletes project

Scenario: admin deletes project
  Given that the current user is an admin
  And a project exists
  And user attempts to delete the project
  Then project is marked as removed

Scenario: project manager deletes project
  Given that the current user is a project manager
  And a project exists
  And user attempts to delete the project
  Then project is not marked as removed


Scenario: project bound emploee deletes project
  Given that the current user is a project bound employee
  And a project exists
  And user attempts to delete the project
  Then project is not marked as removed
