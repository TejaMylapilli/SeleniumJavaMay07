package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	WebElement EmailField;
	
	@FindBy(id="input-password")
	WebElement PasswordField;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginButton;

	public WebElement getEmailField() {
		return EmailField;
	}

	public WebElement getPasswordField() {
		return PasswordField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	
}
