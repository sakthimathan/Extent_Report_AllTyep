package Practice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class demo  {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String ReportTimings = format.format(date);
		
		ExtentReports repo = new ExtentReports();
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\Extent_Report\\Reports_"+ReportTimings+"report.html");

		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		repo.attachReporter(spark);
       
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		String base = CaptureScreenShot_base();
		String path = CaptureScreenShot_base("google.png");

		repo.createTest("test 1").log(Status.INFO, "sec").addScreenCaptureFromBase64String(base);

		repo.createTest("test 2").log(Status.INFO, "sec").addScreenCaptureFromPath(path);
        
		repo.flush();

		// Automatic open report
		Desktop.getDesktop().browse(file.toURI());
		
		
		

	}
	
	public static String CaptureScreenShot_base() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		return base64;
	}

	public static String CaptureScreenShot_base(String FileName) throws IOException {

		Date date = new Date();
		SimpleDateFormat formates= new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String Captures = formates.format(date);
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Lenovo\\eclipse-workspace\\Extent_Report\\Reports\\"+Captures+ FileName);
		FileUtils.copyFile(screenshotAs, des);
		return des.getAbsolutePath();

	}

	

}
