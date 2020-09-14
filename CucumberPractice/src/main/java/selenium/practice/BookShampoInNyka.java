package selenium.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.JScrollBar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookShampoInNyka 
{
	
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch the browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notification");
		ChromeDriver driver = new ChromeDriver(opt);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//Mouseover on Brands and Mouseover on Popular
		
		
		Actions act = new Actions(driver);
		WebElement brands = driver.findElementByXPath("//div[@class='menuContainer_main']//div[1]//ul[1]//li[2]//a");
		act.moveToElement(brands).pause(2000).perform();
		WebElement popular = driver.findElementByXPath("//div[@class='BrandsCategoryHeading']/a[1]");
		act.moveToElement(popular).pause(2000).perform();
		
		//Click L'Oreal Paris
		
		driver.findElementByXPath("//div[@class='Brand-Content']//ul/li[5]//a//img").click();
		
		//Go to the newly opened window and check the title contains L'Oreal Paris
		Set<String> brandednew = driver.getWindowHandles();
		List<String>brandlist= new ArrayList<String>(brandednew);
		driver.switchTo().window(brandlist.get(1));
		opt.addArguments("--disable-notification");
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		if(pagetitle.contains("L'Oreal Paris")) {
			System.out.println("Yes! its Dispalyed");
		}
		else {
			System.out.println("No ! Name is missing");
		}
		
		//Click sort By and select customer top rated
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,1000)");
		WebElement sort = driver.findElementByXPath("//span[@class='pull-right']");
		System.out.println(sort.isDisplayed());
		act.moveToElement(sort).click().build().perform();
		driver.findElementByXPath("(//div[@class='control control--radio text-capitalize'])[4]//div").click();
		
		//Click Category and click Shampoo
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(125, 741)");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("//div[text()='Category']"))); 
		
		act.moveToElement(driver.findElementByXPath("//div[text()='Category']")).click().build().perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//label[@for='chk_Shampoo_undefined'])[1]//div")));
		act.moveToElement(driver.findElementByXPath("(//label[@for='chk_Shampoo_undefined'])[1]//div")).click().build().perform();
		
		System.out.println("Is Shampoo option chceked :"+driver.findElementByXPath("(//label[@for='chk_Shampoo_undefined'])[1]//div").isSelected() );   
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		
		driver.findElementByXPath("//div[@class='m-content__product-list__title']//span[contains(text(),'Protect')]").click();
		Thread.sleep(2000);
		
		//GO to the new window and select size as 175ml
		
		Set<String> shampooliting = driver.getWindowHandles();
		List<String> Nextpage = new ArrayList<String>(shampooliting);
		driver.switchTo().window(Nextpage.get(2));
		
		driver.findElementByXPath("//span[text()='175ml']").click();
		
		//Print the MRP of the product
		
		String MRP = driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
		System.out.println("MRP :"+MRP.replaceAll("\\D", ""));
		
		//Click on ADD to BAG
		
		driver.findElementByXPath("(//div[@class='pull-left'])[1]").click();
		
		//Go to Shopping Bag 
		
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		
		// Print the Grand Total amount
		
		String GrandTotal = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
		System.out.println("GrandTotal :"+GrandTotal.replaceAll("\\D", ""));
		
		//Click Proceed
		
		driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
		
		//Click on Continue as Guest
		
		driver.quit();
		
		
	}

}
