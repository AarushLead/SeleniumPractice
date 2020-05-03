package testNGTutorial;

import org.testng.annotations.Test;

public class WishListTC extends BaseTestNg
{
	
	@Test(groups= {"Smoke"})
	public void addSingleItemToWishList()
	{
		System.out.println("Add single item to wishlist");
	}
	
	@Test
	public void addMultipleItemToWishList()
	{
		System.out.println("Add multiple item to wishlist");
	}
	@Test
	public void deleteItems()
	{
		System.out.println("Delete item from  wishlist");	
	}
	@Test
	public void moveItems()
	{
		System.out.println("move item to another wishlist");
	}
}
