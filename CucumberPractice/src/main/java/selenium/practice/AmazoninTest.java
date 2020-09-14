package selenium.practice;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazoninTest 
{
	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		//1. Launch URL
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,40);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println("1. URL Launced Successfully");
		
		//2. Enter 'outslayer' in the searchbox and Pick the first resulting item
		
		driver.findElementById("twotabsearchtextbox").sendKeys("outslayer");
		//WebElement suggestion = driver.findElementByXPath("//div[@id='suggestions']/div[1]");
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='suggestions']/div[1]"))).click();
				
				
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		System.out.println("2. Seleceted the Search List");
		
		//3. Get all the resulting item prices in the page and print it by sorting it(use list)
		
		List<WebElement> prodprice = driver.findElementsByXPath("//span[@class='a-price-whole']");
		List<Integer> pricelis = new ArrayList<Integer>();
		for (WebElement ele : prodprice) 
		{
			String listprice = ele.getText();
			System.out.println(listprice);
			String replced = listprice.replaceAll("[^0-9]", " ");
			try {
				int prices= Integer.parseInt(replced);//list.add(Integer.parseInt(text));
				pricelis.add(prices);
			}
			catch(NumberFormatException e)
			{
			
			}
			
			
		}
		System.out.println("After adding all the prices to the list");
		System.out.println(pricelis);
		
		Collections.sort(pricelis);
		
		System.out.println("Sorted Price0"+ pricelis);
		
		System.out.println("3. All the price has listed");
		
		//4. Click on the item that has the highest price
		
		
		
		
	
		
		
	 
		
		
		
		
	
		
		
		
		
		
		
	}

}
