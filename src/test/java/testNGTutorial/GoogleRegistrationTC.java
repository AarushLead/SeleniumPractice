package testNGTutorial;

import org.testng.annotations.Test;

public class GoogleRegistrationTC extends BaseTestNg
{
	@Test(groups= {"Smoke"})
	public void GoogleRegistration_validData()
	{
		System.out.println("Google Registration with valid Data");
	}
	@Test
	public void GoogleRegistration_Invaliddata()
	{
		System.out.println("Google Registration with Invalid Data");
	}
}
