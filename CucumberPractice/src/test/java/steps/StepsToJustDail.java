package steps;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.When;

public class StepsToJustDail 
{
	public ChromeDriver driver;
	
	@Given("Launch the URL")
	public void launch_the_URL() 
	{
	 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	 ChromeOptions options = new ChromeOptions();
	 options.addArguments("--disable-notification");
	 driver = new ChromeDriver(options);
	 driver.manage().window().maximize();
	 driver.get("https://www.justdial.com");
	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	@And("Click Air Ticket")
	public void click_Air_Ticket() 
	{
		driver.findElementByLinkText("Air Tickets").click();
	    
	}

	@And("Enter City")
	public void enter_City() 
	{
		driver.findElementById("departure").sendKeys("Chennai");
		List<WebElement> cities = driver.findElementsByXPath("//ul[@id='ui-id-1']/li");
		for (WebElement depaturecity : cities) 
		{
			if(depaturecity.getText().trim().equals("Chennai, IN - Chennai Airport (MAA)")) 
			{
				depaturecity.click();
				break;
				
			}
			 
			
		}
		
	   
	}

	@And("Enter Going to City")
	public void enter_Going_to_City() 
	{
		driver.findElementById("arrival").sendKeys("Canada");
		List<WebElement> arraivalcity = driver.findElementsByXPath("//ul[@id='ui-id-2']/li");
		for(WebElement desgcity : arraivalcity) 
		{
			if(desgcity.getText().trim().equals("Toronto, CA - Lester B Pearson (YYZ)"))
			{
				desgcity.click();
				break;
			}

			
		}
	}

	@And("Set Depature")
	public void set_Depature() throws InterruptedException 
	{
		driver.findElementById("departDate").click();
		  WebElement calclick = driver.findElement(By.xpath("//a[@title='Next']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", calclick);
		Thread.sleep(3000);
		 driver.findElement(By.xpath("//a[text()='22']")).click();
		
		
		
		//String Date = "wed,22-jul-2020";
		//String[] spliteddate = (Date.split("")[0]).split("-");
		
	/*	WebElement cald = driver.findElementByXPath("//table[@class='ui-datepicker-calendar']/tbody");
		List<WebElement> calrows = cald.findElements(By.tagName("tr"));	
		for (int i = 1; i < calrows.size(); i++) 
		{
			List<WebElement> calcols = calrows.get(i).findElements(By.tagName("td"));
			for (WebElement picdate : calcols) 
			{
				if (picdate.getText().trim().equals("22")) 
				{
					picdate.click();
					
				}
				
			}
			
		} */   
	}

	@And("Add Adult Children")
	public void add_Adult_Children() 
	{
		driver.findElementByXPath("(//span[@class='plus'])[1]").click();
		driver.findElementByXPath("(//span[@class='plus'])[2]").click();
		
	    
	}

	@Given("Click Search")
	public void click_Search() 
	{
		driver.findElementByXPath("//input[@value='SEARCH']").click();
	    
	}
	@And("Select Air Canada")
	public void select_Air_Canada() 
	{
		List<WebElement> airlinelist = driver.findElementsByXPath("//div[@id='airDetail']/ul[2]/li");
		for (WebElement airline : airlinelist) 
		{
			if (airline.getText().trim().equals("Air Canada(AC)")) 
			{
				airline.click();
				break;
				
			}
			
		}
 	}

	@And("Click Price to Sort")
	public void click_Price_to_Sort() 
	{
		driver.findElementByLinkText("Price").click();
	    
	}

	@And("Click Price Details")
	public void click_Price_Details() 
	{
		WebElement Airres = driver.findElementById("resTD1");
		Airres.click();
		
	   
	}

	@And("Capture Flight Arraival Time")
	public void capture_Flight_Arraival_Time() 
	{
		List<WebElement> arravingTime = driver.findElementsByXPath("(//tbody)[8]/tr[1]/td[6]");
		 List<WebElement> arravingDate = driver.findElementsByXPath("(//tr[@class='childText'])[1]/td[4]/span");
		Map<String, String> mapping = new HashMap<String, String>();
		for (int i = 0; i < arravingTime.size(); i++) 
		{
			
			mapping.put(arravingTime.get(i).getText(),arravingDate.get(i).getText());
				
		}
		System.out.println("Arraving Date with Time:   ");
		for (Map.Entry<String, String> dates : mapping.entrySet()) 
		{
			System.out.println("Arraival Date : "+dates.getKey() + "Arraival Time : "+dates.getValue());
			
		}
		System.out.println();	  
	}

	@And("Capture Total Price")
	public void capture_Total_Price() 
	{
	 
	 String TotalPrice = driver.findElementByXPath("//ul[@class='detUL']/li[4]/div[1]/span").getText();
	 System.out.println("The Total Price : "+TotalPrice);
	   
	}

	@When("Click Book Tickets")
	public void click_Book_Tickets() 
	{
		driver.findElementByXPath("(//tbody)[7]/tr[1]/td[6]/a").click();
	   
	}

	@And("Capture the Airports")
	public void capture_the_Airports() 
	{
		List<WebElement> time = driver.findElementsByXPath("(//tbody)[3]/tr[1]/td[6]");
		List<WebElement> airportname = driver.findElementsByXPath("(//tbody)[3]/tr[@class='childText']/td[4]");
		Map<String,String> map = new HashMap<String, String>();
		for (int i = 0; i < time.size(); i++) 
		{
			map.put(time.get(i).getText(),airportname.get(i).getText());	
		}
		System.out.println("AirPort List by Time");
		for(Map.Entry<String, String> listofport : map.entrySet())
		{
			System.out.println("Time : "+listofport.getKey()+"Airport : "+listofport.getValue());
		}
		System.out.println();
	}
	
	


}
