 package automationUtils;

 import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
 import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import pageObjectModels.CategorySearchPage;
import pageObjectModels.ItemsByCategoryPage;
import pageObjectModels.ProductDetailsPage;
import pageObjectModels.SupplyHouseHomePage;

 public class RunWeb {
 	public String frameworkDirectory = System.getProperty("user.dir");
	public WebDriver driver;
 	
 	public void initializeWebDriver(String webBrowser) {
 		webBrowser = webBrowser.toLowerCase();
 		switch (webBrowser) {
 		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", frameworkDirectory + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver(options);
 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 			break;
 		case "edge":
 			System.out.println(frameworkDirectory + "\\browserDrivers\\msedgedriver.exe");
 			driver = new FirefoxDriver();
 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 			break;
 		case "firefox":
 			System.setProperty("webdriver.gecko.driver", frameworkDirectory + "\\browserDrivers\\geckodriver.exe");
 			driver = new EdgeDriver();
 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 			break;
 		default:
 			System.out.println("improper settings for WebBrowser, using default webbrowser (Chrome)");
 			System.setProperty("webdriver.chrome.driver", frameworkDirectory + "\\browserDrivers\\chromedriver.exe");
 			driver = new ChromeDriver();
 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 			break;
 		}
 	}
 	
 	public static Boolean waitForUrlChange(String oldUrl, WebDriver driver) throws InterruptedException {
 		for (int i = 0; i < 15; i++) {
 			if (driver.getCurrentUrl() != oldUrl) {
 				return true;
 			}
 			Thread.sleep(2000);
 		}
 		return false;
 	}
 	
 	public void closeWebDriver() {
 		driver.close();
 	}
 }