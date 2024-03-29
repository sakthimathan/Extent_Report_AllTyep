package extent_Repo_Listen;

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

	public static String CaptureScreenShot_base1() throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String dynamicDate = sdf.format(date);
		String desty = "C:\\Users\\Lenovo\\eclipse-workspace\\Extent_Report\\src\\test\\resources\\Attachments\\screen_"+dynamicDate+".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(desty));
		return desty;
	}


}
