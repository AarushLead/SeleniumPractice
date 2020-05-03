package com.java.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestRetry implements IRetryAnalyzer {

	private int minRetry = 0;
	private static final int MAX_RETRY_COUNT = 2;

	@Override
	public boolean retry(ITestResult result) {
		 if(!result.isSuccess())
		 if(minRetry<MAX_RETRY_COUNT)
		 {
			 System.out.println("Going for retry test Case: "+result.getName()+" with status "+
		      gettestStatus(result.getStatus())+"for "+(minRetry+1)+" out of "+MAX_RETRY_COUNT);
			 minRetry++;
			return true;
		 }
		 return false;
	}

	private String gettestStatus(int status) {
		String testStatus = null;
		switch (status) {
		case 1:
			testStatus = "PASSED";
			break;
		case 2:
			testStatus = "FAILED";
			break;
		case 3:
			testStatus = "SKIPPED";
			break;
		}
		return testStatus;
	}

}
