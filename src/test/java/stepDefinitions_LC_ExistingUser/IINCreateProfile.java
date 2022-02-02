package stepDefinitions_LC_ExistingUser;

import org.testng.Assert;

import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IINCreateProfile extends SeleniumFunctions{
	
	@When("user Enters the {string}")
	public void user_enters_the(String password) throws Exception {
	  //Entering the create password and confirm password.  
	  Page("BeginWithIINEnrollment").clickElement("IINCreatepassword");
	  Page("BeginWithIINEnrollment").sendKeysToElement("IINCreatepassword", password);
	  Page("BeginWithIINEnrollment").clickElement("IINConfirmPassword");
	  Page("BeginWithIINEnrollment").sendKeysToElement("IINConfirmPassword", password);
	  
	}
	@When("User Enters {string},{string},{string}")
	public void user_enters(String fname, String mname, String lname) throws Exception {
		//Entering the first name
		 Page("BeginWithIINEnrollment").clickElement("IINfirstname"); 
		 Page("BeginWithIINEnrollment").sendKeysToElement("IINfirstname", fname);
		 //Entering the middle name
		 Page("BeginWithIINEnrollment").clickElement("IINmiddlename"); 
		 Page("BeginWithIINEnrollment").sendKeysToElement("IINmiddlename", mname);
		 //ENtering the last name
		 Page("BeginWithIINEnrollment").clickElement("IINlastname"); 
		 Page("BeginWithIINEnrollment").sendKeysToElement("IINlastname", lname);
	}
	@When("User Enters {string},{string},{string},{string},{string}")
	public void user_enters(String DOB, String Gender, String countrycode, String Mobilenumber, String Address) throws Exception {
	  //Entering the Date of Birth 
		Page("BeginWithIINEnrollment").clickElement("IINDOB"); 
		Page("BeginWithIINEnrollment").TypeInField("IINDOB", DOB); 
		//Selecting Gender
		Page("BeginWithIINEnrollment").clickElement("IINOpenGender"); 
		Thread.sleep(1000);
		Page("BeginWithIINEnrollment").DropDownSelect("BeginWithIINEnrollment", "IINGenderdropdowndata", Gender);
		//Selecting Country code
		Page("BeginWithIINEnrollment").clickElement("IINCountryCode"); 
		Page("BeginWithIINEnrollment").countrycodeselect(countrycode, "IINCountryCode");
		//Enter mobile Number
		Page("BeginWithIINEnrollment").clickElement("IINMobilePhone");
		Page("BeginWithIINEnrollment").sendKeysToElement("IINMobilePhone", Mobilenumber);
		//Enter the Address
		Page("BeginWithIINEnrollment").clickElement("IINAddress");
		Page("BeginWithIINEnrollment").TypeInField("IINAddress", Address);
		Page("BeginWithIINEnrollment").DropDownSelect("BeginWithIINEnrollment", "IINAddressdropdowndata", Address);
	
		
		
	}
	@When("User clicks to Continue Button")
	public void user_clicks_to_continue_button() throws Exception {
		Page("BeginWithIINEnrollment").clickElement("IINContinue");
		
	}
	@Then("User lands on {string} page")
	public void user_lands_on_course_selection_page(String pagename) throws Exception {
		String text= Page("CourseandLanguage").GetElementText("CourseLanguageIIN");
		Assert.assertEquals(text, pagename);	
	   	    
	}



}
