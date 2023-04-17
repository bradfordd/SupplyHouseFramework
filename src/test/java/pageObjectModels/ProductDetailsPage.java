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

public class ProductDetailsPage extends BasePageObject {
	
	protected final static String productTitleXpath = "//h1[@font-size='h5,,h4,,h2']";

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(productTitleXpath)));
		driver.findElement(By.xpath(productTitleXpath)).click();
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName() {
		return productTitle.getText();
	}
	
	
	@FindBy(xpath=productTitleXpath)
	WebElement productTitle;

}
