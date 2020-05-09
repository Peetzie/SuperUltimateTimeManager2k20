Feature: user deletes project

Scenario: Admin deletes project
  Given that the current user is an admin
  And a project exists
  Then user deletes the project

Scenario: Project manager deletes project
  Given that the current user is a project manager
  And a project exists
  Then user fails to delete the project

Scenario: Project bound emploee deletes project
  Given that the current user is a project bound employee
  And a project exists
  Then user fails to delete the project