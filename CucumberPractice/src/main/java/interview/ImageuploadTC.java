package interview;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImageuploadTC 
{
	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://kirill3333.github.io/react-avatar/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Robot robot = new Robot();
		WebDriverWait wait = new WebDriverWait(driver,40);
		
		driver.findElementByXPath("(//label[text()='Choose a file'])[1]").click(); //upload.sendKeys("C:\\Users\\user\\Pictures\\1.jpg");
		
		robot.setAutoDelay(2000);
		StringSelection selection = new StringSelection("C:\\Users\\user\\Pictures\\parrot.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("Image Has been uploaded");
		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[name()='svg']/*[name()='g']/*[name()='path'and @fill='white'][1]")));
		
		WebElement imageclick = driver.findElementByXPath("//*[name()='svg']/*[name()='g']/*[name()='path'and @fill='white'][1]");
		Actions act = new Actions(driver);
		act.moveToElement(imageclick).click().perform();
		
		System.out.println("Image has removed Successfully");
		
		
		
		
	}

}
