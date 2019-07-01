package library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass 
{
	protected static WebDriver driver;
	protected ExtentHtmlReporter htmlReporter;
	protected ExtentReports extentReport;
	protected ExtentTest extentTest;
	
	UtilMethods util=new UtilMethods();


	public void getDriver()
	{
		String browser=util.getValueOf("browser").toLowerCase();

		switch(browser)
		{
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver=new ChromeDriver();
			break;

		case "ie":
			System.setProperty("webdriver.chrome.driver", "drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			break;

		default:
			System.out.println("Invalid browser has been selected.");

		}

		driver.manage().window().maximize();
		System.out.println("Browser launched.");
		driver.get(util.getValueOf("baseUrl").toLowerCase());
		//return driver;
	}
}
