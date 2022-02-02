package stepDefinitions_LC_ExistingUser;



import org.testng.Assert;

import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IINPaymentPlan extends SeleniumFunctions {

	
	@When("Student clicks on {string} hyperlink")
	public void student_clicks_on_hyperlink(String string) throws Exception {
		Page("IINPaymentPlanpage").clickElement("IINSelectPlanhyperlink");  
	}
	@When("select {string}")
	public void select(String string) throws Exception {
		Page("IINPaymentPlanpage").clickElement("IINPaymentPlancircle");
	}
	@When("click on the {string} button")
	public void click_on_the_button(String string) throws Exception {
		Page("IINPaymentPlanpage").clickElement("IINNEXT1");
	}
	@When("click on the {string} button in the popup window")
	public void click_on_the_button_in_the_popup_window(String string) throws Exception {
		Page("IINPaymentPlanpage").clickElement("IINOK");
	}
	@Then("user is directed to the {string} page")
	public void user_is_directed_to_the_page(String pagename) throws Exception {
	  Assert.assertEquals(pagename, Page("IINPaymentPlanpage").GetElementText("IINPaymentdetailsvalidate"));  
	}



}
