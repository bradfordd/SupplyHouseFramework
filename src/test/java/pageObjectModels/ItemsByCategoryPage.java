package pageObjectModels;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemsByCategoryPage extends BasePageObject{
	protected WebDriver driver;
	
	protected static final String itemLinksXpath = "//a[@class='product-name product-link']";
	protected static final String itemNameXpath = "//div[@class='desc']/a/strong";
	protected static final String breadcrumbsXpath = "//div[@id='breadcrumbs']/ol/li";
	protected static final String breadcrumbLinksXpath = "//div[@id='breadcrumbs']/ol/li//a";
	protected static final String pageTitleXpath = "//div[@class='header-groupings']/h1";
	protected static final String itemCountXpath = "//*[@id='result-size-nav']";
	
	public ItemsByCategoryPage(WebDriver driver) {
		super(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(pageTitleXpath)));
		driver.findElement(By.xpath(pageTitleXpath)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(breadcrumbsXpath)));
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(itemNameXpath)));
		PageFactory.initElements(driver, this);
	}
	
	public int getNumberOfItems() {
		return itemLinks.size();
	}
	
	public void selectItemOnPage(int i) {
		itemLinks.get(i).click();
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
	
	
}
