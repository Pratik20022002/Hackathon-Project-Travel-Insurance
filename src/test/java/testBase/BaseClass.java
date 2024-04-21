package testBase;

 
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.URL;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
public class BaseClass {
	
	public static WebDriver driver;
    public static Properties p;
    public static Logger logger;
    
    public static WebDriver getDriver() {
		return driver;
	}

	public static Properties getProperties() throws IOException
	{		 
	    FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	    p=new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}

    @BeforeClass(alwaysRun = true)
    public static WebDriver initilizeBrowser() throws IOException
	{
    	if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//os
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
			    capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
			    capabilities.setPlatform(Platform.MAC);
			} else {
			    System.out.println("No matching OS..");
			      }
			//browser
			switch (getProperties().getProperty("browser").toLowerCase()) {
			    case "chrome":
			        capabilities.setBrowserName("chrome");
			        break;
			    case "edge":
			        capabilities.setBrowserName("MicrosoftEdge");
			        break;
			    default:
			        System.out.println("No matching browser");
			     }
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
			{
				switch(getProperties().getProperty("browser").toLowerCase()) 
				{
				case "chrome":
					ChromeOptions options = new ChromeOptions();
					options.addArguments("disable-notifications");
					driver = new ChromeDriver(options);
					
			        break;
			    case "edge":
			    	EdgeOptions options1 = new EdgeOptions();
					options1.addArguments("disable-notifications");
					driver = new EdgeDriver(options1);
					
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			}
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    	 driver.manage().window().maximize();
		 //driver.manage().deleteAllCookies(); 
		 //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		 driver.get(p.getProperty("appURL"));
		 return driver;
	}
    
    
    @AfterClass(alwaysRun = true)
	public static WebDriver tearDown() {
		driver.quit();
		return driver;
	}
    
 
 
}