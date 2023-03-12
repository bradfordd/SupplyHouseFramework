Feature: Search for an item and click on an item on Amazon
  
  Background:
  Given User Navigates to SupplyHouse HomePage without being logging in
	
	@WebTest
  Scenario Outline: Searching for item and navigating to item Product Details Page
    Given User Searches For item
    And User is navigated to item category select Page, selects first category on page
    Then Product details Page Corresponding with selected entry is displayed