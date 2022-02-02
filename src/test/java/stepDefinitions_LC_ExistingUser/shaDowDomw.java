package stepDefinitions_LC_ExistingUser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class shaDowDomw   {

	
	public static WebElement getShadowDom(WebElement element_root,WebDriver driver)
	{
		return element_root;
		/*JavascriptExecutor js =  (JavascriptExecutor)driver;
		WebElement shadowDom1=  (WebElement) js.executeScript("return arguments[0].shadowRoot", element_root);
		return shadowDom1;*/
	}
	
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.d3jxrb105lf5ve.amplifyapp.com/start-enrollment?category=HCTP");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement label=(WebElement) js.executeScript("return document.querySelector('d2l-sequence-viewer').shadowRoot.querySelector('#view-container> #viewframe > d2l-sequences-content-router').shadowRoot.querySelector('d2l-sequences-content-module').shadowRoot.querySelector('div>h1>d2l-sequences-module-name')");
       String t =label.getText();
       System.out.println(t);
/*WebElement root = driver.findElement(By.tagName("shop-app"));
		WebElement shadowdom_1=shaDowDomw.getShadowDom(root, driver);
		 WebElement iron_pages=shadowdom_1.findElement(By.tagName("iron-pages"));
		WebElement shophomeroot= iron_pages.findElement(By.name("home"));
		WebElement shadowDom2= shaDowDomw.getShadowDom(shophomeroot, driver);
		shadowDom2.findElement(By.cssSelector("div:nth-child(2)>shop-button>a")).click();*/
		
	}
	
	
	
}
