package stepDefinitions_LC_ExistingUser;

import org.junit.Assert;

import com.core.TestProperties;
import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StudentPortalLogin extends SeleniumFunctions {

	@Given("Student is on Student Portal")
	public void student_is_on_admin_portal() {

		try {
			// Launching the url in browser
			NavigateToURL(TestProperties.getInstance().getBaseUrl_hctp());
			LoadApplication();
		} catch (Exception e) {

		}

	}

	@When("Student Enters the {string} and {string}")
	public void student_enters_the_and(String username, String password) throws Exception {

		// click on email box
		Page("LoginPage").clickElement("UsernameEmail");
		// Entering email
		Page("LoginPage").sendKeysToElement("UsernameEmail", username);
		// clicking on continue button
		Page("LoginPage").clickElement("ContinueButton");
		// clicking on password textbox
		Page("LoginPage").clickElement("UserPassword");
		// Entering password
		Page("LoginPage").sendKeysToElement("UserPassword", password);

	}

	@When("Student Clicks on {string} Button")
	public void student_clicks_on_button(String string) throws Exception {

		// clicking continue button
		Page("LoginPage").clickElement("ContinueButton");

	}

	@When("Student Navigates to Course Enrollment Page")
	public void student_navigates_to_course_enrollment_page() throws Exception {

		// waiting for page to load completely
		Page("LandingPageAfterLogin").waitForPageLoad();
		// validation for landing on page using assertion
		String element_text = Page("LandingPageAfterLogin").GetElementText("Course_Enrollment");
		Assert.assertEquals("Course enrollment", element_text);

	}

}
