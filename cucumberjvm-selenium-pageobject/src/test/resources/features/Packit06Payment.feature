Feature: Verify payment page scenarios

  @SmokeTest
   Scenario: Verify payment page navigation
   When I proceed from additional services
   And I verify if loader is displaying 
   Then I verify if payment page accordion is displaying
   
   @RegressionTest 
   Scenario: Verify AM3 auto adjustment popup
   Given I verify if payment page accordion is displaying
   Then I verify and close if AM3 auto adjustment popup is displayed 
   
   @RegressionTest 
   Scenario: Verify payment method selection
   Given I verify if the form of payment dropdown is available
   And I select the credit card payment from form of payment dropdown
   And I select the credit card type
   #And I enter the credit card number
   Then I verify if loader is displaying
   
   @RegressionTest 
   Scenario: Verify the price details display
    Given I click on Show more in Payment page
    Then I verify price table calculations
    
    @RegressionTest 
    Scenario: Verify the price details update by adding the Agent markup3
    Given I verify by adding the AM3 within the threshold limits
    And I verify and close if AM3 auto adjustment popup is displayed 
    And I verify if loader is displaying
    Then I verify price table calculations
    
    @RegressionTest 
    Scenario: Verify by switching from Method1 to Method2 or vice versa
    Given I verify if Method1 and Method2 are available
    And I switch the method
    And I verify if loader is displaying
    Then I verify price table calculations
    
    @RegressionTest 
    Scenario: Verify by entering the consumer credit card number
    Given I verify if credit card field is displayed
    And I enter the consumer type credit card number
    And I verify if loader is displaying
    And I fail the test if footnote is displayed after entering card number
    Then I verify price table calculations
    
    @RegressionTest 
     Scenario: Verify by switching from Method1 to Method2 or vice versa when consumer card is present
    Given I verify if Method1 and Method2 are available
    And I switch the method
    And I verify if loader is displaying
    And I fail the test if footnote is displayed after entering card number
    Then I verify price table calculations
    
    #Scenario: Verify the price details and credit card number by adding the Agent markup3
   # Given I verify by adding the AM3 more than upper threshold limit
    #And I verify and close if AM3 auto adjustment popup is displayed 
   # And I verify if loader is displaying
   # And I verify if credit card field is displayed
   # And I verify if credit card number is displaying
   # Then I verify price table calculations
   
    @RegressionTest 
     Scenario: Verify by entering the corporate credit card number
    Given I verify if credit card field is displayed
    And I enter the corporate type credit card number
    And I verify if loader is displaying
    And I fail the test if footnote is displayed after entering card number
    Then I verify price table calculations
    
    @RegressionTest 
     Scenario: Verify by switching from Method1 to Method2 or vice versa when corporate card is present
    Given I verify if Method1 and Method2 are available
    And I switch the method
    And I verify if loader is displaying
    And I fail the test if footnote is displayed after entering card number
    Then I verify price table calculations
    
    @RegressionTest 
    Scenario: Verify by modifying the card type to AMERICAN EXPRESS
     Given I change the card type to AMERICAN EXPRESS
     And I verify if loader is displaying
      And I verify if credit card field is displayed
    # And I verify if credit card number is displaying
     And I enter the AMERICAN EXPRESS card number
     And I verify if loader is displaying
     And I fail the test if footnote is displayed after entering card number
   # And I verify if credit card field is displayed
   # And I verify if credit card number is displaying
    Then I verify price table calculations
    
    @RegressionTest 
    Scenario: Verify the price details and credit card number by adding the Agent markup3
    Given I verify by adding the AM3 more than upper threshold limit
    And I verify and close if AM3 auto adjustment popup is displayed 
    And I verify if loader is displaying
    And I verify if credit card field is displayed
   # And I verify if credit card number is displaying
    Then I verify price table calculations
    
     @RegressionTest 
     Scenario: Verify by Pay & order with credit card
    Given I verify by adding the AM3 less than lower threshold limit
    And I verify and close if AM3 auto adjustment popup is displayed 
    And I verify if loader is displaying
    Then I click on Pay & order
    
    
    Scenario: Verify if TSA or APIS confirmation popup is displayed
    Given I verify if TSA and APIS popup is appeared
    And I click on Ok button in TSA or APIS missing popup
    And I verify if passenger details page is displayed
    And I click on confirm in TSA line
    And I verify if loader is displaying
    Then I verify if payment page accordion is displaying
    
    Scenario: Verify the invoice and insurance popups that will appear when doing pay & order
    Given I verify if total markup is zero
    And I verify if method2 is selcted
    And I click on Pay & order 
    And I verify if invoice popup is displaying
    And I click on close icon
    And I click on Pay & order
    And I click on invoice button
    And I verify if insurance popup is displaying
    And I select the insurance option
    And I click on proceed button in insurance popup
    Then I verify if loader is displaying
   