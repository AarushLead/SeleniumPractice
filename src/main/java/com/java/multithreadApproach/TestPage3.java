package com.java.multithreadApproach;

import org.testng.annotations.Test;

public class TestPage3 {

	@Test
	public void testCaseSeven() {
		//Printing Id of the thread on using which test method got executed
		System.out.println("Test Case seven with Thread Id:- "
				+ Thread.currentThread().getId());
	}

	@Test
	public void testCaseEight() {
		//Printing Id of the thread on using which test method got executed
		System.out.println("Test Case Eight with Thread Id:- "
				+ Thread.currentThread().getId());
	}

	@Test
	public void testCaseNine() {
		////Printing Id of the thread on using which test method got executed
		System.out.println("Test Case Nine with Thread Id:- "
				+ Thread.currentThread().getId());
	}
}
