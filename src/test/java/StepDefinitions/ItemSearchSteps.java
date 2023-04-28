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
	
	Map<String, String> scenarioParams = new HashMap<String, String>();
	SoftAssert softAssert = new SoftAssert();
	@Given("User Selects (.*?) then selects (.*?)$")
	public void user_selects_faucet_parts_then_selects_test(String navbarCategory, String subCategory) throws InterruptedException {
		GenericUtils.clickOnPageBody(driver);
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
//    	map.put("Review Score", reviewScore);
//    	map.put("In Stock Only", inStockOnly);
//    	map.put("Product Type", productType);
//    	map.put("Price Range", priceRange);
//    	map.put("Application", application);
//    	map.put("Material", material);
    	map.put("Size", size);
//    	String[] testCases = {
//                "5 Star",
//                "6 Star",
//                "4 Star",
//                "3 Star",
//                "2 Star",
//                "1 Star",
//                reviewScore
//        };
//
//        for (String testCase : testCases) {
//            int firstInteger = SearchSpecifications.findFirstIntegerBetweenOneAndFive(testCase);
//            System.out.println("The first integer between 1 and 5 in the input string \"" + testCase + "\" is: " + firstInteger);
//        }
//    	map.put("Size", size);
    	i = new ItemsByCategoryPage(driver);
    	Thread.sleep(2000);
    	SearchSpecifications s = new SearchSpecifications(driver);
    	Thread.sleep(2000);
    	s.makeSelections(map);
    	i.reinitializeItemsOnPage();
    	i.selectItemOnPage(0);
    	p = new ProductDetailsPage(driver);
//    	System.out.println(p.getProductName());
//    	System.out.println(p.getProductRating());
//    	System.out.println(ProductDetailsPage.parseIdFromSourceAttribute("data:image/svg+xml,%3C?xml%20version=%271.0%27%20encoding=%27utf-8%27?%3E%20%3C!--%20Generator:%20Adobe%20Illustrator%2023.1.1,%20SVG%20Export%20Plug-In%20.%20SVG%20Version:%206.00%20Build%200)%20--%3E%20%3Csvg%20version=%271.1%27%20id=%27Fill%27%20xmlns=%27http://www.w3.org/2000/svg%27%20xmlns:xlink=%27http://www.w3.org/1999/xlink%27%20x=%270px%27%20y=%270px%27%20viewBox=%270%200%20100%20100%27%20enable-background=%27new%200%200%20100%20100%27%20xml:space=%27preserve%27%3E%20%3Cpath%20fill=%27%23F15C02%27%20d=%27M79.44,0.95H20.56C9.78,0.95,0.95,9.78,0.95,20.56v58.87c0,10.79,8.82,19.61,19.61,19.61h58.87%20c10.79,0,19.61-8.83,19.61-19.61V20.56C99.05,9.78,90.22,0.95,79.44,0.95z%20M65.38,58.24l9.38,29.58L49.69,69.78L24.5,87.82%20l9.34-29.6L8.8,39.6l30.73-0.17c0,0,6.98-19.61,10-28.93c0.54,1.36,9.88,29.1,9.88,29.1H91.2L65.38,58.24z%27/%3E%20%3C/svg%3E\r\n"));
//    	System.out.println(ProductDetailsPage.parseIdFromSourceAttribute("data:image/svg+xml,%3C?xml%20version=%271.0%27%20encoding=%27utf-8%27?%3E%20%3C!--%20Generator:%20Adobe%20Illustrator%2023.1.1,%20SVG%20Export%20Plug-In%20.%20SVG%20Version:%206.00%20Build%200)%20--%3E%20%3Csvg%20version=%271.1%27%20id=%27With-RB%27%20xmlns=%27http://www.w3.org/2000/svg%27%20xmlns:xlink=%27http://www.w3.org/1999/xlink%27%20x=%270px%27%20y=%270px%27%20viewBox=%270%200%20100%20100%27%20enable-background=%27new%200%200%20100%20100%27%20xml:space=%27preserve%27%3E%20%3Cpath%20fill=%27%23FBC8B4%27%20d=%27M79.44,0.95H20.56C9.78,0.95,0.95,9.78,0.95,20.56v58.87c0,10.79,8.82,19.61,19.61,19.61h58.87%20c10.79,0,19.61-8.83,19.61-19.61V20.56C99.05,9.78,90.22,0.95,79.44,0.95z%20M65.38,58.24l9.38,29.58L49.69,69.78L24.5,87.82%20l9.34-29.6L8.8,39.6l30.73-0.17c0,0,6.98-19.61,10-28.93c0.54,1.36,9.88,29.1,9.88,29.1H91.2L65.38,58.24z%27/%3E%20%3C/svg%3E\r\n"
//    			+ ""));
    }

    @Then("^Products with specifications are displayed$")
    public void productDetailsPageIsDisplayed() {
        // Your implementation here
    }
    
	@Given("User Navigates to SupplyHouse HomePage without being logging in")
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
	@Given("User is navigated to item category select Page, selects first category on page and subsequent category pages, selects first item displayed")
	public void user_is_navigated_to_item_search_results_page_selects_first_item_on_search_page() throws InterruptedException {
	    while (true) {
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
	    }
    	i = new ItemsByCategoryPage(driver);
	    selectedItemName = i.getItemOnPageName(0);
	    i.selectItemOnPage(0);
	}
	@Then("Product details Page Corresponding with selected entry is displayed")
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
