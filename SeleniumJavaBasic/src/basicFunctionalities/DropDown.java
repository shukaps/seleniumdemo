package basicFunctionalities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.name("firstName")).sendKeys("John");
		driver.findElement(By.name("lastName")).sendKeys("Snow");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("7342896577");
		driver.findElement(By.id("userName")).sendKeys("johnsnownothing@gmail.com");
		
		//DropDown
		
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText("ANTARCTICA");
		
		//isDisplayed any element
		
		Boolean button = driver.findElement(By.name("submit")).isDisplayed();
		System.out.println(button);


	}

}
