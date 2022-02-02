package stepDefinitions_LC_ExistingUser;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditProfileOfStudent extends SeleniumFunctions {

	String[] data_profile;

	String profileimagename = "";

	@When("User Clicks on Edit Button")
	public void user_clicks_on_edit_button() throws Exception {

		// Clicking edit button so we can edit profile
		Page("ProfilePage").clickElement("EditButtonType");

	}

	@When("User Changes {string},{string}, {string},{string}, {string}, {string} , {string} , {string}, {string},{string} , {string} , {string} , {string} , {string}")
	public void user_changes(String attachmentPNG, String fname, String mname, String lastname, String dob,
			String gender, String occupation, String educationlevel, String countrycode, String mobilephone,
			String homephone, String workphone, String mailingaddress, String billingaddress) throws Exception {

		// Image name is stored in variable below
		profileimagename = attachmentPNG;

		// Entering firstname
		Page("ProfilePage").clickElement("Fname");
		Page("ProfilePage").BackspacePressUntilTextBoxClear("Fname");
		Page("ProfilePage").TypeInField("Fname", fname);
		// Entering middlename
		Page("ProfilePage").tripleClickElement("Mname");
		Page("ProfilePage").sendKeysToElement("Mname", mname);
		// Entering lastname
		Page("ProfilePage").tripleClickElement("Lname");
		Page("ProfilePage").sendKeysToElement("Lname", lastname);
		// Scrolling down webpage
		Page("ProfilePage").ScrollDown();
		// Selecting date from calendar
		Page("ProfilePage").CalendarDateSelect(dob, "ProfilePage");
		// Double click to open the file menu
		Page("ProfilePage").doubleClickElement("chooseFile");
		// Uploading file from desktop
		Page("ProfilePage").UploadFileFromDesktop(attachmentPNG);
		// Open the gender dropdown
		Page("ProfilePage").clickElement("GenderPopUp");
		// Select the gender from dropdown
		Page("ProfilePage").DropDownSelect("ProfilePage", "Genderlist", gender);
		// Open the occupation dropdown
		Page("ProfilePage").clickElement("OccupationDropdown");
		// Select the occupation from dropdowmn
		Page("ProfilePage").ScrollDownAndClick("ProfilePage", occupation);
		// Open the education dropdown
		Page("ProfilePage").clickElement("EducationLevelDropdown");
		// Select the education from dropdowm
		Page("ProfilePage").DropDownSelect("ProfilePage", "EducationLevelDropdownData", educationlevel);
		// Select the country code
		Page("ProfilePage").clickElement("CountryCodeMobilePhone");
		Page("ProfilePage").countrycodeselect(countrycode, "CountryCodeMobilePhone");
		// Enter the number
		Page("ProfilePage").clickElement("MobilePhoneNumber");
		Page("ProfilePage").TextboxSelectAll("MobilePhoneNumber");
		Page("ProfilePage").sendKeysToElement("MobilePhoneNumber", mobilephone);
		// Select the Country code
		Page("ProfilePage").clickElement("CountryCodeHomePhone");
		Page("ProfilePage").countrycodeselect(countrycode, "CountryCodeHomePhone");
		// Enter the number
		Page("ProfilePage").tripleClickElement("HomePhoneNumber");
		Page("ProfilePage").sendKeysToElement("HomePhoneNumber", homephone);
		// select the country code
		Page("ProfilePage").clickElement("CountryCodeWorkPhone");
		Page("ProfilePage").countrycodeselect(countrycode, "CountryCodeWorkPhone");
		// Enter the number
		Page("ProfilePage").tripleClickElement("WorkPhoneNumber");
		Page("ProfilePage").sendKeysToElement("WorkPhoneNumber", workphone);

		// Enter the mailing address
		Page("ProfilePage").TypeInField("MailingAddress", mailingaddress);
		Page("ProfilePage").DropDownSelect("ProfilePage", "MailingAddressList", mailingaddress);
		// Enter billing address
		Page("ProfilePage").doubleClickElement("BillingAddress");
		Page("ProfilePage").sendKeysToElement("BillingAddress", billingaddress);
		// Page("ProfilePage").DropDownSelect("ProfilePage", "BillingAddressList",
		// billingaddress); //Not required now

	}

	@When("User Clicks on Save Button")
	public void user_clicks_on_save_button() throws Exception {

		// click on save profile
		Page("ProfilePage").clickElement("SaveProfile");

	}

	@Then("All Information along with {string},{string},{string},{string},{string},{string},{string},{string},{string} will be saved and displayed on UI")
	public void all_information_will_be_saved_and_displayed_on_ui(String gender, String dob, String educationlevel,
			String occupation, String email, String workphone, String mobilephone, String homephone, String countrycode)
			throws Exception {

		// formatting date as per the page (UI) for validating it later
		String dobirth = Page("ProfilePage").formatDOB(dob);

		// check image updated or not
		Page("ProfilePage").checkImagePresence("ImagePresence", profileimagename);

		// getting all data in one array for later validation
		data_profile = new String[] { gender, dobirth, educationlevel, occupation, email, (countrycode + mobilephone),
				(countrycode + homephone), (countrycode + workphone) };

		// using validateprofilepageforvalidation()
		Page("ProfilePage").validateProfilePage(data_profile, "GetValuesProfilePage");
	}

}
