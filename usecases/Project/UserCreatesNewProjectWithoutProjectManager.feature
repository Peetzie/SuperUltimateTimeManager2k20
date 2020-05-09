Feature: user creates new project without project manager
Description: User creates new project, without a project manager

Scenario: Admin creates new project
  Given that the current user is an admin
  And another Employee exists
  Then user creates new project
  And current project has no project manager

Scenario: projectmanager creates new project
  Given that the current user is a project manager
  And another Employee exists
  Then user creates new project
  And current project has no project manager

Scenario: Project bound employee creates new project
  Given that the current user is a project bound employee
  And another Employee exists
  Then user creates new project
  And current project has no project manager