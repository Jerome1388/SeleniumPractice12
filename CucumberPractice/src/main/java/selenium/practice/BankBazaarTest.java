package selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BankBazaarTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		
		driver.get("https://www.bankbazaar.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		WebElement loan = driver.findElementByLinkText("LOANS");
		Actions act = new Actions(driver);
		act.moveToElement(loan).pause(2000).build().perform();
		driver.findElementByXPath("(//a[text()='Personal Loan'])[1]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//label[@class='labelContainer'])[1]").click();
		List<WebElement> company = driver.findElementsByXPath("(//input[@class='Select-input'])[1]");
		for (WebElement ele : company) 
		{
			if(ele.getText().trim().equals("Bankbazaar.com"))
			{
				ele.click();
			}
			
		}
	
		
		driver.findElementByLinkText("Continue").click();
		
	}
}
