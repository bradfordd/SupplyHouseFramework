package pageObjectModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePageObject {

	public ProductDetailsPage(WebDriver driver, WebDriverWait wait) {
		super(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//h1[@font-size='h5,,h4,,h2']")));
		driver.findElement(By.xpath("//h1[@font-size='h5,,h4,,h2']")).click();
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName() {
		return productTitle.getText();
	}
	
	
	@FindBy(xpath="//h1[@font-size='h5,,h4,,h2']")
	WebElement productTitle;

}
