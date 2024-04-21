package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObject.Health_InsurancePage;

public class Health_Insurance {
	Health_InsurancePage hInsurance;
	@Given("User Click On Health Insurance")
	public void user_click_on_health_insurance() throws InterruptedException {
		hInsurance = new Health_InsurancePage(Hooks.driver);
		hInsurance.goToInsuranceProducts();
	}
 
	@Then("Display All Health Insurance Plans")
	public void display_all_health_insurance_plans() throws IOException {
		hInsurance.getHealthInsMenuItemsList();
	}

}
