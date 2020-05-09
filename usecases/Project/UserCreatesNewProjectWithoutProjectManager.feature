Feature: user creates new project without project manager
Description: User creates new project, without a project manager

Scenario: Admin creates new project
  Given that the current user is an admin
  And another Employee exists
  And user attempts to create new project
  Then New project is created and has no project manager

Scenario: projectmanager creates new project
  Given that the current user is a project manager
  And another Employee exists
  And user attempts to create new project
  Then New project is not created and has no project manager

Scenario: Project bound employee creates new project
  Given that the current user is a project bound employee
  And another Employee exists
  And user attempts to create new project
  Then New project is not created and has no project manager

Scenario: employee creates new project
  Given that the current user is an employee
  And another Employee exists
  And user attempts to create new project
  Then current project is not created and does not project manager