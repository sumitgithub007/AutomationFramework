package stepDefinitions_LC_ExistingUser;

import com.core.TestProperties;
import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class newUser extends SeleniumFunctions {
	String Email;
	@When("user takes one Email from the website")
	public void user_takes_one_Email_from_the_website() throws Exception {


		try {
			NavigateToURL(TestProperties.getInstance().getEmailUrl());
			LoadApplication();
		} catch (Exception e) {

		}
	 Email=Page("fakeemail").GetElementText("Emailvalue");
		
	}
	@When("Student Enters the Username")
	public void Student_Enters_the_Username() throws Exception {

		Page("LoginPage").clickElement("UsernameEmail");
		Page("LoginPage").sendKeysToElement("UsernameEmail", Email);
		
	
		
	}
	
	

	@Then("Student Navigates to {string} page")
	public void student_navigates_to_page(String string) {
	   
	}



}
 
