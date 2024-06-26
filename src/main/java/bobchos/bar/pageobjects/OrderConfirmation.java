package bobchos.bar.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bobchos.bar.AbstractComponents.AbstractComponents;

public class OrderConfirmation extends AbstractComponents {
	WebDriver driver;
	
	public OrderConfirmation(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='container body-content']/div//p")
	private WebElement confirmationMessage;

	@FindBy(id="Size")
	private WebElement selectSize;
	
	@FindBy(id="Price")
	private WebElement price;
	
	
	@FindBy(id="Qty")
	private WebElement qty;
	
	@FindBy(id="Name")
	private WebElement name;
	
	@FindBy(id="Email")
	private WebElement email;

	
	public String getSize()
	{
		highLightElement(driver,selectSize);
		return selectSize.getText();
	}
	
	public String getPrice()
	{
		highLightElement(driver,price);
		return price.getText();
	}
	
	public String getQuantity()
	{
		highLightElement(driver,qty);
		return qty.getText();
	}
	
	public String getName()
	{
		highLightElement(driver,name);
		return name.getText();
	}
	
	public String getEmail()
	{
		highLightElement(driver,email);
		return email.getText();
	}
	
	public String getConfirmationMessage()
	{
		
		waitForElementtoAppear(confirmationMessage);
		staticWait(2000);
		highLightElement(driver,confirmationMessage);
		return confirmationMessage.getText();
	}

}
