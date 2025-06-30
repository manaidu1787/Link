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

public class DevicesPage extends BaseTest{
	private By addDeviceButton = By.xpath("//button[@aria-label='Add Device']");
	private By dvicesHeaderText = By
			.xpath("//div[@class='ant-row deviceSetting-header']//div[contains(text(),'Devices')]");
	private By locationName = By.xpath("//input[@placeholder='Location Name']");
	private By subLocationName = By.xpath("//input[@placeholder='Sublocation Name']");
	private By deleteLocationOptionOnPopup = By.xpath("//span[contains(text(), 'Delete Location')]");
	private By deleteLocationSuccessMessage = By.xpath("//div[contains(text(), 'Location Deleted Successfully')]");
	
	

	private static final Logger logger = LogManager.getLogger(DevicesPage.class);

	public DevicesPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void verifyDevicesHeaderOnDevicesPage() {
		try {
			Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(dvicesHeaderText)).isDisplayed());
			logger.info("Devices heading is visible");
			test.pass("Devices heading is visible");

		} catch (AssertionError e) {
			logger.error("Devices heading is not visible: ", e);
			test.fail("Devices heading is not visible: " + e.getMessage());
		}
	}

	public void clickAddDevice() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(addDeviceButton)).click();
			logger.info("Add Device button clicked successfully");
			test.pass("Add Device button clicked successfully");
		} catch (Exception e) {
			logger.info("Unable to click add Device button: ", e);
			test.fail("Unable to click add Device button: " + e.getMessage());
		}
	}
}
