package extent_Repo_Listen;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Execution extends base {

	@Test()
	public static void Runner() {

		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}

}
