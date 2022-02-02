package com.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.seleniumFuctions.SeleniumFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import static com.core.Constanst.BROWSER_CHROME;
import static com.core.Constanst.BROWSER_FIREFOX;
import static com.core.Constanst.BROWSER_IE;
import static com.core.Constanst.BROWSER_OPERA;
import static com.core.Constanst.BROWSER_SAFARI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class WebDriverUtils {

	SeleniumFunctions seleniumFunctins;
	WebDriver driver;
	
	private static WebDriverUtils instance = null ;
	
	 public static WebDriverUtils getInstance() {
	        if (instance == null) {
	            instance = new WebDriverUtils();
	        }
	        return instance;
	    }
	 public void setUpDriver() throws Exception {
	        
	        try {
	        	switch (TestProperties.getInstance().getBrowserName().toLowerCase()) {
	                    case BROWSER_CHROME:
	                    	System.out.println("Iam inside switch case");
	                        BaseVariables.getInstance().setWebdriver(new ChromeCapabilities().setChromeCapabilities());		                        
	                        break;
	                        default:
					 	System.out.println("Hi therweee");
	                        throw new IllegalArgumentException("The Browser Name is Undefined");
	                        }
	        	
	        } catch (Exception e) {
	           //catch Exception
	        }
	    }

	 public void initWebDriver() throws Exception {
	        if (BaseVariables.getInstance().getWebdriver() == null) {
	           setUpDriver();
	        }
	        this.driver = BaseVariables.getInstance().getWebdriver();
	       
	       //pass to any constructors 
	        
	    }
	 public void LaunchBrowser() throws Exception {
	 if (BaseVariables.getInstance().getWebdriver() == null) 
	 {
		 setUpDriver(); 
         
      }
	 else
	 {
		 BaseVariables.getInstance().getWebdriver().quit();
		 setUpDriver();
	 }
	 }
	 
	 
	 public class ChromeCapabilities {
	 ChromeOptions options;
	 ChromeDriver Chromedriver;
	public WebDriver setChromeCapabilities() throws Exception {
    	
		System.out.println("Iam inside chromecapabilities method");
		
    	try {
        	options = new ChromeOptions();
        	//System.setProperty("webdriver.chrome.driver", PathConstants.getInstance().getChromeDriverFile());        	
            //commented above line will use webdrivermanager
        	WebDriverManager.chromedriver().setup();
        	options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            options.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("disable-infobars");
            setChromeOptions();            
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            System.setProperty("webdriver.chrome.silentOutput","true");
            Chromedriver = new ChromeDriver(options);
            Chromedriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return Chromedriver;
    }
	
	
	 private void setChromeOptions() {
	        try {
	            Map<String, Object> prefs = new HashMap<String, Object>();
	            prefs.put("credentials_enable_service", false);
	            prefs.put("profile.password_manager_enabled", false);
	            options.setExperimentalOption("prefs", prefs);
	            options.setCapability(ChromeOptions.CAPABILITY, options);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}

}
