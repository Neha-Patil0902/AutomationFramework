package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void sampleHard()
	{	
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		//if(1==0) //FAIL - VALIDATE - fail -script - fail
		//{
			//System.out.println("PASS");
		//}
		//else
		//{
			//System.out.println("PASS");
		//}
		
		//Assert.assertEquals(0,1); //if we use 0 here then it shows error and does not display steps 4,5,6 
		Assert.assertEquals(1,1); //if we use 1 here then it shows pass and all steps here from 1 to 6 is display
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
	}
	
	@Test
	public void sampleSoft() 
	{
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(1, 1); 
		//sa.assertEquals(0, 1);  //if we use (0,1) here then it shows error
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
		
		sa.assertAll();  // This step is mandatory while we using soft assert
						 // Without calling asserAll() method we can't make any changes to soft assert
	}

}
