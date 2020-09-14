package selenium.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ZanlandoTC 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.zalando.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println("1. URL Launched SUccessfully");
		
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		System.out.println(msg);
		alert.accept();
		
		
		System.out.println("2. Alert text captured and closed");
		Thread.sleep(2000);
	
		driver.findElementByXPath("//div[@class='wrapper wrapper_content content']//li[10]//a").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='btn-list uc-col-lg-12 uc-col-md-12 uc-col-sm-12 uc-col-12 uc-overflow-hidden hide-deny-btn show-more-btn']//button[1]").click();
		WebElement msg1 = driver.findElementByXPath("//div[@class='z-navicat-header-uspBar_message']//span[2]");
		Actions act = new Actions(driver);
		act.moveToElement(msg1).pause(2000).build().perform();
		String Delivermsg = driver.findElementByXPath("//span[@title='*Free delivery for orders over £19.90. For orders below this amount, the delivery fee is £3.00.']").getAttribute("title");
		System.out.println(Delivermsg);
		
		System.out.println("3. PRinted Free Deliver and Returns Message");
		
		driver.findElementByXPath("//span[text()='Women']").click();
		WebElement cloth = driver.findElementByXPath("//div[@class='z-navicat-header_bottomRow']//li[3]//a//span");
		act.moveToElement(cloth).pause(2000).build().perform();
		
		driver.findElementByXPath("(//div[@class='ry-Xoz'])[1]//div[5]//a//span").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//div[@class='cat_container-2yN_D']//li[6]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='cat_box-61TrD cat_narrow-GAhUW']//li[4]//span").click();
		driver.findElementByXPath("//div[@class='cat_pane-xETbh']//button[2]").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("//div[@class='cat_container-2yN_D']//li[9]").click();
		driver.findElementByXPath("//div[@class='cat_itemList-sgr85 cat_scrollbar---3VP']//li[3]//span").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='cat_pane-xETbh']//button[2]").click();
		
		System.out.println("4. Selected Material as COtten Length as Thigh-Length");
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='KVKCn3 u-C3dd jDGwVr mo6ZnF KLaowZ'])[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='adFHlH _0xLoFW _7ckuOK mROyo1'])[4]//div[2]").click();
		
		System.out.println("5. Clicked first product and selected the color as well");
		
		String title = driver.getTitle();
		System.out.println("Title of the page is :"+title);
		
		driver.findElementByXPath("//span[@class='_7Cm1F9 ka2E9k uMhVZi dgII7d z-oVg8 pVrzNP BDUtDm GhPDv6 q-6yg2 e5adJm _9bYLON CJVJQ4 _2LebSa']//h3").getText();
		if(title.equals("ICEBound"))
		{
			System.out.println("Product has been matched with title");
		}
		else
		{
			System.out.println("Not Matched witn title");
		}
		
		driver.findElementByXPath("//span[text()='Add to bag']").click();
		System.out.println("6. Product has been added to bag");
		Thread.sleep(2000);
		
		driver.findElementByXPath("//a[text()='Free delivery and returns*']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='channel__button'])[1]//span").click();
		Set<String> chatwin = driver.getWindowHandles();
		List<String> winli = new ArrayList<String>(chatwin);
		driver.switchTo().window(winli.get(1));
		Thread.sleep(2000);
		driver.findElementById("prechat_customer_name_id").sendKeys("Jerry");
		driver.findElementById("prechat_customer_email_id").sendKeys("jerry@gmail.com");
		driver.findElementByXPath("//span[text()='Start Chat']").click();
		Thread.sleep(2000);
		driver.findElementById("liveAgentChatInput").sendKeys("Hi");
		driver.findElementByXPath("//button[text()='Send']").click();
		Thread.sleep(2000);
		String reply = driver.findElementByXPath("(//span[@class='operator'])[3]//span[2]").getText();
		System.out.println(reply);
		

	
		
		
		
		
		
		
		
		
		
		
		
	}

}
