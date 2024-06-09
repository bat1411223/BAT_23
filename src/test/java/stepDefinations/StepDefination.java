package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddNewCustomerPage;
import pageObjects.AdminPage;
import utilities.ReadConfig;

public class StepDefination extends Base {

	//hooks concept in bdd cucumber
	@Before
	public void setUp() throws Exception {
		
		System.out.println("Set up method execution before each scenarios");
		
		readConfig=new ReadConfig();//Creating object of ReadConfig java class
		
		String browser=readConfig.getBrowser();//firefox
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browser.equalsIgnoreCase("IE")) {
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}
	}
	
	@Given("User Lanch Chrome Browser")
	public void user_lanch_chrome_browser() {
	 
	  
	  admin=new AdminPage(driver);
	}

	@When("User open url {string}")
	public void user_open_url(String url) {
	    driver.get(url);
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
	  admin.setEmail(email);
	  admin.setPassword(password);
	}

	@When("User click on Login button")
	public void user_click_on_login_button() throws Exception {
       admin.clickOnLogin();
	}

	@Then("User verify page title should be {string}")
	public void user_verify_page_title_should_be(String title) {
	  Assert.assertEquals("Dashboard / nopCommerce administration", title);
	}
	
	//coding snippet for Add new Customer Page
	
	//add new customer
	
		@Then("User can view Dashboard")
		public void user_can_view_dashboard() throws InterruptedException {
			addCust=new AddNewCustomerPage(driver);
			   Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
			    Thread.sleep(2000);
		}

		@When("user click on customers menu")
		public void user_click_on_customers_menu() throws Exception {
			 addCust.clickOnCustomesMenu();
			    Thread.sleep(2000);
		}

		@When("User click on customers menu item")
		public void user_click_on_customers_menu_item() throws InterruptedException {
			 addCust.clickOnCustomesMenuItem();
			    Thread.sleep(2000);
		}

		@When("User click on new add button")
		public void user_click_on_new_add_button() throws Exception {
			addCust.clickOnAddNew();
		    Thread.sleep(2000);
		}

		@Then("User can view add new customer page")
		public void user_can_view_add_new_customer_page() throws Exception {
			 Thread.sleep(2000);
		       Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
		}

		@When("user enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
		public void user_enter_customer_info_as_and_and_and_and_and_and(String newEmail, String NewPassword, String firstName, String lastName, String gender, String compName, String adminComment) throws Exception {
			 addCust.SetEmail(newEmail);
			  addCust.SetPassword(NewPassword);
			  addCust.SetFirstName(firstName);
			  addCust.SetLastName(lastName);
			  addCust.SetGender(gender);
			//  addCust.enterDob("6/13/1988");
			//  addCust.enterManagerOfVendor("Vendor 1");
			  addCust.SetCompanyName(compName);
			  addCust.SetAdminContent(adminComment);
			    Thread.sleep(2000);
		}

		@When("user click on save button")
		public void user_click_on_save_button() {
			   addCust.clickOnSave();
		}

		@Then("User can view confirmation msg {string}")
		public void user_can_view_confirmation_msg(String string) throws Exception {
			 Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
			    Thread.sleep(2000);
		}

	@Then("close browser")
	public void close_browser() {
	  driver.close();
	}
	
	@After
	public void captureScreenshot(Scenario sc) throws Exception {
		
		System.out.println("Capture failed scenarios");
		
	     if(sc.isFailed()) {
	    	
//	    	 String filePath="C:\\Users\\Prashant\\eclipse-workspace\\09March2024BDDCucumberproject\\Screenshot\\FailedScreenhot.png";
//	    	 
//	    	 //convert WebDriver into TakeScreeshot
//	    	 
//	    	 TakesScreenshot scrShot=(TakesScreenshot) driver;
//	    	 
//	    	 //call getScreenshotAs
//	    	 File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
//	    	 Thread.sleep(2000);
//	    	 
//	    	 File destFile=new File(filePath);
//	    	 
//	    	 FileUtils.copyFile(scrFile, destFile +""+);
//	    	 
//	    	 driver.quit();
	    	 
	 		//1. Create object of TakeScreenshot and Type cast with driver
				
				TakesScreenshot ts=(TakesScreenshot)driver;
				
				//2. call method to capture the screenshot and store interms of File
				
				File scr=ts.getScreenshotAs(OutputType.FILE);//scr>actaul screenshot
				
				//3. copy (scr) and paste it at our project lavel
				// (./) I want to store screenhot at project lavel
				
				//selenium version 2.53.1
				FileUtils.copyFile(scr,new File("./screenshot/" +sc.getName() +".png"));
	    	 
	     }
	}
}
