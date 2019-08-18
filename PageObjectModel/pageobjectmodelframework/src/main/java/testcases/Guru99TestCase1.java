package testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import library.BaseClass;
import library.CommonMethod;
import library.UtilMethods;
import pages.DeleteCustomerPage;
import pages.EditCustomerPage;
import pages.Guru99HomePage;
import pages.Guru99LoginPage;
import pages.NewAccountPage;
import pages.NewCustomerPage;

//@Listeners(commonLib.TestNGListeners.class)
public class Guru99TestCase1 extends BaseClass
{

	UtilMethods utilMethods=new UtilMethods();
	CommonMethod cm=new CommonMethod();
	Guru99LoginPage guru99LoginPage=new Guru99LoginPage();
	Guru99HomePage guru99Homepage=new Guru99HomePage();
	NewCustomerPage newcustomerpage=new NewCustomerPage();
	EditCustomerPage editcustomerpage=new EditCustomerPage();
	DeleteCustomerPage deletecustomer=new DeleteCustomerPage();


	@BeforeTest
	public void browserSetup()
	{
		getDriver();
		htmlReporter=new ExtentHtmlReporter("Reports/Report1.html");
		htmlReporter.config().setDocumentTitle("Guru99Bank Testing");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);

		extentReport=new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("HostName", "LocalHost");
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("Operating System", "Windows 10");
		extentReport.setSystemInfo("Username", "Kiran");
	}
	
	@Test(priority=0)
	public void loginAppFails()
	{
		extentTest=extentReport.createTest("Login Test");
		guru99LoginPage.loginToGuru99Bank(utilMethods.getValueOf("guru99username"), utilMethods.getValueOf("guru99password"));
		Assert.assertTrue(guru99LoginPage.loginToGuru99BankFails(utilMethods.getValueOf("guru99username")+"2", utilMethods.getValueOf("guru99password")));
	}


	@Test(priority=1)
	public void loginApp()
	{
		extentTest=extentReport.createTest("Login Test");
		guru99LoginPage.loginToGuru99Bank(utilMethods.getValueOf("guru99username"), utilMethods.getValueOf("guru99password"));
		Assert.assertTrue(guru99Homepage.verifyHomePage());
	}

	@Test(priority=2)
	public void createNewCustomer()
	{
		extentTest=extentReport.createTest("New Customer");
		newcustomerpage.navigateToNewCustomerPage();
		newcustomerpage.createNewCustomer();
		Assert.assertTrue(newcustomerpage.verifyCustomerSuccessfulRegistration());
	}

	@Test(priority=3)
	public void editCustomer()
	{
		extentTest=extentReport.createTest("Edit Customer");
		editcustomerpage.navigateToEditCustomer();
		editcustomerpage.EditCustomer();
		Assert.assertTrue(editcustomerpage.verifyEditCustomerSuccessful());
	}

	@Test(priority=4)
	public void deleteCustomer()
	{
		extentTest=extentReport.createTest("Delete Customer");
		deletecustomer.navigateToDeleteCustomer();
		deletecustomer.deleteCustomer(utilMethods.getValueOf("customerId"));
		Assert.assertTrue(true);
	}

	@Test(priority=5)
	public void test1()
	{
		extentTest=extentReport.createTest("Failed Test");
		Assert.assertTrue(false);
	}

	@Test(priority=6)
	public void test2()
	{
		extentTest=extentReport.createTest("Skipped Test");
		throw new SkipException("");
	}

	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			extentTest.log(Status.FAIL, "Test Case Failed : "+result.getName()); //to add name to extent report
			extentTest.log(Status.FAIL, "Test Case Failed : "+result.getThrowable()); //to add error/exception in extent report

			String screenshotPath=cm.captureScreenshot(result.getName()); //adding screenshot

			try {
				extentTest.addScreenCaptureFromPath(screenshotPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (result.getStatus()==ITestResult.SKIP){

			extentTest.log(Status.SKIP, "Test Case Skipped : "+result.getName()); 
		}

		else if (result.getStatus()==ITestResult.SUCCESS){

			extentTest.log(Status.PASS, "Test Case Success : "+result.getName()); 
		}
	}


	@AfterTest
	public void tearDown()
	{
		extentReport.flush();
		driver.quit();
	}


}
