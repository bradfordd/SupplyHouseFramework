package pageObjectModels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.GenericUtils;

public class ProductSearchResultListing {
	private WebElement listingElement;
	
	protected static final String productTitleClassPath = "product-name";
	protected static final String itemRatingClassPath = "desc-rating";
	protected static final String itemStatusClassPath = "status";

    public ProductSearchResultListing(WebElement listingElement) {
        this.listingElement = listingElement;
    }
    
    public String getProductTitle() {
    	return listingElement.findElement(By.className(productTitleClassPath)).getText();
    }
    
    public Double getItemRating() {
    	WebElement ratingBar = listingElement.findElement(By.className(itemRatingClassPath));
    	List<WebElement> ratingStars = ratingBar.findElements(By.className("star"));
    	double numberOfStars = 0.0;
    	for (int i = 0; i < ratingStars.size(); i++) {
    		String starClassName = ratingStars.get(i).getAttribute("class");
    		switch (starClassName) 
    		{
    			case "star off":
    				break;
    			case "star half":
    				numberOfStars += 0.5;
    				break;
    			case "star ":
    				numberOfStars += 1.0;
    				break;
				default:
					return -1.0;
    		}
    	}
    	return numberOfStars;
    }
    
    public static Boolean doesProductListingsMatchSpecs(List<ProductSearchResultListing> li, String inStock, String expectedRating) {
	    if (!expectedRating.equals("null")) {
	    	double expectedRatingLowerBound = GenericUtils.findFirstIntegerBetweenOneAndFive(expectedRating);
	    	double expectedRatingUpperBound = expectedRatingLowerBound;
	    	if (expectedRatingLowerBound != 1.0) {
	    		expectedRatingUpperBound += 0.5;
	    	}
	    	expectedRatingLowerBound -= 0.5;
	    	for (ProductSearchResultListing temp : li) {
	    	    double actualRating = temp.getItemRating();
	    	    if (actualRating < expectedRatingLowerBound || actualRating > expectedRatingUpperBound) {
	    	    	return false;
	    	    }
	    	}
	    }
	    if (inStock.equals("true")) {
	    	for (ProductSearchResultListing temp : li) {
	    		if (!temp.getInventoryStatus().equals("in stock")) {
	    			return false;
	    		}
	    	}
	    }
    	return true;
    }
    
    public String getInventoryStatus() {
    	String statusElementClassName = listingElement.findElement(By.className(itemStatusClassPath)).getAttribute("class");
    	if (statusElementClassName.contains("in-stock") || statusElementClassName.contains("available-atp")) {
    		return "in stock";
    	}
    	System.out.println(listingElement.findElement(By.className(itemStatusClassPath)).getAttribute("outerHTML"));
    	return "not in stock";
    }
}
