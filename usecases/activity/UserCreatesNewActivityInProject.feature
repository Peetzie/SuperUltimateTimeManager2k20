Feature: user creates new activity in project
  Description: user creates new activity in project
  Actor: admin/project manager/project bound employee/employee

Scenario: project manager creates new activity in project
  Given that the current user is a project manager
  Then new activity in project is created

Scenario: admin creates new activity in project
  Given that the current user is a admin
  Then new activity in project is created

Scenario: project bound employee creates new activity in project
  Given that the current user is a project bound employee
  Then new activity in project is not created

Scenario: employee creates new activity in project
  Given that the current user is a employee
  Then new activity in project is not created

