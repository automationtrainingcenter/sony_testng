package banking.testng_framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationPage {

	private WebDriver driver;

	// branch name
	@FindBy(id = "txtbName")
	private WebElement branchName;

	// address1
	@FindBy(id = "txtAdd1")
	private WebElement address1;

	// zipcode
	@FindBy(id = "txtZip")
	private WebElement zipcode;

	// country
	@FindBy(id = "lst_counrtyU")
	private WebElement country;

	// state
	@FindBy(id = "lst_stateI")
	private WebElement state;

	// city
	@FindBy(id = "lst_cityI")
	private WebElement city;

	// submit
	@FindBy(id = "btn_insert")
	private WebElement submit;

	// reset
	@FindBy(id = "Btn_Reset")
	private WebElement reset;

	// cancel
	@FindBy(id = "Btn_cancel")
	private WebElement cancel;

	public BranchCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// fill branch name
	public void fillBranchName(String branchName) {
		this.branchName.sendKeys(branchName);
	}

	// fill address1
	public void fillAddress1(String address1) {
		this.address1.sendKeys(address1);
	}

	// fill zip code
	public void fillZipcode(String zipcode) {
		this.zipcode.sendKeys(zipcode);
	}

	// select country
	public void selectCountry(String country) {
		// selecting an option using visible text
		Select countrySel = new Select(this.country);
		countrySel.selectByVisibleText(country);
	}

	// select state
	public void selectState(String state) {
		Select stateSel = new Select(this.state);
		stateSel.selectByVisibleText(state);
	}

	// select city
	public void selectCity(String city) {
		Select citySel = new Select(this.city);
		citySel.selectByVisibleText(city);
	}

	// click submit
	public Alert clickSubmit() {
		this.submit.click();
		return this.driver.switchTo().alert();
	}

	// click reset
	public BranchCreationPage clickReset() {
		this.reset.click();
		return this;
	}

	// click cancel
	public BranchDetailsPage clickCancel() {
		this.cancel.click();
		return PageFactory.initElements(driver, BranchDetailsPage.class);
	}
	
	// verify form is reset or not
	public boolean isFormReset() {
		return JavaScriptHelper.getElementText(driver, this.branchName).isEmpty();
	}
}
