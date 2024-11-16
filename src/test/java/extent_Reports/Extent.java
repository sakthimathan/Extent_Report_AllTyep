package extent_Reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent extends ScreenShots {

	public static ExtentReports report() throws IOException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String ReportTime = sdf.format(date);
		
		ExtentReports repo = new ExtentReports();
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace_Sakthi\\Extent_Report\\target\\MyReport\\genarel_"+ReportTime+".html");
		ExtentSparkReporter spark = new ExtentSparkReporter(file);
		repo.attachReporter(spark);

		String base = CaptureScreenShot_base();
		String path =CaptureScreenShot_base("facebook.png");
		
		repo.createTest("test1 ").log(Status.INFO, "sec").addScreenCaptureFromBase64String(base);
		repo.createTest("test2").log(Status.INFO, "sec").addScreenCaptureFromPath(path);
		
		repo.flush();
		// Automatic open report
		Desktop.getDesktop().browse(file.toURI());

		return repo;

	}

}
