package testNGdemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportDemo {
	
	public WebDriver driver;
	
	public ExtentReports extentreport;
	public ExtentTest logger;
	
	@BeforeTest
	public void BeforeanyTest() {
		extentreport = new ExtentReports(System.getProperty("user.dir")+"/test-output/Version2Report.html",true);
		//extentreport = new ExtentReports("C:\\Users\\apoorva shukla\\Downloads\\Reports\\ReportVersion2Demo.html");
		
				//extentreport.addSystemInfo("Tester"	, "Apoorva");
				//extentreport.addSystemInfo("Environment", "Test");
		extentreport.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
	@BeforeMethod
	public void SetUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		//logger.log(LogStatus.INFO, "Browser Started");
		driver.manage().window().maximize();
		driver.get("https://testng.org/doc/documentation-main.html#testng-listeners");
		
		//logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test(priority=1)
	public void VerifyTitle() {
		
		
		
		logger=extentreport.startTest("Test1VerifyTitle");
		
		
		
				
		String titlename=driver.getTitle();
		Assert.assertTrue(titlename.contains("TestNG"), "Title is verified");
		logger.log(LogStatus.PASS, "TestCase Passed");
		extentreport.endTest(logger);
		
		
	}
	@Test(priority=2)
	public void FailedTest() {
		logger=extentreport.startTest("Test2FailedTest");
		String titlename=driver.getTitle();
		Assert.assertTrue(titlename.contains("hjdghjf"), "Title is not verified");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL,"Test Case Failed is", result.getName());
			logger.log(LogStatus.FAIL,"Test Case Failed is",result.getThrowable());
			String Screenshotpath = ReportDemo.screenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(Screenshotpath));//to add the screenshot is extent report
			
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "TestCase Passed is",result.getName());
		}
		
		extentreport.endTest(logger);//end the current test case and save the report
		
		driver.quit();
	}
	
	@AfterTest
	public void afterAnyTest() {
		
		extentreport.flush();
		extentreport.close();
	}
	
	
	
	public static String screenshot(WebDriver driver, String Screenshots) throws IOException {
		String datetime= new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\apoorva shukla\\git\\seleniumdemo\\SeleniumJavaBasic"+Screenshots+datetime+".png";
		Files.copy(src,new File(path));
		return path;
	}
	

	
	

}
