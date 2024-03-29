package extent_Reports;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Execution extends base {

	@Test
	public static void Runner() throws IOException {

		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Extent.report();
	}

}
