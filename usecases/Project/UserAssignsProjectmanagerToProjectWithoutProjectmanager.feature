Feature: user assigns project manager to project, without project manager
Description: user assigns project manager to project, without one


Scenario: admin assigns project manager to Unmanaged project
  Given that the current user is an admin
  And an unmanaged project Exists
  And another employee exists
  And user attempts to assign a new project manager to the unmanaged project
  Then A new project manager is assigned to the project

Scenario: project bound employee assigns project manager to Unmanaged project
  Given that the current user is a project bound employee
  And an unmanaged project Exists
  And another employee exists
  And user attempts to assign a new project manager to the unmanaged project
  Then A new project manager is not assigned to the project
