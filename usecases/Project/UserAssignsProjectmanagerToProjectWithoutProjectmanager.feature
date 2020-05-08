Feature: user assigns project manager to project, without projectmanager
Description: user assigns project manager to project, without one


Scenario: Admin assigns projectmanager to Unmanaged project
  Given current user is admin
  And an unmanaged Project Exists
  And an employee exists who isnt a projectmanager
  Then current user assigns a new projectmanager to the unmanaged project

Scenario: projectmanager assigns projectmanager to Unmanaged project
  Given current user is projectmanager
  And an unmanaged Project Exists
  And an employee exists who isnt a projectmanager
  Then current user fails to assigns a new projectmanager to the unmanaged project

Scenario: projectbound Employee assigns projectmanager to Unmanaged project
  Given current user is Project bound Employee
  And an unmanaged Project Exists
  And an employee exists who isnt a projectmanager
  Then current user fails to assigns a new projectmanager to the unmanaged project

