package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * The objective of this class is to read the properties from Config.properties file
 *
 */
public class ConfigFileReader {

	private Properties prop;
    private final String propertyFilePath= "src/test/resources/Config.properties";
    
    public ConfigFileReader() {
    	prop= new Properties();
    	FileInputStream fis = null;
    	try {
			fis= new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * 
     * Objective of the below method is to get the browser name from properties file
     */
    public String getTheBrowser() {
    	return prop.getProperty("Browser");
    }
    
    /**
     * 
     * Objective of the below method is to get the Application URL from properties file
     */
    public String getTheApplicationUrl() {
        return prop.getProperty("url");
    }
    
    /**
     * 
     * Objective of the below method is to get the timeout value from properties file
     */
    public String getWaitTimeout() {
        return prop.getProperty("WaitTime");
      
    }
}
