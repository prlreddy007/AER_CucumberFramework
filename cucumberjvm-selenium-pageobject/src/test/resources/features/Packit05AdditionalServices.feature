Feature: Packit Additional Services verification
  
  @SmokeTest @RegressionTest
  Scenario: Verify if navigated to Additional services
    When I proceed from details page
    Then I should get the additional services page
   
   @SmokeTest @RegressionTest 
   Scenario: Verify the ZZf selection
    Given I verify if ZZF is available
    When I select ZZF
    Then I verify greencheck
    
   