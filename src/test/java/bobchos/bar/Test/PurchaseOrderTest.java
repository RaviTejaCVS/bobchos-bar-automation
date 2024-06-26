package bobchos.bar.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import bobchos.bar.TestComponents.BaseTest;
import bobchos.bar.pageobjects.OrderConfirmation;
import bobchos.bar.pageobjects.OrderHistory;
import bobchos.bar.pageobjects.PurchasePage;



/**Author- ravteja.cvs15@gmail.com
 *This tests placing orders with data from JSON.
placeOrder uses HashMap for customer data, verifies order details.
getData provides test data from PurchaseOrder.json file.
 */
public class PurchaseOrderTest extends BaseTest{
	
	boolean isAdult=true;
	
	PurchasePage purchasepage;
	OrderConfirmation orderconfirmation;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	@Test(dataProvider="getData")
	public void placeOrder(HashMap<String,String> input) throws IOException{
		purchasepage=landingpage.clickPurchase();
		orderconfirmation=purchasepage.selectSize(input.get("size"));
		  
		purchasepage.enterQuantity(input.get("quantity"));
		purchasepage.enterName(input.get("name"));
		purchasepage.enterEmail(input.get("email"));
		purchasepage.checkIsAdult(Boolean.parseBoolean(input.get("isAdult")));
		purchasepage.clickBtnOrder();
		
		String match=orderconfirmation.getConfirmationMessage();
		Assert.assertTrue(match.equalsIgnoreCase("Thank you for your order. You can find the details below."));
		Assert.assertTrue(orderconfirmation.getSize().equalsIgnoreCase(input.get("size")));
		Assert.assertTrue(orderconfirmation.getName().equalsIgnoreCase(input.get("name")));
		Assert.assertTrue(orderconfirmation.getQuantity().equalsIgnoreCase(input.get("quantity")));
		Assert.assertTrue(orderconfirmation.getEmail().equalsIgnoreCase(input.get("email")));
		OrderHistory orderhistory=new OrderHistory(driver);
		orderhistory.goToOrdersPage();
		WebElement order =orderhistory.findOrderByName(input.get("name"));

      if (order != null) {
          List<WebElement> cells = order.findElements(By.tagName("td"));
          // Get the details from each cell and assert them as needed
          Assert.assertTrue(cells.get(1).getText().equals(input.get("name")));
          Assert.assertTrue(cells.get(2).getText().equals(input.get("email")));
          Assert.assertTrue(cells.get(3).getText().equals(input.get("size")));
          Assert.assertTrue(cells.get(4).getText().equals(input.get("quantity")));
          System.out.println("Customer Name: " + cells.get(1).getText());
          System.out.println("Email: " + cells.get(2).getText());
          System.out.println("Size: " + cells.get(3).getText());
          System.out.println("Quantity: " + cells.get(4).getText());
          System.out.println("Price: " + cells.get(5).getText());
          System.out.println("Date: " + cells.get(6).getText());
      } else {
          System.out.println("Order not found for customer Hershel Nader");
      }
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//bobchos//bar//data//PurchaseOrder.json");
		return new Object[][]  {{data.get(0)}, {data.get(1) } };
		
	}
	
	
	
}
