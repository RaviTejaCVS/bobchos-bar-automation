package bobchos.bar.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bobchos.bar.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "btn-primary")
	private WebElement purchase;
	
	
	public PurchasePage clickPurchase()
	{
		waitForElementtoAppear(purchase);
		highLightElement(driver,purchase);
		purchase.click();
		return new PurchasePage(driver);
	}

}
