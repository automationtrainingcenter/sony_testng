package banking.testng_framework;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridExecution extends TestExecution{
	// launch browser
		@BeforeClass(groups= {"dd", "branch", "create", "reset", "cancel", "valid"})
		@Parameters({"browser", "url", "nodeURL", "os"})
		public void launchBrowser(String browserName, String appUrl, String nodeURL, String os) {
			openBrowser(browserName, appUrl, nodeURL, os);
		}

}
