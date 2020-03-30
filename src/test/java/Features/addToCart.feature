@CTR
Feature: Verify CTR app

Background:
    Given I click on 'Allow' button
    

@CTR_SignIn
Scenario: Verify 'CTR page' fields and functionality
   When I click on 'SignIn' button
   Then I enter 'UserName'
   And I enter 'password'
   
#    When I Click on 'shop' button

    
 