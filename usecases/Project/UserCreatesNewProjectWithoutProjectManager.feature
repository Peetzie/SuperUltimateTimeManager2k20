Feature: user creates new project without project manager
Description: User creates new project, without a project manager

Scenario: admin creates new project
  Given that the current user is an admin
  And user attempts to create new project
  Then New project is created and has no project manager

Scenario: project manager creates new project
  Given that the current user is a project manager
  And user attempts to create new project
  Then New project is not created

Scenario: project bound employee creates new project
  Given that the current user is a project bound employee
  And user attempts to create new project
  Then New project is not created

Scenario: employee creates new project
  Given that the current user is an employee
  And user attempts to create new project
  Then New project is not created

