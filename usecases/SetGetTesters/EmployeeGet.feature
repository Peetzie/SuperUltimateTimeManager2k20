Feature: getters in Employee.java

  Scenario: system gets list of project the employee manages
    Given that employee.java is instantiated
    Then system gets projects which the employee manages for employee

  Scenario: system gets project employee relations for employee
    Given that employee.java is instantiated
    Then system gets project employee relations for employee

  Scenario: system gets admin boolean for employee
    Given that employee.java is instantiated
    Then system gets admin boolean for employee

  Scenario: system gets password for employee
    Given that employee.java is instantiated
    Then system gets password for employee

  Scenario: system gets name for employee
    Given that employee.java is instantiated
    Then system gets name for employee

  Scenario: system gets employee is removed boolean
    Given that employee.java is instantiated
    Then system gets employee is removed boolean

  Scenario: system gets employee as a string
    Given that employee.java is instantiated
    Then system gets employee as a string