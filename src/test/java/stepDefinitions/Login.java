package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import resources.Base;

public class Login extends Base
{
	WebDriver driver;
	 LoginPage login;

    @Given("^open chrome browser$")
    public void open_chrome_browser() throws IOException 
    {
      driver=initializeDriver();
    }

    @And("^Navigate to login page$")
    public void navigate_to_login_page() 
    {
        driver.get(prop.getProperty("url"));
        
        LandingPage landing=new LandingPage(driver);
        landing.MyAccountDropdown().click();
        landing.loginOptionEle().click();
    }
    
    @When("^User enters email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enters_email_as_something_and_password_as_something(String strArg1, String strArg2) 
    {
      login= new LoginPage(driver);
      login.getEmailField().sendKeys(strArg1);
      login.getPasswordField().sendKeys(strArg2);
    }

   
    @And("^User clicks on login button$")
    public void user_clicks_on_login_button()
    {
      login.getLoginButton().click();
    }
    
    @Then("^Verify user able to login successfully$")
    public void verify_user_able_to_login_successfully() 
    {
       MyAccountPage account=new MyAccountPage(driver);
       Assert.assertTrue(account.getEditAcchyperlink().isDisplayed());
    }

    @After
    public void closure()
    {
    	driver.close();
    }




}
