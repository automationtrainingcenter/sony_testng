package banking.testng_framework;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BasicExecution extends TestExecution {

	// launch browser
	@BeforeClass(groups = { "dd", "branch", "create", "reset", "cancel", "valid" })
	public void launchBrowser() {
		openBrowser("chrome", "http://primusbank.qedgetech.com/");
	}

}
