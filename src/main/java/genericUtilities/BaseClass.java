package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class BaseClass {

	public JavaUtility jUtil = new JavaUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public FileUtility fUtil = new FileUtility();
	
	public WebDriver driver;
	
	//for listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = "SmokeSuite")			//group execution of suite means .xml file
	public void bsConfig()
	{
		System.out.println("======Database Connection Successful =====");
	}
	
	
	//@Parameters("browser")		//this annotation is used for cross browser execution
	
	//@BeforeTest  //This method is used for parallel execution of browser
	
	//@BeforeClass(groups = {"SmokeSuite",""})
	
	@BeforeClass(alwaysRun = true)
	
	public void bcConfig(/*String pValue*/) throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		
		driver = new EdgeDriver();	//simple step for browser execution
		
		//For  cross browser execution - "Run Time Polymorphism"
			//(we make it comment because for listeners we have to use @BeforeClass and this type
			//		of browser execution is used in cross browser execution concept)

//		if(pValue.equals("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//		else if(pValue.equals("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else
//		{
//			driver = new EdgeDriver();
//		}
		
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		//for listeners
		sdriver = driver;
		
		System.out.println("===== Browser Launch Successfully =====");
	}
	
	@BeforeMethod(alwaysRun = true) //default value of alwaysRun is false but we use here true to run for all
	public void bmConfig() throws IOException
	{
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("===== Login To App Successful =====");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("===== Logout of App Successful =====");
	}
	
	@AfterTest     //Whenever we use @BeforeTest it is mandatory to use @AfterTest
 	//@AfterClass(alwaysRun = true)
	public void acConfig() 
	{
		driver.quit();
		
		System.out.println("===== Browser Closure Successful =====");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("===== Database Closure Successful =====");
	}
}
