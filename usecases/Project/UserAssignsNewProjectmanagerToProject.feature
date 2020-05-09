Feature: user assigns new projectmanager to project

Scenario: Admin assigns new projectmanager to project
  Given that the current user is an admin
  And a project exists with a projectmanager
  And a new employee exist
  Then user assigns a new project manager to the project

Scenario: projectmanager assigns new projectmanager to project
  Given that the current user is a project manager
  And a project exists with a projectmanager
  And a new employee exist
  Then user assigns a new project manager to the project

Scenario: Projectbound employee assigns new projectmanager to project
  Given that the current user is a project bound employee
  And a project exists with a projectmanager
  And a new employee exist
  Then user fails to assign a new project manager to the project

