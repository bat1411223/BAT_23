package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
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
	
	@When("User click on Customer Menu")
	public void user_click_on_customer_menu() {
	
	}

	@When("User click on Customer mentu item")
	public void user_click_on_customer_mentu_item() {
	   
	}

	@When("User Click On add new button")
	public void user_click_on_add_new_button() {
	    
	}

	@Then("User verify Add new customer page")
	public void user_verify_add_new_customer_page() {
	   
	}

	@When("User enter cutomer info as {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_enter_cutomer_info_as_and_and_and_and_and_and_and(String newEmail, String newPass, String fname, String lname, String genere, String dob, String comName, String AdminCommnet) {
	   
	}

	@When("User click on save button")
	public void user_click_on_save_button() {
	  
	}

	@Then("User can view confirmation msg {string}")
	public void user_can_view_confirmation_msg(String confirmation) {
	   
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
