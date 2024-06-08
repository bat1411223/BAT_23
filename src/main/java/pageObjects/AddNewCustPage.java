package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustPage {

	
WebDriver ldriver;
	
	public AddNewCustPage(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver,this);
	}
}
