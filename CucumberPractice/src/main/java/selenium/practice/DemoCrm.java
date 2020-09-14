package selenium.practice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DemoCrm 
{
	public static void main(String[] args) throws InterruptedException,  IOException
	{
		//1) Go to https://demo.1crmcloud.com/
		//--------------------------------------------
		
		System.setProperty("webdriver.chrome.driver", "");
		/*ChromeOptions options  = new ChromeOptions();
	    
	    options.addArguments("--disable-popup-blocking");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);*/
	   // ChromeDriver  driver = new ChromeDriver(capabilities);
		
		ChromeDriver driver = new ChromeDriver();
		
		
		driver.get("https://demo.1crmcloud.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//2) Give username as admin and password as admin
		//-----------------------------------------------
		
		driver.findElementById("login_user").sendKeys("admin");
		
		driver.findElementById("login_pass").sendKeys("admin");
		
		//3) Choose theme as Claro Theme
		//------------------------------
		
		WebElement ele_ThemeDropdown = driver.findElementById("login_theme");
		
		Select slt_ThemeDropdown = new Select(ele_ThemeDropdown);
		
		slt_ThemeDropdown.selectByVisibleText("Claro Theme");
		
		driver.findElementById("login_button").click();
		
		//4) Click on Sales and Marketting 
		//----------------------------------
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[text()='Sales & Marketing']")));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElementByXPath("//div[text()='Sales & Marketing']")).click().build().perform();
		
		//5) Click Create contact
		//---------------------
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[text()='Create Contact']")));
		
		driver.findElementByXPath("//div[text()='Create Contact']").click();
		
		System.out.println("DONE ---> 5) Click Create contact");
		
		//6) Select Title and type First name, Last Name, Email and Phone Numbers
		//---------------------------------------------------------------------
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("DetailFormtitle-input")));
		
		driver.findElementById("DetailFormtitle-input").sendKeys("MR");
		
		Thread.sleep(500);
		
		driver.findElementById("DetailFormfirst_name-input").sendKeys("Sachin");
		Thread.sleep(500);
		
		driver.findElementById("DetailFormlast_name-input").sendKeys("Tendulkar");
		Thread.sleep(500);
		
		driver.findElementById("DetailFormemail1-input").sendKeys("Sachin@MRF.com");
		Thread.sleep(500);
		
		driver.findElementById("DetailFormphone_work-input").sendKeys("6789909876");
		
		
		//7) Select Lead Source as "Public Relations"
		//-----------------------------------------
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElementById("DetailFormlead_source-input"));
		
		Thread.sleep(2000);
		
		action.moveToElement(driver.findElementById("DetailFormlead_source-input")).click().build().perform();
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("DetailFormlead_source-input-popup")));
		
		Thread.sleep(2000);
		
		action.moveToElement(driver.findElementByXPath("//div[contains(@class,'option-cell input-label') and text()='Public Relations']")).click().build().perform();
		
		System.out.println("Public relations selected");
		
		
		
		//8) Select Business Roles as "Sales"
		//-----------------------------------
				
		action.moveToElement(driver.findElementById("DetailFormbusiness_role-input")).click().build().perform();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("DetailFormbusiness_role-input-popup")));
		
		action.moveToElement(driver.findElementByXPath("//div[contains(@class,'option-cell input-label') and text()='Sales']")).click().build().perform();
		
		System.out.println("Sales selected");
		
		
		//9) Fill the Primary Address, City, State, Country and Postal Code and click Save
		//--------------------------------------------------------------------------------
		
		driver.findElementById("DetailFormprimary_address_street-input").sendKeys("12, Krishnapuram  2nd asdfasd");
		Thread.sleep(500);
		
		driver.findElementById("DetailFormprimary_address_city-input").sendKeys("Chennai");
		Thread.sleep(500);
		
		driver.findElementById("DetailFormprimary_address_state-input").sendKeys("Tamil nadu");
		Thread.sleep(500);
		
		driver.findElementById("DetailFormprimary_address_country-input").sendKeys("India");
		Thread.sleep(500);
		
		driver.findElementById("DetailFormprimary_address_postalcode-input").sendKeys("625009");
		Thread.sleep(500);
		
		driver.findElementById("DetailForm_save2").click();
		Thread.sleep(500);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("DONE ---> 9) Fill the Primary Address, City, State, Country and Postal Code and click Save");
		
		//10) Mouse over on Today's Activities and click Meetings
		//-------------------------------------------------------
		
		Thread.sleep(2000);
		
		action.moveToElement(driver.findElementByXPath("//li[@id='grouptab-0']//div[contains(text(),'Today')]")).build().perform();
		
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[contains(@class,'option-cell input-label') and text()='Meetings']")));
		
		Thread.sleep(1000);
		
		action.moveToElement(driver.findElementByXPath("//div[contains(@class,'option-cell input-label') and text()='Meetings']")).click().build().perform();
		
		System.out.println("DONE ---> 10) Mouse over on Today's Activities and click Meetings");
		
		//11) Click Create 
		//---------------
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//span[@class='input-label' and text()='Create']/parent::button[@name='SubPanel_create']")));
		
		
		action.moveToElement(driver.findElementByXPath("//span[@class='input-label' and text()='Create']")).click().build().perform();
		
		
		//12) Type Subject as "Project Status" , Status as "Planned"
		//-----------------------------------------------------------
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("DetailFormname-input")));
		
		Thread.sleep(2000);
		
		driver.findElementById("DetailFormname-input").sendKeys("Project Status");
		
		Thread.sleep(2000);
		
		driver.findElementById("DetailFormstatus-input").click();
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("DetailFormstatus-input-popup")));
		
		action.moveToElement(driver.findElementByXPath("//div[contains(@class,'option-cell input-label') and text()='Planned']")).click().build().perform();
		
		Thread.sleep(2000);
		
		//13) Start Date & Time as tomorrow 3 pm and Duration as 1hr
		//----------------------------------------------------------
		
		driver.findElementByXPath("//div[@class='input-label datetime-label text-number']").click();
		
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='active-icon uii-time uii-lg uii']")));
		
		Thread.sleep(2000);
		
		Calendar calendar = Calendar.getInstance();
	    
	    Date today = calendar.getTime();
	    System.out.println("today:    " + today);
	 
	    // add one day to the date/calendar
	    calendar.add(Calendar.DATE, 1);
	    
	    // now get "tomorrow"
	    Date tomorrow = calendar.getTime();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String formattedDate = formatter.format(tomorrow);
		
		driver.findElementByXPath("//div[@id='DetailFormdate_start-calendar-text']//input[@class='input-text']").sendKeys(formattedDate);
		
		Thread.sleep(1000);
		
		driver.findElementByXPath("//div[@class='popup-search tools-row']//div[@class='active-icon uii-time uii-lg uii']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//div[@id='DetailFormdate_start-calendar-text']//input[@class='input-text']").clear();
		driver.findElementByXPath("//div[@id='DetailFormdate_start-calendar-text']//input[@class='input-text']").sendKeys("15:00",Keys.ENTER);
	        
        Thread.sleep(2000);
        
        wait.until(ExpectedConditions.visibilityOf(driver.findElementById("DetailFormduration-time")));
        
        driver.findElementById("DetailFormduration-time").clear();
        
        driver.findElementById("DetailFormduration-time").sendKeys("1",Keys.TAB);
        Thread.sleep(1000);
        
        //14) Click Add paricipants, add your created Contact name and click Save
        //------------------------------------------------------------------------
        
        driver.findElementByXPath("//span[@class='input-label' and contains(text(),'Add Participants')]").click();
        Thread.sleep(2000);
        
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@id='app-search-text']//input")));
        
        driver.findElementByXPath("//div[@id='app-search-text']//input").sendKeys("Sachin tendulkar");
        
        Thread.sleep(2000);
        
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@id='app-search-list']//div[text()='Sachin Tendulkar']")));
        
        driver.findElementByXPath("//div[@id='app-search-list']//div[text()='Sachin Tendulkar']").click();
        
        Thread.sleep(2000);
       
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='scheduler-hours col-space-sm row']//span[text()='Sachin Tendulkar']")));
        
        driver.findElementById("DetailForm_save2-label").click();
        
        //15) Go to Sales and Marketting-->Contacts
        //--------------------------------------------
        
        Thread.sleep(2000);
        
        action.moveToElement(driver.findElementByXPath("//div[text()='Sales & Marketing']")).build().perform();
        
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[contains(@class,'option-cell input-label') and text()='Contacts']")));
		
		action.moveToElement(driver.findElementByXPath("//div[contains(@class,'option-cell input-label') and text()='Contacts']")).click().build().perform();
		
		Thread.sleep(2000);
		
		//16) search the lead Name and click the name from the result
		//-----------------------------------------------------------
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("filter_text")));
		
		driver.findElementById("filter_text").sendKeys("Sachin Tendulkar",Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//tr[@class='listViewRow oddListRowS1']//a[text()='Sachin Tendulkar']")));
		
		//17) Check weather the Meeting is assigned to the contact under Activities Section.
		//---------------------------------------------------------------------------------
		
		if(driver.findElementByXPath("//tr[@class='listViewRow oddListRowS1']//a[text()='Sachin Tendulkar']").isDisplayed())
		{
			driver.findElementByXPath("//tr[@class='listViewRow oddListRowS1']//a[text()='Sachin Tendulkar']").click();
			
			Thread.sleep(2000);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//tr[@data-id='0']")));
		
		System.out.println("DONE ---> 17) Check weather the Meeting is assigned to the contact under Activities Section.");
		
		
		System.out.println("Meeting is assigned to the contact under Activities Section.");
		
		driver.close();
		

		
	}
}


