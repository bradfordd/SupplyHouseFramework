package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import automationUtils.RunWeb;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjectModels.CategorySearchPage;
import pageObjectModels.ItemsByCategoryPage;
import pageObjectModels.ProductDetailsPage;
import pageObjectModels.SupplyHouseHomePage;
import utils.GenericUtils;

public class ItemSearchSteps extends RunWeb{
	SupplyHouseHomePage s;
	CategorySearchPage c;
	WebDriverWait wait;
	ItemsByCategoryPage i;
	ProductDetailsPage p;
	String selectedItemName;
	String item = "";
	Map<String, String> scenarioParams = new HashMap<String, String>();
	SoftAssert softAssert = new SoftAssert();
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
