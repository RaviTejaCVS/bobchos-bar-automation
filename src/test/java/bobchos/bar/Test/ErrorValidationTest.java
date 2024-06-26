package bobchos.bar.Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import bobchos.bar.TestComponents.BaseTest;
import bobchos.bar.pageobjects.OrderConfirmation;
import bobchos.bar.pageobjects.OrderHistory;
import bobchos.bar.pageobjects.PurchasePage;

/**
 * 
 */
public class ErrorValidationTest extends BaseTest {

	PurchasePage purchasepage;
	OrderConfirmation orderconfirmation;
	ExtentTest test;

	/**
	 * Author raviteja.cvs15@gmail.com This test verifies the error message
	 * displayed when no size is selected.
	 */
	@Test
	public void assertSizeFieldError() throws InterruptedException {

		purchasepage = landingpage.clickPurchase();
		orderconfirmation = purchasepage.selectSize("...");
		purchasepage.clickBtnOrder();
		String alerttext = purchasepage.getAlertText();
		String expectedText = "Please select size";
		boolean b = comparedValues(alerttext, expectedText);
		Report(b, alerttext, expectedText);

	}

	/**
	 * Author raviteja.cvs15@gmail.com This test verifies the error message
	 * displayed when the quantity is empty.
	 */

	@Test()
	public void assertQuantityFieldError() throws InterruptedException {
		String size = "0.330 l";
		purchasepage = landingpage.clickPurchase();
		orderconfirmation = purchasepage.selectSize(size);

		purchasepage.clickBtnOrder();
		String alerttext = purchasepage.getAlertText();
		Assert.assertEquals(alerttext, "Please input Quantity");
		String match = orderconfirmation.getConfirmationMessage();
		Assert.fail("Alert not received and Order confirmation message received for empty quantity ");
		Reporter.log("Alert not received and Order confirmation message received for empty quantity ");

	}

	/**
	 * Author raviteja.cvs15@gmail.com This test verifies the error message
	 * displayed when the name is empty.
	 */

	@Test
	public void assertNameFieldError() throws InterruptedException {
		String size = "0.330 l";
		purchasepage = landingpage.clickPurchase();
		orderconfirmation = purchasepage.selectSize(size);

		purchasepage.clickBtnOrder();
		String alerttext = purchasepage.getAlertText();
		String expectedText = "Please input Name";
		boolean b = comparedValues(alerttext, expectedText);
		Report(b, alerttext, expectedText);

	}

	/**
	 * Author raviteja.cvs15@gmail.com This test verifies the error message
	 * displayed when the email is empty.
	 */

	@Test
	public void assertEmailFieldError() throws InterruptedException {
		String size = "0.330 l";
		String name = "Selenium Test4";

		purchasepage = landingpage.clickPurchase();
		orderconfirmation = purchasepage.selectSize(size);
		purchasepage.enterName(name);
		purchasepage.clickBtnOrder();
		String alerttext = purchasepage.getAlertText();
		String expectedText = "Please input Email";
		boolean b = comparedValues(alerttext, expectedText);
		Report(b, alerttext, expectedText);
	}

	/**
	 * Author raviteja.cvs15@gmail.com This test verifies the error message
	 * displayed when the "is adult" checkbox is not selected.
	 */

	@Test
	public void assertIsAdultFieldError() throws InterruptedException {
		String size = "0.330 l";
		String name = "Selenium Test4";
		String email = "rt1001@gmail.com";
		purchasepage = landingpage.clickPurchase();
		orderconfirmation = purchasepage.selectSize(size);

		purchasepage.enterName(name);
		purchasepage.enterEmail(email);

		purchasepage.clickBtnOrder();
		String alerttext = purchasepage.getAlertText();
		String expectedText = "Please confirm you are above 18 years old!";
		boolean b = comparedValues(alerttext, expectedText);
		Report(b, alerttext, expectedText);
	}

	/**
	 * Author raviteja.cvs15@gmail.com TThis test verifies that the order is not
	 * confirmed and the email is not saved in the order history when an invalid
	 * email address is entered.
	 */

	@Test
	public void invalidEmailInput() throws IOException {
		boolean isAdult = true;
		String size = "0.330 l";
		String quantity = "1";
		String name = "Invalid email char test1";
		String email = "!@$%*(()**&&^";
		purchasepage = landingpage.clickPurchase();
		orderconfirmation = purchasepage.selectSize(size);
		purchasepage.enterQuantity(quantity);
		purchasepage.enterName(name);
		purchasepage.enterEmail(email);
		purchasepage.checkIsAdult(isAdult);
		purchasepage.clickBtnOrder();
		String confirmMsg = "Thank you for your order. You can find the details below";
		String match = orderconfirmation.getConfirmationMessage();
		Assert.assertTrue(confirmMsg.isEmpty());
		if (match.equals(confirmMsg)) {
			Reporter.log("Order confirmation message received for invalid email ");
			Assert.fail("Order confirmation message received for invalid email ");
			Assert.assertEquals(true, false);
		}
		boolean b = comparedValues(confirmMsg, match);
		Assert.assertFalse(b, "Order confirmation message received for invalid email ");

		OrderHistory orderhistory = new OrderHistory(driver);
		orderhistory.goToOrdersPage();
		String tbEmail = orderhistory.findEmail(email);
		boolean b1 = comparedValues(tbEmail, email);
		Assert.assertFalse(b, "invalid email " + email + " inserted in OrdersHitory table");

	}

	/**
	 * /**Author raviteja.cvs15@gmail.com This test verifies that the order is not
	 * confirmed and the entered negative quantity is not displayed in the
	 * confirmation message.
	 */
	@Test
	public void checkQuantityNegative() throws IOException {
		boolean isAdult = true;
		String size = "0.330 l";
		String quantity = "-11";
		String name = "Invalid";
		String email = "!@$%*(()**&&^";
		purchasepage = landingpage.clickPurchase();
		orderconfirmation = purchasepage.selectSize(size);
		purchasepage.enterQuantity(quantity);
		purchasepage.enterName(name);
		purchasepage.enterEmail(email);
		purchasepage.checkIsAdult(isAdult);
		purchasepage.clickBtnOrder();

		String confirmMsg = "Thank you for your order. You can find the details below";
		String match = orderconfirmation.getConfirmationMessage();
		boolean b = comparedValues(confirmMsg, match);
		Assert.assertFalse(b, "Order confirmation message received for invalid email ");

		Assert.assertTrue(orderconfirmation.getSize().equalsIgnoreCase(size));
		String expectedQuantity = orderconfirmation.getQuantity();

		Assert.assertTrue(confirmMsg.isEmpty());
		
		boolean b1 = comparedValues(expectedQuantity, quantity);
		Assert.assertFalse(b,
				quantity + "-displayed in confirmation page when quantity is passed with a negative value");

		if (b) {
			Reporter.log(quantity + "-displayed in confirmation page when quantity is passed with a negative value");
		}

	}

}
