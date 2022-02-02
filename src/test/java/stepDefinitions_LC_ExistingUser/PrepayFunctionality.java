package stepDefinitions_LC_ExistingUser;

import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.When;

public class PrepayFunctionality extends SeleniumFunctions {

	float amountbeforeprepay;
	float amount_of_prepay;
	SoftAssert sa = new SoftAssert();

	@When("Student clicks on Make a payment followed by Make Payment")
	public void Student_clicks_on_Make_a_payment_followed_by_Make_Payment() throws Exception {

		String amount_before_prepay = Page("PaymentInformation").GetElementText("CurrentOwedAmount");

		String updatedamount = Page("PaymentInformation").ExtractNumberExcluding$(amount_before_prepay);
		amountbeforeprepay = Page("PaymentInformation").Convert_String_To_Float(updatedamount);

		Page("PaymentInformation").clickElement("MakeApayment");
		Page("PaymentInformation").clickElement("MakePayment");

	}

	@When("Student enters the {string} and clicks on pre-pay")
	public void Student_enters_the_amount_and_clicks_on_pre_pay(String amount) throws Exception {
		amount_of_prepay = Page("PaymentInformation").Convert_String_To_Float(amount);
		Page("PaymentInformation").doubleClickElement("AmountToBePaid");
		Page("PaymentInformation").sendKeysToElement("AmountToBePaid", amount);

		// clicking on pre-pay button
		Page("PaymentInformation").clickElement("PrePay");

	}

	@When("Student checks total amount to be paid is correct")
	public void Student_checks_total_amount_to_be_paid() throws Exception {

		String amount_text = Page("PaymentInformation").GetElementText("Amount");
		amount_text = Page("PaymentInformation").ExtractNumberExcluding$(amount_text);
		float amount = Page("PaymentInformation").Convert_String_To_Float(amount_text);
		System.out.println(amount);

		String tax_amount = Page("PaymentInformation").GetElementText("Tax_Amount");
		tax_amount = Page("PaymentInformation").ExtractNumberExcluding$(tax_amount);
		float Tax_Amount = Page("PaymentInformation").Convert_String_To_Float(tax_amount);
		System.out.println(Tax_Amount);

		String totaltobePaid = Page("PaymentInformation").GetElementText("Total_To_Be_Paid");
		totaltobePaid = Page("PaymentInformation").ExtractNumberExcluding$(totaltobePaid);
		float total_to_be_paid = Page("PaymentInformation").Convert_String_To_Float(totaltobePaid);

		System.out.println(total_to_be_paid);

		sa.assertEquals(String.valueOf(amount + Tax_Amount), String.valueOf(total_to_be_paid));

	}

	@When("Student clicks on Submit Payment")
	public void Student_clicks_on_Submit_Payment() throws Exception {

		Page("PaymentInformation").clickElement("SubmitPayment");

	}

	@When("Student gets a message saying {string}")
	public void Student_gets_a_message_saying_payment_succeess(String msg) throws Exception {
		String text_payment = Page("PaymentInformation").GetElementText("ThanksMessagePayment");
		Assert.assertEquals(msg, text_payment);

		// close the popup
		Page("PaymentInformation").clickElement("Closepopup");

	}

	@When("the current balanced owed should be updated accordingly")
	public void the_current_balanced_owed_should_be_updated_accordingly() throws Exception {

		Page("PaymentInformation").RefreshBrowser();
		String updated_amount_after_prepay = Page("PaymentInformation").GetElementText("CurrentOwedAmount");
		updated_amount_after_prepay = Page("PaymentInformation").ExtractNumberExcluding$(updated_amount_after_prepay);
		// tax will not be included
		String calculated_amount = String.valueOf(amountbeforeprepay - amount_of_prepay);

		sa.assertEquals(calculated_amount, updated_amount_after_prepay);

		// sa.assertAll();

	}

	@When("Total paid to date amount should be correct")
	public void Total_paid_to_date_amount_should_be_correct() throws Exception {

		float expected_total_paid_date = 0;

		String actual_total_paid_date = Page("PaymentInformation").GetElementText("TotalPaidToDate");
		actual_total_paid_date = Page("PaymentInformation").ExtractNumberExcluding$(actual_total_paid_date);
		System.out.println("Total paid date = " + actual_total_paid_date);

		String depositamount = Page("PaymentInformation").GetElementText("DepositAmount");
		depositamount = Page("PaymentInformation").ExtractNumberExcluding$(depositamount);

		float deposit_amount_ = Page("PaymentInformation").Convert_String_To_Float(depositamount);

		// Navigate to payment plan terms
		Page("PaymentInformation").clickElement("PaymentPlanTermsPage");

		float total_amounts_sum = Page("PaymentInformation").calculate_PaymentPlanSchedule_Amounts("PaymentInformation",
				"PaymentScheduleAmounts");
		expected_total_paid_date = total_amounts_sum + deposit_amount_;

		sa.assertEquals(String.valueOf(expected_total_paid_date), actual_total_paid_date);

		sa.assertAll();

	}

}
