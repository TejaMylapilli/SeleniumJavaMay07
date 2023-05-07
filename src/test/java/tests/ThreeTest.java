package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base
{
	public WebDriver driver;
	@Test
	public void testThree() throws InterruptedException, IOException 
	{
		System.out.println("TestThree");
		driver=initializeDriver(); 
		driver.get("https://www.amazon.com/");
		Thread.sleep(3000);
		Assert.assertTrue(false);
		driver.close();
	}

}
