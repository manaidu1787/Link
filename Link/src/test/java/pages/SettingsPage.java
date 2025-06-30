package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;
import base.WindowHandles;

public class SettingsPage extends BaseTest {
	
	private By locationsTab = By.xpath("//span[contains(text(),'Locations')]");
	private By devicesTab = By.xpath("//span[contains(text(),'Devices')]"); 
	private By settigsHeaderText = By.xpath("//span[contains(text(),'General Settings')]");
	private By addNewFamilyMemberButton = By.xpath("//span[text()='Add New Family Member']");
	private By settingsIcon = By.xpath("//img[@class='settingIconFix']");

	private static final Logger logger = LogManager.getLogger(SettingsPage.class);

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void isSettingsPageDisplayed() {
		try {
			Assert.assertTrue(
					wait.until(ExpectedConditions.visibilityOfElementLocated(settigsHeaderText)).isDisplayed());
			logger.info("User successfully navigated to the Settings Page ");
			test.pass("User successfully navigated to the Settings Page");
		} catch (Exception e) {
			logger.error("User not able to navigate to the Settings Page : ", e);
			test.fail("User not able to navigate to the Settings Page : " + e.getMessage());
		}
	}

	public void selectLocationsTab() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locationsTab)).click();
			logger.info("User selected Locations Tab");
			test.pass("User selected Locations Tab");
		} catch (Exception e) {
			logger.error("User not able to select Locations Tab: ", e);
			test.fail("User not able to select Locations Tab: " + e.getMessage());
		}
	}
	
	public void selectDevicesTab() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(devicesTab)).click();
			logger.info("User selected Devices Tab");
			test.pass("User selected Devices Tab");
		} catch (Exception e) {
			logger.error("User not able to select Devices Tab: ", e);
			test.fail("User not able to select Devices Tab: " + e.getMessage());
		}
	}
}