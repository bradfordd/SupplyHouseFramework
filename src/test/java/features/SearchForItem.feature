Feature: Search for a given product category and clicks subcategories until item selection is shown and user selects first item
  
  Background:
  Given User Navigates to SupplyHouse HomePage without being logging in
	
	@WebTest
  Scenario Outline: Searching for item and navigating to item Product Details Page
    Given User Searches For <item>
    And User is navigated to item category select Page, selects first category on page and subsequent category pages, selects first item displayed
    Then Product details Page Corresponding with selected entry is displayed
  
Examples:
    |  item      |
		|	Faucet Parts |
#	  |  Access Doors | 
#		|	Expansion Tanks |
#		|	Chemicals |
#		|	Backflow |
#		|	Flush Valves |
#		|	Outlet Boxes |
#		|	PEX Plumbing |
#		|	Pipe |
#		|	Pipe Hangers |
#		|	Pumps |
#		|	Toilet Parts |
#		|	Tubular |
#		|	Valves |
#		|	Water Filters |
#		|	Water Heaters |
#		|	Water Heater Parts |
#		|	Well Tanks |





