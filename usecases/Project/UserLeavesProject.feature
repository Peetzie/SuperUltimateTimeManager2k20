Feature: user leaves project

Scenario: Admin leaves project
  Given current user is admin
  And user is assigned to a project
  Then user leaves project

Scenario: Project Manager leaves project
  Given current user is a project manager
  And user is assigned to a project
  Then user leaves project

Scenario: Project bound employee leaves project
  Given that the current user is a project bound employee
  And user is assigned to a project
  Then user leaves project