package com.java.multithreadApproach;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestPage4 extends BaseThread{

	@Test
	@Parameters({"search"})
	public void seleniumTest(String search)
	{
		driver.findElement(By.name("q")).sendKeys(search);
	}
	@Test
	@Parameters({"search"})
	public void javaTest(String search)
	{
		driver.findElement(By.name("q")).sendKeys(search);
	}
	@Test
	@Parameters({"search"})
	public void sqlTest(String search)
	{
		driver.findElement(By.name("q")).sendKeys(search);
	}
}
