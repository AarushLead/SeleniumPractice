package com.java.xpathPractice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.java.base.BaseTest;

public class XpathHandling extends BaseTest {
    
	@Test
	public void  customeXpath1() throws InterruptedException
	{
		driver.get("https://www.ebay.com/");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search for')]")).sendKeys("Mobile");
		Thread.sleep(3000);
    }
}
