Feature: user creates new activity in project

Scenario: admin creates new activity in project
  Given that the current user is an admin
  And the user creates a new activity
  Then new activity in project is created

Scenario: project manager creates new activity in project
  Given that the current user is a project manager
  And the user creates a new activity
  Then new activity in project is created

Scenario: project bound employee creates new activity in project
  Given that the current user is a project bound employee
  And the user creates a new activity
  Then new activity in project is not created

Scenario: employee creates new activity in project
  Given that the current user is an employee
  And the user creates a new activity
  Then new activity in project is not created

