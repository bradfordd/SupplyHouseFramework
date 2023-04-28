package pageObjectModels;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class SearchSpecifications extends BasePageObject {
	protected Actions actions;
	protected WebDriverWait wait;
	
	public SearchSpecifications(WebDriver driver) {
		super(driver);
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="sidebar")
	WebElement specificationsWindow;
	
	@FindBy(xpath="//div[@id='refine-clear']//a")
	WebElement resetButton;
	
	@FindBy(xpath="//div[@id='refine-groups']//div[contains(@id, 'group')]")
	List<WebElement> specificationGroups;
	
	public static Document decodeAndParseSVG(String svgDataURL) throws UnsupportedEncodingException, SAXException, IOException, ParserConfigurationException {
        String[] parts = svgDataURL.split(",", 2);
        String data = URLDecoder.decode(parts[1], StandardCharsets.UTF_8.toString());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new ByteArrayInputStream(data.getBytes(StandardCharsets.UTF_8)));

        return document;
    }

    public static String identifyStarType(String src) {
        String starType = "unknown_star_type";
        try {
            Document svg = decodeAndParseSVG(src);
            Element svgElement = svg.getDocumentElement();
            String svgId = svgElement.getAttribute("id");

            if (svgId.equals("Fill")) {
                starType = "full_star";
            } else if (svgId.equals("Half")) {
                starType = "half_empty_star";
            } else if (svgId.equals("No-RB")) {
                starType = "empty_star";
            }
        } catch (Exception e) {
            System.err.println("Error identifying star type: " + e.getMessage());
        }

        return starType;
    }
    
    public static int findFirstIntegerBetweenOneAndFive(String input) {
        Pattern pattern = Pattern.compile("[1-5]");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            return -1; // Return -1 if no integer between 1 and 5 is found
        }
    }
	
	public void toggleInStockOnly() {
		specificationGroups.get(0).findElement(By.tagName("ul")).click();
	}
	
	public void resetSpecifications() {
		if (!resetButton.getAttribute("class").contains("hidden")) {
			resetButton.click();
		}
	}
	
	public void makeSelections(Map<String, String> map) throws InterruptedException {
		this.resetSpecifications();
		if (map.containsKey("In Stock Only") && map.get("In Stock Only").equals("true")) {
			toggleInStockOnly();
		}
		if (map.containsKey("Review Score") && map.get("Review Score") != "null") {
			selectUserRating(map.get("Review Score"));
		}
		for (int i = 1; i < specificationGroups.size(); i++) {
			String specificationTitle = getSpecificationTitle(specificationGroups.get(i));
			if (map.containsKey(specificationTitle) && map.get(specificationTitle) != "null") {
				makeIndividualSelection(specificationGroups.get(i), map.get(specificationTitle));
				Thread.sleep(1000);
			}
		}
	}
	
	private void selectUserRating(String desiredUserRating) {
		int desiredNumberOfStars = findFirstIntegerBetweenOneAndFive(desiredUserRating);
		WebElement userRatingOption = getUserRatingOption();
		List<WebElement> listElements = userRatingOption.findElements(By.tagName("li"));
		for (int i = 0; i < listElements.size(); i++) {
			//System.out.println(listElements.get(i).getAttribute("outerHTML"));
			//WebElement w = listElements.get(i).findElement(By.tagName("div"));
			List<WebElement> temp = listElements.get(i).findElements(By.tagName("div"));
			if (temp.size() != 0) {
				int filledStars = countNumberOfStarsInRatingSelector(temp.get(0));
				if (filledStars == desiredNumberOfStars) {
					listElements.get(i).click();
					return;
				}
				
			}
		}
		System.out.println("# of listElements: " + listElements.size());
	}

	private int countNumberOfStarsInRatingSelector(WebElement w) {
		List<WebElement> filledStars = w.findElements(By.tagName("div"));
		if (filledStars.size() == 0) {
			return -1;
		}
		int numberOfStars = 0;
		for (int i = 0; i < filledStars.size();i++) {
			String temp = filledStars.get(i).getAttribute("class");
			if (temp.equals("star ")) {
				numberOfStars++;
			}
		}
		return numberOfStars;
	}

	private WebElement getUserRatingOption() {
		for (int i = 0; i < specificationGroups.size(); i++) {
			List<WebElement> temp = specificationGroups.get(i).findElements(By.className("text"));
			if (temp.size() > 0) {
				String labelText = temp.get(0).getText();
				if (labelText.contains("Review Score")) {
					return specificationGroups.get(i);
				}
			}
		}
		return null;
	}

	public Boolean isOptionDisabled(WebElement Option) {
		WebElement input = Option.findElement(By.tagName("input"));
		if (input.getAttribute("disabled") != null) {
			return true;
		}
		return false;
	}
	
	public void makeIndividualSelection(WebElement specGroup, String selectionToMake) {
		List<WebElement> options = specGroup.findElements(By.tagName("li"));
		WebElement finalElement = options.get(options.size() - 1);
		if (isShowMoreElement(finalElement)) {
//			try {
//	            nonClickableElement.click();
//	        } catch (ElementNotInteractableException e) {
//	            isClickable = false;
//	        }
			try {
				finalElement.findElement(By.tagName("a")).click();
			} catch (ElementNotInteractableException e) {
				System.out.println("ShowMoreElement Not clicked");
			}
			for (int i = 0; i < options.size() - 1; i++) {
				WebElement temp = options.get(i).findElement(By.tagName("label"));
				String labelText = temp.getText();
				if (labelText.contains(selectionToMake) && !isOptionDisabled(options.get(i))) {
					temp.click();
					break;
				}
			}
		}
		else {
			for (int i = 0; i < options.size(); i++) {
				WebElement temp = options.get(i).findElement(By.tagName("label"));
				String labelText = temp.getText();
				if (labelText.contains(selectionToMake) && !isOptionDisabled(options.get(i))) {
					temp.click();
					break;
				}
			}
		}
	}

	private boolean isShowMoreElement(WebElement finalElement) {
		if (finalElement.getAttribute("class").equals("show-more")) {
			return true;
		}
		return false;
	}

	public String getSpecificationTitle(WebElement specification) {
		WebElement w = specification.findElement(By.className("text"));
		return w.getText();
	}
	
}
