package banking.testng_framework;
// using page factory

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {

	private WebDriver driver;

	// branches
	@FindBy(how = How.CSS, using = "a[href *= 'banker']")
	private WebElement branches;

	// logout
	@FindBy(css = "a[href *= 'primus']")
	private WebElement logout;

	// role
	@FindBy(how = How.CSS, using = "a[href *= 'Roles']")
	private WebElement role;

	// employee
	@FindBy(how = How.CSS, using = "a[href *= 'Emp']")
	private WebElement employee;

	// users
	@FindBy(how = How.CSS, using = "a[href *= 'user']")
	private WebElement users;

	// home
	@FindBy(how = How.CSS, using = "a[href *= 'adminflow']")
	private WebElement home;

	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BranchDetailsPage clickBranches() {
		this.branches.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}

	public BankHomePage clickLogout() {
		this.logout.click();
		return new BankHomePage(driver);
	}
	
	// validate admin home page is displayed or not
	public boolean isAdminHomePageDisplayed() {
		return this.logout.isDisplayed() && driver.getTitle().contains("Primus BANK");
	}

}
