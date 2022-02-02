package stepDefinitions_LC_ExistingUser;

import org.testng.Assert;

import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.Then;

public class EditCreditCardData extends SeleniumFunctions{

	
	
	
@Then("Student edits the credit card {string},{string} details by clicking on Edit Button")
 public void Student_edits_the_credit_card_details_by_clicking_on_Edit_Button(String newexpirydate,String new_address) throws Exception {

	//click edit button
	Page("PaymentInformation").clickToElementByJS("EditButtonClick");
 
	//click three times on box
	Page("PaymentInformation").tripleClickElement("EditCardExpirationDate");
	//Enter expiry date
	Page("PaymentInformation").sendKeysToElement("EditCardExpirationDate", newexpirydate);
	
	 //Enter new billing address
    Page("PaymentInformation").TypeInField("CardBillingAddressInput", new_address);
	Page("PaymentInformation").DownKeyPress();
	Page("PaymentInformation").EnterPress();
    
	
	
	//click save button
	Page("PaymentInformation").clickElement("SaveTheCard");
	String newexpirydateText=Page("PaymentInformation").GetElementText("CardExpirationdateValidate");
	System.out.println(newexpirydateText);
	//Validate edited expiry data is correct
    Assert.assertEquals(newexpirydateText.trim(), newexpirydate);
    
    //Validating billing address of saved card correct or not after editing  card
	String billingaddress= Page("PaymentInformation").GetElementText("CardBillingAdressValidate");
	billingaddress=billingaddress.trim();
	System.out.println(new_address.replaceAll("\\s+",""));
	System.out.println(billingaddress.replaceAll("\\s+",""));
	 Assert.assertEquals(new_address.replaceAll("\\s+",""), billingaddress.replaceAll("\\s+",""));
 
   
    
    
    
    
}

	
}
