package inventoryTests;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenersImplementation.class)  //This is used for listeners implementation


public class AddProductToCartTest extends BaseClass {
	
	@Test(groups = "SmokeSuite")	
	 public void tc_01_AddProductTocartTest() throws IOException{
		 
		 // Read data from excel File 
		 String PRODUCTNAME = fUtil.readDataFromExcel("Sheet1", 1, 2); // has to be added to cart-run time datat
		 
		 //Click on product
		 InventoryPage ip = new InventoryPage(driver);
		 ip.clickOnProduct(driver, PRODUCTNAME);
		 
		 //Add product to cart
		 InventoryItemPage iip = new InventoryItemPage(driver);
		 iip.clickOnAddTocartBtn();
		 
		 //Click on cart container
		 ip.clickOnCartContainer();
		 
		 //Validate in cart
		 CartPage cp = new CartPage(driver);
		 String productInCart =  cp.getItemName();
				
				 // if(productInCart.equals(PRODUCTNAME))
				 //{
					// System.out.println("PASS");
					// System.out.println(productInCart);
				 //}
				 //else
				 //{
					// System.out.println("FAIL");
				 //}
		 
		 //To run assertion programs
		 Assert.assertEquals(productInCart, PRODUCTNAME);
		 
		 Assert.assertTrue(productInCart.equals(PRODUCTNAME));
		 System.out.println(productInCart);
	 }
	 
	 @Test
	 public void sampleTest() 
	 {
		 Assert.fail();  //intensionally we use Assert.fail() here to capture the exception 
		 					//in listenerImplentation.java file,the code which is written onTestFailure() method
		 					//by using this we can capture th error
		 					//if we not use this qand make it comment our code will be run successfully without any error or exception
		 
		 System.out.println("sample");
	 }

}
