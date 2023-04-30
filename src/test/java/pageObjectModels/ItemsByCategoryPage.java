package pageObjectModels;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemsByCategoryPage extends BasePageObject{
	
	protected static final String itemLinksXpath = "//a[@class='product-name product-link']";
	protected static final String itemNameXpath = "//div[@class='desc']/a/strong";
	protected static final String breadcrumbsXpath = "//div[@id='breadcrumbs']/ol/li";
	protected static final String breadcrumbLinksXpath = "//div[@id='breadcrumbs']/ol/li//a";
	protected static final String pageTitleXpath = "//div[@class='header-groupings']/h1";
	protected static final String itemCountXpath = "//*[@id='result-size-nav']";
	protected static final String productSpecificationsXpath = "//div[@id='refine-groups']//div[contains(@id, 'group')]";
	protected static final String itemListingsXpath = "//*[@id='browse-results']//li";
	
	public ItemsByCategoryPage(WebDriver driver) {
		super(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pageTitleXpath)));
		driver.findElement(By.xpath(pageTitleXpath)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(breadcrumbsXpath)));
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(itemNameXpath)));
		PageFactory.initElements(driver, this);
	}
	
	public List<ProductSearchResultListing> initializeItemListings() {
		List<WebElement> itemListings = driver.findElements(By.xpath(itemListingsXpath));
		List<ProductSearchResultListing> li = new ArrayList<ProductSearchResultListing>();
		for (WebElement w : itemListings) {
			if(w.isDisplayed()) {
				ProductSearchResultListing temp = new ProductSearchResultListing(w);
				li.add(temp);
			}
		}
		return li;
	}
	
	public int getNumberOfItems() {
		return itemLinks.size();
	}
	
	public void selectItemOnPage(int i) {
		itemLinks.get(i).click();
	}
	
	public void reinitializeItemsOnPage() {
		itemLinks = driver.findElements(By.xpath(itemLinksXpath));
	}
	
	public String getBreadcrumbValue(int i) {
		return breadcrumbs.get(i).getText();
	}
	
	public String getFinalBreadcrumbValue() {
		return breadcrumbs.get(breadcrumbs.size() - 1).getText();
	}
	
	public String getItemOnPageName(int i) {
		return itemNames.get(i).getText();
	}
	
	public static String getExpectedUrlText(String item) {
		if (item == "") {
			return item;
		}
		StringBuilder answer = new StringBuilder();
		char ch = item.charAt(0);
		answer.append(Character.toUpperCase(ch));
		for (int i = 1; i < item.length(); i++) {
			if (item.charAt(i) == ' ') {
				answer.append('-');
				i++;
				ch = item.charAt(i);
				ch = Character.toUpperCase(ch);
				answer.append(ch);
			} else {
				answer.append(item.charAt(i));
			}
		}
		return answer.toString();
	}
	
	public static Boolean isItemPage(WebDriver driver) {
		try{
		    driver.findElement(By.xpath(itemCountXpath));
		    return true;

		} catch(Exception e){
		    return false;
		}

	}
	
	public Boolean makeProductSpecification(String specificationType, String specificationMade) {
		if (specificationType.equals("In Stock Only")) {
			if (specificationMade.equals("true")) {
				//WebElement w = driver.findElement(By.xpath("//div[@id='refine-groups']//div[contains(@id, 'group')]//ul"));
				WebElement w = productSpecifications.get(0).findElement(By.tagName("ul"));
				w.click();
				return true;
			}
			else {
				return true;
			}
		}
		if (specificationMade.equals("Review Score")) {
			return ratingSpecification(specificationType, specificationMade);
		}
		for (int i = 1; i < productSpecifications.size(); i++) {
			WebElement w = productSpecifications.get(i).findElement(By.className("text"));
            if (w.getText().contains(specificationType)) {
            	return selectProductSpecificationOption(productSpecifications.get(i), specificationMade);
            }
        }
		return false;
	}
	
	public Boolean ratingSpecification(String specificationType, String specificationMade) {
		for (int i = 1; i < productSpecifications.size(); i++) {
			WebElement w = productSpecifications.get(i).findElement(By.className("text"));
			if (w.getText().equals("Review Score ")) {
            	return selectProductSpecificationOption(productSpecifications.get(i), specificationMade);
            }
		}
		return false;
	}
	
	public Boolean selectProductSpecificationOption(WebElement w, String specificationMade) {
		List<WebElement> options = w.findElements(By.tagName("li"));
		int optionsSize = options.size();
		WebElement lastElement = options.get(optionsSize - 1);
		if (lastElement.getAttribute("class").equals("show-more")) {
			WebElement showMoreButton = lastElement.findElement(By.tagName("a"));
			showMoreButton.click();
			for (int i = 0; i < options.size() - 1; i++) {
				WebElement temp = options.get(i).findElement(By.tagName("label"));
				System.out.println("Option: " + temp.getText());
			}
		} else {
			for (int i = 0; i < options.size(); i++) {
				WebElement temp = options.get(i).findElement(By.tagName("label"));
				System.out.println("Option: " + temp.getText());
			}
		}
		System.out.println("class Name: " + lastElement.getAttribute("class"));
		return true;
	}
	
	@FindBy(xpath=itemLinksXpath)
	List<WebElement> itemLinks;
	
	@FindBy(xpath= itemNameXpath)
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
	
	
	
}
