package pageObjectModels;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategorySearchPage extends BasePageObject {
	protected WebDriver driver;
	
	public CategorySearchPage(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		super(driver);
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//h1[@class='Box-sc-1z9git-0 dfVmTn']")));
		driver.findElement(By.xpath("//h1[@class='Box-sc-1z9git-0 dfVmTn']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//a[@class='Box-sc-1z9git-0 fDOPef CategoryTileLink-sc-rz7j01-0 fkxXHf Box-sc-1z9git-0 Flex-sc-1qhr4qe-0 CategoryTile__CategoryTileContainerFlex-sc-1giyifi-2 gUKiTB dNxDHg goVhUA']")));
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//div[@class='Box-sc-1z9git-0 BreadcrumbLinks__BreadcrumbLinkContainer-sc-1251clj-0 fyQmaI fldFAB']//a")));
		PageFactory.initElements(driver, this);
	}
	
	public void selectCategory(int i) {
		itemCategories.get(i).click();
	}
	
	public String getCategoryName(int i) {
		return itemCategories.get(i).getText();
	}
	
	public int getNumberOfCategories() {
		return itemCategories.size();
	}
	
	public ArrayList<String> getCategoryValues() {
		ArrayList<String> li = new ArrayList<String>();
		for (int i = 0; i < itemCategories.size(); i++) {
			li.add(itemCategories.get(i).getText());
		}
		return li;
	}
	
	@FindBy(xpath="//a[@class='Box-sc-1z9git-0 fDOPef CategoryTileLink-sc-rz7j01-0 fkxXHf Box-sc-1z9git-0 Flex-sc-1qhr4qe-0 CategoryTile__CategoryTileContainerFlex-sc-1giyifi-2 gUKiTB dNxDHg goVhUA']")
	List<WebElement> itemCategories;
	
	@FindBy(xpath="//h1[@class='Box-sc-1z9git-0 dfVmTn']")
	WebElement pageTitle;
			
	@FindBy(xpath="//div[@class='Box-sc-1z9git-0 hzZBOh']")
	List<WebElement> breadcrumbs;
	
	@FindBy(xpath="//div[@class='Box-sc-1z9git-0 BreadcrumbLinks__BreadcrumbLinkContainer-sc-1251clj-0 fyQmaI fldFAB']//a")
	List<WebElement> breadcrumbLinks;
	

	
	
	public int getNumberOfBreadCrumbLinks() {
		return breadcrumbLinks.size();
	}
	
	public int getNumberOfBreadCrumbs() {
		return breadcrumbs.size();
	}
	
	public String getPageTitle() {
		return pageTitle.getText();
	}
	
	public ArrayList<String> getBreadCrumbText() {
		ArrayList<String> li = new ArrayList<String>();
		for(WebElement E: breadcrumbs) {
			li.add(E.getText());
		}
		return li;
	}
	
	public String getFinalBreadCrumbText() {
		return breadcrumbs.get(breadcrumbs.size() - 1).getText();
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
}