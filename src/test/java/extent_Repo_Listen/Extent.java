package extent_Repo_Listen;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent extends ScreenShots {

	public static ExtentReports report()   {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String dynamicDate = sdf.format(date);
		String reportPath = "C:\\Users\\Lenovo\\eclipse-workspace\\Extent_Report\\target\\MyReport\\ereport_"+dynamicDate+".html";
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter report = new ExtentSparkReporter(reportPath);
		extent.attachReporter(report);
		return extent;

	}

}
