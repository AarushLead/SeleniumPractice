package com.java.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.java.base.BaseTest;

public class HandlingBootStrapDropDown  extends BaseTest{

	
	@Test(priority=1)
	public void printallOptions() throws InterruptedException
	{
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.findElement(By.id("menu1")).click();
		List<WebElement> dropLst = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//a"));
		int totalele=dropLst.size();
		for (int i = 0; i < totalele; i++) {
			System.out.println("Text in Drop Down is:"+dropLst.get(i).getText());
		}		
		Thread.sleep(4000);
	}
	@Test(priority=2)
	public void clickSelected() throws InterruptedException
	{
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.findElement(By.id("menu1")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'CSS')]")).click();
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void clickSelectedOnCondiion() throws InterruptedException
	{
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.findElement(By.id("menu1")).click();
		 List<WebElement> lst = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//a"));
		 for (WebElement webElement : lst) {
			 if(webElement.getText().equalsIgnoreCase("CSS")) {
				 webElement.click(); 
				 Thread.sleep(3000);
				 break;
			 }
		}		
	}
	@Test(priority=3)
	public void clickSelectedOnCondiion2() throws InterruptedException
	{
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.findElement(By.id("menu1")).click();
		 List<WebElement> lst = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//a"));
		 for (WebElement webElement : lst) {
			 if(webElement.getAttribute("innerHTML").contains("JavaScript")) {
				 webElement.click(); 
				 Thread.sleep(3000);
				 break;
			 }
		}		
	}
	
}
