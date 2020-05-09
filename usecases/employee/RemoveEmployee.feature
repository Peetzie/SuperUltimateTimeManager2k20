Feature: remove employee

Scenario: admin removes employee
  Given that the admin is logged in
  Then admin created new employee
  And a new employee exist
  And admin removes employee suceeds
  And a new employee dont exist

Scenario: employee removes employee
  Given that the employee is not signed in
  Then the employee signs in
  And employee removes employee fails

Scenario: admin removes self
  Given that the admin is logged in
  And admin removes self fails

Scenario: employee removes self
  Given that the employee is not signed in
  Then the employee signs in
  And employee removes self fails