package selenium.practice;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudyAbroad 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","");
		ChromeDriver driver = new ChromeDriver();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://studyabroad.shiksha.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		System.out.println("1. URl Loaded and Launched Successfully");
		Actions act = new Actions(driver);
		
		//Mouse over on Colleges and click MS in Computer Science &Engg under MS Colleges
		//driver.findElement(By.xpath("(//label[@class='menuTab-div fnt-wt melabel'])[3]"));
		WebElement menu = driver.findElementByXPath("(//label[@class='menuTab-div fnt-wt melabel'])[3]");
		act.moveToElement(menu).build().perform();
		driver.findElementByLinkText("MS in Computer Science &Engg").click();
		System.out.println("2. Navigated to MS in Computer Science");
		
		//Click Change course / country select box, choose course as BE/Btech and Choose specialization as Computer Science & Engineering
		//WebDriverWait wait = new WebDriverWait(driver,30);
		Thread.sleep(2000);
		WebElement changecourse = driver.findElementByLinkText("Change course / country");
		
		changecourse.click();
		//driver.switchTo().alert();
		WebElement popularcourse = driver.findElementById("desiredCourse");
		Select sel = new Select(popularcourse);
		sel.selectByValue("1510");
		Thread.sleep(3000);
		WebElement Specliazation = driver.findElementById("subCatSelect");
		Select sel1 = new Select(Specliazation);
		sel1.selectByVisibleText("Computer Science & Engineering");
		Thread.sleep(3000);
		
		
		//Select Study destination as USA, UK, Canada and click Update
		driver.findElementByXPath("//div[@class='select-overlap']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='flag-chkbox'])[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='flag-chkbox'])[2]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='flag-chkbox'])[6]").click();
		driver.findElementByLinkText("OK").click();
		driver.findElementByXPath("//input[@class='button-style big-button']").click();
		System.out.println("3. Course has been Selected");
		Thread.sleep(2000);
		
		//In Filters Select IELTS and score as 7.5 & Below in Exam Accepted
		
		driver.findElementByXPath("//label[@for='exam-1']//span").click();
		Thread.sleep(1000);
		WebElement score = driver.findElementByXPath("(//select[@class='score-select-field'])[2]");
		Select sel2 = new Select(score);
		sel2.selectByIndex(2);
		driver.findElementByXPath("//label[@for='fee-1']");
		
		List<WebElement> collegeName = driver.findElementsByXPath("//div[@class='tuple-title']");
		List<WebElement> collegeFee = driver.findElementsByXPath("//div[@class='uni-course-details flLt']//div[1]");
		Map<String,String> map = new HashedMap<String, String>();
		for (int i = 0; i < collegeName.size(); i++) 
		{
			map.put(collegeName.get(i).getText(), collegeFee.get(i).getText());
			
		}
		for (Map.Entry<String,String> fees : map.entrySet()) 
		{
			System.out.println("College Name : "+fees.getKey()+"  Fees :"+fees.getValue() );
			
		}
		088
		
		
		
	}

}
