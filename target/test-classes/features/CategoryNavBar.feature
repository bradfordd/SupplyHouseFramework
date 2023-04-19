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
    |  Plumbing    |  Access Doors       |
