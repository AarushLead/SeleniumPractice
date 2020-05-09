package com.java.multithreadApproach;

import org.testng.annotations.Test;

public class TestPage2{

	@Test
	public void testCaseOne() {
		//Printing Id of the thread on using which test method got executed
		System.out.println("Test Case One with Thread Id:- "
				+ Thread.currentThread().getId());
	}

	@Test
	public void testCaseTwo() {
		//Printing Id of the thread on using which test method got executed
		System.out.println("Test Case Two with Thread Id:- "
				+ Thread.currentThread().getId());
	}

	@Test
	public void testCaseThree() {
		////Printing Id of the thread on using which test method got executed
		System.out.println("Test Case Three with Thread Id:- "
				+ Thread.currentThread().getId());
	}
	
}
