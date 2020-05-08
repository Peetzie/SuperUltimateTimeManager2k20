Feature: user join activity
  Description: user join activity
  Actor: project manager/project bound employee/empoyee

Scenario: project manager join activity
  Given that the employee is logged in
  And is project manager
  Then employee joined activity

Scenario: admin join activity
  Given that the employee is logged in
  And is project bound employee
  Then employee joined activity

Scenario: admin join activity
  Given that the employee is logged in
  And is employee
  Then employee didnt join activity