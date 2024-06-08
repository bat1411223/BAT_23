package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	WebDriver ldriver;
	
	public AdminPage(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver,this);
	}
	// java project
	// WebElement txtEmail=driver.findElement(By.xpath("//input[@id='Email']"));

	// Maven project

	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmail;// email text field

	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;// passwword text filed

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement btnLogin;// login button

	// user defined method to perform opeartion on able web element

	public void setEmail( String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
          txtPassword.clear();
          txtPassword.sendKeys(password);
	}
	
	public void clickOnLogin() throws Exception {
		btnLogin.click();
		Thread.sleep(2000);
	}

}
