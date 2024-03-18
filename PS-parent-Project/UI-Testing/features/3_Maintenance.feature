Feature: maintanance Functionality

  Background: 
    Given User is on the Login Page
    When User enters the valid username and password
    Then User will be redirected to the Home Page of OrangeHRM
    Then User will click to the maitenance button
    And User is enter the password for Administration Access
    Then User will be redirected to the Maintenance Page of OrangeHRM
    And user will click on the Purge Record dropdown option
    
  Scenario: Purge Feature
  	When User will select the Candidate Record 
  	Then User enter the text into the vacancy and select the option
  	And User will initiate search
  	Then user will click the purge button
  	
  Scenario: Employees Records
  	When User will select the Employee Record
  	Then enter the text into the Past Employee textbox and select the option
  	And User will initiate search 
  	
  Scenario: Confirm Purge Records
  	Then user click on the Yes, Purge button to confirm the purge
  	
  Scenario: Access Records options
  	When User will select the Access Record 
  	Then User enters the Name in Employee name texbox
  	And select the name from the options 
  	And User will initiate search
  	Then user click the download button
  	