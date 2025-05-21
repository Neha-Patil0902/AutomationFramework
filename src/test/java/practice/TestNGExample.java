package practice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGExample {
  //1.Simple Tests:
	
  /**
	@Test(invocationCount = -1, priority = 2)
	public void createSample()
	{
		System.out.println("Create");
	}
	@Test
	public void modifySample()
	{
		System.out.println("Modify");
	}
	
	@Test
	public void deleteSample()
	{
		System.out.println("delete");
	}
  */
	
  //2. Using 'dependsOnmethods' and also use Assert.fail() and enabled = false :
	
  /**
	
	@Test
	public void createSample()
	{
		//Assert.fail();       //forcefully fail
		System.out.println("Create");
	}
	
	@Test(dependsOnMethods = "createSample")
	public void modifySample()
	{
		System.out.println("Modify");
	}
	
	@Test(enabled = false)
	public void deleteSample()
	{
		System.out.println("Delete");
	}
  */
	
   //3. Using DataProvider
	
	@Test(dataProvider = "getData")
	public void createEmpData(String name, int id)
	{
		System.out.println("Name id - "+name);
		System.out.println("ID is - "+id);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];   //3x2 - three datasets
		
		//1 st dataset
		data[0][0] = "Shree";
		data[0][1] = 7;
		
		//2 nd dataset
		data[1][0] = "Swami";
		data[1][1] = 9;
		
		//3 rd dataset
		data[2][0] = "Samarth";
		data[2][1] = 11;
				
				
		return data;
		
	}
}
