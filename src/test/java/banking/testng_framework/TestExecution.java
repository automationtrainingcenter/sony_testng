package banking.testng_framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.BrowserHelper;
import utilities.ExcelHelper;

public class TestExecution extends BrowserHelper {
	AdminHomePage adminHomePage;
	private BranchDetailsPage branchDetailsPage;
	private BranchCreationPage branchCreationPage;

	@AfterClass(groups = { "dd", "branch", "create", "reset", "cancel", "valid" })
	public void teardown() {
		closeBrowser();
	}

	// login
	@Test(priority = 1, groups = { "dd", "branch", "create", "reset", "cancel", "valid" })
	public void logintest() {
		BankHomePage bankHomePage = new BankHomePage(driver);
		bankHomePage.fillUserName("Admin");
		bankHomePage.fillPassword("Admin");
		bankHomePage.clickLogin();
		sleep(3000);
	}

	// branch creation with valid data
	@Test(priority = 2, groups = { "create", "valid", "branch" })
	public void branchCreationWithValidData() {
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		branchCreationPage.fillBranchName("anynewbranchname");
		branchCreationPage.fillAddress1("some new address");
		branchCreationPage.fillZipcode("12345");
		branchCreationPage.selectCountry("UK");
		branchCreationPage.selectState("England");
		branchCreationPage.selectCity("LONDON");
		Alert alert = branchCreationPage.clickSubmit();
		System.out.println("alert is " + alert.getText());
		Reporter.log("alert is " + alert.getText());
		alert.accept();
	}

	// branch creation reset
	@Test(priority = 3, groups = { "reset", "branch" })
	public void branchCreationReset() {
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		branchCreationPage.fillBranchName("anynewbranchname");
		branchCreationPage.fillAddress1("some new address");
		branchCreationPage.fillZipcode("12345");
		branchCreationPage.selectCountry("UK");
		branchCreationPage.selectState("England");
		branchCreationPage.selectCity("LONDON");
		branchCreationPage = branchCreationPage.clickReset();
	}

	// branch creation cancel
	@Test(priority = 4, groups = { "cancel", "valid", "branch" })
	public void branchCreationCancel() {
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		branchDetailsPage = branchCreationPage.clickCancel();
	}

	@Test(priority = 5, groups = { "dd" })
	public void branchCreationResetWithExcelData() {
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		ExcelHelper obj = new ExcelHelper();
		obj.openExcel("resources", "testdata.xlsx", "branchData");
		int nor = obj.rowCount();
		int noc = obj.columnCount();
		for (int r = 1; r <= nor; r++) {
			branchCreationPage.fillBranchName(obj.readData(r, 0));
			branchCreationPage.fillAddress1(obj.readData(r, 1));
			branchCreationPage.fillZipcode(obj.readData(r, 2));
			branchCreationPage.selectCountry(obj.readData(r, 3));
			branchCreationPage.selectState(obj.readData(r, 4));
			branchCreationPage.selectCity(obj.readData(r, 5));
			branchCreationPage = branchCreationPage.clickReset();
			sleep(3000);
		}

		obj.closeExcel();
	}

	@DataProvider(name = "branches")
	public Object[][] getBranchData() {
		ExcelHelper excel = new ExcelHelper();
		String[][] data = excel.getExcelData("resources", "testdata.xlsx", "branchData");
		return data;

	}

	@Test(priority = 6, groups = { "dd_dp" }, dataProvider="branches")
	public void branchCreationResetWithDP(String branchName, String address, String zipcode, String country,
			String state, String city) {
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewBranch();
		branchCreationPage.fillBranchName(branchName);
		branchCreationPage.fillAddress1(address);
		branchCreationPage.fillZipcode(zipcode);
		branchCreationPage.selectCountry(country);
		branchCreationPage.selectState(state);
		branchCreationPage.selectCity(city);
		branchCreationPage = branchCreationPage.clickReset();
		sleep(3000);
	}

//	@DataProvider(name = "testdata")
//	public Object[][] getData(){
//		String[][] data = {{"1", "surya", "python"}, 
//					  	   {"2", "prakash", "selenium"}, 
//					  	   {"3", "teja", "testing"}};
//		return data;
//	}
//	
//	
//	@Test(dataProvider = "testdata")
//	public void testDP(String id, String name, String course) {
//		System.out.println("id = "+id);
//		System.out.println("name = "+name);
//		System.out.println("course = "+course);
//		
//	}
}
