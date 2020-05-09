package com.java.multithreadApproach;

import org.testng.annotations.Test;

public class TestPage1 {
	@Test
	public void testCaseFour() {
		//Printing Id of the thread on using which test method got executed
		System.out.println("Test Case four with Thread Id:- "
				+ Thread.currentThread().getId());
	}

	@Test
	public void testCaseFive() {
		//Printing Id of the thread on using which test method got executed
		System.out.println("Test Case five with Thread Id:- "
				+ Thread.currentThread().getId());
	}

	@Test
	public void testCaseSix() {
		////Printing Id of the thread on using which test method got executed
		System.out.println("Test Case six with Thread Id:- "
				+ Thread.currentThread().getId());
	}
}
