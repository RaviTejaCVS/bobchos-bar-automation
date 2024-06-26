package bobchos.bar.pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import bobchos.bar.AbstractComponents.AbstractComponents;

public class PurchasePage extends AbstractComponents {
	WebDriver driver;
	
	public PurchasePage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="Size")
	private WebElement selectSize;
	
	@FindBy(id="Qty")
	private WebElement qty;
	
	@FindBy(id="Name")
	private WebElement name;
	
	@FindBy(id="Email")
	private WebElement email;
	
	@FindBy(id="IsAdult")
	private WebElement isAdult;
	
	@FindBy(id="btnOrder")
	private WebElement btnOrder;
	
	public OrderConfirmation selectSize(String size)
	{
		Select s=new Select(selectSize);
		highLightElement(driver,selectSize);
		s.selectByVisibleText(size);
		return new OrderConfirmation(driver);
	}
	
	public OrderConfirmation enterQuantity(String qty)
	{
		this.qty.sendKeys(qty);
		highLightElement(driver,this.qty);
		return new OrderConfirmation(driver);
	}
	
	public OrderConfirmation enterName(String name)
	{
		this.name.sendKeys(name);
		return new OrderConfirmation(driver);
	}
	
	public OrderConfirmation enterEmail(String email)
	{
		this.email.sendKeys(email);
		highLightElement(driver,this.email);
		return new OrderConfirmation(driver);
	}
	
	public OrderConfirmation checkIsAdult(boolean isAdult)
	{
		this.isAdult.click();
		highLightElement(driver,this.isAdult);
		return new OrderConfirmation(driver);
	}
	
	public String getAlertText() throws NoAlertPresentException {
	    try {
	        Alert alert = driver.switchTo().alert();
	        String alertText = alert.getText();
	        alert.accept(); // Click OK on the alert
	        return alertText;
	    } catch (NoAlertPresentException e) {
	        // Handle the case where no alert is present (optional)
	        System.out.println("No alert present.");
	        return null;  // Or return an appropriate default value
	    }
	}
	   
	public OrderConfirmation clickBtnOrder()
	{
		scrollToElement(driver,btnOrder);
		btnOrder.click();
		return new OrderConfirmation(driver);
	}
}
