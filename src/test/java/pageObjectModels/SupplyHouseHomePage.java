package pageObjectModels;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SupplyHouseHomePage extends BasePageObject{
	protected WebDriver driver;
	public SupplyHouseHomePage(WebDriver driver) {
		super(driver);
		driver.findElement(By.xpath("//html")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("react-header-search-input")));
		Assert.assertEquals(this.getCurrentUrl(), "https://www.supplyhouse.com/");
		PageFactory.initElements(driver, this);
	}
	
	public static void navigateToSupplyHouseHomePage(WebDriver driver) {
		driver.get("https://www.supplyhouse.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.supplyhouse.com/"));
	}
	
	public void searchForItem(String item) throws InterruptedException {
		topSearchBar.click();
		Thread.sleep(2000);
		topSearchBar.sendKeys(item + Keys.ENTER);
	}
	
	public static String getHomePageUrl() {
		return "https://www.supplyhouse.com/";
	}
	
	public static String getAlternateHomePageUrl() {
		return "https://www.supplyhouse.com/?";
	}
	
	
	@FindBy(id="react-header-search-input")
	WebElement topSearchBar;
	
	@FindBy(id="headerSearchSubmitButton")
	WebElement searchBarSubmitButton;
	
	
	
}