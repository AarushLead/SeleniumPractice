package com.java.popup;

import org.testng.annotations.Test;

import com.java.base.BaseTest;

public class PopUpHandling extends BaseTest{

	@Test
	public void ahandleAuthentication() throws InterruptedException {
		driver.get("https://selenium:webdriver@chercher.tech/auth");
	}
}
