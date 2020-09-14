package selenium.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MyntraTC 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		
		// Open https://www.myntra.com/
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("1. Browser Launced and URL Loaded !!!!!!!!");
		
		//Mouse over on WOMEN (Actions -> moveToElement and Click Jackets & Coats
		WebElement menu = driver.findElementByXPath("(//a[text()='Women'])[1]");
		Actions act = new Actions(driver);
		act.moveToElement(menu).pause(2000).build().perform();
		driver.findElementByXPath("//a[text()='Jackets & Coats']").click();
		
		System.out.println("2. Mouse over on WOMEN (Actions -> moveToElement and Clicked Jackets & Coats !!!!!");
		
		//Find the total count of item
		
		String count = driver.findElementByXPath("//span[@class='title-count']").getText();
		String countreplaceAll = count.replaceAll("\\D", "");
		int totalcount = Integer.parseInt(countreplaceAll);
		System.out.println("Total Count of Jackets and Coat :"+ totalcount);
		
		//Validate the sum of categories count matches
		//Jacket Count
		String jacket = driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText();
		String JacketCount = jacket.replaceAll("\\D", "");
		int totalcountjacket = Integer.parseInt(JacketCount);
		System.out.println("Total Count of Jacket :"+totalcountjacket);
		
		// coat count
		
		String coat = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		String coatcount = coat.replaceAll("\\D","");
		int totalcountcoat = Integer.parseInt(coatcount);
		System.out.println("Totalcount of Coat :"+ totalcountcoat);
		
		//adding sum && Validation
		
		int totalofboth = totalcountjacket+totalcountcoat;
		System.out.println("Total of Both : "+totalofboth);
		
		if(totalcount == totalofboth)
		{
			System.out.println("Both Counts are Same !");
		}
		else
		{
			System.out.println("Both Counts are not same !");
		}
		
		System.out.println("3. Validation done !!!!");
		
		
		opt.addArguments("--disable-notifications");
		//Check Coats and Click + More option under BRAND
		
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		driver.findElementByClassName("brand-more").click();
		
		System.out.println("4. Checked Coats and Clicked + More option under BRAND !!!!");
		
		//Type MANGO and click checkbox
		
		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("MANGO");
		Thread.sleep(2000);
		driver.findElementByXPath("//label[@class=' common-customCheckbox']//div").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		
		System.out.println("5. Type MANGO and clicked checkbox !!!!");
		
		//Confirm all the Coats are of brand MANGO,findElements (brand) -> List<WebElement>,foreach -> getText of each brand,compare > if(condition) 
		
		List<WebElement> brands = driver.findElementsByXPath("//div//h3");
		for (WebElement list : brands) 
		{
			if(list.getText().trim().equals("MANGO")) {
				System.out.println("All Product are belongs to MANGO");
			}
			else
			{
				System.out.println("No! There is match");
			}
			
		}
		
		System.out.println("6. Confirmed all the Coats are of brand MANGO !!!!");
		
		
		//Sort by Better Discount
		
		 WebElement sort = driver.findElementByXPath("//div[@class='sort-sortBy']");
		 act.moveToElement(sort).perform();
		 Thread.sleep(2000);
		 WebElement sorting = driver.findElementByXPath("(//label[@class='sort-label '])[3]");
		act.moveToElement(sorting).click().perform();
		System.out.println("7. Sort by Better Discount !!!!");
		
		//Find the price of first displayed item
		
		List<WebElement> prodprice = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		WebElement newprice = prodprice.get(0);
		String price = newprice.getText();
		String replacedprice = price.replaceAll("[^0-9]","");
		int pricing = Integer.parseInt(replacedprice);
		System.out.println("Price of a product : "+pricing);
		
		System.out.println("8. Find the price of first displayed item !!!!");
		
		//Mouse over on size of the first item
		WebElement prod = driver.findElementByXPath("(//div[@class='product-sliderContainer'])[1]");
		act.moveToElement(prod).pause(2000).build().perform();
		Thread.sleep(2000);
		System.out.println("9. Mouse over on size of the first item !!!!");
		
		//Click on WishList Now
		driver.findElementByXPath("(//span[@class='product-actionsButton product-wishlist '])[1]").click();
		
		System.out.println("10.Wishlist CLicked !!!!");
	    
		
		//Close Browser
		
		driver.close();
		
		System.out.println("11. Browser Closed !!!!");
	    
	    
		
	}

}
