package banking.testng_framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BankHomePage {
	private WebDriver driver;
	
	
	// username
	public WebElement username() {
		WebElement uname =  driver.findElement(By.id("txtuId"));
		return uname;
	}
	
	// password
	public WebElement password() {
		return driver.findElement(By.id("txtPword"));
	}
	
	// login button
	public WebElement login() {
		return driver.findElement(By.id("login"));
	}
	
	// constructor
	public BankHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	// fill username
	public void fillUserName(String username) {
//		WebElement uname = this.username();
//		uname.sendKeys(username);
		this.username().sendKeys(username);
	}
	
	
	// fill password
	public void fillPassword(String password) {
		this.password().sendKeys(password);
	}
	
	
	// click login button
	public void clickLogin() {
		this.login().click();
	}
}
