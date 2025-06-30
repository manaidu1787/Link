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

public class Organization extends BaseTest {
	private By organizationHeaderText = By.xpath("//p[@class='headerLogoText']");
	private By addNewFamilyMemberButton = By.xpath("//span[text()='Add New Family Member']");
	private By settingsIcon = By.xpath("//img[@class='settingIconFix']");

	private static final Logger logger = LogManager.getLogger(Organization.class);

	public Organization(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void isOrgNameDisplayedAsExpected(String orgName, String env) {
		try {
			Thread.sleep(600);
			if (env.equals("load")) {
				driver.switchTo().window(WindowHandles.getSecondChildWindow());
			} else {
				driver.switchTo().window(WindowHandles.getChildWindow());
			}
			String actualOrgName = wait.until(ExpectedConditions.visibilityOfElementLocated(organizationHeaderText))
					.getText();
			Assert.assertEquals(orgName, actualOrgName);
			logger.info("User successfully navigated to the Organization Dashboard Page : " + orgName);
			test.pass("User successfully navigated to the Organization Dashboard Page : " + orgName);
		} catch (Exception e) {
			logger.error("User not able to navigate to the Organization Dashboard Page : ", e);
			test.fail("User not able to navigate to the Organization Dashboard Page : " + e.getMessage());
		}
	}

	public void clickOnSettingsIcon() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(settingsIcon)).click();
			logger.info("User Clicked on Settings Icon");
			test.pass("User Clicked on Settings Icon");
		} catch (Exception e) {
			logger.error("User not able to Click on Settings Icon: ", e);
			test.fail("User not able to Click on Settings Icon: " + e.getMessage());
		}
	}
}
