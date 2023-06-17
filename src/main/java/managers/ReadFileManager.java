package managers;

import genericUtilities.ConfigFileReader;

/**
 * 
 * Objective of the below class is to read all the files from this class
 *
 */
public class ReadFileManager {

	   private static ReadFileManager readfilemanager = new ReadFileManager();
	   private static ConfigFileReader configFileReader;
	  
	   private ReadFileManager() {
	    }

	    /**
	     * Below method will return the current instance of the file reader manager class.
	     */
	    public static ReadFileManager getFileReaderManagerInstance( ) {
	        return readfilemanager;
	    }
	   
	   /**
	    * Objective of the below method is to return the current instance of ConfigFileReader class 
	    */
	   public ConfigFileReader getConfigReader() {
	       return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	    }
}
