package stepDefinitions_LC_ExistingUser;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.seleniumFuctions.LocatorType;
import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.When;

public class DeleteCreditCard extends SeleniumFunctions {

	@When("User Changes the Primary method of Payment")
	public void User_Changes_the_Primary_method_of_Payment() throws Exception {

		// click on make primary payment method
		Page("PaymentInformation").clickElement("PrimaryPaymentVisibility");
		Page("PaymentInformation").clickElement("PrimaryPayment");
		// click on yes
		Page("PaymentInformation").clickElement("YesButton");

	}

	@When("User removes the Credit card")
	public void User_removes_the_Credit_card() throws Exception {
		// click remove button
		Page("PaymentInformation").clickElement("RemoveButton");
		// click on yes button
		Page("PaymentInformation").clickElement("YesButton");
		// validation for popup
		String msg = Page("PaymentInformation").GetElementText("ValidationMessageCardRemoval");
		Assert.assertEquals("Payment method removed.", msg);
		
		

	}
	
	  
	@When("Card data {string} should not be present on page")
	public void Card_data_should_not_be_present_on_page(String name) throws Exception   {
		 
		 
		Assert.assertFalse(Page("PaymentInformation").isElementPresent("NameValidate"));
		Assert.assertFalse(Page("PaymentInformation").isElementPresent("CardExpirationdateValidate"));
		Assert.assertFalse(Page("PaymentInformation").isElementPresent("CardBillingAdressValidate"));
		
		 
	}
	

	 
}
