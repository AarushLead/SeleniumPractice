package testNGTutorial;

import org.testng.annotations.Test;

public class FaceBookLoginTC extends BaseTestNg
{
	@Test(groups= {"Smoke","Regression"})
	public void facebookLogin_validUserName_Password()
	{
		System.out.println("facebook login with valid userName and Password");
	}
	@Test
	public void facebookLogin_BlankUserName_Passoword()
	{
		System.out.println("facebook login with Blank username and passowordd");
	}
	@Test
	public void facebookLogin_InvalidUserName_Passowrd()
	{
		System.out.println("facebook login with Invalid userName and Password");
	}
}
