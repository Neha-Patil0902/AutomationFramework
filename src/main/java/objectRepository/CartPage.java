package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	@FindBy(className = "inventory_item_name")
	private WebElement itemInfo;
	
	@FindBy(id="remove-sauce-labs-backpack")
	
	//Initialization
	private WebElement removeBtn;
	
	public 	CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getInfo() {
		return itemInfo;
	}
	public WebElement getRemove() {
		return removeBtn;
	}
	
	//Business Library
	
	/**
	 * This method will capture the product-name and return to caller
	 * @return
	 */
	public String getItemName()
	{
		return itemInfo.getText();
	}
	
	/**
	 * This method will click on remove button
	 */
	public void clickOnRemoveBtn()
	{
		removeBtn.click();
	}
}
