package stepDefinitions_LC_ExistingUser;

import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IINPersonalInfo extends SeleniumFunctions {

	

	@When("Student selects {string} from EducationLevel dropdown on Student Portal")
	public void student_selects_from_education_level_dropdown_on_student_portal(String Education) throws Exception {
		Page("IINPersonalInfo").clickElement("IINEducationdropdownclick");
		Page("IINPersonalInfo").DropDownSelect("IINPersonalInfo", "IINEducationdropdownvalue", Education);
	}
	    
	@When("Student selects {string} from Occupation dropdown on Student portal")
	public void student_selects_from_occupation_dropdown_on_student_portal(String Occupation) throws Exception {
		Page("IINPersonalInfo").clickElement("IINOccupationdropdownclick");
		Page("IINPersonalInfo").ScrollDownAndClick("IINPersonalInfo", Occupation);
	}
	@When("Click on the {string} checkbox")
	public void click_on_the_checkbox(String string) throws Exception {
		Page("IINPersonalInfo").clickElement("IINMilitarycheckbox");
	}
	@When("Student selects the dropdown option from the readiness question1 {string}")
	public void student_selects_the_dropdown_option_from_the_readiness_question1(String string) throws Exception {
		Page("IINPersonalInfo").clickElement("Question1");
		Page("IINPersonalInfo").DownKeyPress();
		Page("IINPersonalInfo").EnterPress();
		
	}
	@When("Student selects the dropdown option from the readiness question2 {string}")
	public void student_selects_the_dropdown_option_from_the_readiness_question2(String string) throws Exception {
		Page("IINPersonalInfo").clickElement("Question2");
		Page("IINPersonalInfo").DownKeyPress();
		Page("IINPersonalInfo").EnterPress();
		
	}
	
	@When("Student selects the dropdown option from the readiness question3 {string}")
	public void student_selects_the_dropdown_option_from_the_readiness_question3(String string) throws Exception {
		
		Page("IINPersonalInfo").clickElement("Question3");
		Page("IINPersonalInfo").DownKeyPress();
		Page("IINPersonalInfo").EnterPress();
		
	}
	
	@When("Student selects the dropdown option from the readiness question4 {string}")
	public void student_selects_the_dropdown_option_from_the_readiness_question4(String string) throws Exception {
		
		Page("IINPersonalInfo").clickElement("Question4");
		Page("IINPersonalInfo").DownKeyPress();
		Page("IINPersonalInfo").EnterPress();
	}
	
	
	@When("Student Clicks on the {string} Button")
	public void student_clicks_on_button(String string) throws Exception {
		Page("IINPersonalInfo").clickElement("NextButtonIIN");
	}
	@Then("Student Navigates to the {string} page")
	public void student_navigates_to_page(String string) {
		/*Page("IINPersonalInfo").clickElement("IINOccupationdropdownclick");*/
	}








}
