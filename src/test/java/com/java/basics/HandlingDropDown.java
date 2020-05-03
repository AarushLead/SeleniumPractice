package com.java.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.java.base.BaseTest;

public class HandlingDropDown  extends BaseTest{

	@Test(priority=1,enabled=false)
	public void selectTagHandling() throws InterruptedException
	{
		 driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		 WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		 Select slt=new Select(dropdown);
		 slt.selectByIndex(1); //Handling the DropDown by Index
		 Thread.sleep(3000);
		 slt.selectByValue("option2");  //Handling the DropDown by Value
		 Thread.sleep(3000);
		 slt.selectByVisibleText("Option3");
		 Thread.sleep(3000);   //Handling the DropDown by VisibleText
	}
	@Test(priority=2,enabled=false)
	public void handlingMultiValueDropDown() throws InterruptedException
	{
		 driver.get(System.getProperty("user.dir")+"/htmlfiles/multidropdown.html");
		 WebElement dropdown = driver.findElement(By.name("Browsers"));
		 Select slt=new Select(dropdown);
		 Assert.assertTrue(slt.isMultiple());
		 slt.selectByIndex(1);
		 Thread.sleep(2000);
		 slt.deselectByIndex(1);
		 slt.selectByValue("IE");
		 Thread.sleep(2000);
		 slt.deselectByValue("IE");
		 slt.selectByVisibleText("Opera");
		 Thread.sleep(2000);
		 slt.selectByValue("Safari");
		 slt.deselectAll();
		 	 		 
	}
	@Test(priority=2,enabled=false)
	public void printAllOptions() throws InterruptedException
	{
		 driver.get(System.getProperty("user.dir")+"/htmlfiles/multidropdown.html");
		 WebElement dropdown = driver.findElement(By.name("Browsers"));
		 Select slt=new Select(dropdown);
		 List<WebElement> options = slt.getOptions();
		 for (WebElement webElement : options) {
			System.out.println(webElement.getText());
		}
	}
	@Test(priority=2)
	public void getSelectedOptions() throws InterruptedException
	{
		 driver.get(System.getProperty("user.dir")+"/htmlfiles/multidropdown.html");
		 WebElement dropdown = driver.findElement(By.name("Browsers"));
		 Select slt=new Select(dropdown);
		 Assert.assertTrue(slt.isMultiple());
		 slt.selectByIndex(1);
		 Thread.sleep(2000);
		 slt.selectByValue("IE");
		 Thread.sleep(2000);
		 slt.selectByValue("Safari");
		 List<WebElement> slctdoptions = slt.getAllSelectedOptions();
		 for (WebElement webElement : slctdoptions) {
			System.out.println("selected options:"+webElement.getText()+
					"[value:"+webElement.getAttribute("value")+"]");
		}
	}
	
}
