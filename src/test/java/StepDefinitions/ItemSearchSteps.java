package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import automationUtils.RunWeb;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectModels.CategorySearchPage;
import pageObjectModels.ItemsByCategoryPage;
import pageObjectModels.ProductDetailsPage;
import pageObjectModels.ProductSearchResultListing;
import pageObjectModels.SearchSpecifications;
import pageObjectModels.SupplyHouseHomePage;
import utils.GenericUtils;

public class ItemSearchSteps extends RunWeb{
	SupplyHouseHomePage s;
	CategorySearchPage c;
	ItemsByCategoryPage i;
	ProductDetailsPage p;
	String selectedItemName;
	String item = "";
	
	String inStockOnly;
	String productType; 
	String priceRange;
	String reviewScore;
	String application;
	String material; 
	String size;
	
	Map<String, String> scenarioParams = new HashMap<String, String>();
	SoftAssert softAssert = new SoftAssert();
	@Given("User Selects (.*?) then selects (.*?) from dropdown menu$")
	public void user_selects_faucet_parts_then_selects_test(String navbarCategory, String subCategory) throws InterruptedException { //Approved
		s = new SupplyHouseHomePage(driver);
		scenarioParams.put("navbarCategory", navbarCategory);
		scenarioParams.put("subCategory", subCategory);
		Assert.assertTrue(s.hoverOverNavBarElementAndSelectCategory(navbarCategory, subCategory), 
				String.format(
						"NavBar element navigation failed: %s",
						getFormattedScenarioParams()
						)
				);	
		c = new CategorySearchPage(driver);
	}
	
	@When("^User Selects (.*) at the HomePage$")
    public void userSelectsBrandAtHomePage(String brand) throws InterruptedException {
        s = new SupplyHouseHomePage(driver);
        s.clickTrustedBrand(brand);
    }

    @When("^User selects the following parameters: (.*), (.*), (.*), (.*), (.*), (.*), (.*)$")
    public void userSelectsParameters(String inStockOnly, String productType, String priceRange, String reviewScore, String application, String material, String size) throws InterruptedException {
    	Map<String, String> map = new HashMap<String, String>();
    	this.inStockOnly = inStockOnly;
    	this.productType = productType;
    	this.priceRange = priceRange;
    	this.reviewScore = reviewScore;
    	this.application = application;
    	this.material = material;
    	this.size = size;
    	scenarioParams.put("inStockOnly", inStockOnly);
    	scenarioParams.put("productType", productType);
    	scenarioParams.put("priceRange", priceRange);
    	scenarioParams.put("reviewScore", reviewScore);
    	scenarioParams.put("application", application);
    	scenarioParams.put("material", material);
    	scenarioParams.put("size", size);
    	map.put("In Stock Only", inStockOnly);
    	map.put("Review Score", reviewScore);
    	map.put("Product Type", productType);
    	map.put("Price Range", priceRange);
    	map.put("Application", application);
    	map.put("Material", material);
    	map.put("Size", size);
    	i = new ItemsByCategoryPage(driver);
    	SearchSpecifications s = new SearchSpecifications(driver);
    	Assert.assertTrue(s.makeSelections(map), generateSearchSpecificationsFailureMessage(inStockOnly, productType, priceRange, reviewScore, application, material, size));
    }
    
    public static String generateSearchSpecificationsFailureMessage(String inStockOnly, String productType, String priceRange, String reviewScore, String application, String material, String size) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("Couldn't specified selections, selections made are the following: \n");
    	sb.append("In Stock Only: " + inStockOnly + "\n");
    	sb.append("Product Type: " + productType + "\n");
    	sb.append("Price Range: " + priceRange + "\n");
    	sb.append("Review Score: " + reviewScore + "\n");
    	sb.append("Application: " + application + "\n");
    	sb.append("Material: " + material + "\n");
    	sb.append("Size: " + size);
    	return sb.toString();
    }

    @Then("^Products with specifications are displayed$")
    public void productDetailsPageIsDisplayed() {
    	List<ProductSearchResultListing> li = i.initializeItemListings();
    	Assert.assertTrue(ProductSearchResultListing.doesProductListingsMatchSpecs(li, inStockOnly, reviewScore, priceRange),
    			String.format(
    			"Specifications not reflected in search results: \n %s",
    					getFormattedScenarioParams()
    			)
    			);
    }
    
	@Given("User Navigates to SupplyHouse HomePage without being logging in")  //Approved
	public void user_navigates_to_SupplyHouse_home_page_without_being_logging_in() {
		initializeWebDriver("Chrome");
		SupplyHouseHomePage.navigateToSupplyHouseHomePage(driver);
	}
	@Given("User Searches For (.+)$")
	public void user_searches_for_item(String item) throws InterruptedException {
		this.item = item;
		scenarioParams.put("item", item);
		s = new SupplyHouseHomePage(driver);
		s.searchForItem(item);			
		c = new CategorySearchPage(driver);
		String pageTitle = c.getPageTitle();
		softAssert.assertTrue(
				pageTitle.toLowerCase().contains(item.toLowerCase()),
				String.format(
						"Page Title assertion failed: Expected '%s', but found '%s'. \n%s",
						item.toLowerCase(),
						pageTitle.toLowerCase(),
						getFormattedScenarioParams()
						)
				);
		ArrayList<String> breadCrumbValues= c.getBreadCrumbText();
		String getFinalBreadcrumbText = breadCrumbValues.get(breadCrumbValues.size() - 1);
		softAssert.assertTrue(
				getFinalBreadcrumbText.toLowerCase().contains(item.toLowerCase()),
				String.format(
						"Final Breadcrumb assertion failed: Expected '%s', but found '%s'. \n%s",
						item.toLowerCase(),
						getFinalBreadcrumbText.toLowerCase(),
						getFormattedScenarioParams()
						)
				);
	}
	
//	@Given("User is navigated to item category select Page, selects first category on page and subsequent category pages, selects first item displayed on search results page")
//	public void user_is_navigated_to_item_category_select_page_selects_first_category_on_page_and_subsequent_category_pages_selects_first_item_displayed_on_search_results_page() throws InterruptedException {
//		int j = 0;
//		while (j < 5) {
//			String categoryName = c.getCategoryName(0);
//			c.selectCategory(0);
//		    if (ItemsByCategoryPage.isItemPage(driver)) {
//		    	break;
//		    }
//		    c = new CategorySearchPage(driver);
//		    String finalBreadCrumbValue = c.getFinalBreadCrumbText();
//		    softAssert.assertTrue(
//		    		finalBreadCrumbValue.toLowerCase().contains(categoryName.toLowerCase()),
//		    		String.format(
//							"Final Breadcrumb assertion failed: Expected '%s', but found '%s'. \n%s",
//							categoryName.toLowerCase(),
//							finalBreadCrumbValue.toLowerCase(),
//							getFormattedScenarioParams()
//							)
//		    		);
//			String pageTitle = c.getPageTitle();
//			softAssert.assertTrue(
//					pageTitle.toLowerCase().contains(categoryName.toLowerCase()),
//					String.format(
//							"Page Title assertion failed: Expected '%s', but found '%s'. \n%s",
//							categoryName.toLowerCase(),
//							pageTitle.toLowerCase(),
//							getFormattedScenarioParams()
//							)
//					);
//			j++;
//	    }
//		if (j == 5) {
//			Assert.assertTrue(
//					false,
//					String.format(
//							"Navigation to item Search results failed: \n%s",
//							getFormattedScenarioParams()
//							)
//					);
//		}
//    	i = new ItemsByCategoryPage(driver);
//	    selectedItemName = i.getItemOnPageName(0);
//	    i.selectItemOnPage(0);
//	}

	@Given("User is navigated to item category select Page, selects first category on page and subsequent category pages, selects first item displayed")
	public void user_is_navigated_to_item_category_select_page_selects_first_category_on_page_and_subsequent_category_pages_selects_first_item_displayed() throws InterruptedException {
		int j = 0;
		while (j < 5) {
			String categoryName = c.getCategoryName(0);
			c.selectCategory(0);
		    if (ItemsByCategoryPage.isItemPage(driver)) {
		    	break;
		    }
		    c = new CategorySearchPage(driver);
		    String finalBreadCrumbValue = c.getFinalBreadCrumbText();
		    softAssert.assertTrue(
		    		finalBreadCrumbValue.toLowerCase().contains(categoryName.toLowerCase()),
		    		String.format(
							"Final Breadcrumb assertion failed: Expected '%s', but found '%s'. \n%s",
							categoryName.toLowerCase(),
							finalBreadCrumbValue.toLowerCase(),
							getFormattedScenarioParams()
							)
		    		);
			String pageTitle = c.getPageTitle();
			softAssert.assertTrue(
					pageTitle.toLowerCase().contains(categoryName.toLowerCase()),
					String.format(
							"Page Title assertion failed: Expected '%s', but found '%s'. \n%s",
							categoryName.toLowerCase(),
							pageTitle.toLowerCase(),
							getFormattedScenarioParams()
							)
					);
			j++;
	    }
		if (j == 5) {
			Assert.assertTrue(
					false,
					String.format(
							"Navigation to item Search results failed: \n%s",
							getFormattedScenarioParams()
							)
					);
		}
    	i = new ItemsByCategoryPage(driver);
	    selectedItemName = i.getItemOnPageName(0);
	    i.selectItemOnPage(0);
	}
	@Then("Product details Page Corresponding with selected entry is displayed") //Approved
	public void product_details_page_corresponding_with_selected_entry_is_displayed() {
		p = new ProductDetailsPage(driver);
		String productName = p.getProductName();
		softAssert.assertTrue(
				selectedItemName.toLowerCase().contains(productName.toLowerCase()),
				String.format(
						"Selected Title assertion failed: Expected '%s', but found '%s'. \n%s",
						selectedItemName.toLowerCase(),
						productName.toLowerCase(),
						getFormattedScenarioParams()
						)
				);
		softAssert.assertAll();
	}
	
	@After("@WebTest")
	public void Aftervalidation(Scenario scenario) throws IOException
	{
		
		if (scenario.isFailed()) {
			StringBuilder sb = new StringBuilder();
			sb.append(scenario.getName() + "-");
			for (Map.Entry<String, String> entry : scenarioParams.entrySet()) {
	            String temp = entry.getKey() + "- " + entry.getValue();
	            sb.append(temp);
	        }
			sb.append(".png");
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String filePathString = "C:\\Users\\lordr\\AppiumWorkspace\\AmazonFramework\\Automation\\target\\screenshots\\" + sb.toString();
			filePathString = GenericUtils.replaceSpacesWithUnderscores(filePathString);
			FileUtils.copyFile(srcFile, new File(filePathString));
		}
		closeWebDriver();
	}
	
	public String getFormattedScenarioParams() {
		StringBuilder sb = new StringBuilder();
		sb.append("Scenario Parameters: \n");
		for (Map.Entry<String, String> entry : scenarioParams.entrySet()) {
            String temp = entry.getKey() + ": " + entry.getValue() + "\n";
            sb.append(temp);
        }
		return sb.toString();
	}
}
