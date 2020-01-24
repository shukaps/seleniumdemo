package basicFunctionalities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		//accept the alert function
		/*
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println(alert.getText());
		alert.accept();*/
		
		//accept or dismiss the alert and get the message
		/*driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.dismiss();
		System.out.println(driver.findElement(By.id("confirm-demo")).getText());*/
		
		//to enter text in a alert
		driver.findElement(By.xpath("//button[contains(text(),'Click for Prompt Box')]")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		alert.sendKeys("Apoorva");
		alert.accept();
		System.out.println(driver.findElement(By.id("prompt-demo")).getText());
		
		driver.quit();
		
		
		
		
		
		

	}

}
