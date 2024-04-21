package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Travel_InsurancePage;
import testBase.BaseClass;

public class Travel_Insurance extends BaseClass{
	WebDriver driver;
	Travel_InsurancePage tInsurance;
	
	
	@Given("the user is on the travel insurance page")
	public void the_user_is_on_the_travel_insurance_page() throws InterruptedException {
	   tInsurance = new Travel_InsurancePage(Hooks.driver);
	   tInsurance.clickTravelInsurance(); 
	}

	@When("selects any European country")
	public void selects_any_european_country() throws InterruptedException {
		tInsurance.clickEuropeanCountry();
		tInsurance.clickNext();
	}

	@When("selects dates")
	public void selects_dates() throws InterruptedException, IOException {
		tInsurance.clickStartDateLogo();
		tInsurance.clickStartDate();
		tInsurance.clickEndDate();
		tInsurance.clickNext();
	}

	@When("selects No of peoples and ages")
	public void selects_no_of_peoples_and_ages() throws InterruptedException, IOException {
		tInsurance.clickNoOfPeoples();
		tInsurance.selectAgeOfTraveller1();
		tInsurance.selectAgeOfTraveller2();
	}

	@When("click on meadical issues")
	public void click_on_meadical_issues() throws InterruptedException, IOException {
		tInsurance.clickOnYesNo();
	}

	@When("enter contact details")
	public void enter_contact_details() throws InterruptedException, IOException {
		tInsurance.enterMobileNumber();
		tInsurance.disableWhatsappBtn();
		tInsurance.clickViewPlans();
		
	}
	
//	@Then("user is on Travel Insurance plan for students page")
//	public void user_is_on_Travel_Insurance_plan_for_students_page() throws IOException, InterruptedException {
//		
//	}
	
	@Given("the user is on the travel insurance for students page")
	public void the_user_is_on_the_travel_insurance_for_students_page() throws IOException, InterruptedException {
		tInsurance = new Travel_InsurancePage(Hooks.driver);
		tInsurance.clickStudentPlans();
	}

	@When("select student plan and sort option")
	public void select_student_plan_and_sort_option() throws IOException, InterruptedException {
		tInsurance.clickTravellers();
		tInsurance.clickTravelDurationDropDown();
		tInsurance.selectSorts();
		tInsurance.closeBtnForRecommendedPlan();	    
	}

	@Then("user should get list of three lowest insurance plans")
	public void user_should_get_list_of_three_lowest_insurance_plans() throws IOException {
		tInsurance.insurerNameAndPlan();
	}


}
