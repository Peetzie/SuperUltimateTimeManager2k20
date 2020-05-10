Feature: system gets real activities

  Scenario: system gets real activities
    Given two activities exists in project
    And one activity is removed
    Then system gets real activities
