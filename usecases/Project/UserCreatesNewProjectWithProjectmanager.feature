Feature: user creates new project with a project manager
Description: Users of various level creates a new project

Scenario: admin creates new project with project manager
  Given that the current user is an admin
  And another employee exists
  And user attempts to create new project, with a project manager
  Then current project is created and has a project manager

Scenario: project manager creates new project
  Given that the current user is a project manager
  And another employee exists
  And user attempts to create new project, with a project manager
  Then current project is not created

Scenario: project bound employee creates new project
  Given that the current user is a project bound employee
  And another employee exists
  And user attempts to create new project, with a project manager
  Then current project is not created

Scenario: employee creates new project
  Given that the current user is an employee
  And another employee exists
  And user attempts to create new project, with a project manager
  Then current project is not created

