package utils;

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
}
