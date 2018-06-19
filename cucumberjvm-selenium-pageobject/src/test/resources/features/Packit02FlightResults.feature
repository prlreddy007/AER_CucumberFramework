Feature: Verify flight details in results 
  
  
   @SmokeTest @RegressionTest
  Scenario: Verify if flight results are in ascending order
  Given I click on best results dropdown
  And I click on Price ascending order
 Then I verify if the results are in price ascending order
  
  
  @SmokeTest @RegressionTest
  Scenario: Verify price details of a fare
  Given I click on flight row expand button 
  And I click on Show price break down
  And I click on Show more
  Then I verify the price details
  Then I click on flight row expand button
  