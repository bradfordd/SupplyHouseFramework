# Selenium Java with Cucumber SupplyHouse Regression Suite

This project contains a Selenium Java regression suite using the Cucumber framework for SupplyHouse.com. The test suite covers various functional and UI aspects of the application.

## Requirements:
- jdk 11
- Cucumber-java 7.5.0
- junit 4.11
- testng 6.14.3
- Selenium java 4.8.0
- cucumber-testng 7.5.0
- Apache Maven 3.8.6
- SupplyHouseFramework

## Table of Contents
- [Getting Started](#getting-started)



## Getting Started

Follow these steps to set up the SupplyHouseFramework project on your local machine and import it into your Java IDE:

Clone the repository:
Use the following command in git bash to clone the remote Git repository located at https://github.com/bradfordd/SupplyHouseFramework.git to your local machine. This creates a new directory called SupplyHouseFramework containing the project files.

    git clone https://github.com/bradfordd/SupplyHouseFramework.git		
    
Navigate to the project directory:
Change your current directory to the newly cloned SupplyHouseFramework directory with this command:

git bash:

	 cd SupplyHouseFramework 
Import the project into your Java IDE as a Maven project:
Open your preferred Java IDE (such as IntelliJ IDEA or Eclipse) and follow the steps below to import the project as a Maven project.

For IntelliJ IDEA:

Open IntelliJ IDEA.
Select "Open" or "Import Project" from the welcome screen or File menu.
Navigate to the SupplyHouseFramework directory and select the pom.xml file.
Click "OK" to import the project as a Maven project.
For Eclipse:

Open Eclipse.
Go to File > Import.
Select "Existing Maven Projects" under the "Maven" folder.
Click "Next."
Click "Browse" and navigate to the SupplyHouseFramework directory.
Select the pom.xml file.
Click "Finish" to import the project as a Maven project.
After completing these steps, the SupplyHouseFramework project will be set up in your Java IDE, and you can start working with it.


## Running Tests
To run the test suite from your IDE, follow these steps:
Navigate to Automation\src\test\java\features
Locate the test runner class corresponding to the feature file you wish to run, or use TestNGTestRunner to run all feature files
Run as a TestNG file

Alternatively, you can run the tests from the command line using Maven:

mvn test

You can also use 
mvn test -Prun-BrandSelect to run Brand Select Feature File

mvn test -Prun-CategoryNavBarTestRunner to run Navbar Feature File

mvn test -Prun-SearchForItem to run search bar Feature file

# CategoryNavBar.feature Documentation

This feature file, named `CategoryNavBar.feature`, contains test scenarios for navigating the SupplyHouse.com website's category navigation bar and its subcategories. The test scenarios ensure that the user can successfully select categories from the navigation bar, navigate through subcategories, and reach an item's Product Details Page.

## Feature Overview

\```
Feature: User Selects category from navbar and clicks subcategories until item selection is shown and user selects first item
\```

This feature tests the functionality of the category navigation bar and subcategories, ensuring that the user can select a category, navigate through its subcategories, and eventually reach an item's Product Details Page.

## Background

\```
Background:
  Given User Navigates to SupplyHouse HomePage without being logged in
\```

This background step sets the initial state for all scenarios in the feature file. The user navigates to the SupplyHouse homepage and is not logged in.

## Test Scenario


	 Scenario Outline: Selecting category and navigating to item Product Details Page
	 Given User Selects <NavbarCategory> then selects <subCategory> from dropdown menu
	 And User is navigated to item category select Page, selects first category on page and subsequent category pages, selects first item displayed on search results page
	 Then Product details Page Corresponding with selected entry is displayed

Examples:
  |  NavbarCategory  |  subCategory                   |
  ... (all combinations of NavbarCategory and subCategory)
\```

This `Scenario Outline` tests the functionality of selecting a category and navigating through subcategories until an item's Product Details Page is displayed. The scenario is parameterized with different combinations of categories and subcategories. 

- `Given` step: The user selects a category from the navigation bar and then selects a subcategory from the dropdown menu.
- `And` step: The user navigates to the item category select page, selects the first category on the page and continues through subsequent category pages, and selects the first item displayed on the search results page.
- `Then` step: The Product Details Page corresponding to the selected item is displayed.

The `Examples` table provides all combinations of `NavbarCategory` and `subCategory` to be tested.

## Tags

The `@WebTest` tag is used to categorize this test scenario as a web test. This can be helpful for filtering and running tests based on specific criteria or grouping.

## Usage

This feature file is part of a Selenium Java regression suite using the Cucumber framework. It should be executed with the appropriate test runner and environment setup.


markdown
Copy code
# SearchProduct.feature Documentation

Feature: Search for a given product category and clicks subcategories until item selection is shown and user selects first item

css
Copy code

This feature tests the functionality of searching for a product category and navigating through subcategories until an item's Product Details Page is displayed.

## Background

Background:
Given User Navigates to SupplyHouse HomePage without being logged in

css
Copy code

This background step sets the initial state for all scenarios in the feature file. The user navigates to the SupplyHouse homepage and is not logged in.

## Test Scenario

@WebTest
Scenario Outline: Searching for item and navigating to item Product Details Page
Given User Searches For <item>
And User is navigated to item category select Page, selects first category on page and subsequent category pages, selects first item displayed
Then Product details Page Corresponding with selected entry is displayed

Examples:
| item |
... (all items to be searched)

vbnet
Copy code

This `Scenario Outline` tests the functionality of searching for a product category and navigating through subcategories until an item's Product Details Page is displayed. The scenario is parameterized with different items to be searched. 

- `Given` step: The user searches for a product category.
- `And` step: The user navigates to the item category select page, selects the first category on the page and continues through subsequent category pages, and selects the first item displayed on the search results page.
- `Then` step: The Product Details Page corresponding to the selected item is displayed.

The `Examples` table provides all items to be searched.

## Tags

The `@WebTest` tag is used to categorize this test scenario as a web test. This can be helpful for filtering and running tests based on specific criteria or grouping.

## Usage

This feature file is part of a Selenium Java regression suite using the Cucumber framework. It should be executed with the appropriate test runner and environment setup.


This `Scenario Outline` tests the functionality of selecting a trusted brand from the homepage, adding specifications in the item catalog page, and displaying results that match the specified parameters. The scenario is parameterized with different combinations of parameters.

- `Given` step: The user selects a trusted brand from the homepage.
- `And` step: The user selects the following parameters: In Stock Only, Product Type, Price Range, Review Score, Application, Material, Size.
- `Then` step: Products with the specified parameters are displayed.

The `Examples` table provides all combinations of parameters to be tested.

## Tags

The `@WebTest` tag is used to categorize this test scenario as a web test. This can be helpful for filtering and running tests based on specific criteria or grouping.

## Usage

This feature file is part of a Selenium Java regression suite using the Cucumber framework. It should be executed with the appropriate test runner and environment setup.



# CategorySearchPage.java Documentation

`CategorySearchPage` is a Page Object Model class that represents the Category Search Page of the SupplyHouse web application. It provides methods to interact with the page's elements, such as selecting a category, getting the number of categories, and interacting with breadcrumbs.

## Class Definition

```java
public class CategorySearchPage extends BasePageObject {
CategorySearchPage extends the BasePageObject class.
```

## Fields

```protected WebDriver driver;
protected final String itemCategoriesXpath = "//a[@color='blueLink' and @font-weight='bold']/div[2]/span[1]";
protected final String pageTitleXpath = "//h1[@font-size='22,,24,,34']";
protected final String breadcrumbsXpath = "//div[contains(@class, 'Box-sc-1z9git-0 hzZBOh')]";
```

The class has fields for the WebDriver, XPath selectors for item categories, page title, and breadcrumbs.

## Constructor

```
public CategorySearchPage(WebDriver driver) throws InterruptedException {
	super(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(pageTitleXpath)));
	wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(itemCategoriesXpath)));
	wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(breadcrumbsXpath)));
	PageFactory.initElements(driver, this);
}
```

The constructor initializes the CategorySearchPage instance by calling the superclass constructor and waiting for the required elements to be present on the page. Then, it initializes the instance's fields using the PageFactory class.

## Methods

```selectCategory(int i): Selects a category by its index.
getCategoryName(int i): Returns the name of a category by its index.
getNumberOfCategories(): Returns the number of categories on the page.
getCategoryValues(): Returns an ArrayList of category names.
getNumberOfBreadCrumbs(): Returns the number of breadcrumbs on the page.
getPageTitle(): Returns the page title text.
getBreadCrumbText(): Returns an ArrayList of breadcrumb texts.
getFinalBreadCrumbText(): Returns the text of the final breadcrumb.
getExpectedUrlText(String item): Returns a formatted version of the input item that is expected to be used as part of a URL.
```

## Page Factory Elements

```@FindBy(xpath=itemCategoriesXpath)
List<WebElement> itemCategories;

@FindBy(xpath=pageTitleXpath)
WebElement pageTitle;

@FindBy(xpath=breadcrumbsXpath)
List<WebElement> breadcrumbs;
```

These @FindBy annotations define WebElement instances corresponding to the item categories, page title, and breadcrumbs.

## Usage:
This CategorySearchPage class should be used in a Selenium Java test suite using the Page Object Model pattern. It allows for interacting with the Category Search Page and makes it easier to write maintainable and readable test code.