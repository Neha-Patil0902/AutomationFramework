package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility {

	
	
	@FindBy(className="product_sort_container")		//fort sort dropdown filter
	private WebElement sortDropDown;
	
	@FindBy(id="shopping_cart_container")		//for cart container
	private WebElement cartContainerBtn;
	
	@FindBy(id="react-burger-menu-btn")			//for menu button
	private WebElement menuBtn;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLink;
	
	//Initialization
	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public WebElement getSort() {
		return sortDropDown;
	}
	public WebElement getContainer() {
		return cartContainerBtn;
	}
	public WebElement getMenu() {
		return menuBtn;
	}
	public WebElement getLogout() {
		return logoutLink;
	}
	
	//This method will perform logout operation
	public void logoutOfApp()
	{
		menuBtn.click();
		logoutLink.click();
	}
	
	/**
	 * This method will sort for lowest price product and then click on it
	 * @param driver
	 * @param sortOption
	 * @param productname
	 */
	public void clickOnLowestPriceProduct(WebDriver driver, String sortOption, String productname)
	{
		handleDropDown(sortDropDown, sortOption);
		driver.findElement(By.xpath("//div[.='"+productname+"']")).click();
	}

	public void clickOnProduct(WebDriver driver, String productname) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//div[.='"+productname+"']")).click();
	}

	public void clickOnCartContainer() {
		// TODO Auto-generated method stub
		cartContainerBtn.click();
	}
}
