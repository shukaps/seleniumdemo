package basicFunctionalities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindoHandle {
	
	public static void main(String[] args) throws InterruptedException, Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://chandanachaitanya.github.io/selenium-practice-site/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[@id='win1']")).click();
		
		//to find the id of all the windows opened
		Set<String> handler = driver.getWindowHandles();
		
		//to point the iterator
		Iterator<String> it= handler.iterator();
		
		
		String parentwindowId=it.next();
		System.out.println(parentwindowId);
		
		String childWindowID=it.next();
		System.out.println(childWindowID);
		
		driver.switchTo().window(childWindowID);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parentwindowId);
		System.out.println(driver.getTitle());
		
		
		
	}

}
