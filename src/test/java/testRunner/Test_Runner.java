package testRunner;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
					features= {".//FeatureFiles/01_Travel_Insurance.feature",".//FeatureFiles/02_Car_Insurance.feature",".//FeatureFiles/03_Health_Insurance.feature"},
					//features= {".//FeatureFiles/01_Travel_Insurance.feature"},
					//features= {".//FeatureFiles/02_Car_Insurance.feature"},
					//features= {".//FeatureFiles/03_Health_Insurance.feature"},
					//features= {"@target/rerun.txt"},
					glue="stepDefinitions",
					
					plugin= {"pretty", "html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true,  // to publish report in cucumber server
					tags="@Smoke"  // this will execute scenarios tagged with @Smoke
					//tags="@Regression"
					///tags="@Smoke and @Regression" //Scenarios tagged with both @Smoke and @Regression
					//tags="@Smoke and not @Regression" //Scenarios tagged with @Smoke but not tagged with @Regression
					//tags="@Smoke or @Regression" //Scenarios tagged with either @Smoke or @Regression
		)
public class Test_Runner extends AbstractTestNGCucumberTests{

		}
