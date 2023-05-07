package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import resources.Base;

public class LoginTest extends Base    
{
	public WebDriver driver;
	Logger log;
	@BeforeMethod
	public void prerequesties() throws IOException
	{
		log = LogManager.getLogger(LoginTest.class.getName());
		driver=initializeDriver(); 
		log.debug("Browser Launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application");
	}

	@Test(dataProvider = "getLoginData")
	public void login(String email,String password,String expected) throws IOException, InterruptedException
	{
		
		LandingPage land=new LandingPage(driver);
		land.MyAccountDropdown().click();
		log.debug("Clicked on My acc Dropdown");
		land.loginOptionEle().click();
		log.debug("Clicked on Login option");
		
		Thread.sleep(2000);
		LoginPage loginpge= new LoginPage(driver);
		loginpge.getEmailField().sendKeys(email);
		log.debug("Entered email");
		loginpge.getPasswordField().sendKeys(password);
		log.debug("Entered password");
		Thread.sleep(2000);
		loginpge.getLoginButton().click();
		log.debug("clicked on Login button");
		
		MyAccountPage accpage=new MyAccountPage(driver);
		
		String actual=null;
		
		try {
		if(accpage.getEditAcchyperlink().isDisplayed())
		{
			log.debug("User logged in successfully");
			actual="Success";
		}}
		catch(Exception e)
		{
			log.debug("login failed");
			actual="failure";
		}
		Assert.assertEquals(actual, expected);
	
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
		log.debug("browser closed");
	}
	@DataProvider
	public Object[][] getLoginData()
	{
		Object[][] data= {{"automation535541@gmail.com","Teja@444","Success"},{"trhh@gmail.com","Tejhdh6","failure"}};
		return data;
	}
	
	
}
