package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObject.Health_InsurancePage;
import testBase.BaseClass;

public class Health_Insurance_Tc extends BaseClass {
	Health_InsurancePage hInsurance;
	//WebDriver driver;
	
	@Test(priority = 0, groups = {"Smoke","Regression"})
	public void healthInsuranceMenuItems() throws InterruptedException, IOException {
		hInsurance = new Health_InsurancePage(driver);
		hInsurance.goToInsuranceProducts();
		hInsurance.getHealthInsMenuItemsList();
	}

}
