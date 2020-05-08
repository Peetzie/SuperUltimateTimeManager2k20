Feature: user creates new project with a project manager
Description: Users of various level creates a new project



Scenario: Admin creates new project
Given Current user is Admin
And another Employee exists
Then user creates new project
And project has no project manager
And user Assigns project to new project

Scenario: Employee creates new project with Projectmanager
Given Current user is not an Admin
And another Employee exists
Then user fails to create new project



