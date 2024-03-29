package extent_Repo_Listen;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

public class MyListners extends Extent implements ITestListener {

	public static ExtentReports extend = Extent.report();
	ScreenShots sc = new ScreenShots();

	@Override
	public void onTestStart(ITestResult result) {
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String base = sc.CaptureScreenShot_base();
		String path= null;
		try {
			 path = sc.CaptureScreenShot_base1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extend.createTest("test 1").log(Status.INFO, "sec").addScreenCaptureFromBase64String(base);
		extend.createTest("test 1").log(Status.INFO, "sec").addScreenCaptureFromPath(path);
	}

	@Override
	public void onFinish(ITestContext context) {
		extend.flush();
	}
	
	

}
