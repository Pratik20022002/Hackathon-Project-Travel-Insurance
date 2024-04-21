package testCases;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObject.Travel_InsurancePage;
import testBase.BaseClass;

public class Travel_Insurance_Tc extends BaseClass{
	Travel_InsurancePage tInsurance ;
	//WebDriver driver;
	
	@Test(priority = 0, groups = {"Smoke","Regression"})
	public void clickTravelInsurance() throws InterruptedException {
		tInsurance = new Travel_InsurancePage(driver);
		tInsurance.clickTravelInsurance();
		tInsurance.clickEuropeanCountry();
		tInsurance.clickNext();
	}
	
	@Test(priority = 1, groups = {"Smoke","Regression"})
	public void clickDates() throws InterruptedException, IOException {
		
		tInsurance.clickStartDateLogo();
		tInsurance.clickStartDate();
		tInsurance.clickEndDate();
		tInsurance.clickNext();	
	}
	
	@Test(priority = 2, groups = {"Smoke","Regression"})
	public void selectAges() throws InterruptedException, IOException {
		tInsurance.clickNoOfPeoples();
		tInsurance.selectAgeOfTraveller1();
		tInsurance.selectAgeOfTraveller2();
		tInsurance.clickOnYesNo();	
	}
	
	@Test(priority = 3, groups = {"Smoke","Regression"})
	public void enterContactDetais() throws InterruptedException, IOException {
		tInsurance.enterMobileNumber();
		tInsurance.disableWhatsappBtn();
		tInsurance.clickViewPlans();
	}
	
	@Test(priority = 4, groups = {"Regression"})
	public void enterStudentPlans() throws InterruptedException, IOException {
		tInsurance.clickStudentPlans();
		tInsurance.clickTravellers();
		tInsurance.clickTravelDurationDropDown();
	}
	
	@Test(priority = 5, groups = {"Regression"})
	public void selectSorts() throws InterruptedException, IOException {
		tInsurance.selectSorts();
		tInsurance.closeBtnForRecommendedPlan();
	}
	
	@Test(priority = 6, groups = {"Regression"})
	public void insurerNameAndPlanPrice() throws InterruptedException, IOException {
		tInsurance.insurerNameAndPlan();
	}
	
}
