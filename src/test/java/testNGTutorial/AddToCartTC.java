package testNGTutorial;

import org.testng.annotations.Test;

public class AddToCartTC extends BaseTestNg{

	@Test(groups= {"Smoke"})
	public void addSingleItem()
	{
		System.out.println("Add single item to cart");
	}
	@Test(groups= {"Smoke"})
	public void addMultipleItem()
	{
		System.out.println("Add Multiple item to cart");
	}
	@Test
	public void appyCoupon()
	{
		System.out.println("Apply coupon");
	}
	@Test
	public void removeCoupon()
	{
		System.out.println("remove coupon");
	}
}
