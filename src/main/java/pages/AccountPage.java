package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountPage {

	WebDriver driver;
	public AccountPage(WebDriver driver){
		this.driver = driver;
	}
	
	public void verifyLoginSuccessfulText() {
		String expectedText = "Edit your account information";
		String actualText = driver.findElement(By.linkText("Edit your account information")).getText();
		Assert.assertEquals(expectedText, actualText);
	}
}
