Feature: user creates new project with a project manager
Description: Users of various level creates a new project

Scenario: Admin creates new project with Projectmanager
  Given that the current user is an admin
  And another Employee exists
  And user attempts to create new project, with a project manager
  Then current project is created and has a project manager

Scenario: projectmanager creates new project
  Given that the current user is a project manager
  And another Employee exists
  And user attempts to create new project, with a project manager
  Then current project is not created and does not project manager

Scenario: Project bound employee creates new project
  Given that the current user is a project bound employee
  And another Employee exists
  And user attempts to create new project, with a project manager
  Then current project is not created and does not project manager

Scenario: employee creates new project
  Given that the current user is an employee
  And another Employee exists
  And user attempts to create new project, with a project manager
  Then current project is not created and does not project manager

