package basicFunctionalities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;



public class Screenshot_navigation {
	
	public static void main(String[] args) throws InterruptedException, Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Screenshot
		File screnshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(screnshot,new File("C:\\Drivers\\screendemo.png"));
		
		
		//Navigation
		driver.navigate().to("https://jqueryui.com/droppable/");
		driver.navigate().back();
		driver.navigate().forward();
		
		driver.quit();
		
	}	

}
