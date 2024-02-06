package pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void takeScreenshot(WebDriver driver) throws Throwable {

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\Screenshots\\ScreenshotImage.png");
		FileUtils.copyFile(src, dest);

	}

	public void enterUserName(String email) {
		driver.findElement(By.id("input-email")).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);// Valid password
	}

	public void clickOnLoginButton() {
		driver.findElement(By.xpath("//input[@type='submit']")).click(); // clicks on Login
	}

	public void verifyLoginWarningMessageText() throws Throwable {
		String actualText = driver.findElement(By.xpath("//i[@class='fa fa-exclamation-circle']")).getText();
		//Assert.assertTrue(actualText.contains("No match for E-Mail Address and/or Password"));
		Assert.assertTrue(actualText.contains("ABC"));
		//takeScreenshot(driver);
	}
}
