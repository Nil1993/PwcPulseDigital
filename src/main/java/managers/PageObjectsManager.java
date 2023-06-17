package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.SearchResultPage;
import pageObjects.SubscribeDigitalPage;

public class PageObjectsManager {
	
	 private WebDriver driver;
	 private HomePage homePage;
	 private SubscribeDigitalPage subscribedigitalpage;

	 private SearchResultPage searchResultPage;


	    public PageObjectsManager(WebDriver driver) {
	        this.driver = driver;
	    }

	    /**
	     * The below method will return an instance of Home page.
	     */
	    public HomePage getHomePage() {
	        if(homePage == null)
	        	return new HomePage(driver);
	        else
	        	return homePage;
	    }
	    
	    /**
	     * The below method will return an instance of SubsribeDigital page.
	     */
	    public SubscribeDigitalPage getSubscribeDigitalPage() {
	         if(subscribedigitalpage == null)
	        	 return new SubscribeDigitalPage(driver);
	         else
	        	 return subscribedigitalpage;
	    }

	    /**
	     * The below method will return an instance of SearchResultPage page.
	     */
	    public SearchResultPage getSearchResultPage() {
	         if(searchResultPage == null)
	        	 return new SearchResultPage(driver);
	         else
	        	 return searchResultPage;
	    }

	    
	   



}
