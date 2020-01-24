package testNGdemo.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
	}
	
	@Test
	public void emailtest(){
		boolean b= driver.findElement(By.linkText("Gmail")).isDisplayed();
		
		
	}
	
	@Test
	public void Search() {
		boolean b=driver.findElement(By.cssSelector("input.gNO89b")).isDisplayed();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
