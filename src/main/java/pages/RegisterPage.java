package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void enterFirstName(String firstName) {
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		driver.findElement(By.id("input-email")).sendKeys(email);
	}
	
	public void enterTelephone(String telephone) {
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(By.id("input-password")).sendKeys(pass);
	}
	
	public void enterConfirmPassword(String confirmPass) {
		driver.findElement(By.id("input-confirm")).sendKeys(confirmPass);
	}
	
	public void selectAgreePrivacyPolicy() {
		driver.findElement(By.name("agree")).click(); // click on privacy policy
	}
	
	public void clickOnContinueButton() {
		driver.findElement(By.xpath("//input[@type='submit']")).click(); // click on Continue button
	}
	
	public void selectNewsLetterSubscriptionAsYes() {
		driver.findElement(By.name("newsletter")).click();// Select news letter subscription - Yes
	}
	
	
	
	
	
	
	
	
	
}
