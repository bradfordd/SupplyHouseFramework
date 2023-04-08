package StepDefinitions;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.commons.exec.util.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationUtils.RunWeb;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjectModels.CategorySearchPage;
import pageObjectModels.ItemsByCategoryPage;
import pageObjectModels.ProductDetailsPage;
import pageObjectModels.SupplyHouseHomePage;

public class ItemSearchSteps extends RunWeb{
	SupplyHouseHomePage s;
	CategorySearchPage c;
	WebDriverWait wait;
	ItemsByCategoryPage i;
	ProductDetailsPage p;
	String selectedItemName;
	@Given("User Navigates to SupplyHouse HomePage without being logging in")
	public void user_navigates_to_SupplyHouse_home_page_without_being_logging_in() {
		initializeWebDriver("Chrome");
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		SupplyHouseHomePage.navigateToSupplyHouseHomePage(driver);
	}
	@Given("User Searches For (.+)$")
	public void user_searches_for_item(String item) throws InterruptedException {
		s = new SupplyHouseHomePage(driver, wait);
		String oldUrl = driver.getCurrentUrl();
		s.searchForItem(item);			
//		String urlText = CategorySearchPage.getExpectedUrlText(item);
		//wait.until(ExpectedConditions.urlContains(oldUrl));
		Assert.assertTrue(waitForUrlChange(oldUrl, driver));
		c = new CategorySearchPage(driver, wait);
		String pageTitle = c.getPageTitle();
		Assert.assertTrue(pageTitle.toLowerCase().contains(item.toLowerCase()));
		ArrayList<String> breadCrumbValues= c.getBreadCrumbText();
		String getFinalBreadcrumbText = breadCrumbValues.get(breadCrumbValues.size() - 1);
		Assert.assertTrue(getFinalBreadcrumbText.toLowerCase().contains(item.toLowerCase()));
	}
	@Given("User is navigated to item category select Page, selects first category on page")
	public void user_is_navigated_to_item_search_results_page_selects_first_item_on_search_page() throws InterruptedException {
	    while (true) {
			String categoryName = c.getCategoryName(0);
			String oldUrl = driver.getCurrentUrl();
			c.selectCategory(0);
			Assert.assertTrue(waitForUrlChange(oldUrl, driver));
//			String urlText = CategorySearchPage.getExpectedUrlText(categoryName);
//			wait.until(ExpectedConditions.urlContains(urlText));
		    if (ItemsByCategoryPage.isItemPage(driver)) {
		    	break;
		    }
		    c = new CategorySearchPage(driver, wait);
		    String finalBreadCrumbValue = c.getFinalBreadCrumbText();
		    Assert.assertTrue(finalBreadCrumbValue.toLowerCase().contains(categoryName.toLowerCase()));
			String pageTitle = c.getPageTitle();
			Assert.assertTrue(pageTitle.toLowerCase().contains(pageTitle.toLowerCase()));
			ArrayList<String> breadCrumbValues= c.getBreadCrumbText();
			String getFinalBreadcrumbText = breadCrumbValues.get(breadCrumbValues.size() - 1);
			Assert.assertTrue(getFinalBreadcrumbText.toLowerCase().contains(pageTitle.toLowerCase()));
	    }
    	i = new ItemsByCategoryPage(driver, wait);
	    selectedItemName = i.getItemOnPageName(0);
	    //System.out.println("Select Item On Page: " + i.getItemOnPageName(0));
	    i.selectItemOnPage(0);
	}
	@Then("Product details Page Corresponding with selected entry is displayed")
	public void product_details_page_corresponding_with_selected_entry_is_displayed() {
		p = new ProductDetailsPage(driver, wait);
		String productName = p.getProductName();
		Assert.assertTrue(productName.toLowerCase().contains(selectedItemName.toLowerCase()));
	}
	
	@After("@WebTest")
	public void Aftervalidation()
	{
		closeWebDriver();
	}
}
