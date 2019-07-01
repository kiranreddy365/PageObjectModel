package reportTypes;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportType 
{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	
//	public ExtentReportType()
//	{
//		htmlReporter=new ExtentHtmlReporter("Reports/Report1.html");
//		htmlReporter.config().setDocumentTitle("Guru99Bank Testing");
//		htmlReporter.config().setReportName("Functional Testing");
//		htmlReporter.config().setTheme(Theme.DARK);
//
//		extentReport=new ExtentReports();
//		extentReport.attachReporter(htmlReporter);
//		extentReport.setSystemInfo("HostName", "LocalHost");
//		extentReport.setSystemInfo("Environment", "QA");
//		extentReport.setSystemInfo("Operating System", "Windows 10");
//		extentReport.setSystemInfo("Username", "Kiran");
//	}
}
