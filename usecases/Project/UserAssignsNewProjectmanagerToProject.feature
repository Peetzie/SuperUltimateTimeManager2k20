Feature: user assigns new project manager to project

Scenario: admin assigns new project manager to project
  Given that the current user is an admin
  And a project exists with a project manager
  And another employee exists
  And user attempts to assign a new project manager to the project
  Then new project manager is assigned to the project

Scenario: project manager assigns new project manager to project
  Given that the current user is a project manager
  And a project exists with a project manager
  And another employee exists
  And user attempts to assign a new project manager to the project
  Then new project manager is assigned to the project
  And current user is no longer project manager for the project

Scenario: project bound employee assigns new project manager to project
  Given that the current user is a project bound employee
  And a project exists with a project manager
  And another employee exists
  And user attempts to assign a new project manager to the project
  Then new project manager not is assigned to the project

