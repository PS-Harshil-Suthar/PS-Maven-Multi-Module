Feature: Directory Functionality

  Background: 
    Given User is on the Login Page
    When User enters the valid username and password
    Then User will be redirected to the Home Page of OrangeHRM
    Then User will click to the directory button

  Scenario Outline: Access Directory Page and Search for Employee
    When User enters "<Employee Name>" in the search bar
    And User selects a Job Title from the dropdown list
    And User selects a Location from the dropdown options
    Then User initiates the search
    And User selects a record
    Then User resets the search

    Examples: 
      | Employee Name |
      | O             |
