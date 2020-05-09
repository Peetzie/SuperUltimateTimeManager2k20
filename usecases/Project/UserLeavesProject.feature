Feature: user leaves project

Scenario: Admin leaves project
  Given that the current user is an admin
  And user is assigned to a project
  And user attempts to leaves project
  Then user has left project

Scenario: Project Manager leaves project
  Given that the current user is a project manager
  And user is assigned to a project
  And user attempts to leaves project
  Then user has left project

Scenario: Project bound employee leaves project
  Given that the current user is a project bound employee
  And user is assigned to a project
  And user attempts to leaves project
  Then user has left project