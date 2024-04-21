package pageObject;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;
import testBase.ExcelUtils;



public class Travel_InsurancePage extends BaseClass{
	WebDriver driver;
	ExcelUtils excelUtils = new ExcelUtils();
	String file = System.getProperty("user.dir") + "\\testdata\\PolicyBazaar Inputs.xlsx";
	String file2 = System.getProperty("user.dir") + "\\testdata\\PolicyBazaar Outputs.xlsx";
	private static final String variable = "Germany";


	
	// constructor 
	public Travel_InsurancePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Location of required elements on the BeCognizant Page.
		@FindBy (xpath="//p[normalize-space()='Travel Insurance']")
		WebElement txt_TravelInsurance;
		
		@FindBy (xpath="//p[text()='Schengen']")
		WebElement txt_EuropeanCountries;
		
		@FindBy (xpath="//*[text()='" + variable + "']")
		WebElement txt_EuropeanCountry;
		
		@FindBy (xpath="//button[text()='Add']")
		WebElement btn_Add;
		
		@FindBy (xpath="//button[text()='Next']")
		WebElement btn_Next;
		
		@FindBy (xpath="(//input[@placeholder='dd mmmm, yyyy'])[1]")
		WebElement logo_StartDate;
		
		@FindBy (xpath="//h6[1]")
		WebElement txt_MonthYear;
		
		@FindBy (xpath="//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersArrowSwitcher-iconButton MuiIconButton-sizeSmall']")
		WebElement btn_nextMonthYear;
		
		@FindBy (xpath="(//div[@role='grid'])[1]//span[@class='MuiPickersDay-dayLabel']")
		List<WebElement> txt_Date;
		
		@FindBy (css="label[for='traveller_2']")
		WebElement btn_noOfPeople;
		
		@FindBy (xpath="//div[@id='0']")
		WebElement slct_AgeDropDown1;
		
		@FindBy (xpath="//div[@id='1']")
		WebElement slct_AgeDropDown2;
		
		@FindBy (xpath="//div[@id='optionBox_0_wrapper']//label")
		List<WebElement> list_AgeDropDown1;
		
		@FindBy (xpath="//div[@id='optionBox_1_wrapper']//label")
		List<WebElement> list_AgeDropDown2;
		
		@FindBy (css="#ped_yes")
		WebElement rbtn_Yes;
		
		@FindBy (css="#ped_no")
		WebElement rbtn_No;
		
		@FindBy (css="label[for='ped_yes_traveller_0']")
		WebElement rbtn_Yes_Trav1;
		
		@FindBy (css="label[for='ped_yes_traveller_1']")
		WebElement rbtn_Yes_Trav2;
		
		@FindBy (id="mobileNumber")
		WebElement txt_MobileNumber;
		
		@FindBy (css=".slider.round")
		WebElement slider_WhatsApp;
		
		@FindBy (xpath="//button[normalize-space()='View plans']")
		WebElement btn_ViewPlans;
		
		@FindBy (css=".text-btn")
		WebElement btn_ContWithNo;
		
		@FindBy (css="label[for='studentTrip']")
		WebElement rbtn_StudentPlans;
		
		@FindBy (css="label[for='Traveller_1']")
		WebElement rbtn_Traveller_1;
		
		@FindBy (css="label[for='Traveller_2']")
		WebElement rbtn_Traveller_2;
		
		@FindBy (id="feet")
		WebElement drpdn_TravelDuration;
		
		@FindBy (xpath="//select/option")
		List<WebElement> list_TravelDuration;
		
		@FindBy (xpath="//button[normalize-space()='Apply']")
		WebElement btn_Apply;
		
		@FindBy (css=".filter_name_heading")
		WebElement drpdn_SortBy;
		
		@FindBy (css="label[for='16_sort']")
		WebElement rbtn_Default;
		
		@FindBy (css="label[for='17_sort']")
		WebElement rbtn_LowToHigh;
		
		@FindBy (css="label[for='18_sort']")
		WebElement rbtn_HighToLow;
			
		@FindBy (css=".closeIconBtn")
		WebElement btn_CloseBtn;
		
		@FindBy (className = "quotesCard--insurerName")
		List<WebElement> txt_InsurerName;
		
		@FindBy (className = "premiumPlanPrice")
		List<WebElement> txt_PlanPrice;
		
		@FindBy (linkText ="Policybazaar")
		WebElement img_Logo;
		
	
		// Method for click on Travel Insurance
		public void clickTravelInsurance() throws InterruptedException {
			txt_TravelInsurance.click();
			getLogger().info("The user is on the travel Insurance Page.");
			Thread.sleep(2000);
		}
		
		// Method for click on any European Country
		public void clickEuropeanCountry() throws InterruptedException {
			txt_EuropeanCountries.click();
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", txt_EuropeanCountry);
			Thread.sleep(1000);
			btn_Add.click();
			getLogger().info("User has selected European Country.");
			Thread.sleep(2000);
		}
		
		// Method for click on next button
		public void clickNext() throws InterruptedException {
			btn_Next.click();
			Thread.sleep(2000);
		}
		
		// Method for click on Start date Logo
		public void clickStartDateLogo() throws InterruptedException {
			logo_StartDate.click();
			Thread.sleep(1000);
			getLogger().info("The user is on the select dates Page.");
		}
		
		// Method for click on Start Date
		public void clickStartDate() throws IOException, InterruptedException 
		{
			String monthAndYear = excelUtils.getCellData(file, "Sheet1", 2, 1);
			String date = excelUtils.getCellData(file, "Sheet1", 2, 2);
			Thread.sleep(1000);

			while(true) {
				String monYear = txt_MonthYear.getText(); 
				
				if(monYear.equals(monthAndYear)) {
					break;
				}
				btn_nextMonthYear.click();
			}
			for(WebElement dts : txt_Date) 
			{
				if(date.equals(dts.getText())) 
				{
					dts.click();
					break;
				}
			}
			Thread.sleep(2000);
			getLogger().info("User has selected start date.");
		}
		
		// Method for click on End Date
		public void clickEndDate() throws IOException, InterruptedException 
		{
			String monthAndYear = excelUtils.getCellData(file, "Sheet1", 3, 1);
			String date = excelUtils.getCellData(file, "Sheet1", 3, 2);
			Thread.sleep(1000);
			
			while(true) {
				String monYear = txt_MonthYear.getText(); 
				
				if(monYear.equals(monthAndYear)) {
					break;
				}
				btn_nextMonthYear.click();
			}
			for(WebElement dts : txt_Date) 
			{
				if(date.equals(dts.getText())) 
				{
					dts.click();
					break;
				}
			}
			Thread.sleep(2000);
			getLogger().info("User has selected end date.");
		}
		
		// Method for click on Number of People
		public void clickNoOfPeoples() throws InterruptedException {
			getLogger().info("The user is on the number of people page.");
			btn_noOfPeople.click();
			getLogger().info("User has selected number of people.");
			Thread.sleep(1000);
		}
		
		// Method for selecting age of traveller 1
		public void selectAgeOfTraveller1() throws IOException, InterruptedException {
			slct_AgeDropDown1.click();
			Thread.sleep(1000);
			String ageT1 = excelUtils.getCellData(file, "Sheet1", 2, 3);
			Thread.sleep(1000);
			for(WebElement ages : list_AgeDropDown1) 
			{
				if(ageT1.equals(ages.getText())) 
				{
					ages.click();
					break;
				}
			}
			Thread.sleep(1000);
			getLogger().info("User has selected Age of Traveller 1.");
		}
		
		// Method for selecting age of traveller 2
		public void selectAgeOfTraveller2() throws InterruptedException, IOException {
			slct_AgeDropDown2.click();
			String ageT2 = excelUtils.getCellData(file, "Sheet1", 2, 4);
			Thread.sleep(1000);
			for(WebElement ages : list_AgeDropDown2) 
			{
				if(ageT2.equals(ages.getText())) 
				{
					ages.click();
					break;
				}
			}
			Thread.sleep(1000);
			getLogger().info("User has selected Age of Traveller 1.");
			btn_Next.click();
		}
		
		// Method for confirming medical issues
		public void clickOnYesNo() throws InterruptedException, IOException {
			
			String YorN = excelUtils.getCellData(file, "Sheet1", 2, 5);
			String Traveller = excelUtils.getCellData(file, "Sheet1", 2, 6);
			Thread.sleep(1000);
			
			if(YorN.equalsIgnoreCase("Yes")) {
				rbtn_Yes.click();
				if(Traveller.equalsIgnoreCase("Traveller 1")) {
					rbtn_Yes_Trav1.click();
				}else if(Traveller.equalsIgnoreCase("Traveller 2")) {
					rbtn_Yes_Trav2.click();
				}else if(Traveller.equalsIgnoreCase("Both")) {
					rbtn_Yes_Trav1.click();
					rbtn_Yes_Trav2.click();
				}
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", btn_Next);
			}else {
				rbtn_No.click();
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].scrollIntoView();", btn_Next);
			}
			Thread.sleep(2000);
			getLogger().info("User has selected any Medical issue.");
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", btn_Next);
		}
		
		// Method for entering mobile number
		public void enterMobileNumber() throws IOException, InterruptedException {
			txt_MobileNumber.click();
			String mobNo = excelUtils.getCellData(file, "Sheet1", 2, 7);
			Thread.sleep(2000);
			txt_MobileNumber.sendKeys(mobNo);
			getLogger().info("User has entered Mobile Number.");
		}
		
		// Method for disabling whatsapp button
		public void disableWhatsappBtn() throws InterruptedException {
			slider_WhatsApp.click();
			Thread.sleep(2000);
			getLogger().info("User has disabled Whatsapp button.");
		}
		
		// Method for clicking on view plan button
		public void clickViewPlans() throws InterruptedException {
			btn_ViewPlans.click();
			btn_ContWithNo.click();
			getLogger().info("User clicked view plans.");
			Thread.sleep(5000);
		}
		
		// Method for selecting student plan radio button
		public void clickStudentPlans() throws InterruptedException {
			rbtn_StudentPlans.click();
			getLogger().info("User clicked on student plan.");
			Thread.sleep(3000);
		}
		
		// Method for selecting travelers
		public void clickTravellers() throws InterruptedException {
			rbtn_Traveller_1.click();
			Thread.sleep(1000);
			rbtn_Traveller_2.click();
			Thread.sleep(1000);
			getLogger().info("User clicked on travellers.");
		}
		
		// Method for selecting travel duration
		public void clickTravelDurationDropDown() throws IOException, InterruptedException {
			drpdn_TravelDuration.click();
			Thread.sleep(2000);
			String duration = excelUtils.getCellData(file, "Sheet1", 2, 8);
			for(WebElement drpdwn : list_TravelDuration) {
				if(duration.equalsIgnoreCase(drpdwn.getText())) {
					drpdwn.click();
					break;
				}	
			}
			btn_Apply.click();
			Thread.sleep(2000);
			getLogger().info("User selected duration of travel.");
		}
		
		// Method for selecting sort options
		public void selectSorts() throws IOException, InterruptedException {
			drpdn_SortBy.click();
			Thread.sleep(2000);
			String sort = excelUtils.getCellData(file, "Sheet1", 2, 9);
			if(sort.equalsIgnoreCase(rbtn_Default.getText())) {
				rbtn_Default.click();
			}else if(sort.equalsIgnoreCase(rbtn_LowToHigh.getText())) {
				rbtn_LowToHigh.click();
			}else if(sort.equalsIgnoreCase(rbtn_HighToLow.getText())) {
				rbtn_HighToLow.click();
			}
			Thread.sleep(2000);
			getLogger().info("User has selected sort option.");
			
		}
		
		// Method for closing recommended plan
		public void closeBtnForRecommendedPlan() throws InterruptedException {
			btn_CloseBtn.click();
			Thread.sleep(2000);
			getLogger().info("clicked on close recommended plan.");
		}
		
		// Method for getting Insurer name and plan details
		public void insurerNameAndPlan() throws IOException {
			for(int i=0,j=2 ; i<3 && j<5 ; i++,j++) {
				System.out.println("Insurer Name: "+txt_InsurerName.get(i).getText()+"     "
			+"Plan Price: "+txt_PlanPrice.get(i).getText());
				
			excelUtils.setCellData(file2, "Sheet1", j, 0, "Insurer Name: "+txt_InsurerName.get(i).getText()+"     "
							+"Plan Price: "+txt_PlanPrice.get(i).getText());
				
			}
			getLogger().info("User gets the three lowest travel insurance plan.");
			img_Logo.click();
			getLogger().info("User is on Home Page.");
		}
		
}
