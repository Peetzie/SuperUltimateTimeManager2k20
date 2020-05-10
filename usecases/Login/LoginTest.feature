Feature: employee login

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

Scenario: employee can log in
  Given that the employee is not logged in
  And the password is "password"
  Then the employee login suceeds
  And the employee logout suceeds
  And the employee is not logged in


