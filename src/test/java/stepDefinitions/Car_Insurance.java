package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Car_InsurancePage;

public class Car_Insurance {
	WebDriver driver;
	Car_InsurancePage cInsurance;
	
	@Given("User is on the policybazar website")
	public void user_is_on_the_policybazar_website() throws InterruptedException {
		cInsurance = new Car_InsurancePage(Hooks.driver);	
	}
 
	@When("User Click On Car Insurance")
	public void user_click_on_car_insurance() throws InterruptedException {
		cInsurance.clickCarInsurance();
	}
	
	@When("User select on new car")
	public void User_select_on_new_car() throws InterruptedException {
		cInsurance.clickHere_NewCar();
	}	
	
	@When("User select city and RTO")
	public void User_select_city_and_RTO() throws InterruptedException {
		cInsurance.selCity_Rto();
	}
	
	@Then("User select car brand and variant")
	public void User_select_car_brand_and_variant () throws InterruptedException {
		cInsurance.selCarBrand();
	}
	
	@Given("User is on contact details page")
	public void User_is_on_contact_details_page() throws IOException {
		cInsurance = new Car_InsurancePage(Hooks.driver);
	}
	
	@When("User Enters invalid email address")
	public void user_enters_invalid_email_address() throws IOException {
		cInsurance.email_Send();
	}
 
	@Then("Display the Error Message")
	public void display_the_error_message() throws IOException {
		Assert.assertEquals(cInsurance.email_ErrorMessage(), true,"Error Message is not Displayed");
		System.out.println("Error Message is Displayed");
		cInsurance.navigateBack();
	}

}
