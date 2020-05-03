package testNGTutorial;

import org.testng.annotations.Test;

public class GoogleLoginTC extends BaseTestNg
{
	@Test(groups= {"Smoke","Regression"})
	public void googleLogin_validUserName_Password()
	{
		System.out.println("Google login with valid userName and Password");
	}
	@Test
	public void googleLogin_BlankUserName_Passoword()
	{
		System.out.println("Google login with Blank username and passowordd");
	}
	@Test
	public void googleLogin_InvalidUserName_Passowrd()
	{
		System.out.println("Google login with Invalid userName and Password");
	}
}
