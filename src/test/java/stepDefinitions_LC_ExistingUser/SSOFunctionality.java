package stepDefinitions_LC_ExistingUser;

import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.When;

public class SSOFunctionality extends SeleniumFunctions{

	String moduleName ="";
	
	@When("Student clicks on My Courses")
	public void Student_clicks_on_My_Courses() throws Exception {

		//Clicki on MyCourse
		Page("SSOFunctionality").clickElement("MyCourse");
		
	}
	
	@When("Student clicks on Continue Learning")
	public void Student_clicks_on_Continue_Learning() throws Exception {

		//Click on continue learning
		Page("SSOFunctionality").clickElement("ContinueLearning");
		
	}
 
	@When("Student should be navigated to Modules Section")
	public void Student_should_be_navigated_to_Modules_Section() throws Exception {

		//check page url should conntain modules
		Page("SSOFunctionality").VerifyPageUrl("/modules");
		
	}
	
	@When("Student checks the FirstModule text")
	public void Student_checks_the_FirstModule_text() throws Exception {

		//Fetch module name
		moduleName=Page("SSOFunctionality").GetElementText("ModuleName");
		
	}
	
	@When("Student clicks on start button")
	public void Student_clicks_on_start_button() throws Exception {

		//click on start button
		Page("SSOFunctionality").clickElement("StartButtonClick");
		
	}
	
	@When("Student will be Navigated to same module page which was outside")
	public void Student_will_be_Navigated_to_same_module_page_which_was_outside() {

		//shadowDom method
	//	Page("SSOFunctionality")
	 
	}
	
	
	
	
	
	
	
	
	
	
}
