package com.core;

import java.util.logging.Logger;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ContextInjection.FeatureContext;
import com.ContextInjection.ScenarioContext;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
 

public class Hooks{
	
	public ScenarioContext scenarioContext ;
	private static final Logger LOGGER = Logger.getLogger(CommonUtils.class.getName());
	
	
	
	@BeforeClass
	public static void beforeTest() {

		try {
			System.out.println("before test ");
			TestProperties.getInstance().initProperties();
			WebDriverUtils.getInstance().initWebDriver();
			FeatureContext.getInstance().setFeatureContext("Initial", "Test");

		} catch (Exception e) {

		}

	}
	
	/*@Before
	public  void beforeScenario(){
//		try {
//			WebDriverUtils.getInstance().initWebDriver();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}*/
	
	/*@AfterStep
	public static void TakeScreenshot(Scenario scenario) {

	   System.out.println("After run");
	 	WebDriver driver = BaseVariables.getInstance().getWebdriver();
		//System.out.println(scenario.isFailed());
		
	 	
		//if (scenario.isFailed()) { //uncomment this to take screenshot of only failed ones
		 
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		 
			     String name = scenario.getName();
				scenario.attach(screenshotBytes,"image/png",name);
		 // }
 		
		
	}*/
	
	
	/*@AfterStep
	public void afterScenario(Scenario scenario){
		if (scenario.isFailed()) {
		ReportsUtils.TakeScreenshot(scenario);
//		BaseVariables.getInstance().getWebdriver().close();
		//}
	}*/
	
	/*private static void logError(Scenario scenario) {
		   Field field = FieldUtils.getField(((ScenarioImpl) scenario).getClass(), "stepResults", true);
		   field.setAccessible(true);
		   try {
		       ArrayList<Result> results = (ArrayList<Result>) field.get(scenario);
		       for (Result result : results) {
		           if (result.getError() != null)
		        	   LOGGER.info("Error in Scenario ID:-" + scenario.getId()+ "Exception:" +  result.getError());
		            throw new Exception("Error in Scenario ID:-" +result.getError());
		             
		       }
		   } catch (Exception e) {
		       LOGGER.info("Error while logging error"+e);
		   }
		}*/
	
	
	@AfterClass
	public static void afterTest(){ 
		 System.out.println("After Test");
		//BaseVariables.getInstance().getWebdriver().quit();
		
	}
	

}

