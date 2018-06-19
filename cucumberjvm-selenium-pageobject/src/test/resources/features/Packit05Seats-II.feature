Feature: Packit Seats-II verification
  
  @RegressionTest
  Scenario: Verify if Seats box is enabled
    Given I verify if additional services page is displayed
    And I verify if the seats box is enabled
     
   @RegressionTest
   Scenario: Verify if the seats addition is possible
    Given I verify if the seats box is enabled
    And I open the seats box 
    And I verify and add seats if possible
    And I verify if the seat number is updated correctly
    Then I verify if seats price updated correctly
    
     @RegressionTest
    Scenario: Verify if greencheck is displayed on seats box
    And I click on Proceed
    Then I verify if green check is displayed in seats tile
