Feature: user creates new project without project manager
Description: User creates new project, without a project manager

Scenario: Admin creates new project
  Given Current user is Admin
  And another Employee exists
  Then user creates new project
  And project has no project manager

Scenario: Employee creates new project with Projectmanager
  Given Current user is not an Admin
  And another Employee exists
  Then user fails to create new project