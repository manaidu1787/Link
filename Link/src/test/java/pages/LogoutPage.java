package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;

public class LogoutPage extends BaseTest {
	private static final Logger logger = LogManager.getLogger(LogoutPage.class);

	private WebElement returnToSignInPage = driver.findElement(By.id("LinkReturnToApplication"));
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}	
	
	public void clickReturnToSignInPage() {
		try {
			wait.until(ExpectedConditions.visibilityOf(returnToSignInPage)).click();		
			logger.info("Return To SignIn Page Clicked");
			test.pass("Return To SignIn Page Clicked");
		} catch (AssertionError e) {
			logger.info("Unable to click on Return To SignIn Page");
			test.fail("Unable to click on Return To SignIn Page");
		}		
	}
}
