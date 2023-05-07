package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base
{
	public WebDriver driver;
	@Test
	public void testTwo() throws IOException, InterruptedException
	{
		System.out.println("test two");
		
		driver=initializeDriver(); 
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.close();
		
	}

}
