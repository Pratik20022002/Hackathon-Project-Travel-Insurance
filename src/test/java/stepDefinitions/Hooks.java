package stepDefinitions;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import testBase.BaseClass;

public class Hooks {
	
     static WebDriver driver;
   	 static Properties p;
   	 
   	@Before
   	public static void setup() throws IOException
    {
      driver=BaseClass.initilizeBrowser();  				
    }
   	
   	//Quit the browser
   	@After																
   	public static void tearDown() {
   	  driver = BaseClass.tearDown();
   	}
       
   	//Take Screenshot method to capture the screenshots   
   	@AfterStep																
    public static void addScreenshot(Scenario scenario) {
        try
       	{
           	TakesScreenshot ts=(TakesScreenshot) driver;
           	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
           	scenario.attach(screenshot, "image/png",scenario.getName());   	
       	}
       	catch (Exception e) {
   			
   		}
       	
   	}
}