package testNGTutorial;

import org.testng.annotations.Test;

public class PaymentTC extends BaseTestNg
{

	@Test(priority=1,groups= {"Smoke"})
	public void PaymenByCOD()
	{
		System.out.println("Payment by COD");
	}
	@Test(priority=2)
	public void PaymenByWallet_GooglePay()
	{
		System.out.println("Payment by Google Pay WALLET");
	}
	@Test
	public void PaymenByWallet_FreeCharge()
	{
		System.out.println("Payment by FREE CHARGE WALLET");
	}
	@Test(dependsOnMethods= {"PaymenByWallet_FreeCharge"})
	public void PaymenByWallet_PhonePe()
	{
		System.out.println("Payment by  PHONE PE WALLET");
	}
	@Test(priority=5)
	public void PaymenByUPI()
	{
		System.out.println("Payment by UPI");
	}
	@Test(enabled=false)
	public void PaymenByCreditcard()
	{
		System.out.println("Payment by CREDIT CARD");	
	}
	
	
}
