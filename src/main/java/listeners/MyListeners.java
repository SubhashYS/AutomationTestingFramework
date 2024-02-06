package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentReporter;
import utils.Utilities;

public class MyListeners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;
	WebDriver driver;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Project Tests started Executing");
		extentReport = ExtentReporter.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testCaseName = result.getName();
		extentTest = extentReport.createTest(testCaseName);
		extentTest.log(Status.INFO, testCaseName + " - started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testCaseName = result.getName();
		extentTest.log(Status.PASS, testCaseName + " - Successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testCaseName = result.getName();
		extentTest.log(Status.FAIL, testCaseName + " - got failed");

		//we need driver
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {		
			e.printStackTrace();
		}
		
		
		// add screenshot for the failed test case
		String destScreenshotPath = Utilities.takeScreenshot(driver, testCaseName);

		// And Attach Screenshot to Extent Report
		extentTest.addScreenCaptureFromPath(destScreenshotPath);
				
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testCaseName = result.getName();
		extentTest.log(Status.SKIP, testCaseName + " - got skipped");
		extentTest.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		extentTest.log(Status.INFO, "All the testcases executed successfully");
		extentReport.flush();
	}
}
