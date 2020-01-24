package basicFunctionalities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//List<WebElement> valuee;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@type = 'search']")).sendKeys("Software");
		
		//to get the entire web table
		WebElement table=driver.findElement(By.id("example"));
		
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		System.out.println("no. of rows="+rows.size());
		
		
		/*List<WebElement> cols=table.findElements(By.tagName("th"));
		System.out.println("no. of cols="+cols.size());*/
		
		
		
		
		
		/*for(int i=1;i<rows.size();i++) {
			
			//String valuee=table.findElement(By.xpath("//*[@id='example']/tbody/tr["+i+"]"));
			//List<WebElement> valuee=driver.findElements(By.xpath("//*[@id='example']/tbody/tr["+i+"]"));
			//System.out.println("no. of cols="+valuee.get(i).getText());
			List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
			System.out.println("no. of cols="+cols.size());
			
			
			for(int j=0;j<cols.size();j++) {
				
				String cellvalue= cols.get(j).getText();
				/*valuee =driver.findElements(By.xpath("//*[@id='example']/tbody/tr/td["+j+"]"));
				//System.out.println(cellvalue);
				if(cols.get(j).getText().contains("San Francisco")){
					System.out.println("index is"+j+"value is:"+cols.get(j).getText());
					break;
				}
				
				
				
				
				}
			
				
			}*/
		
		for(int i=1;i<rows.size();i++) {
			List<WebElement> cols=rows.get(i).findElements(By.xpath("//*[@id='example']/tbody/tr["+i+"]/td"));
			System.out.println(cols.size());
			for(int j=0; j<cols.size();j++) {
				String cellvalue= cols.get(j).getText();
				System.out.println(cellvalue);
			}
		}
		
			
		driver.quit();
			
		}
		
		


	}


