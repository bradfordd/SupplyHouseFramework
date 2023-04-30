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
		| Access Doors |
		| Backflow |
		| Chemicals |
#		| Drains |
#		| Faucet Parts |
#		| Flush Valves |
#		| Outlet Boxes |
#		| PEX Plumbing |
#		| Pipe |
#		| Pipe Hangers |
#		| Pumps |
#		| Toilet Parts |
#		| Tools |
#		| Tub & Shower |
#		| Tubular |
#		| Valves |
#		| Water Filters |
#		| Water Heaters |
#		| Water Heater Parts |
#		| Boiler Parts |
#		| Pressure Valves |
#		| Pumps |
#		| Relief Valves |
#		| Gas Flex |
#		| Gas Regulators |
#		| Gas Valves |
#		| Chemicals |
#		| Electric Radiant Heat |
#		| Fittings |
#		| Heat Tape |
#		| Nipples |
#		| Radiant Heat |
#		| Tekmar Controls |
#		| Kickspace Heaters |
#		| Radiator Valves |
#		| Air Cleaners |
#		| Capacitors |
#		| Dampers |
#		| Dehumidifiers |
#		| Flex Duct |
#		| Humidifiers |
#		| Motors |
#		| Refrigeration Controls |
#		| Registers |
#		| Replacement Parts |
#		| Tools |
#		| Ventilation Fans |
#		| ZoomLock |
#		| Fittings |
#		| Manifolds |
#		| Tools |
#		| Valves |
#		| Fittings |
#		| Manifolds |
#		| Valves |
#		| Electrical |
#		| PEX |
#		| Solenoid Valves |
#		| Baseboard |
#		| Fittings |
#		| Motors |
#		| Ventilation Fans |




