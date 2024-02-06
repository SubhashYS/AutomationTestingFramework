package utils;

import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	
	public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReports = new ExtentReports();
		
		//File extentReportPath = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html");
		File extentReportPath = new File("C:\\SeleniumFramework\\SeleniumMavenProjectBatch2\\test-output\\ExtentReport\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Selenium Project Report");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReports.attachReporter(sparkReporter);
		
		extentReports.setSystemInfo("Application URL", "https://tutorialsninja.com/demo/");
		extentReports.setSystemInfo("Browser name", "Chrome");
		extentReports.setSystemInfo("Username", "subbutop5@gmail.com");
		extentReports.setSystemInfo("Password", "Password@123");
		
		return extentReports;
	}
}
