package selenium.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HondaTestcase 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		
		Actions act = new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://www.honda2wheelersindia.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.findElementByXPath("//div[@class='modal-body']//button").click();
		
		System.out.println("1. URL Launched Successfully");
		
		driver.findElementByLinkText("Scooter").click();
		driver.findElementByXPath("(//div[@class='owl-wrapper'])[2]//div[1]//div").click();
		
		System.out.println("2. Naviagted to Dio");
		
		driver.findElementByXPath("//div[@id='accordion-1']//li[4]").click();
		Thread.sleep(2000);
		WebElement engine = driver.findElementByXPath("//div[@class='specifications-box text-center']//li[2]//a");
		act.moveToElement(engine).pause(2000).build().perform();
		
		System.out.println("3. Navigated to Specifications and Engine");
		
		String displace = driver.findElementByXPath("//div[@class='engine part-2 axx']//li[3]//span[2]").getText();
		System.out.println("Dio Displacement Value   :"+displace);
		
		System.out.println("4. Dispalyed Dio Displacement Value");
		Thread.sleep(2000);
		
		driver.findElementByLinkText("Scooter").click();
		driver.findElementByXPath("(//div[@class='owl-wrapper'])[2]//div[3]//div").click(); 
		
		System.out.println("5. Navigated to ACtiva125");
		
		
		driver.findElementByXPath("//div[@id='accordion-1']//li[4]").click();
		Thread.sleep(2000);
		WebElement actieng = driver.findElementByXPath("//div[@class='specifications-box col-md-4 col-sm-4 wow bounceInLeft']//li[4]//a");
		act.moveToElement(actieng).pause(2000).build().perform();
		
		System.out.println("6. Navigated to Aciva 125 Engine Details");
		
		String activeDis = driver.findElementByXPath("//div[@class='engine part-4 axx']//li[3]").getText();
		System.out.println("Activa125 Displacement Value : "+activeDis);
		System.out.println("7. Activa125 Dispalced Value");
		
		if(displace.equals(activeDis))
		{
			System.out.println(" Dio is Best ");
		}
		else
		{
			System.out.println(" Activa 125 is Best");
		}
		
		System.out.println("8. Compared Displacement ");
		
		driver.findElementByLinkText("FAQ").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='force-overflow'])[2]//a[11]").click();
		
		System.out.println("9. Clicked FAQ and Clicked ActivaBS-IV");
		
		driver.findElementByXPath("//div[@class='col-md-3']//li[6]").click();
		driver.findElementById("submit6").click();
		
		System.out.println("10. Select the vechile Pice and submit the same");
		
		
		driver.findElementByXPath("//table[@id='tblPriceMasterFilters']//tbody//td[3]//a").click();
		Set<String> window = driver.getWindowHandles();
		List<String> winlis = new ArrayList<String>(window);
		driver.switchTo().window(winlis.get(1));
		
		System.out.println("11. Clicked the Priclink and Navigated to new window");
		
		WebElement state = driver.findElementById("StateID");
		Select sel = new Select(state);
		sel.selectByVisibleText("Tamil Nadu");
		Thread.sleep(2000);
		
	
		WebElement city = driver.findElementById("CityID");
		Select selcity = new Select(city);
		selcity.selectByVisibleText("Chennai");
		
		driver.findElementByXPath("(//div[@class='col-md-4'])[3]//button[1]").click();
		
		System.out.println("12. Selected the State and City");
		
		/* WebElement price = driver.findElementByXPath("//div[@class='datashow-responsivediv']");
		
		 List<WebElement> rows = price.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++) 
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			cols.get(2);
			
			
		} */
		
		List<WebElement> model = driver.findElementsByXPath("//div[@class='datashow-responsivediv']//tr//td[2]");
		for (WebElement ele : model) 
		{
			String vechicle = ele.getText();
			System.out.println("Model :"+ vechicle);
		
			
		}
		
		List<WebElement> price = driver.findElementsByXPath("//div[@class='datashow-responsivediv']//tr//td[3]");
		for (WebElement prices : price) 
		{
			String prcval = prices.getText();
			System.out.println("Price :"+prcval);
			
		}
		
		driver.quit();
		
		
		
		
		
		
		
		
	}

}
