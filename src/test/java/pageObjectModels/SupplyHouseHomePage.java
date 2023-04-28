package pageObjectModels;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SupplyHouseHomePage extends BasePageObject{
	protected Actions actions;
	protected WebDriverWait wait;
 	protected SupplyHouseHomePage s;
	protected CategorySearchPage c;
	protected ItemsByCategoryPage i;
	protected ProductDetailsPage p;
	Map<String, String> scenarioParams = new HashMap<String, String>();
	SoftAssert softAssert = new SoftAssert();
	
	//protected static final String navBarXpath = "//ul[contains(@class, 'HeaderNavBarUl')]";
	
	//protected static final String navBarSubCategoryXpathTemplate = "//a[contains(text(), 'subcategoryName')]";
	
	protected static final String navBarPlumbingXpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[3]";
	
	@FindBy(xpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[3]/a")
    protected WebElement navBarPlumbing;
	
	protected static final String navBarHeatingXpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[4]";
    
    @FindBy(xpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[4]/a")
    protected WebElement navBarHeating;
    
    protected static final String navBarHVACXpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[5]";
    
    @FindBy(xpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[5]/a")
    protected WebElement navBarHVAC;
    
    protected static final String navBarPEXXpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[6]";
    
    @FindBy(xpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[6]/a")
    protected WebElement navBarPEX;
    
    protected static final String navBarFittingsXpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[7]";
    
    @FindBy(xpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[7]/a")
    protected WebElement navBarFittings;
    
    protected static final String navBarValvesXpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[8]";
    
    @FindBy(xpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[8]/a")
    protected WebElement navBarValves;
    
    protected static final String navBarThermostatsXpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[9]";
    
    @FindBy(xpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[9]/a")
    protected WebElement navBarThermostats;
    
    protected static final String navBarElectricalXpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[10]";
    
    @FindBy(xpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[10]/a")
    protected WebElement navBarElectrical;
    
    protected static final String navBarResourcesXpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[13]";
    
    @FindBy(xpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[13]/a")
    protected WebElement navBarResources;
    
    protected static final String navBarOurTeamXpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[14]";
    
    @FindBy(xpath = "//ul[contains(@class, 'HeaderNavBarUl')]/li[14]/a")
    protected WebElement navBarOurTeam;
    
    @FindBy(xpath = "//a[contains(@class, 'HomePageTrustedBrandLink__HomePageTrustedBrandLinkContainer')]")
    protected List<WebElement> trustedBrands;
	
    public int getNumberOfTrustedBrands() {
    	return trustedBrands.size();
    }
    
    public List<String> getNamesOfTrustedBrands() {
    	List<String> ls = new ArrayList<String>();
    	for (int i = 0; i < trustedBrands.size(); i++) {
    		String temp = trustedBrands.get(i).getAttribute("href");
    		temp = temp.replace(getHomePageUrl(), "");
    		ls.add(temp);
    	}
    	
    	return ls;
    }
    
    public Boolean clickTrustedBrand(String brandName) {
    	List<String> trustedBrands = this.getNamesOfTrustedBrands();
    	for (String item : trustedBrands) {
            if (item.equals(brandName)) {
            	String myXpath = generateDynamicTrustedBrandXpath(item);
            	WebElement linkToClick = driver.findElement(By.xpath(myXpath));
            	linkToClick.click();
            	return true;
            }
        }
    	return false;
    }
    
    public String generateDynamicTrustedBrandXpath(String brandName) {
    	return "//a[@href='/" + brandName + "']";
    }
    
	public SupplyHouseHomePage(WebDriver driver) {
		super(driver);
		//driver.findElement(By.xpath("//html")).click();
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Assert.assertEquals(this.getCurrentUrl(), "https://www.supplyhouse.com/");
		PageFactory.initElements(driver, this);
		wait.until(ExpectedConditions.visibilityOfAllElements(trustedBrands));
	}
	
	
	public Boolean hoverOverNavBarElementAndSelectCategory(String navBarCategory, String subCategory) {
		navBarCategory = navBarCategory.toLowerCase();
		String dynamicXpath = "";
		switch (navBarCategory) {
		case "plumbing":
			dynamicXpath += navBarPlumbingXpath;
			this.hoverOverNavBarPlumbing();
			break;
		case "heating":
			dynamicXpath += navBarHeatingXpath;
			this.hoverOverNavBarHeating();
			break;
		case "hvac":
			dynamicXpath += navBarHVACXpath;
			this.hoverOverNavBarHVAC();
			break;
		case "pex":
			dynamicXpath += navBarPEXXpath;
			this.hoverOverNavBarPEX();
			break;
		case "fittings":
			dynamicXpath += navBarFittingsXpath;
			this.hoverOverNavBarFittings();
			break;
		case "valves":
			dynamicXpath += navBarValvesXpath;
			this.hoverOverNavBarValves();
			break;
		case "thermostats":
			dynamicXpath += navBarThermostatsXpath;
			this.hoverOverNavBarThermostats();
			break;
		case "electrical":
			dynamicXpath += navBarElectricalXpath;
			this.hoverOverNavBarElectrical();
			break;
		case "resources":
			dynamicXpath += navBarResourcesXpath;
			this.hoverOverNavBarResources();
			break;
		case "our team":
			dynamicXpath += navBarOurTeamXpath;
			this.hoverOverNavBarOurTeam();
			break;
		default:
			return false;
		}
		dynamicXpath += "//a[contains(text(), '";
		dynamicXpath += subCategory;
		dynamicXpath += "')]";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXpath)));
		driver.findElement(By.xpath(dynamicXpath)).click();
		return true;
	}
	
	public void hoverOverNavBarPlumbing() {
		WebElement navBarPlumbing = this.getNavBarPlumbing();
		actions.moveToElement(navBarPlumbing).perform();
	}
	
	public void hoverOverNavBarHeating() {
	    WebElement navBarHeating = this.getNavBarHeating();
	    actions.moveToElement(navBarHeating).perform();
	}

	public void hoverOverNavBarHVAC() {
	    WebElement navBarHVAC = this.getNavBarHVAC();
	    actions.moveToElement(navBarHVAC).perform();
	}

	public void hoverOverNavBarPEX() {
	    WebElement navBarPEX = this.getNavBarPEX();
	    actions.moveToElement(navBarPEX).perform();
	}

	public void hoverOverNavBarFittings() {
	    WebElement navBarFittings = this.getNavBarFittings();
	    actions.moveToElement(navBarFittings).perform();
	}

	public void hoverOverNavBarValves() {
	    WebElement navBarValves = this.getNavBarValves();
	    actions.moveToElement(navBarValves).perform();
	}

	public void hoverOverNavBarThermostats() {
	    WebElement navBarThermostats = this.getNavBarThermostats();
	    actions.moveToElement(navBarThermostats).perform();
	}

	public void hoverOverNavBarElectrical() {
	    WebElement navBarElectrical = this.getNavBarElectrical();
	    actions.moveToElement(navBarElectrical).perform();
	}

	public void hoverOverNavBarResources() {
	    WebElement navBarResources = this.getNavBarResources();
	    actions.moveToElement(navBarResources).perform();
	}

	public void hoverOverNavBarOurTeam() {
	    WebElement navBarOurTeam = this.getNavBarOurTeam();
	    actions.moveToElement(navBarOurTeam).perform();
	}

	
	public WebElement getNavBarPlumbing() {
		wait.until(ExpectedConditions.elementToBeClickable(navBarPlumbing));
		return navBarPlumbing;
	}
	public WebElement getNavBarHeating() {
	    wait.until(ExpectedConditions.elementToBeClickable(navBarHeating));
	    return navBarHeating;
	}

	public WebElement getNavBarHVAC() {
	    wait.until(ExpectedConditions.elementToBeClickable(navBarHVAC));
	    return navBarHVAC;
	}

	public WebElement getNavBarPEX() {
	    wait.until(ExpectedConditions.elementToBeClickable(navBarPEX));
	    return navBarPEX;
	}

	public WebElement getNavBarFittings() {
	    wait.until(ExpectedConditions.elementToBeClickable(navBarFittings));
	    return navBarFittings;
	}

	public WebElement getNavBarValves() {
	    wait.until(ExpectedConditions.elementToBeClickable(navBarValves));
	    return navBarValves;
	}

	public WebElement getNavBarThermostats() {
	    wait.until(ExpectedConditions.elementToBeClickable(navBarThermostats));
	    return navBarThermostats;
	}

	public WebElement getNavBarElectrical() {
	    wait.until(ExpectedConditions.elementToBeClickable(navBarElectrical));
	    return navBarElectrical;
	}

	public WebElement getNavBarResources() {
	    wait.until(ExpectedConditions.elementToBeClickable(navBarResources));
	    return navBarResources;
	}

	public WebElement getNavBarOurTeam() {
	    wait.until(ExpectedConditions.elementToBeClickable(navBarOurTeam));
	    return navBarOurTeam;
	}

	
	public static void navigateToSupplyHouseHomePage(WebDriver driver) {
		driver.get("https://www.supplyhouse.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.supplyhouse.com/"));
	}
	
	public Boolean searchForItem(String item) throws InterruptedException {
		String currUrl = "";
		topSearchBar.click();
		Thread.sleep(2000);
		topSearchBar.sendKeys(item + Keys.ENTER);
		Thread.sleep(5000);
		currUrl = driver.getCurrentUrl();
		if (!currUrl.equals(getHomePageUrl()) && !currUrl.equals(getAlternateHomePageUrl())) {
			return true;
		}
		PageFactory.initElements(driver, this);
		for (int i = 0 ; i < 3; i++) {
			PageFactory.initElements(driver, this);
			topSearchBar.click();
			Thread.sleep(2000);
			topSearchBar.sendKeys(item + Keys.ENTER);
			Thread.sleep(5000);
			currUrl = driver.getCurrentUrl();
			if (currUrl != getHomePageUrl() && currUrl != getAlternateHomePageUrl()) {
				return true;
			}
		}
		return false;
	}
	
	public static String getHomePageUrl() {
		return "https://www.supplyhouse.com/";
	}
	
	public static String getAlternateHomePageUrl() {
		return "https://www.supplyhouse.com/?";
	}
	
	
	@FindBy(id="react-header-search-input")
	WebElement topSearchBar;
	
	protected static final String topSearchBarXpath = "react-header-search-input";
	
	@FindBy(id="headerSearchSubmitButton")
	WebElement searchBarSubmitButton;
	
	
	
}