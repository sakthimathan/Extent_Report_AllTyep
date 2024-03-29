package extent_Reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShots extends base {
	
	public static String CaptureScreenShot_base() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		return base64;
	}

	public static String CaptureScreenShot_base( String FileName) throws IOException {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String ReportTime = sdf.format(date);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Lenovo\\eclipse-workspace\\Extent_Report\\"+ReportTime+FileName);
		FileUtils.copyFile(screenshotAs, des);
		return des.getAbsolutePath();

	}


}
