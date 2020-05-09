Feature: user join activity

Scenario: project manager join activity
  Given that the current user is a project manager
  And user joins the activity
  Then employee joined activity

Scenario: admin join activity
  Given that the current user is a project bound employee
  And user joins the activity
  Then employee joined activity

Scenario: project bound employee join activity
  Given that the current user is an employee
  And user joins the activity
  Then employee didnt join activity