package basicFunctionalities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.amazon.in/gp/browse.html?node=11400137031&ref_=nav_em_T1_0_4_NaN_2_sbc_wfashion_western");
		driver.get("https://www.softwaretestinghelp.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> iframeno = driver.findElements(By.tagName("iframe"));
		System.out.println(iframeno);
		System.out.println(iframeno.size());
		
		/*System.out.println(driver.switchTo().frame(0));
		System.out.println(driver.getPageSource());
		
		driver.switchTo().defaultContent();
		System.out.println(driver.switchTo().frame(3));
		System.out.println(driver.getPageSource());*/
		driver.quit();
		
		
		
		

	}

}
