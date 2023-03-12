package pageObjectModels;

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
	public ItemsByCategoryPage(WebDriver driver, WebDriverWait wait) {
		super(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header-groupings']/h1")));
		driver.findElement(By.xpath("//div[@class='header-groupings']/h1")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//div[@id='breadcrumbs']/ol/li")));
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//div[@class='desc']/a/strong")));
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
	
	@FindBy(xpath="//a[@class='product-name product-link']")
	List<WebElement> itemLinks;
	
	
	@FindBy(xpath="//div[@class='desc']/a/strong")
	List<WebElement> itemNames;
	
	@FindBy(xpath="//div[@id=\"breadcrumbs\"]/ol/li")
	List<WebElement> breadcrumbs;
	
	@FindBy(xpath="//div[@id='breadcrumbs']/ol/li//a")
	List<WebElement> breadcrumbLinks;
	
	@FindBy(xpath="//div[@class='header-groupings']/h1")
	WebElement PageTitle;
	
}
