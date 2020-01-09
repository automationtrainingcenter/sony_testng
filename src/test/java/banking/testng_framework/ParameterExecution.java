package banking.testng_framework;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterExecution extends TestExecution{
	// launch browser
		@BeforeClass(groups= {"dd", "branch", "create", "reset", "cancel", "valid"})
		@Parameters({"browser", "url"})
		public void launchBrowser(String browserName, String appUrl) {
			openBrowser(browserName, appUrl);
		}

}
