package interview;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FillTheForm 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://srdjan.github.io/react-multistep/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElementByXPath("(//div[@class='six columns'])[1]//input").sendKeys("Jerome");
		driver.findElementByXPath("(//div[@class='six columns'])[2]//input").sendKeys("Jerry");
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='container'])[2]//button[2]").click();
		System.out.println("Step 1 has been filled ");
		
		
		driver.findElementByXPath("(//div[@class='row'])[1]//input").sendKeys("jerry@testmail.com");
		driver.findElementByXPath("(//div[@class='row'])[2]//input").sendKeys("jerry@testmail.com");
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='container'])[2]//button[2]").click();
		System.out.println("Step 2 has been filled");
		
		WebElement pwd = driver.findElementByXPath("(//div[@class='six columns'])[1]//input");
		pwd.clear();
		pwd.sendKeys("Test@123");
		driver.findElementByXPath("(//div[@class='six columns'])[2]//input").sendKeys("Test@123");
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='container'])[2]//button[2]").click();
		System.out.println("Step 3 has been filled");
		
		driver.findElementByXPath("//div[@class='ten columns terms']//input").click();
		
		System.out.println("Step 4 has been filled");
		
	}

}
