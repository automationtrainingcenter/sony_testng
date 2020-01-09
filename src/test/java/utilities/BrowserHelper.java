package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserHelper {

	protected WebDriver driver;

	public void openBrowser(String browserName, String url) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", GenericHelper.getFilePath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
//			driver.manage().window().setPosition(new Point(10, 40));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", GenericHelper.getFilePath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
//			driver.manage().window().setPosition(new Point(400, 40));
		} else {
			throw new RuntimeException("invalid browser name");
		}
		driver.get(url);
		driver.manage().window().maximize();
//		driver.manage().window().setSize(new Dimension(350, 300));
	}
	
	public void openBrowser(String browserName, String url, String nodeURL, String os) {
		DesiredCapabilities caps = new DesiredCapabilities();
		if(os.equals("windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}
		if(os.equals("mac")) {
			caps.setPlatform(Platform.MAC);
		}
		if(os.equals("linux")) {
			caps.setPlatform(Platform.LINUX);
		}
		if(browserName.equals("chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		if(browserName.equals("firefox")) {
			caps = DesiredCapabilities.firefox();
		}
		try {
			driver = new RemoteWebDriver(new URL(nodeURL), caps);
			driver.get(url);
			driver.manage().window().maximize();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}

	public void closeBrowser() {
		if (driver.getWindowHandles().size() > 1) {
			driver.quit();
		} else {
			driver.close();
		}
	}

	public void sleep(long timeInMills) {
		try {
			Thread.sleep(timeInMills);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
