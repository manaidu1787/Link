package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import base.WindowHandles;

public class DashboardPage extends BaseTest {
	private By bibLogo = By.xpath("//img[@class='bibLogoSty']");
	private By signOutButton = By.xpath("//span[contains(text(), 'Sign Out')]");
	private By searchIcon = By.xpath("//button[@class='ant-btn ant-btn-link ant-btn-circle serOrgBtn']");
	private By logoutOption = By.xpath("//span[contains(text(), 'Log Out')]");
	private By warningPopupYesButton = By.xpath("//button[contains(text(), 'YES')]");
	private By myAccountOption = By.xpath("//li[contains(text(), 'My Account')]");
	private By profileDetailsTitle = By.xpath("//span[contains(text(), 'Profile Details')]");
	private By createPlanButton = By.xpath("//span[contains(text(), 'Create Plan')]");
	private By profileIcon = By.xpath("//div[contains(@id, 'profileIconActive')]");
	private By managePlans = By.xpath("//p[contains(text(), 'Manage Plans')]");
	private By manageCoupons = By.xpath("//p[contains(text(), 'Manage Coupons')]");
	private By createCouponButton = By.xpath("//span[contains(text(), 'Create Coupon')]");
	private By manageDevices = By.xpath("//p[contains(text(), 'Manage Devices')]");
	private By addDeviceButton = By.xpath("//span[contains(text(), 'Add Device')]");
	private By rolesAndPermissions = By.xpath("//p[contains(text(), 'Roles / Permissions')]");
	private By rolesAndPermissionsTitle = By.xpath("//span[contains(text(), 'Roles / Permission')]");	
	private By manageOrders = By.xpath("//p[contains(text(), 'Manage Orders')]");
	private By selectOrderStatusDropDown = By.xpath("//span[contains(text(), 'Select order status')]");	
	private By searchField = By.xpath("//input[@placeholder=\"Search\"]");
	private By familyUpdatedSuccessMessage = By.xpath("//*[contains(text(),'Family updated successfully')]");
	private By familyAddedSuccessMessage = By.xpath("//*[contains(text(),'Family added successfully')]");
	private By beneficiaryUpdatedSuccessMessage = By.xpath("//*[contains(text(),'Beneficiary updated successfully')]");
	private By beneficiaryAddedSuccessMessage = By.xpath("//*[contains(text(),'Beneficiary added successfully')]");
	private By searchedOrganization = By.xpath("//div[@class='orgShortNameContentSlicing']");
	private By addNewFamilyMemberButton = By.xpath("//span[text()='Add New Family Member']");
	private static final Logger logger = LogManager.getLogger(DashboardPage.class);

	public DashboardPage (WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void isDashboardPageDisplayed(String env) {
		try {
			Thread.sleep(2000);
			if (env.equals("load")) {
			driver.switchTo().window(WindowHandles.getChildWindow());
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(bibLogo)).isDisplayed();
			logger.info("User is on Dashboard Page ");
			test.pass("User is on Dashboard Page");
		} catch (Exception e) {
			logger.error("User not loggedin into Dashboard Page  ", e);
			test.fail("User not loggedin into Dashboard Page: " + e.getMessage());
		}
	}
	
	public void enterOrgNameOnSearchBar(String orgName) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys(orgName);
            Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys(Keys.ENTER);
            logger.info("User entered Org name on search field : " + orgName);
            test.pass("User entered Org name on search field : "+ orgName);
        } catch (Exception e) {
            logger.error("User not able to enter Org name on search field: ", e);
            test.fail("User not able to enter Org name on search field: " + e.getMessage());
        }
    }
	
	public void clickOnSearchedOrganization() {
        try {
        	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            wait.until(ExpectedConditions.elementToBeClickable(searchedOrganization)).click();
            logger.info("User Clicked on Searched Organization");
            test.pass("User Clicked on Searched Organization");
        } catch (Exception e) {
            logger.error("User not able to Clicked on Searched Organization: ", e);
            test.fail("User not able to Clicked on Searched Organization: " + e.getMessage());
        }
    }
	
//	public void clickAddNewFamilyMemberButton() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(addNewFamilyMemberButton)).click();
//            logger.info("User Clicked Add New Family Member Button");
//            test.pass("User Clicked Add New Family Member Button");
//        } catch (Exception e) {
//            logger.error("User not able to Click on Add New Family Member Button: ", e);
//            test.fail("User not able to Click on Add New Family Member Button: " + e.getMessage());
//        }
//    }	
//	public void isBeneficiaryAddedSuccessMessageDisplayed() {
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(beneficiaryAddedSuccessMessage)).isDisplayed();
//            logger.info("Beneficiay added success message is displayed ");
//            test.pass("Beneficiay added success message is displayed ");
//        } catch (Exception e) {
//            logger.error("Beneficiay added success message is not displayed : ", e);
//            test.fail("Beneficiay added success message is not displayed : " + e.getMessage());
//        }
//    }	
//	
//	public void isFamilyMemberAddedSuccessMessageDisplayed() {
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(familyAddedSuccessMessage)).isDisplayed();
//            logger.info("Family Member added success message is displayed ");
//            test.pass("Family Member added success message is displayed ");
//        } catch (Exception e) {
//            logger.error("Family Member added success message is not displayed : ", e);
//            test.fail("Family Member added success message is not displayed : " + e.getMessage());
//        }
//    }	
//	
	public void clickOnSearchIcon() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
            logger.info("User clicked on Search Icon");
            test.pass("User clicked on Search Icon");
        } catch (Exception e) {
            logger.error("User not able to click on Search Icon : ", e);
            test.fail("User not able to click on Search Icon: " + e.getMessage());
        }
    }	
	
	public void signOut() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(profileIcon)).click();
            wait.until(ExpectedConditions.elementToBeClickable(logoutOption)).click();
            logger.info("User Signed Out Successfully");
            test.pass("User Signed Out Successfully");
        } catch (Exception e) {
            logger.error("User not able to Signed Out : ", e);
            test.fail("User not able to Signed Out: " + e.getMessage());
        }
    }	
//	
//	public void clickOnYesButtonOnLogoutWarningPopup() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
//            wait.until(ExpectedConditions.elementToBeClickable(logoutOption)).click();
//            wait.until(ExpectedConditions.elementToBeClickable(warningPopupYesButton)).click();
//            logger.info("Platform Admin User Signed Out Successfully");
//            test.pass("Platform Admin User Signed Out Successfully");
//        } catch (Exception e) {
//            logger.error("Platform Admin User not able to Signed Out : ", e);
//            test.fail("Platform Admin User not able to Signed Out: " + e.getMessage());
//        }
//    }
//	
//	public void navigateToMyAccountDetails() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(userIcon)).click();
//            wait.until(ExpectedConditions.elementToBeClickable(myAccountOption)).click();
//             logger.info("Platform Admin user selects my accont option");
//            test.pass("Platform Admin user selects my accont option");
//        } catch (Exception e) {
//            logger.error("Platform Admin user not able to selects my accont option: ", e);
//            test.fail("Platform Admin user not able to selects my accont option: " + e.getMessage());
//        }
//    }	
//	
//	public void isMyAccountDetailsPageDisplayed() {
//        try {          
//            Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(profileDetailsTitle)).isDisplayed());
//            logger.info("Platform Admin user successfully navigate to my accont details page ");
//            test.pass("Platform Admin user successfully navigate to my accont details page");
//        } catch (Exception e) {
//            logger.error("Platform Admin is not able to navigate to my accont details page: ", e);
//            test.fail("Platform Admin is not able to navigate to my accont details page: " + e.getMessage());
//        }
//    }	
//	
//	public void navigateToManagePlansDetailsPage() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(managePlans)).click();
//            logger.info("Platform Admin user selects Manage Plans option");
//            test.pass("Platform Admin user selects Manage Plans option");
//        } catch (Exception e) {
//            logger.error("Platform Admin user not able to selects Manage Plans option: ", e);
//            test.fail("Platform Admin user not able to selects Manage Plans option: " + e.getMessage());
//        }
//    }
//	
//	public void isMangePlansDisplayed() {
//        try {          
//            Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(createPlanButton)).isDisplayed());
//            logger.info("Platform Admin user successfully navigate to Manage Plans details page ");
//            test.pass("Platform Admin user successfully navigate to Manage Plans details page");
//        } catch (Exception e) {
//            logger.error("Platform Admin is not able to navigate to Manage Plans details page: ", e);
//            test.fail("Platform Admin is not able to navigate to Manage Plans details page: " + e.getMessage());
//        }
//    }	
//	
//	public void navigateToManageCouponsDetailsPage() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(manageCoupons)).click();
//            logger.info("Platform Admin user selects Manage Coupons option");
//            test.pass("Platform Admin user selects Manage Coupons option");
//        } catch (Exception e) {
//            logger.error("Platform Admin user not able to selects Manage Coupons option: ", e);
//            test.fail("Platform Admin user not able to selects Manage Coupons option: " + e.getMessage());
//        }
//    }
//	
//	public void isMangeCouponsDisplayed() {
//        try {          
//            Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(createCouponButton)).isDisplayed());
//            logger.info("Platform Admin user successfully navigate to Manage Coupons details page ");
//            test.pass("Platform Admin user successfully navigate to Manage Coupons details page");
//        } catch (Exception e) {
//            logger.error("Platform Admin is not able to navigate to Manage Coupons details page: ", e);
//            test.fail("Platform Admin is not able to navigate to Manage Coupons details page: " + e.getMessage());
//        }
//    }
//	
//	public void navigateToManageDevicesDetailsPage() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(manageDevices)).click();
//            logger.info("Platform Admin user selects Manage Devices option");
//            test.pass("Platform Admin user selects Manage Devices option");
//        } catch (Exception e) {
//            logger.error("Platform Admin user not able to selects Manage Devices option: ", e);
//            test.fail("Platform Admin user not able to selects Manage Devices option: " + e.getMessage());
//        }
//    }
//	
//	public void isMangeDevicesDisplayed() {
//        try {          
//            Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(addDeviceButton)).isDisplayed());
//            logger.info("Platform Admin user successfully navigate to Manage Devices details page ");
//            test.pass("Platform Admin user successfully navigate to Manage Devices details page");
//        } catch (Exception e) {
//            logger.error("Platform Admin is not able to navigate to Manage Devices details page: ", e);
//            test.fail("Platform Admin is not able to navigate to Manage Devices details page: " + e.getMessage());
//        }
//    }	
//	
//	public void navigateToManageOrdersDetailsPage() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(manageOrders)).click();
//            logger.info("Platform Admin user selects Manage Orders option");
//            test.pass("Platform Admin user selects Manage Orders option");
//        } catch (Exception e) {
//            logger.error("Platform Admin user not able to selects Manage Orders option: ", e);
//            test.fail("Platform Admin user not able to selects Manage Orders option: " + e.getMessage());
//        }
//    }
//	
//	public void isMangeOrdersDisplayed() {
//        try {          
//            Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(selectOrderStatusDropDown)).isDisplayed());
//            logger.info("Platform Admin user successfully navigate to Manage Orders details page ");
//            test.pass("Platform Admin user successfully navigate to Manage Orders details page");
//        } catch (Exception e) {
//            logger.error("Platform Admin is not able to navigate to Manage Orders details page: ", e);
//            test.fail("Platform Admin is not able to navigate to Manage Orders details page: " + e.getMessage());
//        }
//    }	
//	
//	public void navigateToRolesAndPermissionsDetailsPage() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(rolesAndPermissions)).click();
//            logger.info("Platform Admin user selects Roles And Permissions option");
//            test.pass("Platform Admin user selects Roles And Permissions option");
//        } catch (Exception e) {
//            logger.error("Platform Admin user not able to selects Roles And Permissions option: ", e);
//            test.fail("Platform Admin user not able to selects Roles And Permissions option: " + e.getMessage());
//        }
//    }
//	
//	public void isRolesAndPermissionsDisplayed() {
//        try {          
//            Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(rolesAndPermissionsTitle)).isDisplayed());
//            logger.info("Platform Admin user successfully navigate to Roles And Permissions details page ");
//            test.pass("Platform Admin user successfully navigate to Roles And Permissions details page");
//        } catch (Exception e) {
//            logger.error("Platform Admin is not able to navigate to Roles And Permissions details page: ", e);
//            test.fail("Platform Admin is not able to navigate to Roles And Permissions details page: " + e.getMessage());
//        }
//    }	
}
