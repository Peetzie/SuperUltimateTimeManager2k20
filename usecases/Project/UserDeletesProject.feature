Feature: user deletes project

Scenario: Admin deletes project
  Given that the current user is an admin
  And a project exists
  And user attempts to delete the project
  Then project is marked as removed

Scenario: Project manager deletes project
  Given that the current user is a project manager
  And a project exists
  And user attempts to delete the project
  Then project is marked as removed


Scenario: Project bound emploee deletes project
  Given that the current user is a project bound employee
  And a project exists
  And user attempts to delete the project
  Then project is marked as removed