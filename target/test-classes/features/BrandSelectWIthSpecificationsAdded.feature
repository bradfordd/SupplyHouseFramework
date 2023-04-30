# Values of null indicate no selection was made
Feature: User Selects a trusted brand from homepage, adds specifications at item catalog, user is then shown results that match parameters

  Background:
    Given User Navigates to SupplyHouse HomePage without being logging in
	
	 @WebTest
  Scenario Outline: Selecting trusted brand and making specifications in item catalog page
    Given User Selects <Brand> at the HomePage
    And User selects the following parameters: <In Stock Only>, <Product Type>, <Price Range>, <Review Score>, <Application>, <Material>, <Size>
    Then Products with specifications are displayed

  Examples:
    |	Brand			|  In Stock Only  |  Product Type 							  | Price Range 	 | Review Score 			| Application | Material | Size |
    |	Bluefin		| true            |  null        									| null      		 | 1 stars            		| null       	| null    	| null  |
    |	Viega			| null            |  Sillcock         						| null        	 | null         			| null        | null     | null |
    |	Taco			| true            |  Pump         								| $2000 to $2500 | null         			| null        | null     | null |
    #|	Honeywell	| null            |  Air Cleaner         								| $700 to $800        	 | null         			| null        | null     | null |
    #|	AO-Smith	| null            |  Water Heater Dip Tube        | $40 to $45        	 | null         			| null        | null     | null |
    #|	Uponor		| true            |  Thermostat         								| null        	 | null         			| null        | null     | null |
    #|	Bluefin		| null            |  Clamp         								| $1 to $5        	 | null         			| null        | null     | null |
    #|	Resideo		| true            |  Air Eliminator        				| $90 to $100      | 5 stars            | null       | null    | null  |
    #|	Milwaukee	| true            |  null         								| null        	 | null         			| null        | null     | null |