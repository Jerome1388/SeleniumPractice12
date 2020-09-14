package selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BookCarwaleTC 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		 ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.carwale.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("1. Browser Launched Successfully !!!");
		
		//Click on UsedCars
		Actions act = new Actions(driver);
		WebElement usedCar = driver.findElementByXPath("(//span[@class='margin-right5 top-nav-label-text'])[2]");
		act.moveToElement(usedCar).pause(2000).perform();
		
		WebElement submenu = driver.findElementByXPath("//*[@id=\"cw-top-navbar\"]/li[2]/div[2]/div/div[1]/div[1]/ul/li[1]/a");
		System.out.println(submenu.isDisplayed());
		submenu.click();
		WebElement query = driver.findElementById("placesQuery");
		query.sendKeys("Chennai");
		query.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		System.out.println("2. Clicked on used cars and Selected the City as Chennai !!!");
		
		
		
		//Select budget min (8L) and max(12L) and Click Search
		
		driver.findElementByXPath("//div[@class='used-budget-box']").click();
		Thread.sleep(2000);
		driver.findElementById("minInput").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//ul[@id='minPriceList']//li[6]").click();
		Thread.sleep(1000);
		driver.findElementByXPath("maxInput").click();
		driver.findElementByXPath("//ul[@id='maxPriceList']//li[6]").click();
		System.out.println("3. Budget has been selected !!!!");
		
		//Select Cars with Photos under Only Show Cars With
		driver.findElementByXPath("(//ul)[21]//li[1]").click();
		
		
		//Select Manufacturer as "Hyundai" --> Creta
		driver.findElementByXPath("//div[@class='custom-search-box position-rel']").sendKeys("Hyundai");
		driver.findElementByXPath("(//li[@class='us-sprite makeLi'])[18]").click();
		
		
		
		
		
			
		
	}

}
