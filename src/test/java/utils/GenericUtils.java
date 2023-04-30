package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericUtils {
	public static String replaceSpacesWithUnderscores(String input) {
        return input.replace(' ', '_');
    }
	//The following function is very important for hover functions as hovers need to have the body selected 
	//before they can hover effectively
	public static void clickOnPageBody(WebDriver driver) throws InterruptedException {
        WebElement bodyElement = driver.findElement(By.cssSelector("body"));
        bodyElement.click();
		Thread.sleep(5000);
	}
	
	public static int findFirstIntegerBetweenOneAndFive(String input) { //Reviewed
        Pattern pattern = Pattern.compile("[1-5]");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            return -1; // Return -1 if no integer between 1 and 5 is found
        }
    }
}
