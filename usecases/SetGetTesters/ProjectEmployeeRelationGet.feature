Feature: getters in ProjectEmployeeRelations.java

  Scenario: system gets isProjectmanager
    Given ProjectEmployeeRelations.java is instantiated
    Then system gets isProjectmanager for ProjectEmployeeRelations

  Scenario: system gets hours
    Given ProjectEmployeeRelations.java is instantiated
    Then system gets hours for ProjectEmployeeRelations

  Scenario: system gets project
    Given ProjectEmployeeRelations.java is instantiated
    Then system gets project for ProjectEmployeeRelations

  Scenario: system gets Employees
    Given ProjectEmployeeRelations.java is instantiated
    Then system gets Employees for ProjectEmployeeRelations

  Scenario: system gets ProjectEmployeeRelations as a string
    Given ProjectEmployeeRelations.java is instantiated
    Then system gets ProjectEmployeeRelations as a string for ProjectEmployeeRelations