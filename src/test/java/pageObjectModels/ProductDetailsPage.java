package pageObjectModels;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.util.regex.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ProductDetailsPage extends BasePageObject {
	
	protected final static String productTitleXpath = "//h1[@font-size='h5,,h4,,h2']";
	
	protected final static String ratingsBarClassPath = "ProductPageHeaderProductRating__ProductPageHeaderProductRatingLink-sc-7ouyyv-0";
	
	protected final static String itemPriceXpath = 
			"//*[contains(@class, 'ProductPageContainerQuantityAdjustors')]//*[contains(@class, 'ProductPriceText__ProductPriceTextAmount')]";

	protected final static String inStockStatusXpath = 
			"//*[contains(@class, 'ProductPageContainerQuantityAdjustors')]//*[contains(@class, 'ProductInventoryStatusAndPromiseMessageText')]";
	
	protected final static String productSpecsXpath = 
			"//*[contains(@class, 'ProductPageSpecification__ProductPageSpecificationTableRow')]";
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath(productTitleXpath)));
		driver.findElement(By.xpath(productTitleXpath)).click();
		PageFactory.initElements(driver, this);
	}
	
	public static String parseIdFromSourceAttribute(String src) {
		Pattern pattern = Pattern.compile("id=%27(.+?)%27");
        Matcher matcher = pattern.matcher(src);
        if (matcher.find()) {
            return matcher.group(1);
        }
		return "";
	}
	
	public String getProductName() {
		return productTitle.getText();
	}
	
	public Boolean isProductName(String expectedProductName) {
		return productTitle.getText().contains(expectedProductName);
	}
	
	public String getProductPrice() {
		return productPrice.getText();
	}
	
	public Boolean isSizeOfProduct(String input) {
		ArrayList<String> li = getSize();
		for (int i = 0; i < li.size(); i++) {
			if (input.equals(li.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	private ArrayList<String> getSize() {
		ArrayList<String> apps = new ArrayList<String>();
		for (int i = 0; i < productSpecs.size(); i++) {
			String tableHeader = productSpecs.get(i).findElement(By.tagName("th")).getText();
			System.out.println("Table Header: " + tableHeader);
			if (tableHeader.equals("Size:")) {
				List<WebElement> li = productSpecs.get(i).findElements(By.tagName("p"));
				for(WebElement w : li) {
					apps.add(w.getText());
				}
				return apps;
			}
		}
		return apps;
	}

	public Boolean isMaterialOfProduct(String input) {
		ArrayList<String> li = getMaterial();
		for (int i = 0; i < li.size(); i++) {
			if (input.equals(li.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<String> getMaterial() {
		ArrayList<String> apps = new ArrayList<String>();
		for (int i = 0; i < productSpecs.size(); i++) {
			String tableHeader = productSpecs.get(i).findElement(By.tagName("th")).getText();
			System.out.println("Table Header: " + tableHeader);
			if (tableHeader.equals("Material:")) {
				List<WebElement> li = productSpecs.get(i).findElements(By.tagName("p"));
				for(WebElement w : li) {
					apps.add(w.getText());
				}
				return apps;
			}
		}
		return apps;
	}
	
	public Boolean isMemberOfApplications(String input) {
		ArrayList<String> li = getApplications();
		for (int i = 0; i < li.size(); i++) {
			if (input.equals(li.get(i))) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public ArrayList<String> getApplications() {
		ArrayList<String> apps = new ArrayList<String>();
		for (int i = 0; i < productSpecs.size(); i++) {
			String tableHeader = productSpecs.get(i).findElement(By.tagName("th")).getText();
			System.out.println("Table Header: " + tableHeader);
			if (tableHeader.equals("Application:")) {
				List<WebElement> li = productSpecs.get(i).findElements(By.tagName("p"));
				for(WebElement w : li) {
					apps.add(w.getText());
				}
				return apps;
			}
		}
		return apps;
	}
	
	
	public double getProductRating() {
		List<WebElement> stars = ratingsBar.findElements(By.tagName("img"));
		double rating = 0.0;
		for (WebElement w : stars) {
		    String src = w.getAttribute("src");
		    String starType = parseIdFromSourceAttribute(src);
		    switch (starType) {
		    case "Fill":
		    	rating += 1;
		    	break;
		    case "Half":
		    	rating += 0.5;
		    	break;
		    case "No-RB":
		    	break;
	    	default:
	    		System.out.println("Couldn't Identify star type");
		    }
		}
		return rating;
	}
	
	
	@FindBy(className=ratingsBarClassPath)
	WebElement ratingsBar;
	
	@FindBy(xpath=productTitleXpath)
	WebElement productTitle;
	
	@FindBy(xpath=itemPriceXpath)
	WebElement productPrice;
	
	@FindBy(xpath=productSpecsXpath)
	List<WebElement> productSpecs;

}
