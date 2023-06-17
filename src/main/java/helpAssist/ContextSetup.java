package helpAssist;

import managers.DriverManager;
import managers.PageObjectsManager;

/**
 * 
 * Objective of this class is the share the data between different StepDefination files using dependency injection.
 *
 */
public class ContextSetup {

	
		private DriverManager driverManager;
	    private PageObjectsManager pageObjectsManager;

	    /**
	     * The below constructor is used to initialize the variables
	     */
	    public ContextSetup(){
	        driverManager = new DriverManager();
	        pageObjectsManager = new PageObjectsManager(driverManager.getDriver());


	    }

	    /**
	     * 
	     * Below method will return the web driver manager object
	     */
	    public DriverManager getWebDriverManager() {
	        return driverManager;
	    }
	    
	    /**
	     * 
	     * Below method will return the page object manager objects
	     */
	    public PageObjectsManager getPageObjectsManager() {
	        return pageObjectsManager;
	    }
}
