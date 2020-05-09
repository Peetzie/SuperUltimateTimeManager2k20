Feature: user creates new project with a project manager
Description: Users of various level creates a new project

Scenario: Admin creates new project with Projectmanager
  Given that the current user is an admin
  And another Employee exists
  Then user creates new project
  And current project has no project manager
  And current user assigns a new projectmanager to new project

Scenario: projectmanager creates new project
  Given that the current user is a project manager
  And another Employee exists
  Then user fails to create new project
  And current project has no project manager

Scenario: Project bound employee creates new project
  Given that the current user is a project bound employee
  And another Employee exists
  Then user fails to create new project
  And current project has no project manager

Scenario: projectmanager creates new project
  Given that the current user is a project manager
  And another Employee exists
  Then user creates new project
  And current project has no project manager

