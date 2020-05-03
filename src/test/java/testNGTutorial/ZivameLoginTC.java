package testNGTutorial;

import org.testng.annotations.Test;

public class ZivameLoginTC extends BaseTestNg
{
    
	@Test(groups= {"Smoke","Regression"})
	public void zivameLogin_validUserName_Password()
	{
		System.out.println("zivame login with valid userName and Password");
	}
	@Test(priority=1,groups= {"Regression"})
	public void zivameLogin_BlankUserName_Passoword()
	{
		System.out.println("zivame login with Blank username and passowordd");
	}
	@Test
	public void zivameLogin_InvalidUserName_Passowrd()
	{
		System.out.println("zivame login with Invalid userName and Password");
	}
}
