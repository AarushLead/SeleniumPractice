package testNGTutorial;

import org.testng.annotations.Test;

public class ZivameRegistrationTC extends BaseTestNg
{

	@Test(groups= {"Smoke"})
	public void zivameRegistration_validData()
	{
		System.out.println("zivame Registration with valid Data");
	}
	@Test
	public void zivameRegistration_Invaliddata()
	{
		System.out.println("zivame Registration with Invalid Data");
	}
}
