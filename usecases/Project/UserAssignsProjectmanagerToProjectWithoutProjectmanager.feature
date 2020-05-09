Feature: user assigns project manager to project, without projectmanager
Description: user assigns project manager to project, without one


Scenario: Admin assigns projectmanager to Unmanaged project
  Given that the current user is an admin
  And an unmanaged Project Exists
  And another Employee exists
  And user attempts to assign a new projectmanager to the unmanaged project
  Then A new project manager is assigned to the project

Scenario: projectbound Employee assigns projectmanager to Unmanaged project
  Given that the current user is a project bound employee
  And an unmanaged Project Exists
  And another Employee exists
  And user attempts to assign a new projectmanager to the unmanaged project
  Then A new project manager is not assigned to the project
