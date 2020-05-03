package testNGTutorial;

import org.testng.annotations.Test;

public class FaceBookRegistrationTC extends BaseTestNg
{
	@Test(groups= {"Smoke"})
	public void facebookRegistration_validData()
	{
		System.out.println("facebook Registration with valid Data");
	}
	@Test
	public void facebookRegistration_Invaliddata()
	{
		System.out.println("facebook Registration with Invalid Data");
	}
}
