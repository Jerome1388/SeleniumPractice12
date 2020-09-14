package selenium.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomCarTC 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.zoomcar.com/chennai");
		System.out.println("1. URL Launched SUccessfully");
		
		driver.findElementByLinkText("Start your wonderful journey").click();
		driver.findElementByXPath("//div[@class='component-popular-locations']//div[3]").click();
		driver.findElementByXPath("//button[text()='Next']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='days']//div[2]").click();
		driver.findElementByXPath("//button[text()='Next']").click();
		
		System.out.println("2. Date selected");
		String Date = driver.findElementByXPath("//div[@class='day picked']").getText();
		System.out.println("Date is :0"+Date);
		String confirmationdate = Date.replaceAll("[^0-9]"," ");
		try {
			int parseprice =Integer.parseInt(confirmationdate);
			System.out.println("Date :"+parseprice);
			
	}	
	catch(NumberFormatException e)
	{
		
	}
		
		if(confirmationdate.equals("15"))
		{
			System.out.println(confirmationdate +" , Yes same date ");
			
		}
		else 
		{
			System.out.println(" Oops, Date mismatched");
		}
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='Done']").click();
		System.out.println("3. Date confirmed");
		
		List<WebElement> carlists = driver.findElementsByXPath("//div[@class='car-item']");
		
		int litsize = carlists.size();
		System.out.println("List of the Cars are  :"+litsize);
		System.out.println("4. Size of Result has cpatured");
		
		
		List<WebElement> pricelists = driver.findElementsByXPath("//div[@class='price']");
		List<Integer> allprices = new ArrayList<Integer>();
		List<WebElement> cardetails = driver.findElementsByXPath("//div[@class='details']//h3");
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (WebElement pricing : pricelists) 
		{
			String allprice = pricing.getText();
			System.out.println("Car Price :"+allprice);
			String replacedprice = allprice.replaceAll("[^0-9]", " ");
			System.out.println("Repalced Price:   "+replacedprice);
			try {
					int parseprice =Integer.parseInt(replacedprice);
				
					allprices.add(parseprice);
			}	
			catch(NumberFormatException e)
			{
				
			}
			System.out.println(allprices);
		}
			
			for (int i = 0; i < allprices.size(); i++) 
			{
				map.put(cardetails.get(i).getText(), allprices.get(i));
				
			}
			for (Map.Entry<String,Integer> entry : map.entrySet()) 
			{
				System.out.println("CarName : "+entry.getKey()+"-------->"+ "Ride Price: "+entry.getValue());
			}
			
		
		
		
		
		
		
		
		
		
		
	}

}
