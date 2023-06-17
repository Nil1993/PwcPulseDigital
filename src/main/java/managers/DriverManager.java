package managers;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	/**
 	* Objective of the below class is to handle all the driver functions
 	*/
	public class DriverManager {

		private String BrowserDriver;
		private WebDriver driver;

		public DriverManager() {
			BrowserDriver = ReadFileManager.getFileReaderManagerInstance().getConfigReader().getTheBrowser();
		}

		/**
		 * Below method will return the current driver instance.
		 */
		public WebDriver getDriver() {
			if(driver == null)
				driver = createDriver();
			return driver;
		}
		
		/**
		 * Below method will create a new driver instance 
		 * according to the browser we choose
		 */
		private WebDriver createDriver() {
			switch (BrowserDriver) {
			case "FireFox" : 
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "Chrome" :
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.setAcceptInsecureCerts(true);
				driver = new ChromeDriver(options);
				break;
			case "InternetExplorer" : 
				driver = new InternetExplorerDriver();
				break;
			default:
				System.out.println("Choose A Right a Option");
				break;


			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ReadFileManager.getFileReaderManagerInstance().getConfigReader().getWaitTimeout())));
			return driver;
		}
		
		/**
		 * Below method will Close the all the Browser instances
		 */
		public void closeDriver() {
			driver.quit();
		}

}
