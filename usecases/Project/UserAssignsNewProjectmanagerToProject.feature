Feature: user assigns new projectmanager to project

Scenario: Admin assigns new projectmanager to project
  Given that the current user is an admin
  And a project exists with a projectmanager
  And a new employee exist
  And user attempts to assign a new project manager to the project
  Then new project manager is assigned to the project

Scenario: projectmanager assigns new projectmanager to project
  Given that the current user is a project manager
  And a project exists with a projectmanager
  And a new employee exist
  And user attempts to assign a new project manager to the project
  Then new project manager is assigned to the project
  And current user is no longer project manager for the project

Scenario: Projectbound employee assigns new projectmanager to project
  Given that the current user is a project bound employee
  And a project exists with a projectmanager
  And a new employee exist
  And user attempts to assign a new project manager to the project
  Then new project manager not is assigned to the project
