Feature: Create and remove employee
Description: Employees creates new employees
Actor: employee

Scenario: admin make new employee
  Given that the admin is not logged in
  Then employee command suceeds with "signin 0 password"
  And the admin is logged in
  And employee command suceeds with "newemployee user pass"
  And a new employee exist
