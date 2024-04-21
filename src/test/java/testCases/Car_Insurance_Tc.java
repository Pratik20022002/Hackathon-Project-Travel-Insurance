package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.Car_InsurancePage;
import testBase.BaseClass;


public class Car_Insurance_Tc extends BaseClass {
	Car_InsurancePage cInsurance;
	//WebDriver driver;

	  @Test(priority = 1, groups = {"Smoke","Regression"})
	  public void sel_NewCar_forInsurance() throws InterruptedException {
		  cInsurance=new Car_InsurancePage(driver);
		  cInsurance.clickCarInsurance();
		  cInsurance.clickHere_NewCar();
		  cInsurance.selCity_Rto();
		  cInsurance.selCarBrand();
      }
	  
	  @Test(priority = 2, groups = {"Regression"})
	  public void sendData() throws IOException{
		  cInsurance.email_Send();
	  }
	  
	  @Test(priority = 3, groups = {"Regression"})
	  public void email_Capture_ErrorMessage() throws InterruptedException, IOException {
		  Assert.assertEquals(cInsurance.email_ErrorMessage(), true,"Error Message is not Displayed");
		  System.out.println("Error Message is Displayed");
	  }
	
	  @Test(priority = 4, groups = {"Regression"})
	  public void navigateBack() {
		  cInsurance.navigateBack();
	  }

	  public void phoneNo_Capture_ErrorMessage() throws InterruptedException {
		  Assert.assertEquals(cInsurance.phno_ErrorMessage(), true,"Error Message is not Displayed");
		  System.out.println("Error Message is Displayed");	
	  }
}
