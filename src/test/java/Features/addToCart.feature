@CTR
Feature: Verify CTR app

Background:
    Given I click on 'Allow' button for location and Notification

@CTR_AddToCart
Scenario: Verify 'CTR page' fields and functionality
   When I click on 'NEXT' button to reach HomePage
   Then I Click on 'shop' button
   And  Add an Item to Cart


   
#    When I Click on 'shop' button

    
 