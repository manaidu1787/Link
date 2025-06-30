package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import base.BaseTest;

public class LocationsPage extends BaseTest {
	private By addLocationButton = By.xpath("//button[@aria-label='addNewLocation']");
	private By addSubLocationButton = By.xpath("//span[contains(text(), 'Add Sublocation')]");
	private By locationsHeaderText = By
			.xpath("//div[@class='pl-vw locationLoading']/span[contains(text(),'Locations')]");
	private By locationName = By.xpath("//input[@placeholder='Location Name']");
	private By subLocationName = By.xpath("//input[@placeholder='Sublocation Name']");
	private By deleteLocationOptionOnPopup = By.xpath("//span[contains(text(), 'Delete Location')]");
	private By deleteLocationSuccessMessage = By.xpath("//div[contains(text(), 'Location Deleted Successfully')]");
	
	

	private static final Logger logger = LogManager.getLogger(LocationsPage.class);
	Actions actions;

	public LocationsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		actions=new Actions(driver);
	}

	public void verifyLocationsHeaderOnLocationsPage() {
		try {
			Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(locationsHeaderText)).isDisplayed());
			logger.info("Locations heading is visible");
			test.pass("Locations heading is visible");

		} catch (AssertionError e) {
			logger.error("Locations heading is not visible: ", e);
			test.fail("Locations heading is not visible: " + e.getMessage());
		}
	}

	public void clickAddLocation() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(addLocationButton)).click();
			logger.info("Add location button clicked successfully");
			test.pass("Add location button clicked successfully");
		} catch (Exception e) {
			logger.info("Unable to click add location button: ", e);
			test.fail("Unable to click add location button: " + e.getMessage());
		}
	}

	public void enterLocationName(String name) {
		try {

			wait.until(ExpectedConditions.elementToBeClickable(locationName)).sendKeys(name);
			wait.until(ExpectedConditions.elementToBeClickable(locationName)).sendKeys(Keys.ENTER);
			logger.info("User entered the Location Name :" + name);
			test.pass("User entered the Location Name :" + name);

		} catch (AssertionError e) {
			logger.info("User not able to enter the Location Name: ", e);
			test.fail("User not able to enter the Location Name: " + e.getMessage());

		}
	}

	public void selectALocationName(String locationName) {
		try {
			By location = By.xpath("//label[contains(text(), '" + locationName + "')]");
			Actions actions=new Actions(driver);
			actions.clickAndHold(wait.until(ExpectedConditions.visibilityOfElementLocated(location))).build().perform();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(location)).click();
			logger.info("User selected the Location Name :" + locationName);
			test.pass("User selected the Location Name  :" + locationName);

		} catch (AssertionError e) {
			logger.info("User not able select the Location Name: ", e);
			test.fail("User not able select the Location Name: " + e.getMessage());

		}
	}

	public void clickAddButtonOnSubLocation() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(addSubLocationButton)).click();
			logger.info("Add Sub Location button clicked successfully");
			test.pass("Add Sub Location button clicked successfully");
		} catch (Exception e) {
			logger.info("Unable to click add sub location button: ", e);
			test.fail("Unable to click add sub location button: " + e.getMessage());
		}
	}

	public void enterSubLocationName(String name) {
		try {

			wait.until(ExpectedConditions.elementToBeClickable(subLocationName)).sendKeys(name);
			wait.until(ExpectedConditions.elementToBeClickable(subLocationName)).sendKeys(Keys.ENTER);

			logger.info("User entered the Sub Location Name :" + name);
			test.pass("User entered the Sub Location Name :" + name);

		} catch (AssertionError e) {
			logger.info("User not able to enter the Sub Location Name: ", e);
			test.fail("User not able to enter the Sub Location Name: " + e.getMessage());

		}
	}

	public void updateSubLocationName(String newName) throws InterruptedException {
		try {
			Actions actions=new Actions(driver);
	        WebElement inputField = driver.findElement(By.id("basic_locationName"));
		        String currentValue = inputField.getAttribute("value");
		        for (int i = 0; i < currentValue.length(); i++) {
		            actions.sendKeys(Keys.BACK_SPACE).perform();		           
		        }
		        Thread.sleep(200);
		        actions.sendKeys(newName).build().perform(); 
		        Thread.sleep(200);
		        actions.sendKeys(Keys.ENTER).build().perform();
		        Thread.sleep(200);
			logger.info("User updated the Sub Location Name :" + newName);
			test.pass("User updated the Sub Location Name :" + newName);

		} catch (AssertionError e) {
			logger.info("User not able to update the Sub Location Name: ", e);
			test.fail("User not able to update the Sub Location Name: " + e.getMessage());

		}
	}

	public void selectASubLocationName(String subLocationName) {
		try {
			By location = By.xpath("//label[contains(text(), '" + subLocationName + "')]");
			
			Actions actions=new Actions(driver);			
			actions.click(wait.until(ExpectedConditions.visibilityOfElementLocated(location))).build().perform();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(location)).click();
			logger.info("User selected the Sub Location Name :" + subLocationName);
			test.pass("User selected the Sub Location Name  :" + subLocationName);

		} catch (AssertionError e) {
			logger.info("User not able select the Sub Location Name: ", e);
			test.fail("User not able select the Sub Location Name: " + e.getMessage());

		}
	}

	public void clickSubLocationEditIcon(String subLocationName) {
		try {
			By location = By.xpath("//label[contains(text(), '" + subLocationName + "')]//following::img[@alt='edit']");
			wait.until(ExpectedConditions.visibilityOfElementLocated(location)).click();
//			wait.until(ExpectedConditions.elementToBeClickable(subLocationName)).sendKeys(name);
//			wait.until(ExpectedConditions.elementToBeClickable(subLocationName)).sendKeys(Keys.ENTER);
//			
			logger.info("User clicked Sub Location edit icon :" + subLocationName);
			test.pass("User clicked Sub Location edit icon :" + subLocationName);

		} catch (AssertionError e) {
			logger.info("User not able to click on the Sub Location edit icon: ", e);
			test.fail("User not able to click on the Sub Location edit icon: " + e.getMessage());

		}
	}

	public void editSubLocationName(String name) {
		try {

			wait.until(ExpectedConditions.elementToBeClickable(subLocationName)).sendKeys(name);
			wait.until(ExpectedConditions.elementToBeClickable(subLocationName)).sendKeys(Keys.ENTER);

			logger.info("User entered the Sub Location Name :" + name);
			test.pass("User entered the Sub Location Name :" + name);

		} catch (AssertionError e) {
			logger.info("User not able to enter the Sub Location Name: ", e);
			test.fail("User not able to enter the Sub Location Name: " + e.getMessage());

		}
	}

	public void deleteSubLocationName(String subLocationName) {
		try {			
			By location = By
					.xpath("//label[contains(text(), '" + subLocationName + "')]//following::img[@alt='delete']");
			wait.until(ExpectedConditions.visibilityOfElementLocated(location)).click();
			logger.info("User clicked Sub Location delete icon :" + subLocationName);
			test.pass("User clicked Sub Location delete icon :" + subLocationName);

		} catch (AssertionError e) {
			logger.info("User not able to click on the Sub Location delete icon: ", e);
			test.fail("User not able to click on the Sub Location delete icon: " + e.getMessage());
		}
	}
	public void isDeleteSubLocationWarningPopupDisplayed() {
		try {
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(deleteLocationOptionOnPopup)).isDisplayed());
			logger.info("User able to see the Delete Sub Location warning Popup");
			test.pass("User able to see the Delete Sub Location warning Popup");

		} catch (AssertionError e) {
			logger.info("User not able to see the Delete Sub Location warning Popup: ", e);
			test.fail("User not able to see the Delete Sub Location warning Popup: " + e.getMessage());
		}
	}
	public void confirmDeleteSubLocationOnPopup() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(deleteLocationOptionOnPopup)).click();
			logger.info("User able to confirm the Delete Sub Location on Popup");
			test.pass("User able to confirm the Delete Sub Location on Popup");

		} catch (AssertionError e) {
			logger.info("User not able to confirm the Delete Sub Location on Popup: ", e);
			test.fail("User not able to confirm the Delete Sub Location on Popup: " + e.getMessage());
		}
	}
	
	
	public void isDeleteSubLocationSuccessMessageDisplayed() {
		try {
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(deleteLocationSuccessMessage)).isDisplayed());
			logger.info("User able to see the Delete Sub Location Success Message");
			test.pass("User able to see the Delete Sub Location Success Message");

		} catch (AssertionError e) {
			logger.info("User not able to see the Delete Sub Location Success Message: ", e);
			test.fail("User not able to see the Delete Sub Location Success Message: " + e.getMessage());
		}
	}
	
	public void clickLocationEditIcon(String locationName) {
		try {
			By location = By.xpath("//label[contains(text(), '" + locationName + "')]//following::img[@alt='edit']");
			wait.until(ExpectedConditions.visibilityOfElementLocated(location)).click();		
			logger.info("User clicked Location edit icon :" + locationName);
			test.pass("User clicked Location edit icon :" + locationName);

		} catch (AssertionError e) {
			logger.info("User not able to click on the Location edit icon: ", e);
			test.fail("User not able to click on the Location edit icon: " + e.getMessage());

		}
	}

	public void editLocationName(String name) {
		try {

			wait.until(ExpectedConditions.elementToBeClickable(locationName)).sendKeys(name);
			wait.until(ExpectedConditions.elementToBeClickable(locationName)).sendKeys(Keys.ENTER);
			logger.info("User entered the Location Name :" + name);
			test.pass("User entered the Location Name :" + name);

		} catch (AssertionError e) {
			logger.info("User not able to enter the Location Name: ", e);
			test.fail("User not able to enter the Location Name: " + e.getMessage());

		}
	}
	
	public void updateLocationName(String newName) throws InterruptedException {
		try {
			Actions actions=new Actions(driver);
	        WebElement inputField = driver.findElement(By.id("basic_locationName"));
		        String currentValue = inputField.getAttribute("value");
		        for (int i = 0; i < currentValue.length(); i++) {
		            actions.sendKeys(Keys.BACK_SPACE).perform();		           
		        }
		        Thread.sleep(200);
		        actions.sendKeys(newName).build().perform(); 
		        Thread.sleep(200);
		        actions.sendKeys(Keys.ENTER).build().perform();
		        Thread.sleep(500);
			logger.info("User updated the Location Name :" + newName);
			test.pass("User updated the Location Name :" + newName);

		} catch (AssertionError e) {
			logger.info("User not able to update the Location Name: ", e);
			test.fail("User not able to update the Location Name: " + e.getMessage());

		}
	}
	
	public void deleteLocationName(String locationName) throws InterruptedException {
		try {
			Thread.sleep(500);
			By location = By
					.xpath("//label[contains(text(), '" + locationName + "')]//following::img[@alt='delete']");
			WebElement e=driver.findElement(location);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 Thread.sleep(1000);
			js.executeScript("arguments[0].click();", e);
				logger.info("User clicked Location delete icon :" + locationName);
			test.pass("User clicked Location delete icon :" + locationName);

		} catch (AssertionError e) {
			logger.info("User not able to click on the Location delete icon: ", e);
			test.fail("User not able to click on the Location delete icon: " + e.getMessage());
		}
	}
	public void isDeleteLocationWarningPopupDisplayed() {
		try {
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(deleteLocationOptionOnPopup)).isDisplayed());
			logger.info("User able to see the Delete Location warning Popup");
			test.pass("User able to see the Delete Location warning Popup");

		} catch (AssertionError e) {
			logger.info("User not able to see the Delete Location warning Popup: ", e);
			test.fail("User not able to see the Delete Location warning Popup: " + e.getMessage());
		}
	}
	public void confirmDeleteLocationOnPopup() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(deleteLocationOptionOnPopup)).click();
			logger.info("User able to confirm the Delete Location on Popup");
			test.pass("User able to confirm the Delete Location on Popup");

		} catch (AssertionError e) {
			logger.info("User not able to confirm the Delete Location on Popup: ", e);
			test.fail("User not able to confirm the Delete Location on Popup: " + e.getMessage());
		}
	}
	
	
	public void isDeleteLocationSuccessMessageDisplayed() {
		try {
			Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(deleteLocationSuccessMessage)).isDisplayed());
			logger.info("User able to see the Delete Location Success Message");
			test.pass("User able to see the Delete Location Success Message");

		} catch (AssertionError e) {
			logger.info("User not able to see the Delete Location Success Message: ", e);
			test.fail("User not able to see the Delete Location Success Message: " + e.getMessage());
		}
	}
}