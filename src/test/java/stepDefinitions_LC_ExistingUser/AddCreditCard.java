package stepDefinitions_LC_ExistingUser;

import org.junit.Assert;
import org.sikuli.hotkey.Keys;

import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCreditCard extends SeleniumFunctions {
	
	String Value_name;
	String expirationdate;
	String billingaddress;
	

	@When("Student clicks on Payment Information")
	public void student_clicks_on_payment_information() throws Exception {

		// Click on PaymentInformation
		Page("PaymentInformation").clickElement("PaymentInformation_");
		//Close popup
		Thread.sleep(1200);
		//close any popup if present
		Page("SelectClassPage").SwitchToFrame(0);
		
		Page("SelectClassPage").clickElement("TakeaTourPopup");
		Page("SelectClassPage").SwitchOutsideTheFrame();

	}

	@When("Student clicks on Wallet")
	public void student_clicks_on_wallet() throws Exception {
		//Click on wallet
		Page("PaymentInformation").clickElement("Wallet");

		//Below line is for testing purpose
		globalvariableSet("sumit@gmail.com");

	}

	@When("Student clicks on Add a Payment method Button")
	public void student_clicks_on_add_a_payment_method_button() throws Exception {

		//click on addpaymentbutton
		Page("PaymentInformation").clickElement("AddPaymentButton");

	}

	@When("Student clicks on Add a credit or debit card")
	public void student_clicks_on_add_a_credit_or_debit_card() throws Exception {
		//Click on add card
		Page("PaymentInformation").clickElement("AddCards");

	}

	@When("Student enters {string},{string},{string}, {string},{string}")
	public void student_enters(String address,String NameOnTheCard, String CardNumber, String ExpirationDate, String CVC)
			throws Exception {
		
		 
		//Fill the name
		Page("PaymentInformation").clickElement("NameOnTheCard");
		Page("PaymentInformation").sendKeysToElement("NameOnTheCard", NameOnTheCard);

		//Fill card number
		Page("PaymentInformation").SwitchToFrame("iframeCardNumber");
		Page("PaymentInformation").clickElement("CardNumber");
		Page("PaymentInformation").sendKeysToElement("CardNumber", CardNumber);

		//switching outside frame
		Page("PaymentInformation").SwitchOutsideTheFrame();
		//Entering billing address
//		/Page("PaymentInformation").clickElement("CardBillingAddressClick");
		Page("PaymentInformation").TypeInField("CardBillingAddressInput", address);
		Page("PaymentInformation").DownKeyPress();
		Page("PaymentInformation").EnterPress();
        //switch inside frame
		Page("PaymentInformation").SwitchToFrame("iframeDate");
		//Fill expiration date
		String[]val = ExpirationDate.split("/20");
		ExpirationDate=val[0]+val[1];
		Page("PaymentInformation").clickElement("ExpirationDate");
		Page("PaymentInformation").sendKeysToElement("ExpirationDate", ExpirationDate);
        //Comeoutside frame
		Page("PaymentInformation").switchToDefaultFrame();
		Page("PaymentInformation").SwitchToFrame("iframeCVC");
		//Fill CVC detail
		Page("PaymentInformation").clickElement("CVC");
		Page("PaymentInformation").sendKeysToElement("CVC", CVC);
		//come outside frame
		Page("PaymentInformation").switchToDefaultFrame();

		
	}

	@When("student clicks on Add payment method Button")
	public void student_clicks_on_add_payment_method_button() throws Exception {
		
		//click on add payment button
		Page("PaymentInformation").clickElement("AddPaymentMethod");
	}

	@Then("the new credit card details {string},{string},{string} will be saved and displayed on the screen")
	public void the_new_credit_card_details_will_be_saved_and_displayed_on_the_screen(String Name, String expiryDate,String address) throws Exception {

		
		 
			//Validating that name is appearing on UI which means card data saved
			Value_name = Page("PaymentInformation").GetElementText("NameValidate");
			Assert.assertEquals(Value_name, Name);
			//Validating expiration date of saved card
			expirationdate = Page("PaymentInformation").GetElementText("CardExpirationdateValidate");
			System.out.println(expirationdate);
			 
		     Assert.assertEquals(expirationdate, expiryDate);
		 //Validating billing address of saved card correct or not after adding card
			billingaddress= Page("PaymentInformation").GetElementText("CardBillingAdressValidate");
			billingaddress=billingaddress.trim();
			System.out.println(address.replaceAll("\\s+",""));
			System.out.println(billingaddress.replaceAll("\\s+",""));
			 Assert.assertEquals(address.replaceAll("\\s+",""), billingaddress.replaceAll("\\s+",""));
		 
	}

}
