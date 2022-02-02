package stepDefinitions_LC_ExistingUser;

import org.testng.Assert;

import com.core.TestProperties;
import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminPortal extends SeleniumFunctions {

	@Given("Admin is on Admin Portal")
	public void admin_is_on_admin_portal() {

		try {
			// Hi the website url on chrome
			NavigateToURL(TestProperties.getInstance().getAdminUrl());
			LoadApplication();
		} catch (Exception e) {

		}

	}

	@When("Admin Enters the {string} and {string}")
	public void admin_enters_the_and(String username, String password) throws Exception {

		// Enter the username
		Page("AdminPortalLogin").clickElement("username_admin");
		Page("AdminPortalLogin").sendKeysToElement("username_admin", username);
		// Enter the password
		Page("AdminPortalLogin").clickElement("password_admin");
		Page("AdminPortalLogin").sendKeysToElement("password_admin", password);

	}

	@When("Admin Clicks on {string} Button")
	public void admin_clicks_on_button(String string) throws Exception {

		// click continue button
		Page("AdminPortalLogin").clickElement("continue_admin");

	}

	@Then("Admin Navigates to {string} Page")
	public void admin_navigates_to_dashboard_page(String pageName) throws Exception {

		// Validation
		Assert.assertEquals(Page("AdminPortalLogin").GetElementText("dashboard_text"), pageName);

	}

	@Then("Admin clicks on Menu Icon")
	public void admin_clicks_on_menu_icon() throws Exception {

		// click on left menu
		Page("AdminPortalLogin").clickElement("menu_icon");

	}

	@Then("Admin clicks on Admissions > Enrollments")
	public void admin_clicks_on_admissions_enrollments() throws Exception {

		// click on admissions > Enrollments
		Page("AdminPortalLogin").clickElement("admissions_lefticon");
		Page("AdminPortalLogin").clickElement("Enrollments_click");

	}

	@Then("Admin searches user based on email")
	public void admin_searches_user_based_on_email() throws Exception {

		// click on EnrollmentPage search box and enter the email
		Page("AdminPortalLogin").clickElement("Enrollments_searchfield");
		Page("AdminPortalLogin").sendKeysToElement("Enrollments_searchfield", "kassen.alfonso@airadding.com");

	}

	@When("admin opens the student detail")
	public void admin_opens_the_student_detail() throws Exception {
		// Open student details
		Page("AdminPortalLogin").clickElement("OpenStudent");

	}

	@Then("Admin should be able to approve student")
	public void admin_should_be_able_to_approve_student() throws Exception {

		// Click on Approve
		Page("AdminPortalLogin").clickElement("clickApprove");
	}

}
