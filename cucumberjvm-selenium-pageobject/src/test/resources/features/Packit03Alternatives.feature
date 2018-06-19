Feature: Alternatives page verification

 @SmokeTest @RegressionTest
 Scenario: Verify alternatives page navigation  
    When I book a flight
    Then I verify if the alternatives page is displayed
 
 Scenario: Verify price table calculations
   Given I verify if the alternatives page is displayed
   And I click on Show more in alternatives page
   Then I verify the price table calculations
 
 @SmokeTest
 Scenario: Verify by proceeding from alternatives page
   Given I verify if the alternatives page is displayed
    Then I proceed from alternatives page 
    