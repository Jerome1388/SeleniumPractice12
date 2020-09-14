package steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepsToHonda 
{
	
public ChromeDriver driver;
public Actions act;

@Given("Launch URL")
public void launch_URL() 
{
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.honda2wheelersindia.com");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElementByXPath("//button[@class='close']").click();

    
}

@And("Click on Scooter and Click on Dio")
public void click_on_Scooter_and_Click_on_Dio() 
{
	driver.findElementByXPath("//div[@class='cont-nivel-1 cont-nivel-2 col-md-offset-3']/a[2]").click();
	driver.findElementByXPath("//img[@src='/assets/images/thumb/dioBS6-icon.png']").click();

    
}

@And("Click on Specification MouseHover on Engine")
public void click_on_Specification_MouseHover_on_Engine() 
{
	driver.findElementByXPath("//div[@id='accordion-1']/ul/li[4]/a").click();
	Actions act = new Actions(driver);
	WebElement engine = driver.findElementByLinkText("ENGINE");
	act.moveToElement(engine).pause(2000).perform();

    
}

@And("All Details of Dio Specification in Map")
public void all_Details_of_Dio_Specification_in_Map() 
{
	List<WebElement> dioengtype = driver.findElementsByXPath("//div[@class='engine part-2 axx']/ul/li[2]/span[1]");
	List<WebElement> dioengvalue = driver.findElementsByXPath("//div[@class='engine part-2 axx']/ul/li[2]/span[2]");
	Map<String,String> mapping = new HashMap<String, String>();
	List<String> engAttri = new ArrayList<String>();
	List<String> engValue = new ArrayList<String>();
	for (int i = 0; i < dioengtype.size(); i++) 
	{
		engAttri.add(dioengtype.get(i).getText());
	}
	for (int j = 0; j < dioengvalue.size(); j++) 
	{
		engValue.add(dioengvalue.get(j).getText());
	}
		
	for (int i = 0; i < engAttri.size(); i++) 
	{
		mapping.put(engAttri.get(i),engValue.get(i));
	}
		
	System.out.println(" Dio Engine Value ");
	for(Map.Entry<String, String> values : mapping.entrySet())
	{
		System.out.println("Dio Engine Type:  "+values.getKey()+" Dio Engine Value   :"+values.getValue());
	}


}

@And("Goto Scooter and Click on Activa")
public void goto_Scooter_and_Click_on_Activa() throws InterruptedException 
{
	driver.findElementByXPath("//div[@class='cont-nivel-1 cont-nivel-2 col-md-offset-3']/a[2]").click();
	driver.findElementByXPath("//img[@src='/assets/images/thumb/activa-125new-icon.png']").click();
    Thread.sleep(2000);

   
}

@And("All Details of Activa Specification in Map")
public void all_Details_of_Activa_Specification_in_Map() 
{
	driver.findElementByXPath("//div[@id='accordion-1']/ul/li[4]/a").click();
	act= new Actions(driver);
	WebElement activa = driver.findElementByXPath("//div[@class='specifications-box col-md-4 col-sm-4 wow bounceInLeft']//ul/li[4]/a");
    act.moveToElement(activa).build().perform();
    
    List<WebElement> activaengType = driver.findElementsByXPath("//div[@class='engine part-4 axx']/ul/li[2]/span[1]");
    List<WebElement> activaendValue = driver.findElementsByXPath("//div[@class='engine part-4 axx']/ul/li[2]/span[2]");
    
    Map<String,String> mapping2 = new HashMap<String, String>();
    
    List<String> actEngType = new ArrayList<String>();
    List<String> actEngValue = new ArrayList<String>();
    
    
    for(int i=0; i<activaengType.size();i++)
    {
    	actEngType.add(activaengType.get(i).getText());
    }
    
    for(int j=0; j<activaendValue.size(); j++)
    {
    	actEngValue.add(activaendValue.get(j).getText());
    }
    
    for (int i = 0; i < actEngType.size(); i++) 
    {
    	mapping2.put(actEngType.get(i), actEngValue.get(i));
		
	}
    
    for(Map.Entry<String, String>activevalues :  mapping2.entrySet())
    {
    	System.out.println("Activa Eng Types :   "+activevalues.getKey()+"Activa Eng Vales :  "+activevalues.getValue());
    }

    
}

/* @And("Compare Dio and Activa Specification print the different values of the samekeys")
public void compare_Dio_and_Activa_Specification_print_the_different_values_of_the_samekeys() {
    
}

@And("Click FAQ from Menu and Click dio under Browse By Product")
public void click_FAQ_from_Menu_and_Click_dio_under_Browse_By_Product() {
   
}

@And("Click  Vehicle Price and Select scooter Dio BS-VI from the dropdown and click submit")
public void click_Vehicle_Price_and_Select_scooter_Dio_BS_VI_from_the_dropdown_and_click_submit() {
    
}

@And("click the price link Go to the new Window and select the state city")
public void click_the_price_link_Go_to_the_new_Window_and_select_the_state_city() {
   
}

@And("Print the price and model")
public void print_the_price_and_model() {
   
}

@And("Click Product Enquiry and Fill all the * field except Mobile check the terms and conditions box and click submit")
public void click_Product_Enquiry_and_Fill_all_the_field_except_Mobile_check_the_terms_and_conditions_box_and_click_submit() {
    
}

@And("Verify the error message under the mobile number field")
public void verify_the_error_message_under_the_mobile_number_field() {
    
}

@Then("Close the Browser")
public void close_the_Browser() {
   
}  */



}
