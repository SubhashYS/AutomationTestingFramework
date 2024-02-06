package testcases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends Base{

	WebDriver driver; //global declaration
	
	public RegisterTest() {
		super();
	}
	
	public int randomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(9999);
		return randomNumber;
	}
	
	@BeforeMethod
	public void setup() {
		
		driver = launchBrowserAndEnterApplicationURL();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectRegisterOption();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority = 1)
	public void registerWithAllTheMandatoryFields() throws Exception {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail("narendra"+randomNumber()+"@gmail.com");
		registerPage.enterTelephone(prop.getProperty("telePhone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));
		
		registerPage.selectAgreePrivacyPolicy();	
		registerPage.clickOnContinueButton();
	}

	// 2 test case - enter all valid fields and also NewsLetter subscription as Yes
	@Test(priority = 2)
	public void registerWithAllMandatoryFieldsAlongWithNewsLetterSubscriptionAsYes() throws Exception {
	
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail("narendra"+randomNumber()+"@gmail.com");
		registerPage.enterTelephone(prop.getProperty("telePhone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));
		registerPage.selectNewsLetterSubscriptionAsYes();
		
		registerPage.selectAgreePrivacyPolicy();	
		registerPage.clickOnContinueButton();

	}

	@Test(priority = 3)
	public void registerAccountWithAllFieldsButNotSelectingPrivacyPolicy() throws Exception {

		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(prop.getProperty("firstName"));
		registerPage.enterLastName(prop.getProperty("lastName"));
		registerPage.enterEmail("narendra"+randomNumber()+"@gmail.com");
		registerPage.enterTelephone(prop.getProperty("telePhone"));
		registerPage.enterPassword(prop.getProperty("password"));
		registerPage.enterConfirmPassword(prop.getProperty("password"));
		
		registerPage.selectNewsLetterSubscriptionAsYes();

		// Not selecting privacy policy

		// click on Continue button
		registerPage.clickOnContinueButton();
		
	}

	@Test(priority = 4)
	public void registerAccountWithoutEnteringAnyFields() throws InterruptedException {	

		RegisterPage registerPage = new RegisterPage(driver);
		// click on Continue button without entering any input
		registerPage.clickOnContinueButton();
		
	}
}
