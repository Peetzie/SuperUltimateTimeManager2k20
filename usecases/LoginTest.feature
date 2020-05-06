Feature: Employee Login
Description: The employee logs into the library system and also logs out
Actor: employee

Scenario: employee can log in
  Given that the employee is not logged in
  And the password is "password"
  Then the employee login suceeds
  And the employee is logged in

Scenario: employee has the wrong password
  Given that the employee is not logged in
  And the password is "wrongpassword"
  Then the employee login fails
  And the employee is not logged in