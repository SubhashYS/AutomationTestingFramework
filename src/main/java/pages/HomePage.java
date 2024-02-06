package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
	}
	
	public void clickOnMyAccount() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
	}
	
	public void selectLoginOption() {
		driver.findElement(By.linkText("Login")).click();
	}
	
	public void selectRegisterOption() {
		driver.findElement(By.linkText("Register")).click(); // click on Register option
	}
	
}
