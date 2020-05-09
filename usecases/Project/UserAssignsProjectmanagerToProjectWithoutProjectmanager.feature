Feature: user assigns project manager to project, without projectmanager
Description: user assigns project manager to project, without one


Scenario: Admin assigns projectmanager to Unmanaged project
  Given that the current user is an admin
  And an unmanaged Project Exists
  And another Employee exists
  Then current user assigns a new projectmanager to the unmanaged project

Scenario: projectmanager assigns projectmanager to Unmanaged project
  Given that the current user is a project manager
  And an unmanaged Project Exists
  And another Employee exists
  Then current user fails to assigns a new projectmanager to the unmanaged project

Scenario: projectbound Employee assigns projectmanager to Unmanaged project
  Given that the current user is a project bound employee
  And an unmanaged Project Exists
  And another Employee exists
  Then current user fails to assigns a new projectmanager to the unmanaged project

