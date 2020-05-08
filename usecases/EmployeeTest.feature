Feature: Employee
Description: Employees creates new employees
Actor: employee

Scenario: admin make new employee
  Given that the admin is logged in
  Then admin created new employee
  And a new employee exist

Scenario: employee make new employee
  Given that the admin is logged in
  Then admin created new employee
  And a new employee exist
  And new employee signs in
  And employee created new employee fails

Scenario: admin make new admin
  Given that the admin is logged in
  Then admin created new admin
  And a new admin exist

Scenario: employee make new admin
  Given that the admin is logged in
  Then admin created new employee
  And a new employee exist
  And new employee signs in
  And employee created new admin fails

Scenario: admin removes employee
  Given that the admin is logged in
  Then admin created new employee
  And a new employee exist
  And admin removes employee suceeds
  And a new employee dont exist

Scenario: employee removes employee
  Given that the admin is logged in
  Then admin created new employee
  Then admin created new employee
  And a new employee exist
  And new employee signs in
  And employee removes employee fails

Scenario: admin removes self
  Given that the admin is logged in
  And admin removes self fails

Scenario: employee removes self
  Given that the admin is logged in
  Then admin created new employee
  And a new employee exist
  And new employee signs in
  And employee removes self fails