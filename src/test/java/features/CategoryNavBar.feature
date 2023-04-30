Feature: User Selects category from navbar and clicks subcategories until item selection is shown and user selects first item

  Background:
    Given User Navigates to SupplyHouse HomePage without being logging in

  @WebTest
  Scenario Outline: Selecting category and navigating to item Product Details Page
    Given User Selects <NavbarCategory> then selects <subCategory>
    And User is navigated to item category select Page, selects first category on page and subsequent category pages, selects first item displayed
    Then Product details Page Corresponding with selected entry is displayed

  Examples:
    |  NavbarCategory  |  subCategory |
		|  Fittings        |  Copper Press         |
		|  Fittings        |  Electrical           |
		|  Fittings        |  PEX                  |
#		|  Fittings        |  Stainless Steel      |
#		|  Fittings        |  ZoomLock             |
#|  Plumbing   |  Access Doors           |
#		|	 Plumbing		|		Backflow							|		
#		|	 Plumbing		|		Chemicals							|
#		|	 Plumbing		|		Drains								|
#		|	 Plumbing		|		Faucet Parts					|
#		|	 Plumbing		|		Fittings & Nipples		|
#		|	 Plumbing		|		Flush Valves					|
#		|	 Plumbing		|		Outlet Boxes					|
#		|	 Plumbing		|		PEX Plumbing					|
#		|	 Plumbing		|		Pipe									|
#		|	 Plumbing		|		Pipe Hangers					|
#		|	 Plumbing		|		Pumps									|
#		|	 Plumbing		|		Specialties						|
#		|	 Plumbing		|		Toilet Parts					|
#		|	 Plumbing		|		Tools									|
#		|	 Plumbing		|		Tub & Shower					|
#		|	 Plumbing		|		Tubular								|
#		|	 Plumbing		|		Valves								|
#		|	 Plumbing		|		Water Filters					|
#		|	 Plumbing		|		Water Heaters					|
#		|	 Plumbing		|		Water Heater Parts		|
#		|  Heating    |		Boiler Parts					|
#		|  Heating    |		Pressure Valves				|
#		|  Heating    |		Pumps									|
#		|  Heating    |		Relief Valves					|
#		|  Heating    |		Venting								|
#		|  Heating    |		Gas Flex							|
#		|  Heating    |		Gas Regulators				|
#		|  Heating    |		Gas Valves						|
#		|  Heating    |		Ignitors							|
#		|  Heating    |		Chemicals							|
#		|  Heating    |		Electric Radiant Heat |
#		|  Heating    |		Fittings							|
#		|  Heating    |		Heat Tape							|
#		|  Heating    |		Misc Specialties			|
#		|  Heating    |		Nipples								|
#		|  Heating    |		Radiant Heat					|
#		|  Heating    |		Tekmar Controls				|
#		|  Heating    |		Kickspace Heaters			|
#		|  Heating    |		Radiator Valves				|
#		|  HVAC            |  Air Cleaners        |
#		|  HVAC            |  Capacitors          |
#		|  HVAC            |  Controls            |
#		|  HVAC            |  Dampers             |
#		|  HVAC            |  Dehumidifiers       |
#		|  HVAC            |  Flex Duct           |
#		|  HVAC            |  HRVs & ERVs         |
#		|  HVAC            |  Humidifiers         |
#		|  HVAC            |  HVAC/R Valves       |
#		|  HVAC            |  Install Parts       |
#		|  HVAC            |  Mini Split AC       |
#		|  HVAC            |  Motors              |
#		|  HVAC            |  Refrigeration Controls |
#		|  HVAC            |  Registers           |
#		|  HVAC            |  Replacement Parts   |
#		|  HVAC            |  Tools               |
#		|  HVAC            |  Ventilation Fans    |
#		|  HVAC            |  Venting             |
#		|  HVAC            |  ZoomLock            |
#		|  PEX             |  Fittings         |
#		|  PEX             |  Install Parts    |
#		|  PEX             |  Manifolds        |
#		|  PEX             |  Tools            |
#		|  PEX             |  Valves           |
#		|  PEX             |  Controls         |
#		|  PEX             |  Electric Radiant |
#		|  PEX             |  Fittings         |
#		|  PEX             |  Install Parts    |
#		|  PEX             |  Manifolds        |
#		|  PEX             |  Packages         |
#		|  PEX             |  Panels           |
#		|  PEX             |  Tools            |
#		|  PEX             |  Valves           |
#		|  Valves          |  Solenoid Valves      |
#		|  Electrical      |  Baseboard       |
#		|  Electrical      |  Controls        |
#		|  Electrical      |  Electric Radiant|
#		|  Electrical      |  Fittings        |
#		|  Electrical      |  Motors          |
#		|  Electrical      |  Roof De-Icing   |
#		|  Electrical      |  Timers          |
#		|  Electrical      |  Tools           |
#		|  Electrical      |  Ventilation Fans|
				
		