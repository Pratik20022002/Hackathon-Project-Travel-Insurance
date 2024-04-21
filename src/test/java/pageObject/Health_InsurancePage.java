package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;
import testBase.ExcelUtils;

public class Health_InsurancePage extends BaseClass {
	
	WebDriver driver;
	ExcelUtils excelUtils = new ExcelUtils();
	String file2 = System.getProperty("user.dir") + "\\testdata\\PolicyBazaar Outputs.xlsx";


	
	// constructor 
	public Health_InsurancePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Location of required elements on the BeCognizant Page.
	@FindBy (xpath="//a[normalize-space()='Insurance Products']")
	WebElement txt_InsuranceProducts;
	
	@FindBy (xpath="//div[contains(@class,'ruby-row')]//div[3]//ul/li//span")
	List<WebElement> txt_HealthInsMenuItems;
	
	// Method for going to Insurance Products
	public void goToInsuranceProducts() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(txt_InsuranceProducts).perform();
		getLogger().info("User mouse hover on Insurance Products");
		Thread.sleep(2000);
	}
	
	// Method for getting Health Insurance Menu Item list
	public void getHealthInsMenuItemsList() throws IOException {
		System.out.println();
		System.out.println("Health Insurance Menu: ");
		for(int i = 2; i<txt_HealthInsMenuItems.size();i++) {
			System.out.println(txt_HealthInsMenuItems.get(i).getText());
			excelUtils.setCellData(file2, "Sheet1", i, 2, txt_HealthInsMenuItems.get(i).getText());
		}
		getLogger().info("User gets the Health Insurance Menu List.");
		
	}
		

}
