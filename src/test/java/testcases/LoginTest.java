package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Utilities;

public class LoginTest extends Base{

	WebDriver driver;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		driver = launchBrowserAndEnterApplicationURL();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void loginWithValidUsernameAndValidPassword() throws Exception {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickOnLoginButton();
		
		AccountPage accountPage = new AccountPage(driver);
		accountPage.verifyLoginSuccessfulText();
	}
	
	//2nd test case - Valid Username and Invalid Password
	@Test(priority = 2)
	public void loginWithValidUsernameAndInvalidPassword() throws Throwable {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.enterPassword(prop.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		loginPage.verifyLoginWarningMessageText();
		//Utilities util = new Utilities(driver);
		//util.takeScreenshot();
	}
	
	//3rd test case - Invalid Username and Valid Password
	@Test(priority = 3)
	public void loginWithInvalidUsernameAndValidPassword() throws Throwable {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(prop.getProperty("invalidUsername"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickOnLoginButton();	
		loginPage.verifyLoginWarningMessageText();
	}
	
	//4th test case - No Username and No Password and click on Login
	@Test(priority = 4)
	public void loginWithNoUsernameAndNoPassword() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnLoginButton();	
		loginPage.verifyLoginWarningMessageText();
	}
}