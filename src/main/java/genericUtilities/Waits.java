package genericUtilities;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	private static Logger log = LogManager.getLogger(Waits.class); 
	
	 public static WebElement WaitForElementToAppear(WebDriver driver, By by, Integer timeoutInSeconds){
	        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	        log.info("Element found: " + by);
	        return driver.findElement(by);
	    }


}
