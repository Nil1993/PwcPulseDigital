package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import genericUtilities.Waits;
import managers.ReadFileManager;

public class HomePage {

	public WebDriver driver;
	private static final String PAGETITLE = "//p[text()='Digital Pulse']";
	private static final String COLUMNS = "//div[contains(@class,'headline_column')]";
	private static final String ARTICLES = "//div[contains(@class,'headline_column')][$value$]/article";
	private static final String SUBSCRIBELINK = "//a[contains(@navigation-title,'Subscribe')]";
	private static final String SEARCHLINK = "//button[text()='Search']";
	private static final String SEARCHFIELD = "//input[@name='searchfield']";
	private static final String SUBMITBUTTON = "//input[@type='submit']";


	int Timeout = Integer.parseInt(ReadFileManager.getFileReaderManagerInstance().getConfigReader().getWaitTimeout());


	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * The below method is used to navigate to the home page.
	 */
	public void goToDigitalPulseHomePage(){
		driver.get(ReadFileManager.getFileReaderManagerInstance().getConfigReader().getTheApplicationUrl());
	}
	
	
	/**
	 * Objective of the below method is to verify whether Home page is displayed or not.
	 */
	public void verifyHomePageDisplayed(String pageName){

		By PageTitle = By.xpath(PAGETITLE);
		WebElement element = Waits.WaitForElementToAppear(driver, PageTitle, Timeout);
		Assert.assertTrue(element.isDisplayed());

	}

	/**
	 * Objective of the below method is to verify number of columns present
	 */
	public void verifyNumberOfColumns(int NumberOfColumn)
	{
		By columns = By.xpath(COLUMNS);
		List<WebElement> elements = driver.findElements(columns);
		int colCount = elements.size();
		Assert.assertEquals(colCount,NumberOfColumn);
	}

	/**
	 * Objective of the below method is to verify number of articles present in each column
	 */
	public void verifyNumberOfArticlesPerColumn(int column,int NumberOfArtcles)
	{
		String articles = ARTICLES.replace("$value$",String.valueOf(column));
		List<WebElement> elements = driver.findElements(By.xpath(articles));
		int ArticleCount = elements.size();
		Assert.assertEquals(NumberOfArtcles,ArticleCount);
	}
	
	/**
	 * Below method will click the Subscribe Link
	 */
	public void clickSubscribeLink()
	{
		By subscribeLink = By.xpath(SUBSCRIBELINK);
		WebElement element = Waits.WaitForElementToAppear(driver, subscribeLink, Timeout);
		element.click();

	}
	
	/**
	 * Below method will click the Search link
	 */
	public void clickSearchLink()
	{
		By searchLink = By.xpath(SEARCHLINK);
		WebElement element = Waits.WaitForElementToAppear(driver, searchLink, Timeout);
		Assert.assertTrue(element.isDisplayed());
		element.click();
	}
	
	/**
	 * 
	 * Below method enter the text in the search box
	 */
	public void enterTextIntoTheSearchField(String text)
	{
		By searchField = By.xpath(SEARCHFIELD);
		WebElement element = Waits.WaitForElementToAppear(driver, searchField, Timeout);
		Assert.assertTrue(element.isDisplayed());
		element.sendKeys(text);
	}
	
	/**
	 * Below method will click on the Submit button
	 */
	public void clickOnSubmitButton()
	{
		By submitButton = By.xpath(SUBMITBUTTON);
		WebElement element = Waits.WaitForElementToAppear(driver, submitButton, Timeout);
		Assert.assertTrue(element.isDisplayed());
		element.click();

	}


}
