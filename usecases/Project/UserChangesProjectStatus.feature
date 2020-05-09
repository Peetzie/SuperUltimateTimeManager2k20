Feature: user changes project status

Scenario: Admin changes project status
  Given that the current user is an admin
  And a project exists
  Then user changes the status of the project

Scenario: Project manager changes project status
  Given that the current user is a project manager
  And a project exists
  Then user changes the status of the project

Scenario: Project bound emploee changes project status
  Given that the current user is a project bound employee
  And a project exists
  Then user fails to change the status of the project