Feature: user join activity

Scenario: project manager join activity
  Given that the current user is a project manager
  Then employee joined activity

Scenario: admin join activity
  Given that the current user is a project bound employee
  Then employee joined activity

Scenario: admin join activity
  Given that the current user is a employee
  Then employee didnt join activity