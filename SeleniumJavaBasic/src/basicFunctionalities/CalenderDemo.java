package basicFunctionalities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
		driver.findElement(By.id("src")).sendKeys("Wakad");
		
		driver.findElement(By.id("dest")).sendKeys("Mumbai");
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//tr[@class='rb-monthHeader']//child::td[contains(text(),'Mar 2020')]")).click();
		
		//*[@id='rb-calendar_onward_cal']/table/tbody/tr[4]/td[7]
		
		String beforexpath= "//*[@id='rb-calendar_onward_cal']/table/tbody/tr[";
		String afterxpath= "]/td[";
		
		boolean flag=false;
		
		for(int row=4;row<=9;row++) {
			for(int col=1;col<=7;col++) {
				
				String day=driver.findElement(By.xpath(beforexpath+row+afterxpath+col+"]")).getText();
				System.out.println(day);
				
				if(day.equals("12")) {
					driver.findElement(By.xpath(beforexpath+row+afterxpath+col+"]")).click();
					flag=true;
					break;
				}
			}
			if(flag) {
				break;
			}
		}
	}

}
