@CTR
Feature: Verify CTR app

Background:
    Given I click on 'Allow' button
    

@CTR_SignIn
Scenario: Verify 'CTR page' fields and functionality
   When I click on 'SignIn' button
   Then I enter 'UserName'
   And I enter 'password'
   And Click on 'Login' now
   Then Go to 'Account' Page
   Then Click on 'SignOut'
   And  Finish the test

   
#    When I Click on 'shop' button

    
 