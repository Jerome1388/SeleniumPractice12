package selenium.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookFromSnapDeal 
{
	

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		System.out.println("1. Browser Launched and URL Loaded successfully");
		//Mouse over on Toys, Kids' Fashion & more and click on Toys -->Educational Toys in Toys & Games
		
		Actions act = new Actions(driver);
		WebElement menu = driver.findElementByXPath("//div[@class='leftNavigationLeftContainer expandDiv']/ul/li[9]");
		act.moveToElement(menu).build().perform();
		Thread.sleep(2000);
		
		driver.findElementByLinkText("Educational Toys").click();
		System.out.println("2. Navigated to Eductional Toys menu");
		
		//Click CustomerRating 4 and above
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//div[@class='filter-content'])[2]/div/div[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='filter-content '])[2]/div/div[5]//label[@for='discount-40%20-%2050']").click();
		Thread.sleep(3000);
		System.out.println("3. Clicked CustomerRating 4 and Above");
		
		//Click the Quick View of the first product 
		
		WebElement clickprod = driver.findElementByXPath("(//img[@class='product-image wooble'])[1]");
		Actions act1= new Actions(driver);
		act1.moveToElement(clickprod).build().perform();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='clearfix row-disc'])[1]/div").click();
		Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		
		System.out.println("4.Clicked QuikView of the First Poduct ");
		
		
		
		 WebElement viewdetailsbtn = driver.findElementByXPath("//div[@class='modal-wrapper col-xs-24  reset-padding mainWidgetquickView']//a[@class=' btn btn-theme-secondary prodDetailBtn']");
		 viewdetailsbtn.click();
		 
		 
		 
		//wait.until(ExpectedConditions.visibilityOf(viewdetailsbtn));
		//System.out.println(viewdetailsbtn.isDisplayed());
		//viewdetailsbtn.click();
		
		//Click on View Details
		
	/*	Set<String> windowHandles = driver.getWindowHandles();
		List<String>winlist = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winlist.get(1)); */
		
		//Capture the Price of the Product and Delivery Charge
		
		WebElement price = driver.findElementByXPath("//span[@class='payBlkBig']");
		String Prodprice = price.getText();
		System.out.println("Product Price : "+Prodprice);
		
		System.out.println("5. Printed Producted price of the product");
		
		// Search for Sanitizer
		
		driver.findElementByXPath("//input[@class='col-xs-20 searchformInput keyword']").sendKeys("Sanitizer");
		driver.findElementByXPath("//span[@class='searchTextSpan']").click();
		System.out.println("6. Searched the Sanitizer");
		
		
		List<WebElement> prodlist = driver.findElementsByXPath("//p[@class='product-title'][1]");
		List<String>Prodlist1 = new ArrayList<String>();
		for(int i=0; i<prodlist.size();i++)
		{
			Prodlist1.add(prodlist.get(i).getText());

		}
		for (String List : Prodlist1)
		{
			System.out.println(List);
			
		}
		
		//Click on Product "BioAyurveda Neem Power Hand Sanitizer"
		
		//JavascriptExecutor js2 = (JavascriptExecutor)driver;
		//js2.executeScript("window.scrollBy(70, 939)");
		
		WebElement sanitizersearch = driver.findElementByXPath("(//div[@class='filter-content '])[2]/input");
		System.out.println(sanitizersearch.isDisplayed());
		System.out.println(sanitizersearch.getLocation());
		sanitizersearch.click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("//label[@for='Brand-BioAyurveda']").click();
		
		Thread.sleep(2000);
		driver.findElementByXPath(" //div[@class='btn applyFilters lfloat']").click();
		System.out.println("Sanitizer List :");
		System.out.println("-------------------");
	/*	List<WebElement> sanilist = driver.findElementsByXPath("//p[@class='product-title']");
		for (int i = 0; i < sanilist.size(); i++) 
		{
			System.out.println(sanilist.get(i).getText());
			
		} */
		driver.findElementByXPath("//p[contains(@title,'BioAyurveda Neem Power  Hand Sanitizer 500 mL Pack of 1')]").click();
		System.out.println("7. Clicked BioAyurveda Neem Power  Hand Sanitizer 500 mL Pack of 1");
		
		//Capture the Price and Delivery Charge
		
		Set<String> prodwin = driver.getWindowHandles();
		List<String>prodlisting = new ArrayList<String>(prodwin);
		driver.switchTo().window(prodlisting.get(1));
		System.out.println("8. Naviagted to new window");
		String SaniPrice = driver.findElementByXPath("//span[@class='payBlkBig']").getText();
		System.out.println(SaniPrice);
		System.out.println("9. Printed Price");
		
		//Click on Add to Cart
		driver.findElementByXPath("(//div[@id='add-cart-button-id'])[1]").click();
		System.out.println("8. Product added to Cart");
		//Click on Cart
		driver.findElementByXPath("//span[@class='cartTextSpan']").click();
		System.out.println("9. Clicked a Cart");
		//Validate the Proceed to Pay matches the total amount of both the products
		
	/*	String prod1price = driver.findElementByXPath("(//span[@class='item-subtotal-black'])[1]").getText();
		String replaceedprice1 = prod1price.replaceAll("\\D","");
		int prodprice1 = Integer.parseInt(replaceedprice1);
		System.out.println("Price of the Product :"+prodprice1);
		
		
		String prod2price = driver.findElementByXPath("(//span[@class='item-subtotal-black'])[2]").getText();
		String replaceedprice2 = prod2price.replaceAll("\\D","");
		int prodprice2 = Integer.parseInt(replaceedprice2);
		System.out.println("Price of the Product :"+prodprice2);
		
		int finalprice = prodprice1 + prodprice2;
		System.out.println("Total Price :"+ finalprice);
		
		String subtotal = driver.findElementByXPath("//span[@class='rfloat']").getText();
		String replacedtot = subtotal.replaceAll("\\D","");
		int Processedpay = Integer.parseInt(replacedtot);
		System.out.println("Processed Pay : "+Processedpay);
		if(Processedpay == finalprice)
		{
			System.out.println("Yes, Both are Equal!!!");
		}
		else
		{
			System.out.println("No, Both are not Equal");
		}
		
		System.out.println("10. Validated the price"); */
		
		driver.close();
		
		System.out.println("Windows Closed");
		
		
		
		
		
		 
		
		
		
		
		
	}


}
