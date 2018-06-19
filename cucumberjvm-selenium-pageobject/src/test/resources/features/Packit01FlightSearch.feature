Feature: Results Display
 
 
  @SmokeTest
    Scenario: Verify Flight Results Display
    When I open packit website
    Then I verify signin
    
  @SmokeTest
   Scenario: Verify if calculation info popup is displaying
    Given I verify calculation get response
    And I verify if calculation info popup is displaying
    Then I change the language to engish
   
   @SmokeTest  
    Scenario: Verify default farecharcteristic selection
    Given  I verify the customer registry service response
    Then I verify if the LOW checkbox is selected 
    
 @SmokeTest
    Scenario: Verify the search
    And I provide origin,destination and return of travel and submit
    Then I verify results page
    
    @SmokeTest
   Scenario: Verify fare rules popup
    And  I verify filters count
    And I open Tkt filter and select green TKT
    Then I verify fare rules display
   
@SmokeTest
   Scenario: Verify filter selection
    And  I verify filters count
    And I open Tkt filter and select green TKT
    And I open faretype filter and select PUB type
    
  
    
   

   