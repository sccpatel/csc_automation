package csc_automation.testscript;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import csc_automation.webUtil.WebUtil;

public class BaseClass {

	protected WebUtil util = new csc_automation.webUtil.WebUtil();
	protected ExtentReports extent;
	ExtentSparkReporter extentReport;
	protected ExtentTest test;

	@BeforeTest
	public void setReport() {

//		String dateTime = util.findDateAndTime();
		String randomName =  util.getRandom(5);
		extentReport = new ExtentSparkReporter("ExtentReport\\Automation"+randomName+".html");

		extent = new ExtentReports();
		extent.attachReporter(extentReport);
		extent.setSystemInfo("UserNAme", "CSC Testing");
		extentReport.config().setDocumentTitle("CSC Report");
		extentReport.config().setReportName("Virendra Automation");
		extentReport.config().setTheme(Theme.STANDARD);
	}

	@BeforeMethod
	public void browserSetUp(Method testName) {
		test = extent.createTest(testName.getName());
		util.launchBrowser();
		test.log(Status.PASS, "Browser launched successfully");
		util.openUrl("https://digitalseva.csc.gov.in/");
		test.log(Status.PASS, "Url opened successfully");

	}

	@AfterMethod
	public void getReport(ITestResult result) {
		

		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));

			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.

			// String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
			// String screenshotPath = utill.takeSnapshot(result.getName());
			// To add it in the extent report

			try {
				test.pass("<b><font color=red>" + "Screenshot of failure " + "</font></b>");
//				util.takeSnapshot(result.getName());

			} catch (Exception e) {
				test.fail("Test Failed, can't attached screenshot");
			}
		} else if (result.getStatus() == ITestResult.SKIP) {

			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}

	}

	@AfterTest
	public void flush() {
		extent.flush();
		util.myQuit();

	}

}
