package pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import genericUtilities.Waits;
import io.cucumber.datatable.DataTable;
import managers.ReadFileManager;

public class SubscribeDigitalPage {

	public WebDriver driver;
	int Timeout = Integer.parseInt(ReadFileManager.getFileReaderManagerInstance().getConfigReader().getWaitTimeout());

	private static final String PAGETITLE = "//h2[contains(text(), 'Subscribe')]";
	private static final String CAPTCHA = "//iframe[@title='reCAPTCHA']";
	private static final String FIELDS = "//label[contains(text(),'$value$')]";
	private static final String REQUIREDFIELDS = "//label[contains(text(),'$value$')]/span[@class='required']";
	private static final String FIELDTYPE ="//label[contains(text(),'$value$')]/following-sibling::input";
	private static final String DROPDOWNFIELD = "//label[contains(text(),'$value$')]/following-sibling::select";
	private static final String RECAPTCHALINK = "//div[text()='reCAPTCHA']";


	public SubscribeDigitalPage(WebDriver driver) {
		this.driver = driver;
	}



	/**
	 * Below method is used to validate Subscribe page opened or not
	 */
	public void verifySubscribePageDisplayed(){

		By PageTitle = By.xpath(PAGETITLE);
		WebElement element = Waits.WaitForElementToAppear(driver, PageTitle, Timeout);
		Assert.assertTrue(element.isDisplayed());
	}

	/**
	 * Below method is used to verify the fields of the form in the subscribe page.
	 */
	public void verificationOfFields(DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
		
		for(Map<String, String> row:data) {

			String FieldType =  row.get("Type");

			if (FieldType.equals("text")) {

				String filedName = FIELDS.replace("$value$", row.get("Field"));
				String requiredElement = REQUIREDFIELDS.replace("$value$", row.get("Field"));
				String typeOfFieldElement = FIELDTYPE.replace("$value$", row.get("Field"));

				WebElement element = driver.findElement(By.xpath(filedName));
				Assert.assertTrue(element.isDisplayed());

				String required = row.get("Required");
				if (required.equals("true")) {
					WebElement reqelement = driver.findElement(By.xpath(requiredElement));
					Assert.assertTrue(reqelement.isDisplayed());
				}

				String type = row.get("Type");
				WebElement ElementType = driver.findElement(By.xpath(typeOfFieldElement));
				String elementType = ElementType.getAttribute("type");
				Assert.assertEquals(type, elementType);

			}
			else
			{
				String fieldName = FIELDS.replace("$value$", row.get("Field"));
				String reqElement = REQUIREDFIELDS.replace("$value$", row.get("Field"));
				String dropdownfield = DROPDOWNFIELD.replace("$value$", row.get("Field"));

				WebElement element = driver.findElement(By.xpath(fieldName));
				Assert.assertTrue(element.isDisplayed());

				String required = row.get("Required");
				if (required.equals("true")) {
					WebElement reqelement = driver.findElement(By.xpath(reqElement));
					Assert.assertTrue(reqelement.isDisplayed());
				}

				WebElement dropdownelement = driver.findElement(By.xpath(dropdownfield));
				Assert.assertTrue(dropdownelement.isDisplayed());


			}
		}
	}

	/**
	 * Below method is used to verify the reCaptcha.
	 */
	public void verifyRecaptchaLink()
	{

		driver.switchTo().frame(driver.findElement(By.xpath(CAPTCHA)));
		By CaptchaElement = By.xpath(RECAPTCHALINK);
		WebElement element = Waits.WaitForElementToAppear(driver, CaptchaElement, Timeout);
		Assert.assertTrue(element.isDisplayed());
	}

}
