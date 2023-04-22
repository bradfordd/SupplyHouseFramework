Feature: User Selects a trusted brand from homepage, adds specifications at item catalog, user is then shown results that match parameters

  Background:
    Given User Navigates to SupplyHouse HomePage without being logging in
	
  @WebTest
  Scenario Outline: Selecting trusted brand and making specifications in item catalog page
    Given User Selects <Brand> at the HomePage
    And User selects the following parameters: <In Stock Only>, <Product Type>, <Price Range>, <Review Score>, <Application>, <Material>, <Size>
    Then Products with specifications are displayed

  Examples:
    |	Brand	|  In Stock Only  |  Product Type | Price Range | Review Score | Application | Material | Size |
    |	data	| true            |  data         | data        | data         | data        | data     | data |