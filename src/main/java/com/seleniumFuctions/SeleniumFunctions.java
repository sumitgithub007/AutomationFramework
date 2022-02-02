package com.seleniumFuctions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import com.core.AssertUtils;
import com.core.BaseVariables;
import com.core.CommonUtils;
import com.core.ReadWriteUtils;
import com.core.TestProperties;

public class SeleniumFunctions {
	WebDriverWait wait;
static String pageLoadStatus = null;
static String elementvalue;
	static String variableval;
	static JavascriptExecutor js_;
	WebDriver driver;
	static int check = 0;
	public SeleniumFunctions() {

		this.driver = BaseVariables.getInstance().getWebdriver();
		this.wait = new WebDriverWait(driver, TestProperties.getInstance().getwaitTime());
	}

	String LocValue = "";

	private static final Logger LOGGER = Logger.getLogger(CommonUtils.class.getName());
	private String PageName = "";

	public SeleniumFunctions Page(String PageName) {
		this.PageName = PageName;
		return this;
	}

	public void LoadApplication() {
		ReadWriteUtils RWU = new ReadWriteUtils();
		RWU.ReadLocators();
	}

	public Boolean clickElement(String elmtName) throws Exception {		
		Boolean Clicked = false;
		try {
			WebElement El = wait.until(ExpectedConditions.elementToBeClickable(getElement(elmtName)));
			El.click();
			System.out.println("elmtName----------- "+El);

			Clicked = true;
			Thread.sleep(2000);
		} catch (ElementClickInterceptedException Iex) {
			clickToElementByJS(elmtName);
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			throw new Exception(ex.toString());
		}
		return Clicked;
	}

	
	public void countrycodeselect(String code,String locatorval) throws Exception
	{
		WebDriver driver = BaseVariables.getInstance().getWebdriver();
		WebElement e1 = getElement(locatorval);
		e1.sendKeys(code);
		Actions a = new Actions(driver);
		a.moveToElement(e1).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
	 	
	}
	
	
	
	 
	
	public void check() throws InterruptedException
	{
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='q-img__content absolute-full'])[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[text()='Payment information']")).click();
	 driver.findElement(By.xpath("//*[text()='Wallet']")).click();
	
	
	 driver.findElement(By.xpath("(//span[@class='block'])[3]")).click();
	 Thread.sleep(2000);
	
	 
	 driver.findElement(By.xpath("(//div[@class='text-weight-medium text-orange-01 cursor-pointer'])[1]")).click();
	
	 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Secure card number input frame']")));
	
	 System.out.println("he7777777777777777777");
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@aria-label='Credit or debit card number']")).click();
	driver.findElement(By.xpath("//input[@aria-label='Credit or debit card number']")).sendKeys("4242424242424242");
	
	driver.switchTo().defaultContent();
	
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Secure expiration date input frame']")));
	
	driver.findElement(By.xpath("//input[@aria-label='Credit or debit card expiration date']")).click();
	driver.findElement(By.xpath("//input[@aria-label='Credit or debit card expiration date']")).sendKeys("323");
	driver.switchTo().defaultContent();
	
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Secure CVC input frame']")));
	
	driver.findElement(By.xpath("//input[@aria-label='Credit or debit card CVC/CVV']")).click();
	driver.findElement(By.xpath("//input[@aria-label='Credit or debit card CVC/CVV']")).sendKeys("990");
	driver.switchTo().defaultContent();
	
	
	
	
	}
	
	public Boolean clickDynamicElement(String elmtName, String replacedBy) throws Exception {
		Boolean Clicked = false;
		try {
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(getElementDynamically(elmtName, replacedBy)));
			// WebElement element = getElementDynamically(elmtName, replacedBy);
			element.click();
			Clicked = true;
		} catch (ElementNotVisibleException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Element:" + elmtName + " is not visible/present on this page.Exception Description:"
					+ ex.getMessage());
			throw new Exception("Element:" + elmtName + " is not visible/present on this page");
		} catch (StaleElementReferenceException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Element:" + elmtName + " is no longer present on this page.Exception Description:"
					+ ex.getMessage());
			throw new Exception("Element:" + elmtName + " is no longer present on this page");
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Exception while clicking dynamic element:" + ex.getMessage());
			throw new Exception("Exception while clicking dynamic element:" + ex.toString());
		}
		return Clicked;
	}
	
	
	
	
	
	
	public void toggelebuttonvalidation(String pageName,String attributeName,String locatorName,String eletoClick) throws Exception
	{
	   String classattr_="";
	   int i=0;
		 
	   while(i<3)
	   {
	   
		 classattr_= Page(pageName).GetElementAttribute(locatorName, attributeName);
		
		 
		if(classattr_.contains("text-green"))
		{
			//means already checked
			Page(pageName).clickElement(eletoClick); //click again to uncheck
			classattr_= Page(pageName).GetElementAttribute(locatorName, attributeName);
			
			if(!(classattr_.contains("text-green")))
			{
				System.out.println("Toggle button unchecked");
				Assert.assertFalse(classattr_.contains("text-green"));
			}
		}
		
		else if(!(classattr_.contains("text-green")))
		{
			//means it is unchecked
			Page(pageName).clickElement(eletoClick); //click again to check
			classattr_= Page(pageName).GetElementAttribute(locatorName, attributeName);
			Assert.assertTrue(classattr_.contains("text-green"));
		}
		++i;
	   }
	}
	
	
	
	
	
	
	

	public Boolean clickDynamicElementByJS(String elmtName, String replacedBy) throws Exception {
		Boolean Clicked = false;
		try {
			JavascriptExecutor ex = (JavascriptExecutor) driver;
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(getElementDynamically(elmtName, replacedBy)));
			// WebElement element = getElementDynamically(elmtName, replacedBy);
			ex.executeScript("arguments[0].click();", element);
			Clicked = true;
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Exception while clicking dynamic element by JS:" + ex.getMessage());
			throw new Exception("Exception while clicking dynamic element by JS:" + ex.toString());
		}
		return Clicked;
	}

	public void setValue(String value) {
		elementvalue=value;
	}
	
	public String getValue() {
		return elementvalue;
	}
	
	
	
	public void clickToElementByJS(String elmtName) {
		WebElement element = null;
		try {
			element = getElement(elmtName);
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
			e.printStackTrace();
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public String GetElementAttribute(String elmtName, String attributeName) throws Exception {
		String value = "";
		try {
			WebElement El = getElement(elmtName);
			Thread.sleep(2000);
			// add wait here
//            WaitForPageToLoad();
			value = El.getAttribute(attributeName);
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			throw new Exception(
					"Error while fetching value of element:" + elmtName + ".Error occured is:" + ex.getMessage());
		}
		return value;
	}

	public String GetElementText(String elmtName) throws Exception {
		String value = "";
		try {
			WebElement El = getElement(elmtName);
			Thread.sleep(2000);
			// add wait here
//            WaitForPageToLoad();
			value = El.getText();

		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			throw new Exception(
					"Error while fetching value of element:" + elmtName + ".Error occured is:" + ex.getMessage());
		}
		return value;
	}
	
	
	public void UploadFileFromDesktop(String filenamePNGformat)
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			 
			e.printStackTrace();
		}
		try {

			String imagesFilePath  = System.getProperty("user.dir") +"\\"+"skuli" +"\\" +"ss" + "\\";
			String filewewillupload  = System.getProperty("user.dir") + "\\"+"skuli" + "\\" + "image" +"\\";
		 	Screen s = new Screen();
			Pattern fileInputTextBox = new Pattern(imagesFilePath + "FileTextBox.PNG");
			Pattern openButton = new Pattern(imagesFilePath + "OpenButton.PNG");

			Thread.sleep(5000);
			 
			// Click on Browse button and handle windows pop up using Sikuli

			
			
			s.wait(fileInputTextBox, 20);
			s.type(fileInputTextBox, filewewillupload + filenamePNGformat + ".png");//come till image path
			s.click(openButton);//come till image path
			Thread.sleep(7000);
			s.type(fileInputTextBox,filewewillupload +filenamePNGformat + ".png");
			s.click(openButton); 
		} catch (Exception ex) {
		}
		
	}
	
	public String GetDynamicElementText(String elmtName, String replacedBy) throws Exception {
		String value = "";
		try {
			WebElement El = wait
					.until(ExpectedConditions.elementToBeClickable(getElementDynamically(elmtName, replacedBy)));
			Thread.sleep(2000);
			// add wait here
//            WaitForPageToLoad();
			value = El.getText();

		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			throw new Exception(
					"Error while fetching value of element:" + elmtName + ".Error occured is:" + ex.getMessage());
		}
		return value;
	}

	public LocatorType locatorTypeName(String elmtName) {
		LocatorType locatorType = BaseVariables.getInstance().GetPageList().get(PageName).getLocatorList().get(elmtName)
				.getLocatorType();
		return locatorType;                            
	}

	
    public Boolean SwitchOutsideTheFrame() {// currently works with Frame id
        Boolean IsSwitched = false;
        try {
                        // wait = Browser.wait;
driver.switchTo().defaultContent();

                        IsSwitched = true;
        } catch (Exception ex) {
                        AssertUtils.getInstance().Fail(ex.getMessage());
                        
        }
        return IsSwitched;
}



	
	
	
	public WebElement getElement(String elmtName) throws Exception {
		
		WebElement element = null;
		try {
			LocValue = BaseVariables.getInstance().GetPageList().get(PageName).getLocatorList().get(elmtName)
					.getLocatorValue();
			element = FindElement(locatorTypeName(elmtName), LocValue);

		} catch (NoSuchElementException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to find the element" + elmtName + "Exception Description:" + ex);
			throw new Exception("Unable to find the element" + elmtName);
		} catch (ElementNotSelectableException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to select element:" + elmtName + "Exception Description:" + ex);
			throw new Exception("Unable to select element:" + elmtName);
		} catch (ElementNotVisibleException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Element is not visible:" + elmtName + "Exception Description:" + ex);
			throw new Exception("Element is not visible:" + elmtName);
		} catch (TimeoutException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Timeout Error while finding element:" + elmtName + "Exception Description:" + ex);
			throw new Exception("Timeout Error while finding element:" + elmtName);
		} catch (StaleElementReferenceException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Stale Element:" + elmtName + "Exception Description:" + ex);
			throw new Exception("Stale Element:" + elmtName);
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to find the element" + elmtName + "Exception Description:" + ex);
			throw new Exception("Unable to find the element" + elmtName + "Exception Description:" + ex);
		}

		return element;
	}

	protected WebElement FindElement(LocatorType locType, String locValue) throws Exception {
		Thread.sleep(1000);
		WebElement elmt = null;
		try {
			switch (locType) {
			case XPath:
				if (isElementPresent(By.xpath(locValue))) {
					elmt = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locValue)));

				}

				break;
			case ID:
				if (isElementPresent(By.id(locValue))) {
					elmt = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locValue)));

				}

				break;
			case TagName:
				if (isElementPresent(By.tagName(locValue))) {
					elmt = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(locValue)));

				}

				break;
			case Name: {

				if (isElementPresent(By.name(locValue))) {
					elmt = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locValue)));

				}
			}

				break;
			case ClassName:
				if (isElementPresent(By.className(locValue))) {
					elmt = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(locValue)));

				}

				break;
			case LinkText:
				if (isElementPresent(By.linkText(locValue))) {
					elmt = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(locValue)));

				}

				break;
			case CssSelector:
				if (isElementPresent(By.cssSelector(locValue))) {
					elmt = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locValue)));
				}

				break;
			}
		} catch (NoSuchElementException ex) {
			LOGGER.info("Unable to find the element" + elmt + "Exception Description:" + ex);
			throw new Exception("Unable to find the element" + elmt);
		}
		return elmt;
	}

	public String formatDOB(String dob)
	{
		String [] dateofBirth = dob.split("/");
		 
		String date = dateofBirth[1];
       String monthname = dateofBirth[0];
       
        String year = dateofBirth[2];
        
        return (monthname+" "+date+", "+year);
		
        	
	}
	
	
	public void CalendarDateSelect(String birthDate,String pagename) throws Exception
	{
		
		/*WebElement WebElementmonth = getElement(monthWebElement);
		WebElement WebElementyear = getElement(yearWebElement);
		WebElement WebElementdate = getElement(dateWebElement);*/
		//22/JAN/2001
		String [] dateofBirth = birthDate.split("/");
		 
		String date = dateofBirth[1];
       String monthname = (StringUtils.substring(dateofBirth[0], 0, 3)).toUpperCase() ;
       
        String year = dateofBirth[2];
		
        int year_that_will_be_edited = Integer.parseInt(year);
        //2005
        
      
         Page(pagename).clickElement("CalendarClick");
        
        int presentyear  = Integer.parseInt(Page(pagename).GetElementText("CalendarYearCheck"));
           //1995
        
        
        
        while ( ! (Page(pagename).GetElementText("CalendarYearCheck").equals(year) ))
  		 {
        	if(year_that_will_be_edited>presentyear)
        	{
        		  Page(pagename).clickElement("CalendarYearNavigateForward");
        	       
        	}
        	else
        	{
          Page(pagename).clickElement("CalendarYearNavigateBackButton");
        	}
        }
        
        
        //click july month first a list of month appears
        Page(pagename).clickElement("CalendarMonthClick");
         
      String locvalmonths=  BaseVariables.getInstance().GetPageList().get(pagename).getLocatorList().get("GetAllMonthsName")
		.getLocatorValue();
        
      List<WebElement> lists =  Page(pagename).FindElements(LocatorType.XPath, locvalmonths	);
        
      
      System.out.println("-----------------List Size =" + lists.size());
        for(int i=0;i<lists.size();++i)
        {
       	 String month_name=lists.get(i).getText();
       	 if(month_name.equals(monthname))
       	 {
       		 lists.get(i).click();
       		 break;
       	 }
       	 
        }
        
        System.out.println("Fetch dates");
        
      //  GetAllDates
        List<WebElement> lists_dates =  Page(pagename).FindElements(LocatorType.XPath,BaseVariables.getInstance().GetPageList().get(pagename).getLocatorList().get("AllDates")
				.getLocatorValue());
        for(int i=0;i<lists_dates.size();++i)
        {
       	 String datevalue=lists_dates.get(i).getText();
       	 if(datevalue.equals(date))
       	 {
       		 lists_dates.get(i).click();
       		 break;
       	 }
       	 
        }
		  
	}
	
	
	public void ScrollDown() throws InterruptedException
	{
		//to perform Scroll on application using Selenium
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)", "");
		 
	}
	
	public void selectCountryCodeFromDropDown(String codetoselect,String PageName,String elementName) throws Exception
	{
	 
		LOGGER.info("Scroll and click  operation");
		// waitForPageToLoad();
		 
		Actions action = new Actions(driver);
		boolean check=false; 
		
		
		while(true)
		{
		
		List<WebElement> elements_afganistan =driver.findElements(By.xpath("//*[text()='+93']"));
	 
		String key=Keys.chord(Keys.PAGE_UP);
		action.sendKeys(key).sendKeys(key).build().perform();
		
		List<WebElement> list =driver.findElements(By.xpath("//*[text()='"+codetoselect+"']"));
		
		
		if(list.size()>0)
		{
			driver.findElement(By.xpath("//*[text()='"+codetoselect+"']")).click();
			 
			break;
		}
		
		
		if(elements_afganistan.size()==1)
		{
			check=true;
			break;
		}
		
		
		}  
		
		if(check==true)
		{
		 
			 
			while(true)
			{
			
			List<WebElement> zimbabwe =driver.findElements(By.xpath("//*[text()='+263']"));
			 
			String key=Keys.chord(Keys.PAGE_DOWN);
			action.sendKeys(key).sendKeys(key).build().perform();
			
			List<WebElement> list =driver.findElements(By.xpath("//*[text()='"+codetoselect+"']"));
			
			
			if(list.size()>0)
			{
				driver.findElement(By.xpath("//*[text()='"+codetoselect+"']")).click();
				 
				break;
			}
			
			
			if(zimbabwe.size()==1)
			{
				check=true;
				break;
			}
				
		 
		}
		
		}
		
		
		}
		
	
	
	
	public void ScrollDownAndClick(String pageName,String elementname) throws Exception
	{
		 boolean b =true;
		LOGGER.info("Scroll and click  operation");
		// waitForPageToLoad();
		 
		Actions action = new Actions(driver);
		
		 
		while(b)
		{
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
			 
			List<WebElement> list =driver.findElements(By.xpath("//*[text()='"+elementname+"']"));
			if(list.size()>0)
			{
				System.out.println("check");
				driver.findElement(By.xpath("//*[text()='"+elementname+"']")).click();
				
				break;
			}
			
			 try
			 {
				String text = driver.findElement(By.xpath("//*[text()='Athlete']")).getText();
				if(text.equals("Athlete"))
				{
					while(true)
					{
						action.sendKeys(Keys.PAGE_UP).build().perform();
						 
						List<WebElement> list2 =driver.findElements(By.xpath("//*[text()='"+elementname+"']"));
						if(list2.size()>0)
						{
							System.out.println("check");
							driver.findElement(By.xpath("//*[text()='"+elementname+"']")).click();
							b=false;
							break;
						}
						
					}
				}
			 }
			catch(Exception e)
			 {
				
			 }
			
		}
	
	
	
	}
	
	
	public void CheckElementPresent(String elmtName) throws InterruptedException
	{
	 
	/*	WebDriverWait wait = new WebDriverWait(driver,240);
	
		
		
      wait.until(ExpectedConditions.(By.xpath("//*[text()='"+elmtName+"']"))).sendKeys(Keys.ARROW_DOWN);
		
	
		
		LOGGER.info("Scroll and click  operation");
		// waitForPageToLoad();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.keyDown(Keys.ARROW_DOWN).build().perform();
		 
		*/
		
	
	}
	
	
	
	public String ExtractNumberExcluding$(String value)
	{
		return value.trim().split(" ")[1];
	}
	
	public float Convert_String_To_Float(String value)
	{
		return Float.parseFloat(value);
	}
	
	
	public List<WebElement> FindElements(LocatorType locType, String locValue) throws Exception {
		List<WebElement> elmt = null  ;
		 
		try {
			switch (locType) {
			case XPath:
				if (isElementPresent(By.xpath(locValue))) {
					elmt =  driver.findElements(By.xpath(locValue));
				}

				break;
			case ID:
				if (isElementPresent(By.id(locValue))) {
					elmt =  driver.findElements(By.id(locValue));
				}

				break;
			case TagName:
				if (isElementPresent(By.tagName(locValue))) {
					elmt =  driver.findElements(By.tagName(locValue));
				}

				break;
			case Name:
				if (isElementPresent(By.name(locValue))) {
					elmt =   driver.findElements(By.name(locValue));
				}

				break;
			case ClassName:
				if (isElementPresent(By.className(locValue))) {
					elmt = driver.findElements(By.className(locValue));
				}

				break;
			case LinkText:
				if (isElementPresent(By.linkText(locValue))) {
					elmt =   driver.findElements(By.linkText(locValue));
				}

				break;
			case CssSelector:
				if (isElementPresent(By.cssSelector(locValue))) {
					elmt =   driver.findElements(By.cssSelector(locValue));
				}

				break;
			}
		} catch (NoSuchElementException ex) {
			LOGGER.info("Unable to find the element" + elmt + "Exception Description:" + ex);
			throw new Exception("Unable to find the element" + elmt);
		}
		return elmt;
	}

	
	public void DownKeyPress() {
		try {
			LOGGER.info("Down key press operation");
			// waitForPageToLoad();
			Thread.sleep(2000);
			String key = Keys.chord(Keys.ARROW_DOWN);
			Actions action = new Actions(driver);
			action.sendKeys(key).build().perform();
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
			LOGGER.info(e.getMessage());
		}
	}
	
	
	
	
	
	
	public void TabPress() {
		try {
			LOGGER.info("TAB press operation");
			// waitForPageToLoad();
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
			LOGGER.info(e.getMessage());
		}
	}

	
	
	
	
	
	
	
	
	
	
	public void EnterPress() {
		try {
			LOGGER.info("Enter press operation");
			// waitForPageToLoad();
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
			LOGGER.info(e.getMessage());
		}
	}

	public void sendKeysToElement(String elmtName, String text) throws Exception {
		WebElement El;
		try {

			El = getElement(elmtName);
			El.sendKeys(text);
			 

		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info(
					"Error occured while entering '" + text + "' in element:" + elmtName + " .Error occured is:" + ex);
			throw new Exception("Error occured while entering '" + text + "' in element:" + elmtName);
		}
	}

	public void ClearTextWithsendKeys(String elmtName, String text, Boolean clearExistingText, String replacedBy)
			throws Exception {

		WebElement El;
		try {
			if (!replacedBy.isEmpty()) {
				El = wait.until(ExpectedConditions.elementToBeClickable(getElementDynamically(elmtName, replacedBy)));
				// El = getElementDynamically(elmtName, replacedBy);
			} else {
				El = getElement(elmtName);
			}
//          add wait here
			if (clearExistingText) {

				El.clear();
			}
			El.sendKeys(text);
			Thread.sleep(2000);
//            add wait here for page load
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info(
					"Error occured while entering '" + text + "' in element:" + elmtName + " .Error occured is:" + ex);
			throw new Exception("Error occured while entering '" + text + "' in element:" + elmtName);
		}
	}

	public Boolean NavigateToURL(String URL) throws Exception {
		Boolean IsNavigationSuccess = false;
		try {
			driver.get(URL);
			LOGGER.info("Navigating to URL:" + URL);
			driver.manage().window().maximize();
			IsNavigationSuccess = true;
		} catch (UnhandledAlertException Ex) {
			handleAlert();
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
			LOGGER.info("Navigation to URL " + URL + " failed due to " + e.getMessage());
			throw new Exception("Navigation to URL " + URL + " failed due to " + e.getMessage());
		}
		return IsNavigationSuccess;
	}

	public void scrollTo(String length) {
		try {
			JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
			javaScriptExecutor.executeAsyncScript("window.scrollBy(0," + length + ")");

		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}

	}

	public void openNewWindow() throws Exception {
		try {
			JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
			javaScriptExecutor.executeAsyncScript("window.open()");
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}

	}

	
	public void DropDownSelect(String pageName,String elmtName, String texttoselect)
	{
		 
		//WebElement El=null;
    try
    {
			String locatorvalue = BaseVariables.getInstance().GetPageList().get(PageName).getLocatorList().get(elmtName)
					.getLocatorValue();
		//	El = getElement(elmtName);
		List<WebElement> list =Page(pageName).FindElements(LocatorType.CssSelector, locatorvalue);
			
			
			
		
		for(int i=0;i<list.size();++i)
		{
			String name = list.get(i).getText();
			System.out.println(name);
			if(name.equalsIgnoreCase(texttoselect))
			{
				list.get(i).click();
				break;
			}
			
		} 
		
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
	}
		
	
	
	
	public static String UpdateLocatorWithOriginalVal(String locator, String Val) {
		String Updatedlocator = "";
		Updatedlocator = locator.replace("$Val$", Val);
		return Updatedlocator;
	}

	public WebElement getElementDynamically(String elmtName, String valuetoreplace) throws Exception {
		WebElement element = null;
		try {
			LocValue = BaseVariables.getInstance().GetPageList().get(PageName).getLocatorList().get(elmtName)
					.getLocatorValue();
			LocValue = UpdateLocatorWithOriginalVal(LocValue, valuetoreplace);
			element = FindElement(locatorTypeName(elmtName), LocValue);
		} catch (NoSuchElementException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to find the element" + elmtName + " Exception Description:" + ex);
			throw new Exception("Unable to find the element " + elmtName);
		} catch (ElementNotSelectableException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to select element: " + elmtName + " Exception Description:" + ex);
			throw new Exception("Unable to select element: " + elmtName);
		} catch (ElementNotVisibleException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Element: " + elmtName + " is not visible.Exception Description:" + ex);
			throw new Exception("Element: " + elmtName + " is not visible.");
		} catch (TimeoutException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Timeout Error while finding element: " + elmtName + "Exception Description:" + ex);
			throw new Exception("Timeout Error while finding element: " + elmtName);
		} catch (StaleElementReferenceException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Stale Element: " + elmtName + "Exception Description:" + ex);
			throw new Exception("Stale Element: " + elmtName);
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to find the element " + elmtName + "Exception Description:" + ex);
			throw new Exception("Unable to find the element " + elmtName + "Exception Description:" + ex);
		}
		return element;
	}

	/*
	 * public Set<WebElement> GetElementSetDynamically(String elmtName, String
	 * valuetoreplace) throws Exception { Set<WebElement> element = null; try { //
	 * LocValue = UpdateLocatorWithOriginalVal(LocValue,valuetoreplace); // element
	 * =
	 * FindElements(StepBase.getInstance().PageList[PageName].LocatorList[elmtName].
	 * LocatorType, LocValue); element = (Set<WebElement>)
	 * FindElement(LocatorTypeName(elmtName), LocValue); } catch
	 * (NoSuchElementException ex) { LOGGER.info("Unable to find elements:" +
	 * elmtName + " Exception Description:" + ex); throw new
	 * Exception("Unable to Find Elements: " + elmtName); } catch
	 * (ElementNotSelectableException ex) {
	 * LOGGER.info("Unable to select elements: " + elmtName +
	 * " Exception Description:" + ex); throw new
	 * Exception("Unable to select elements: " + elmtName); } catch
	 * (ElementNotVisibleException ex) { LOGGER.info("Element: " + elmtName +
	 * " is not visible.Exception Description:" + ex); throw new
	 * Exception("Element: " + elmtName + " is not visible."); } catch
	 * (TimeoutException ex) { LOGGER.info("Timeout Error while finding element: " +
	 * elmtName + "Exception Description:" + ex); throw new
	 * Exception("Timeout Error while finding element: " + elmtName); } catch
	 * (StaleElementReferenceException ex) { LOGGER.info("Stale Element: " +
	 * elmtName + "Exception Description:" + ex); throw new
	 * Exception("Stale Element: " + elmtName); } catch (Exception ex) {
	 * LOGGER.info("Unable to find the element " + elmtName +
	 * "Exception Description:" + ex); throw new
	 * Exception("Unable to find the element " + elmtName + "Exception Description:"
	 * + ex); } return (Set<WebElement>) element; }
	 * 
	  public void WaitForPageToLoad()throws Exception { wait = new
	 * WebDriverWait(driver, 10); TimeSpan timeout = new TimeSpan(0, 0, 30);
	 * 
	 * JavascriptExecutor javascript = (JavascriptExecutor)driver; if (javascript ==
	 * null) throw new ArgumentException("driver",
	 * "Driver must support javascript execution");
	 * 
	 * wait.Until((d) => { try { String readyState = javascript.ExecuteScript(
	 * "if (document.readyState) return document.readyState;").toString(); return
	 * readyState.toLowerCase() == "complete"; } catch (InvalidOperationException e)
	 * { //Window is no longer available return
	 * e.Message.ToLower().Contains("unable to get browser"); } catch
	 * (WebDriverException e) { //Browser is no longer available return
	 * e.Message.ToLower().Contains("unable to connect"); } catch (Exception) {
	 * return false; } }); }
	 */
	private Boolean isElementPresent(By by) {
		try {
			
			  
			 
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return element.isDisplayed();
		} catch (Exception e) {
			
			return false;
		}
	}
	
	public Boolean isElementPresent(String elmtName) {
		try {
			
			  
			 LocValue = BaseVariables.getInstance().GetPageList().get(PageName).getLocatorList().get(elmtName)
						.getLocatorValue();
			 By by = By.xpath(LocValue);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return element.isDisplayed();
		} catch (Exception e) {
			
			return false;
		}
	}

	public void selectElementByText(String elmtName, String val) throws Exception {
		try {
			WebElement elm = getElement(elmtName);
			Select se = new Select(elm);
			se.selectByVisibleText(val);
		} catch (NoSuchElementException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to find the element" + elmtName + ". Exception occured is:" + ex.getMessage());
			throw new Exception("Unable to find the element " + elmtName + ".");
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to find the element" + elmtName + ". Exception occured is:" + ex.getMessage());
			throw new Exception("Unable to find the element " + elmtName + ".");
		}
	}

	public void selectElementByIndex(String elmtName, int val) throws Exception {
		try

		{
			// WebElement elm =
			// wait.until(ExpectedConditions.elementToBeSelected(getElement(elmtName)));
			WebElement elm = getElement(elmtName);
			Select se = new Select(elm);
			se.selectByIndex(val);
		} catch (NoSuchElementException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to find the element" + elmtName + ". Exception occured is:" + ex.getMessage());
			throw new Exception("Unable to find the element " + elmtName + ".");
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to find the element" + elmtName + ". Exception occured is:" + ex.getMessage());
			throw new Exception("Unable to find the element " + elmtName + ".");
		}
	}

	public void switchToNewWindow() {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			driver.switchTo().window(handle);
		}
	}

	
	//check page loaded
	
	public  void waitForPageLoad() {
	do {
		WebDriver driver = BaseVariables.getInstance().getWebdriver();
	js_ = (JavascriptExecutor) driver;
	pageLoadStatus = (String)js_.executeScript("return document.readyState");
	} while ( !pageLoadStatus.equals("complete") );
	System.out.println("Page Loaded.");
	}
	
	
	
	
	public Boolean SwitchToFrame(String framename) {// currently works with Frame xpath
		Boolean IsSwitched = false;
		try {
			// wait = Browser.wait;
			WebElement el = getElement(framename);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(el));

			IsSwitched = true;
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to switch frame" + ex.getMessage());
		}
		return IsSwitched;
	}

	public Boolean SwitchToFrame(int frameIndex) throws Exception {
		Boolean IsSwitched = false;
		try {
			// wait = Browser.wait;
			driver.switchTo().frame(frameIndex);
			IsSwitched = true;
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to switch frame" + ex.getMessage());
		}
		return IsSwitched;
	}

	public void switchToDefaultFrame() throws Exception {
		try {
			// wait = Browser.wait;
			driver.switchTo().defaultContent();
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to switch to the parent frame" + ex.getMessage());
		}
	}

	public Boolean verifyTitle(String ExpTitle) {
		Boolean titleMatched = false;
		try {

			if (driver.getTitle().contains(ExpTitle)) {
				titleMatched = true;
			}

			Assert.assertTrue(titleMatched);

		} catch (Exception ex) {
			AssertUtils.getInstance().Fail("Unable to verify title: Exception" + ex.getMessage());
		}
		return titleMatched;
	}

	public Boolean checkElementVisibility(String ElmName) throws Exception {
		Boolean IsVisible = false;
		try {
			WebElement elm = getElement(ElmName);
			IsVisible = elm.isDisplayed();
		} catch (ElementNotVisibleException ex) {
			
			IsVisible = false;
		}
		catch(Exception e)
		{
			IsVisible = false;
		}

		return IsVisible;
	}

	
	public static void globalvariableSet(String val)
	{
		variableval=val;
	}
	
	public static String globalvariableGet()
	{
		 return variableval;
	}
	
	
	
	public Boolean checkElementEnabled(String ElmName) throws Exception {
		Boolean Enabled = false;
		try {
			WebElement elm = getElement(ElmName);
			Enabled = elm.isEnabled();
		} catch (ElementNotVisibleException ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			Enabled = false;
		}

		return Enabled;
	}

	public WebElement focusElement(String element) throws Exception {
		WebElement elmtName = null;
		try {
			elmtName = getElement(element);
			Actions actions = new Actions(driver);
			actions.moveToElement(elmtName);
			actions.perform();
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}

		return elmtName;
	}

	public WebElement focusElementAndClick(String element) throws Exception {
		WebElement elmtName = null;
		try {
			elmtName = getElement(element);
			Actions actions = new Actions(driver);
			actions.moveToElement(elmtName).click();
			actions.perform();
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}

		return elmtName;
	}

	public WebElement doubleClickElement(String element) throws Exception {
		WebElement elmtName = null;
		try {
			elmtName = getElement(element);
			Actions actions = new Actions(driver);
			actions.doubleClick(elmtName);
			actions.perform();
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}

		return elmtName;
	}

	
	
	public void TypeInField(String elementName, String value) throws InterruptedException{
	    String val = value; 
	    WebElement element = null;
		try {
			element = getElement(elementName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    element.click();

	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s =  Character.toString(c);
	        element.sendKeys(s);
	        Thread.sleep(200);
	       
	    }       
	}
	
	
	public void ValidationMethod(String expected,String actual)
	{
		Assert.assertEquals(expected, actual);
	}
	
	
	public void checkImagePresence(String elementName,String imagename) throws Exception
	{
      WebElement ImageFile = getElement(elementName);
        
      WebElement ele=null;
       
       try
       {
       System.out.println("k");
      ele  = driver.findElement(By.xpath("(//div[contains(@style,'"+imagename.toLowerCase()+"')])[2]"));
      
       }
        		
        
       catch(Exception e)
       {
    	   System.out.println("Image not attached");
    	   e.printStackTrace();
       }
        
        		/*  Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        if (!ImagePresent)
        {
        	 Assert.fail("Image not displayed.");
        }
        else
        {
            System.out.println("Image displayed.");
        }*/
	}
	
		
	
	public WebElement tripleClickElement(String element) throws Exception {
		WebElement elmtName = null;
		try {
			elmtName = getElement(element);
			Actions actions = new Actions(driver);
			actions.moveToElement(elmtName).doubleClick().click().perform();
			actions.perform();
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}

		return elmtName;
	}

	public WebElement TextboxSelectAll(String element) throws Exception {
		WebElement elmtName = null;
		try {
			elmtName = getElement(element);
			String keys = Keys.chord(Keys.CONTROL+"A"); 
			elmtName.sendKeys(keys);
			
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}

		return elmtName;
	}

	
	
	public WebElement RightClick(String element) throws Exception {
		WebElement elmtName = getElement(element);
		try {
			Actions action = new Actions(driver);
		 
			action.moveToElement(elmtName).contextClick().build().perform(); 
			
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}

		return elmtName;
	}

	public WebElement menuclick_selectAll() throws Exception {
		WebElement elmtName = null;
		try {
		 
			  Robot robot = new Robot();
		       
			  for(int i=1;i<=5;++i)
			  {
		       robot.keyPress(KeyEvent.VK_DOWN);	
		       robot.keyRelease(KeyEvent.VK_DOWN);
		       Thread.sleep(1000);
			  }
			
			  robot.keyPress(KeyEvent.VK_ENTER);	
		       robot.keyRelease(KeyEvent.VK_ENTER);	
			  
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}

		return elmtName;
	}

	
	
	public float calculate_PaymentPlanSchedule_Amounts(String pagename,String locvalue) throws Exception
	{
		float total_sum=0;
		String locator_amounts=  BaseVariables.getInstance().GetPageList().get(pagename).getLocatorList().get(locvalue)
				.getLocatorValue();
		WebDriver driver = BaseVariables.getInstance().getWebdriver();
		List<WebElement> lists= Page(pagename).FindElements(LocatorType.XPath, locator_amounts	);
		 
		for(int i=0;i<lists.size();++i)
		{
		  //System.out.println(lists.get(i).getText());
			String amount=lists.get(i).getText();
		   total_sum = total_sum +  Float.parseFloat(amount.trim().split(" ")[1]);
		}
	     return total_sum;
	}
	
	
	
		
		 
		 
		 
		 
	 
	
	
	
	
	
	
	
	public WebElement BackspacePressUntilTextBoxClear(String element) throws Exception {
		WebElement elmtName = null;
		try {
			
			while(true)
			{
			elmtName = getElement(element);
			String keys = Keys.chord(Keys.BACK_SPACE); 
			elmtName.sendKeys(keys);
			 
			if(elmtName.getAttribute("value").equals(""))
			{
				break;
			}
			
			}
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}

		return elmtName;
	}

	
	
	
	
	
	
	
	public WebElement scrollElementToCenterView(String elmtName) throws Exception {
		WebElement element = null;
		try {
			element = getElement(elmtName);
			JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
			javaScriptExecutor.executeAsyncScript("arguments[0].scrollIntoView({block: 'center'});", element);
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}

		return element;
	}

	public WebElement scrollToElement(String elmtName) throws Exception {
		WebElement element = null;
		try {
			element = getElement(elmtName);
			JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
			javaScriptExecutor.executeAsyncScript("arguments[0].scrollIntoView(false);", element);
		} catch (Exception e) {
			AssertUtils.getInstance().Fail(e.getMessage());
		}

		return element;
	}

	public void RefreshBrowser() {
		driver.navigate().refresh();
	}

	public Boolean handleAlert() throws Exception {
		Boolean IsHandled = false;
		try {
			Alert myAlert = driver.switchTo().alert();
			myAlert.accept();
			IsHandled = true;
		} catch (Exception ex) {
			AssertUtils.getInstance().Fail(ex.getMessage());
			LOGGER.info("Unable to handle the alert");
		}
		return IsHandled;
	}

	public Boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			AssertUtils.getInstance().Fail(Ex.getMessage());
			return false;
		}
	}

	public Boolean VerifyPageUrl(String URL) {
		return driver.getCurrentUrl().contains(URL);

	}

	public void validateProfilePage(String[] data,String elmtName) throws InterruptedException {
		 
		SoftAssert sa = new SoftAssert();
		  
		 LocValue = BaseVariables.getInstance().GetPageList().get(PageName).getLocatorList().get(elmtName)
					.getLocatorValue();
		 
		List<WebElement> el =driver.findElements(By.xpath(LocValue));
		
	//	gender,educationlevel,occupation,email, (countrycode+mobilephone) ,(countrycode+homephone),(countrycode+workphone) 
		int k=0;
		for(int i=2;i<el.size()-2;++i)
		{
			if(i==6)
             continue;
			
			String elementtext=el.get(i).getText();
			
			String data_profile = data[k];
			++k;
			sa.assertEquals(data_profile,elementtext );
			
			
		}
			
		sa.assertAll();	
			
			
		
	}

}
