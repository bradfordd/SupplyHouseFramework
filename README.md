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





# ItemsByCategoryPage.java Documentation

`ItemsByCategoryPage` is a Page Object Model class that represents the Items by Category Page of the SupplyHouse web application. It provides methods to interact with the page's elements, such as selecting an item, getting the number of items, and interacting with product specifications and breadcrumbs.

## Class Definition

```java
public class ItemsByCategoryPage extends BasePageObject {
```

`ItemsByCategoryPage` extends the `BasePageObject` class.

## Fields

```java
protected static final String itemLinksXpath = "//a[@class='product-name product-link']";
protected static final String itemNameXpath = "//div[@class='desc']/a/strong";
protected static final String breadcrumbsXpath = "//div[@id='breadcrumbs']/ol/li";
protected static final String breadcrumbLinksXpath = "//div[@id='breadcrumbs']/ol/li//a";
protected static final String pageTitleXpath = "//div[@class='header-groupings']/h1";
protected static final String itemCountXpath = "//*[@id='result-size-nav']";
protected static final String productSpecificationsXpath = "//div[@id='refine-groups']//div[contains(@id, 'group')]";
protected static final String itemListingsXpath = "//*[@id='browse-results']//li";
```

The class has fields for XPath selectors for item links, item names, breadcrumbs, page title, item count, product specifications, and item listings.

## Constructor

```java
public ItemsByCategoryPage(WebDriver driver) throws InterruptedException {
	super(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pageTitleXpath)));
	driver.findElement(By.xpath(pageTitleXpath)).click();
	wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(breadcrumbsXpath)));
	wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(itemNameXpath)));
	PageFactory.initElements(driver, this);
	Thread.sleep(2000);
}
```

The constructor initializes the `ItemsByCategoryPage` instance by calling the superclass constructor and waiting for the required elements to be present on the page. Then, it initializes the instance's fields using the `PageFactory` class.

## Methods

```java
initializeItemListings(): Returns a list of ProductSearchResultListing objects for items on the page.
getNumberOfItems(): Returns the number of items on the page.
selectItemOnPage(int i): Selects an item by its index.
reinitializeItemsOnPage(): Reinitializes the list of item links on the page.
getBreadcrumbValue(int i): Returns the text of a breadcrumb by its index.
getFinalBreadcrumbValue(): Returns the text of the final breadcrumb.
getItemOnPageName(int i): Returns the name of an item by its index.
getExpectedUrlText(String item): Returns a formatted version of the input item that is expected to be used as part of a URL.
isItemPage(WebDriver driver): Returns true if the current page is an item page, false otherwise.
makeProductSpecification(String specificationType, String specificationMade): Applies a product specification filter based on the provided specification type and value.
ratingSpecification(String specificationType, String specificationMade): Applies a rating specification filter based on the provided specification type and value.
selectProductSpecificationOption(WebElement w, String specificationMade): Selects a product specification option based on the provided WebElement and value.
```

## Page Factory Elements

```java
@FindBy(xpath=itemLinksXpath)
List<WebElement> itemLinks;

@FindBy(xpath=itemNameXpath)
List<WebElement> itemNames;

@FindBy(xpath=breadcrumbsXpath)
List<WebElement> breadcrumbs;

@FindBy(xpath=breadcrumbLinksXpath)
List<WebElement> breadcrumbLinks;

@FindBy(xpath=pageTitleXpath)
WebElement PageTitle;

@FindBy(xpath=itemCountXpath)
WebElement itemCount;

@FindBy(xpath=productSpecificationsXpath)
List<WebElement> productSpecifications;
```

These `@FindBy` annotations define WebElement instances corresponding to the item links, item names, breadcrumbs, breadcrumb links, page title, item count, and product specifications.

## Usage

This `ItemsByCategoryPage` class should be used in a Selenium Java test suite using the Page Object Model pattern. It allows for interacting with the Items by Category Page and makes it easier to write maintainable and readable test code.

# ProductDetailsPage.java Documentation

`ProductDetailsPage` is a Page Object Model class that represents the Product Details Page of the SupplyHouse web application. It provides methods to interact with the page's elements, such as getting the product name, price, size, material, and rating.

## Class Definition

```java
public class ProductDetailsPage extends BasePageObject {
```

`ProductDetailsPage` extends the `BasePageObject` class.

## Fields

```java
protected final static String productTitleXpath = "//h1[@font-size='h5,,h4,,h2']";
protected final static String ratingsBarClassPath = "ProductPageHeaderProductRating__ProductPageHeaderProductRatingLink-sc-7ouyyv-0";
protected final static String itemPriceXpath = "//*[contains(@class, 'ProductPageContainerQuantityAdjustors')]//*[contains(@class, 'ProductPriceText__ProductPriceTextAmount')]";
protected final static String inStockStatusXpath = "//*[contains(@class, 'ProductPageContainerQuantityAdjustors')]//*[contains(@class, 'ProductInventoryStatusAndPromiseMessageText')]";
protected final static String productSpecsXpath = "//*[contains(@class, 'ProductPageSpecification__ProductPageSpecificationTableRow')]";
```

The class has fields for XPath and class selectors for product title, ratings bar, item price, in-stock status, and product specifications.

## Constructor

```java
public ProductDetailsPage(WebDriver driver) {
	super(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(productTitleXpath)));
	driver.findElement(By.xpath(productTitleXpath)).click();
	PageFactory.initElements(driver, this);
}
```

The constructor initializes the `ProductDetailsPage` instance by calling the superclass constructor and waiting for the required elements to be present on the page. Then, it initializes the instance's fields using the `PageFactory` class.

## Methods

```java
parseIdFromSourceAttribute(String src): Returns the 'id' attribute value from an input string.
getProductName(): Returns the product name.
isProductName(String expectedProductName): Returns true if the product name matches the expected product name.
getProductPrice(): Returns the product price.
isSizeOfProduct(String input): Returns true if the input size matches any available sizes.
getSize(): Returns an ArrayList of available sizes.
isMaterialOfProduct(String input): Returns true if the input material matches any available materials.
getMaterial(): Returns an ArrayList of available materials.
isMemberOfApplications(String input): Returns true if the input application matches any available applications.
getApplications(): Returns an ArrayList of available applications.
getProductRating(): Returns the product rating.
```

## Page Factory Elements

```java
@FindBy(className=ratingsBarClassPath)
WebElement ratingsBar;

@FindBy(xpath=productTitleXpath)
WebElement productTitle;

@FindBy(xpath=itemPriceXpath)
WebElement productPrice;

@FindBy(xpath=productSpecsXpath)
List<WebElement> productSpecs;
```

These `@FindBy` annotations define WebElement instances corresponding to the ratings bar, product title, product price, and product specifications.

## Usage

This `ProductDetailsPage` class should be used in a Selenium Java test suite using the Page Object Model pattern. It allows for interacting with the Product Details Page and makes it easier to write maintainable and readable test code.
# ProductSearchResultListing.java Documentation

`ProductSearchResultListing` is a class representing a single product listing in the search results of a SupplyHouse web application. It provides methods to interact with and extract information from the listing element, such as the product title, price, rating, and inventory status.

## Class Definition

```java
public class ProductSearchResultListing {
```

## Fields

```java
private WebElement listingElement;
protected static final String productTitleClassPath = "product-name";
protected static final String itemRatingClassPath = "desc-rating";
protected static final String itemStatusClassPath = "status";
protected static final String itemPriceClassPath = "unit-price-text";
```

The class has fields for the `listingElement`, which is a `WebElement` representing a single product listing. It also contains constant strings for the class paths of the product title, item rating, item status, and item price.

## Constructor

```java
public ProductSearchResultListing(WebElement listingElement) {
    this.listingElement = listingElement;
}
```

The constructor initializes the `ProductSearchResultListing` instance with a given `WebElement` representing a product listing.

## Methods

```java
getProductTitle(): Returns the product title.
getProductPrice(): Returns the product price.
getItemRating(): Returns the item rating.
doesProductListingsMatchSpecs(List<ProductSearchResultListing> li, String inStock, String expectedRating, String expectedPriceRange): Returns true if the product listings match the specified filters, false otherwise.
getInventoryStatus(): Returns the inventory status.
```

## Usage

This `ProductSearchResultListing` class should be used in a Selenium Java test suite for interacting with individual product search results. It makes it easier to write maintainable and readable test code by encapsulating the functionality and structure of a product listing.

By using the methods provided by this class, you can extract important information from a product listing, such as the title, price, rating, and inventory status, as well as check if a list of product listings matches specific filter criteria.

# SearchSpecifications.java Documentation

`SearchSpecifications` is a class representing the search specifications sidebar for a web application. This class extends `BasePageObject` and provides methods for interacting with and managing the search specifications, such as selecting filters, resetting selections, and verifying if options are disabled.

## Class Definition

```java
public class SearchSpecifications extends BasePageObject {
```

## Fields

```java
protected Actions actions;
protected WebDriverWait wait;
protected final static String resetButtonXpath = "//div[@id='refine-clear']//a";
protected final static String specsWindowIdpath = "sidebar";
protected final static String specificationGroupsXpath = "//div[@id='refine-groups']//div[contains(@id, 'group')]";
```

The class has fields for the `Actions` and `WebDriverWait` objects, as well as constant strings for the XPath of the reset button, the ID path of the specifications window, and the XPath of the specification groups.

## Constructor

```java
public SearchSpecifications(WebDriver driver) throws InterruptedException {
    super(driver);
    this.actions = new Actions(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    PageFactory.initElements(driver, this);
    Thread.sleep(2000);
}
```

The constructor initializes the `SearchSpecifications` instance with a given `WebDriver` object and sets up the `Actions`, `WebDriverWait`, and `PageFactory` instances.

## Methods

```java
findFirstIntegerBetweenOneAndFive(String input): Returns the first integer between 1 and 5 found in the input string, or -1 if not found.
toggleInStockOnly(): Toggles the "In Stock Only" filter.
resetSpecifications(): Resets all selected specifications.
makeSelections(Map<String, String> map): Applies the specified filters to the search specifications.
selectUserRating(String desiredUserRating): Selects a user rating filter based on the desired rating.
countNumberOfStarsInRatingSelector(WebElement w): Counts the number of filled stars in a rating selector.
getUserRatingOption(): Returns the WebElement for the user rating filter option.
isOptionDisabled(WebElement Option): Returns true if the given filter option is disabled, false otherwise.
makeIndividualSelection(WebElement specGroup, String selectionToMake): Selects a filter option based on the given selection string.
isShowMoreElement(WebElement finalElement): Returns true if the given element is a "Show More" element, false otherwise.
getSpecificationTitle(WebElement specification): Returns the title of a specification.
```

## Usage

This `SearchSpecifications` class should be used in a Selenium Java test suite for interacting with and managing the search specifications sidebar in a web application. It makes it easier to write maintainable and readable test code by encapsulating the functionality and structure of the search specifications.

By using the methods provided by this class, you can apply filters, reset selections, and verify if options are disabled, which are common tasks when testing search specifications and filter functionalities in a web application.

**SupplyHouseHomePage**

This class models the SupplyHouse home page for the purpose of automating browser testing with Selenium. The class extends the `BasePageObject` class and contains several fields, constructors, and methods to interact with and verify the home page's elements.

**Fields**

- `actions`: A `Actions` object used for performing complex user interactions.
- `wait`: A `WebDriverWait` object for waiting for certain conditions.
- Various `WebElement` fields corresponding to navigation bar elements and trusted brands.
- `navBar*` static final fields, which are strings containing the XPath of the corresponding navigation bar elements.

**Constructor**

- `SupplyHouseHomePage(WebDriver driver)`: Constructs a new `SupplyHouseHomePage` instance for the given `WebDriver`. Initializes the `Actions` and `WebDriverWait` objects, checks that the current URL is the home page URL, and initializes the `WebElement` fields using `PageFactory`.

**Methods**

- `getNumberOfTrustedBrands()`: Returns the number of trusted brands displayed on the home page.
- `getNamesOfTrustedBrands()`: Returns a list of strings representing the names of the trusted brands displayed on the home page.
- `clickTrustedBrand(String brandName)`: Clicks the trusted brand link with the specified brand name, if found.
- `generateDynamicTrustedBrandXpath(String brandName)`: Generates an XPath string for the trusted brand link with the specified brand name.
- `hoverOverNavBar*()`: A set of methods for hovering over the navigation bar elements.
- `getNavBar*()`: A set of methods for getting the `WebElement` instances of the navigation bar elements.
- `navigateToSupplyHouseHomePage(WebDriver driver)`: Navigates the given `WebDriver` to the SupplyHouse home page.
- `searchForItem(String item)`: Searches for an item using the search bar on the home page.
- `getHomePageUrl()`: Returns the home page URL as a string.
- `getAlternateHomePageUrl()`: Returns the alternate home page URL as a string.
- `hoverOverNavBarElementAndSelectCategory(String navBarCategory, String subCategory)`: Hovers over the specified navigation bar category and clicks the subcategory. Returns a boolean indicating success or failure.
- `topSearchBar`: A `WebElement` representing the search bar at the top of the home page.
- `topSearchBarXpath`: A string containing the XPath of the search bar at the top of the home page.
- `searchBarSubmitButton`: A `WebElement` representing the search bar submit button.

**Usage**

1. Instantiate a `WebDriver` instance.
2. Instantiate a `SupplyHouseHomePage` instance, passing the `WebDriver` instance as an argument.
3. Use the `SupplyHouseHomePage` instance's methods to interact with and verify the home page's elements.

# ItemSearchSteps Documentation

## Overview

This Java class, `ItemSearchSteps`, is a step definition file for a Cucumber test suite. It is designed to test the navigation, search, and filtering functionality of an e-commerce website called SupplyHouse. The class extends the `RunWeb` class and utilizes Selenium WebDriver for interacting with the web elements.

## Imports

The class imports various Java libraries, such as `java.io`, `java.time`, `java.util`, Selenium WebDriver components, TestNG components, and page object models.

## Class Variables

- `s`: An object representing the SupplyHouseHomePage.
- `c`: An object representing the CategorySearchPage.
- `i`: An object representing the ItemsByCategoryPage.
- `p`: An object representing the ProductDetailsPage.
- `selectedItemName`: A string representing the name of the selected item.
- `item`: A string representing the search item.
- `inStockOnly`, `productType`, `priceRange`, `reviewScore`, `application`, `material`, `size`: Strings representing search and filter parameters.
- `scenarioParams`: A HashMap that stores key-value pairs of scenario parameters.
- `softAssert`: An instance of SoftAssert to collect multiple assertions throughout the test.

## Cucumber Step Definitions

### Given Steps

- `@Given("User Selects (.*?) then selects (.*?) from dropdown menu$")`: The user hovers over a navbar element and selects a sub-category from the dropdown menu.
- `@Given("User Navigates to SupplyHouse HomePage without being logging in")`: The user navigates to the SupplyHouse home page without logging in.
- `@Given("User Searches For (.+)$")`: The user searches for an item using the search bar.
- `@Given("User is navigated to item category select Page, selects first category on page and subsequent category pages, selects first item displayed on search results page")`: The user selects the first category on the category search page, and then selects the first item displayed on the search results page.

### When Steps

- `@When("^User Selects (.*) at the HomePage$")`: The user selects a trusted brand on the home page.
- `@When("^User selects the following parameters: (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")`: The user selects various search and filter parameters on the items by category page.

### Then Steps

- `@Then("^Products with specifications are displayed$")`: The test verifies that the search results match the specified filter parameters.
- `@Then("Product details Page Corresponding with selected entry is displayed")`: The test verifies that the product details page matches the selected item.

## Other Methods

- `generateSearchSpecificationsFailureMessage()`: Generates a failure message with the specified selections.
- `Aftervalidation(Scenario scenario)`: Takes a screenshot if the scenario has failed, saves it to the specified file path, and closes the WebDriver.
- `getFormattedScenarioParams()`: Formats and returns a string with the scenario parameters.

## Usage

This step definition file should be used in conjunction with a Cucumber feature file that outlines the user scenarios to be tested. Implement the appropriate Given, When, and Then steps in the feature file to utilize the methods provided in this class.

# Test Reports

## Target Folder Structure

generated-test-sources: This folder typically contains the test sources that are generated during the build process. In your case, it contains test annotations. These annotations may have been generated by some annotation processing tools or frameworks used in your project.

maven-archiver and maven-status: These folders are created and used by Maven during the build process for archiving and maintaining the status of the build, respectively.

maven-compiler-plugin: This folder is related to the Maven Compiler Plugin, which compiles the source code of your project. In your case, it has a subfolder for test compilation, which suggests that your regression suite has compiled test code.

screenshots: This folder likely stores the screenshots captured during test execution, which can be helpful for debugging and understanding test failures.

surefire-reports: This folder contains the test reports generated by the Maven Surefire plugin. The reports are typically in XML format, and can be used by Continuous Integration (CI) servers, like Jenkins, to display the test results.

junitreports: This subfolder suggests that your regression suite uses JUnit as the testing framework.
old and surefire suite: These subfolders seem to contain older or archived Surefire reports.
Surefire suite: This folder suggests that you have a Surefire test suite configured in your project, which is responsible for running the tests.
test-output: This folder is typically created by the TestNG testing framework and contains test output, including logs and report files generated during test execution. The presence of this folder suggests that your regression suite may also use TestNG as a testing framework, in addition to JUnit.

