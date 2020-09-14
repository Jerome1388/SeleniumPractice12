package steps;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.WindowConstants;

import org.apache.poi.hpsf.Array;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepsToShopClues 
{
	public ChromeDriver driver;
	public ChromeOptions options;
	public JavascriptExecutor js;
	@Given("Launch URL")
	public void launch_URL() 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		options = new ChromeOptions();
		options.addArguments("--disable-notification");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.shopclues.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
	}

	@And("Mousehover on WomenmenuClick Shoes")
	public void mousehover_on_WomenmenuClick_Shoes() throws InterruptedException 
	{
		Actions act = new Actions(driver);
		WebElement women = driver.findElementByLinkText("WOMEN");
		act.moveToElement(women).pause(3000).perform();
		Thread.sleep(4000);
		WebElement shoes = driver.findElementByXPath("//a[@alt='Home|CT4P1|WOMEN|NA|Footwear|Casual Shoes|NA|NA|CT@Casual Shoes']");
		act.moveToElement(shoes).click().perform();
		Thread.sleep(3000);
	    
	}

	@And("Click Black Color")
	public void click_Black_Color() throws InterruptedException 
	{
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		options.addArguments("--disable-notification");
		Thread.sleep(3000);
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		WebElement color = driver.findElementByXPath("//label[@for='Black']");
		js.executeScript("arguments[0].click()",color );
		
	    
	}

	@And("Check the word black add into map")
	public void check_the_word_black_add_into_map() 
	{
		WebElement shoecolr = driver.findElementByXPath("//span[text()='Black']");	    
		String colors = shoecolr.getText();
		if (colors.contains("Black")) 
		{
			System.out.println("The Blck Shoe Displayed");
			
		}
		
		System.out.println("--------------------------------------------------------");
		Map<String, String>Product = new HashMap<String, String>();
		
		List<WebElement> Prodname = driver.findElementsByXPath("//span[@class='prod_name ']");
		List<WebElement> pricelist = driver.findElementsByXPath("//span[@class='p_price']");
		
		for (int i = 0; i < Prodname.size(); i++) 
		{
			Product.put(Prodname.get(i).getText(), pricelist.get(i).getText());
			
		}
		System.out.println("Display Product Name And Price :");
		for(Map.Entry<String, String> prodlist : Product.entrySet()) {
			System.out.println("ProductName : "+prodlist.getKey()+"Product Price: "+prodlist.getValue());
		}
		
	}

	

	@And("Click the highest price of the shoe")
	public void click_the_highest_price_of_the_shoe() throws InterruptedException 
	{
		driver.findElementByLinkText("High Price").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='img_section img_320new']").click();
		
		
	}

	@And("Get the current page URL and check with the product ID")
	public void get_the_current_page_URL_and_check_with_the_product_ID() throws InterruptedException 
	{
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>winli = new ArrayList<String>(windowHandles);
		driver.switchTo().window(winli.get(1));
		Thread.sleep(2000);
		String currentURL = driver.getCurrentUrl().replaceAll("[^0-9]","");
		WebElement prodId = driver.findElementByClassName("pID");
		if(currentURL.equals(prodId.getText()))
			System.out.println("Cuurent URL is equals to ProdID");
		
	   
	}

	@And("Copy the offercode")
	public void copy_the_offercode() throws HeadlessException, UnsupportedFlavorException, IOException 
	{
		driver.findElementById("first__B2G75").click();
		String data= (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		System.out.println("THe Offer code :"+ data);
	   
	}

	@And("Select size, color and click ADD TO CART")
	public void select_size_color_and_click_ADD_TO_CART() throws InterruptedException 
	{
		driver.findElementByXPath("//span[@class='variant var  selected'][1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[@class='variant var  selected'][2]").click();
		Thread.sleep(2000);
	    
		driver.findElementById("add_cart").click();
	}

	@And("Mouse over on Shopping cart and click View Cart")
	public void mouse_over_on_Shopping_cart_and_click_View_Cart() 
	{
		Actions act = new Actions(driver);
		WebElement cart = driver.findElementByXPath("//span[@class='cart_icon_count']");
		act.moveToElement(cart).pause(2000).perform();
		driver.findElementByLinkText("View Cart").click();
	    
	}

	@And("Type Pincode  click Submit and Place Order")
	public void type_Pincode_click_Submit_and_Place_Order() throws InterruptedException 
	{
		driver.findElementByXPath("//span[@class='atom_change_pincode']").click();
		WebElement pinpopup = driver.findElementById("pin_code_popup");
		pinpopup.clear();
		pinpopup.sendKeys("600016");
		driver.findElementById("get_pincode_popup").click();
		Thread.sleep(3000);
		
		driver.findElementByXPath("//div[@class='btn orange']").click();
		Thread.sleep(3000);
	}   
	
	@Then("Close browser")
	public void Close_browser() 
	{
		driver.close();
	}

}
