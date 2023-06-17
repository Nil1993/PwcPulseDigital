package stepDefination;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import helpAssist.ContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;

public class HomePageStepDef {
	
	public ContextSetup context;
	public HomePage homepage;
	private static Logger log = LogManager.getLogger(HomePageStepDef.class);
	
	public HomePageStepDef(ContextSetup context) {
        this.context = context;
        this.homepage= context.getPageObjectsManager().getHomePage();
    }
	
	@Given("^I navigate to the PwC Digital Pulse website$")
    public void I_Navigated_pwc_digital_website() throws Throwable {
		homepage.goToDigitalPulseHomePage();;
    }

	
	 @When("^I am viewing the \"(.*)\" page$")
	 public void I_Am_Viewing_ThePage(String pageName) {
		 homepage.verifyHomePageDisplayed(pageName);
	    }
	 
	 @Then("^I am presented with \"(.*)\" columns of articles$")
	 public void I_Am_Presented_With_Columns_Of_Articles(String colNum) {
		  int col = Integer.parseInt(colNum);
		  homepage.verifyNumberOfColumns(col);
	      log.info(col+" columns of articles are present");
	        
	    }

	 @And("^The Left \"(.*)\" column is displaying \"(.*)\" articles$")
	 public void The_Left_Column_Is_Displaying_Articles(String column,String articleNum) {
		  int articleNumbers = Integer.parseInt(articleNum);
		  homepage.verifyNumberOfArticlesPerColumn(Integer.parseInt(column),articleNumbers);
		  log.info(articleNumbers+" articles are present in the left column");
	    }

	 @And("^the Middle \"(.*)\" column is displaying \"(.*)\" articles$")
	 public void the_MiddleColumn_IsDisplaying_Articles(String column,String articleNum) {
	     int articleNumbers = Integer.parseInt(articleNum);
	     homepage.verifyNumberOfArticlesPerColumn(Integer.parseInt(column),articleNumbers);
	     log.info(articleNumbers+" article is present in the middle column");
	    }

	 @And("^The Right \"(.*)\" is displaying \"(.*)\" articles$")
	 public void the_RightColumn_IsDisplaying_Articles(String column,String articleNum) {
		 int articleNumbers = Integer.parseInt(articleNum);
		 homepage.verifyNumberOfArticlesPerColumn(Integer.parseInt(column),articleNumbers);
	     log.info(articleNumbers+" articles are present in the right column");
	    }
	 
	 @When("^I click on the Subscribe navigation link$")
	 public void I_ClickOn_The_Subscribe_Navigation_Link() {
		 homepage.clickSubscribeLink();
	     log.info("Clicked Subscribe Link");
	    }

	 @When("^I click on the Magnifying glass icon to perform a search$")
	 public void I_ClickOn_The_MagnifyingGlassIcon_To_PerformASearch() {
		 homepage.clickSearchLink();;
	     log.info("Clicked on Search Button");
	    }


	 @And("^I enter the text \"(.*)\"$")
	 public void I_Enter_TheText_SinglePageApplications(String input) {

		 homepage.enterTextIntoTheSearchField(input);
	     log.info("Text entered into the Searchbox");
	    }

	    @And("^I submit the search$")
	    public void I_Submit_The_Search() {

	    homepage.clickOnSubmitButton();
	    log.info("Clicked on the Submit Search button");
	    }


}
