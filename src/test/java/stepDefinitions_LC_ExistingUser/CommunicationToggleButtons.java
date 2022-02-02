package stepDefinitions_LC_ExistingUser;

import org.testng.Assert;

import com.seleniumFuctions.SeleniumFunctions;

import io.cucumber.java.en.When;

public class CommunicationToggleButtons extends SeleniumFunctions {

	String classattr_voice_mail;

	@When("Student clicks on Communication Preferences")
	public void Student_clicks_on_CommunicationPreferences() throws Exception {

		// Go to communication preference page
		Page("CommunicationPreferences").clickElement("communicationPreferencePage");

	}

	@When("Student checks toggle button are working for each of Voice mail sms whatsapp")
	public void Student_Checks_ToggleButtons() throws Exception {

		// Commenting below line as you cannot uncheck and check Email
		// Page("CommunicationPreferences").toggelebuttonvalidation("CommunicationPreferences",
		// "class", "EmailGetAttributeClass","Email");

		// Below methods will check whether the togglebuttons are working correct
		Page("CommunicationPreferences").toggelebuttonvalidation("CommunicationPreferences", "class",
				"VoiceMailGetAttributeClass", "VoiceMail");

		Page("CommunicationPreferences").toggelebuttonvalidation("CommunicationPreferences", "class",
				"SMSGetAttributeClass", "SMS");

		Page("CommunicationPreferences").toggelebuttonvalidation("CommunicationPreferences", "class",
				"WhatsAppGetAttributeClass", "WhatsApp");

	}

}
