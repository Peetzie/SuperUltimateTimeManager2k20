Feature: user changes project status

Scenario: admin changes project status
  Given that the current user is an admin
  And a project exists
  And user attempts to change the status of the project
  Then the status of the project is changed

Scenario: project manager changes project status
  Given that the current user is a project manager
  And a project exists
  And user attempts to change the status of the project
  Then the status of the project is changed

Scenario: project bound emploee changes project status
  Given that the current user is a project bound employee
  And a project exists
  And user attempts to change the status of the project
  Then the status of the project is not changed

