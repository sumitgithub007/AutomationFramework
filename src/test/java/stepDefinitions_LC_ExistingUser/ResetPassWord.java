package stepDefinitions_LC_ExistingUser;

import org.junit.Assert;

import com.core.TestProperties;

import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ResetPassWord extends SeleniumFunctions {

	@Given("user is on application Login Page")
	public void user_is_on_application_login_page() throws Exception {

		try {
			// Launching url in browser
			NavigateToURL(TestProperties.getInstance().getBaseUrl_hctp());
			LoadApplication();
		} catch (Exception e) {

		}

	}

	@When("user Enters the {string} and {string}")
	public void user_enters_the_and(String username, String password) throws Exception {

		// Entering email after clicking the email box
		Page("LoginPage").clickElement("UsernameEmail");
		Page("LoginPage").sendKeysToElement("UsernameEmail", username);
		// Clicking continue button
		Page("LoginPage").clickElement("ContinueButton");
		// Entering password after clicking the email box
		Page("LoginPage").clickElement("UserPassword");
		Page("LoginPage").sendKeysToElement("UserPassword", password);
		Page("LoginPage").clickElement("ShowPass");

	}

	@When("User Clicks on {string} Button")
	public void user_clicks_on_button(String ContinueButton) throws Exception {

		// clicking continue button
		Page("LoginPage").clickElement("ContinueButton");

	}

	@When("User Navigates to ManageAccount")
	public void user_navigates_to_manage_account() throws Exception {

		// Mouse hover for taking proper screenshot in Report

		Page("SelectClassPage").clickElement("ProfileIcon");
		Page("SelectClassPage").clickElement("ManageAccount");
		Thread.sleep(1200);
		//close any popup if present
		Page("SelectClassPage").SwitchToFrame(0);
		
		Page("SelectClassPage").clickElement("TakeaTourPopup");
		Page("SelectClassPage").SwitchOutsideTheFrame();
		
	}

	@Then("User Should be Able to reset the Password {string},{string}")
	public void user_should_be_able_to_reset_the_password(String newpass, String oldpass) throws Exception {

		// click reset password box and enter the oldpassword
		Page("ProfilePage").clickElement("ResetPassword");
		Page("ProfilePage").sendKeysToElement("CurrenttPassword", oldpass);
		Page("ProfilePage").clickElement("ShowPass");
		// click new password box and enter the newpassword
		Page("ProfilePage").sendKeysToElement("NewPassword", newpass);
		Page("ProfilePage").clickElement("ShowPass");
		// click conform password box and enter the newpassword again
		Page("ProfilePage").sendKeysToElement("ConformPassword", newpass);
		Page("ProfilePage").clickElement("ShowPass");
		// Click save button for saving password
		Page("ProfilePage").clickElement("SaveResetPassword");

		// Assertion for validation of popup that comes after saving password
		Assert.assertEquals("Your password was reset successfully.",
				Page("ProfilePage").GetElementText("ResetPasswordPopup"));

	}

	@Then("User should be able to Login and see {string} message along with {string}")
	public void user_should_be_able_to_login(String message, String email) throws Exception {

		//checking the popup is displaying correct after logged in popup should have correct email
		String y = message + " " + email;
		System.out.println(y);
		Assert.assertEquals(message + " " + email, Page("SelectClassPage").GetElementText("WelcomePopup"));
	}

	@Then("User should be Able to Logout")
	public void user_should_be_able_to_logout() throws Exception {

		//Click on profile icon and log out
		Page("ProfilePage").clickElement("ProfileIcon");
		Page("ProfilePage").clickElement("LogOut");

	}

}
