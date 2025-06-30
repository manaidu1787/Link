package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class PlatformAdminDashboard extends BaseTest {
	private By searchedOrganization = By.xpath("//div[@class='orgShortNameContentSlicing']");
	private By loadLink = By.xpath("//span[contains(text(), 'LOAD')]");
	
	private static final Logger logger = LogManager.getLogger(PlatformAdminDashboard.class);

	public PlatformAdminDashboard (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void clickOnLoadEnv() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(loadLink)).click();
			logger.info("User selected Load Env on Platform Admin Dashboard");
			test.pass("User selected Load Env on Platform Admin Dashboard");
		} catch (Exception e) {
			logger.error("User not able to select Load Env on Platform Admin Dashboard : ", e);
			test.fail("User not able to select Load Env on Platform Admin Dashboard : " + e.getMessage());
		}
	}
}
