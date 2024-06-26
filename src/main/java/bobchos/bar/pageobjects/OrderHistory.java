package bobchos.bar.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bobchos.bar.AbstractComponents.AbstractComponents;

public class OrderHistory extends AbstractComponents {
	WebDriver driver;

	public OrderHistory(WebDriver driver) {
		super(driver);
		// initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private By tableLocator = By.id("tbody");

	public List<WebElement> getOrders() {
		return driver.findElement(tableLocator).findElements(By.tagName("tr"));
	}

	public WebElement findOrderByName(String customerName) {
		List<WebElement> orders = getOrders();

		for (WebElement order : orders) {
			List<WebElement> cells = order.findElements(By.tagName("td"));
			String name = cells.get(1).getText(); // Assuming customer name is in the first column (index 0)

			if (name.equals(customerName)) {
				return order;
			}
		}

		return null;
	}

	public String findName(String customerName) {
		List<WebElement> orders = getOrders();

		for (WebElement order : orders) {
			List<WebElement> cells = order.findElements(By.tagName("td"));
			String name = cells.get(1).getText(); // Assuming customer name is in the first column (index 0)

			if (name.equals(customerName)) {
				return name;
			}
		}

		return null;
	}

	public String findEmail(String customerEmail) {
		List<WebElement> orders = getOrders();

		for (WebElement order : orders) {
			List<WebElement> cells = order.findElements(By.tagName("td"));
			String email = cells.get(2).getText(); // Assuming customer name is in the first column (index 0)

			if (email.equals(customerEmail)) {
				return email;
			}
		}

		return null;
	}

	public String findQuantity(String quantity) {
		List<WebElement> orders = getOrders();

		for (WebElement order : orders) {
			List<WebElement> cells = order.findElements(By.tagName("td"));
			String qty = cells.get(4).getText(); // Assuming customer name is in the first column (index 0)

			if (qty.equals(quantity)) {
				return qty;
			}
		}

		return null;
	}

}
