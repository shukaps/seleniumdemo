package day4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class configdemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\apoorva shukla\\eclipse-workspace\\SeleniumJavaBasic\\src\\day4\\config.properties");
		
		prop.load(ip);
		
		driver.get(prop.getProperty("url"));
		System.out.println(prop.getProperty("name"));
	
		
	}

}
