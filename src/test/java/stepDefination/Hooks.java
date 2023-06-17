package stepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import helpAssist.ContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public ContextSetup context;


    public Hooks(ContextSetup context) {
        this.context = context;
    }


    /**
     * Below method will take the screenshot on test failure.
     */
    @After(order = 1)
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            
                File src =((TakesScreenshot) context.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);
                byte[] fileContent = FileUtils.readFileToByteArray(src) ;
                scenario.attach(fileContent,"image/png", "image");

        

        }
    }

    /**
     * Below method will close the driver instance.
     */
    @After(order = 0)
    public void AfterSteps() {
    	context.getWebDriverManager().closeDriver();
    }

}
