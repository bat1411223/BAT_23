package stepDefinations;

import org.openqa.selenium.WebDriver;

import pageObjects.AddNewCustomerPage;
import pageObjects.AdminPage;
import utilities.ReadConfig;



public class Base {

	WebDriver driver;
	
	AdminPage admin;
	
	ReadConfig readConfig;
	
	public AddNewCustomerPage addCust;
}
