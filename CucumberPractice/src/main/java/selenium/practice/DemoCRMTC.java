package selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoCRMTC 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "");
		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,30);
		Actions act = new Actions(driver);
		driver.manage().window().maximize();
		
		// Launch URL
		driver.get("https://demo.1crmcloud.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Give username as admin and password as admin
		
		driver.findElementById("login_user").sendKeys("admin");
		driver.findElementById("login_pass").sendKeys("admin");
		
		//Choose theme as Claro Theme
		WebElement loginTheme = driver.findElementById("login_theme");
 
		Select theme = new Select(loginTheme);
		theme.selectByVisibleText("Claro Theme");
		driver.findElementById("login_button").click();
		System.out.println("1. Logged in to the CRM");
		
		//Click on Sales and Marketting ,,, Click Create contact
		
		//driver.findElementByLinkText("Sales & Marketing").click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[text()='Sales & Marketing']")));
		act.moveToElement(driver.findElementByXPath("//div[text()='Sales & Marketing']")).click().build().perform();
		
		System.out.println("2. Navigate to Sales and Marketing Menu");
	   
	    wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[text()='Create Contact']")));
	    driver.findElementByXPath("//div[text()='Create Contact']").click();
	    
	    System.out.println("3. Clicked Create Contact");
		
		//Select Title and type First name, Last Name, Email and Phone Numbers, 
		//Select Lead Source as "Public Relations",
		//Select Business Roles as "Sales"
		// Fill the Primary Address, City, State, Country and Postal Code 
		// click Save
		
		List<WebElement> sal = driver.findElementsById("DetailFormsalutation-input-label");
		//.sendKeys("Mr.");
		
		for (WebElement opt : sal) 
		{
			if(opt.getText().trim().equals("Mr."))
				opt.click();
			
		}
		driver.findElementById("DetailFormfirst_name-input").sendKeys("Jerry");
		driver.findElementById("DetailFormlast_name-input").sendKeys("Jerome");
		driver.findElementById("DetailFormemail1-input").sendKeys("test@test.com");
		driver.findElementById("DetailFormphone_work-input").sendKeys("04456789090");
		driver.findElementById("DetailFormphone_home-input").sendKeys("0442550056");
		driver.findElementById("DetailFormphone_mobile-input").sendKeys("9876543210");
		
		List<WebElement> leadsource = driver.findElementsById("DetailFormlead_source-input");
		for(WebElement options: leadsource) 
		{
			if(options.getText().trim().equals("Public Relations"))
				options.click();
		}
		List<WebElement> role = driver.findElementsById("DetailFormbusiness_role-input-label");
		for (WebElement br : role) 
		{
			if(br.getText().trim().equals("Sales"))
				br.click();
			
		}
		driver.findElementById("DetailFormprimary_address_street-input").sendKeys("No: 123, GeorgeTown, Warwick, London -123456");
		driver.findElementById("DetailFormalt_address_city-input").sendKeys("London");
		driver.findElementById("DetailFormalt_address_postalcode-input").sendKeys("12345678");
		driver.findElementById("DetailForm_save2-label").click();
		
		System.out.println("4. Details Enterd and stored");
		
		//Mouse over on Today's Activities and click Meetings
		
		act.moveToElement(driver.findElementByXPath("(//li[@class='menubar-item'])[1]//div")).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[contains(@class,'option-cell input-label') and text()='Meetings']\"")));
		driver.findElementByXPath("//div[contains(@class,'option-cell input-label') and text()='Meetings']").click();
		
		//Click Create Meeting
		
		driver.findElementById("listView-73ce-create-label").click();
		driver.findElementById("DetailFormname-input").sendKeys("Project Status");
		List<WebElement> status = driver.findElementsById("DetailFormstatus-input");
		for (WebElement statuscode : status) 
		{
			if(statuscode.getText().trim().equals("Planned"))
			{
				statuscode.click();
			}
			
		}
		
		
		driver.findElementByXPath("input-label datetime-label text-number").click();
		
		
		
		
		
		
		
		
	}

}
