package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo1 {

	public static void main(String[] args) {
		
		//addff
		
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://sites.google.com/a/chromium.org/chromedriver/downloads");
		System.out.println(driver.getTitle());
		driver.quit();
		
	}
}
