package com.java.alert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.java.base.BaseTest;

public class AlertPopUphandling extends BaseTest {

	@Test(enabled = false)
	public void alertAccept() throws InterruptedException {
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		if (alertText.equalsIgnoreCase("Please enter a valid user name")) {
			System.out.println("correct alert msg");
		} else {
			System.out.println("Incorrect alert msg");
		}
		System.out.println(alert.getText());
		alert.accept();

	}

	@Test(enabled = false)
	public void uploadHandle_sendKeys() throws InterruptedException {
		driver.get("https://html.com/input-type-file/");
		driver.findElement(By.id("fileupload")).sendKeys("C:/Users/Shobhit Sharma/Desktop/pcccc.png");
		Thread.sleep(4000);
	}

	@Test(enabled = false)
	public void uploadHandle_robotClass() throws InterruptedException {
		driver.get("https://html.com/input-type-file/");
		driver.findElement(By.id("fileupload")).sendKeys("C:/Users/Shobhit Sharma/Desktop/pcccc.png");
		Thread.sleep(4000);
	}

	@Test(enabled = false)
	public void alerthandleAccept() throws InterruptedException {
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		driver.findElement(By.name("alert")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
	}

	@Test(enabled = false)
	public void alerthandleDismiss() throws InterruptedException {
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		driver.findElement(By.name("confirmation")).click();
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.dismiss();
	}

	@Test(enabled = false)
	public void alerthandleConfirm() throws InterruptedException {
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		driver.findElement(By.name("confirmation")).click();
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
	}

	@Test(enabled = false)
	public void alerthandlePrompt() throws InterruptedException {
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		driver.findElement(By.name("prompt")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("hello");
		Thread.sleep(4000);
		alert.accept();
	}
	
	@Test
	public void alertScreenShot() throws AWTException, InterruptedException {
		driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
		driver.findElement(By.name("prompt")).click();
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_PRINTSCREEN);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_PRINTSCREEN);
		Thread.sleep(4000);
	}
}
