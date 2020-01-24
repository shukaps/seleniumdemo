package basicFunctionalities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
	
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/upload/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//provide file path in send keys to upload any file
		driver.findElement(By.name("uploadfile_0")).sendKeys("C:\\Users\\apoorva shukla\\Downloads\\selenium-java-3.141.59\\CHANGELOG");
		
		
	}

}
