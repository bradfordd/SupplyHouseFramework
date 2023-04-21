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

public class CategorySearchPage extends BasePageObject {
	protected WebDriver driver;
	protected final String itemCategoriesXpath = "//a[@color='blueLink' and @font-weight='bold']/div[2]/span[1]";
	protected final String pageTitleXpath = "//h1[@font-size='22,,24,,34']";
	//protected final String breadcrumbsXpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div | /html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/a";
	protected final String breadcrumbsXpath = "//div[contains(@class, 'Box-sc-1z9git-0 hzZBOh')]";
	public CategorySearchPage(WebDriver driver) throws InterruptedException {
		super(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(pageTitleXpath)));
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(itemCategoriesXpath)));
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(breadcrumbsXpath)));
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
	
	
	@FindBy(xpath=itemCategoriesXpath)
	List<WebElement> itemCategories;
	
	@FindBy(xpath=pageTitleXpath)
	WebElement pageTitle;
			
	@FindBy(xpath=breadcrumbsXpath)
	List<WebElement> breadcrumbs;
	
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
				if ((i + 1 < item.length()) && Character.isLetter(item.charAt(i + 1))) {
					i++;
					ch = item.charAt(i);
					ch = Character.toUpperCase(ch);
					answer.append(ch);
				}
			} else if (item.charAt(i) == '(' || item.charAt(i) == ')') {
				continue;
			}
			else {
				answer.append(item.charAt(i));
			}
		}
		return answer.toString();
	}

}