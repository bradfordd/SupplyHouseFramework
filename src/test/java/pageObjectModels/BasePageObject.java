package pageObjectModels;

import org.openqa.selenium.WebDriver;

public class BasePageObject {
	protected WebDriver driver;
	BasePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
