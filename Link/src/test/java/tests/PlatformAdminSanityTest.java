package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.DevicesPage;
import pages.LocationsPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.Organization;
import pages.PlatformAdminDashboard;
import pages.SettingsPage;
import utils.ConfigReader;
import utils.PropertyUtils;
import utils.RandomDataGenerator;

public class PlatformAdminSanityTest extends BaseTest {

	private static final Logger logger = LogManager.getLogger(PlatformAdminSanityTest.class);
	public LoginPage loginPage;
	public LogoutPage logoutPage;
	public DashboardPage dashboardPage;
	public Organization organization;
	public SettingsPage settingsPage;
	public LocationsPage locationsPage;
	public DevicesPage devicesPage;
	public PlatformAdminDashboard platformAdminDashboard;

	@Test(priority = 2)
	@Parameters("env")
	public void testValidLoginAndLogOut(String env) throws InterruptedException {
		logger.info("Starting login test in environment: " + env);
		test = extent.createTest("Verify the Plafform Admin user should be able to login and logout successfully")
				.assignCategory("Regression").assignCategory("Login");
		if (env.equals("load")) {
			logoutPage = new LogoutPage(driver);
			Thread.sleep(1000);
			logoutPage.clickReturnToSignInPage();
			Thread.sleep(1000);
		}
		loginPage = new LoginPage(driver);
		String username = ConfigReader.get("platformAdminUsername");
		String password = ConfigReader.get("platformAdminPassword");
		loginPage.login(username, password);
		if (env.equals("load")) {
			platformAdminDashboard = new PlatformAdminDashboard(driver);
			platformAdminDashboard.clickOnLoadEnv();
		}
		dashboardPage = new DashboardPage(driver);
		dashboardPage.isDashboardPageDisplayed(env);
		dashboardPage.signOut();
	}
	
	@Test(priority = 2) 
	@Parameters("env")
	public void VerifyPlatformAdminFunctionalityOnLocationsScreen(String env) throws InterruptedException {
		test = extent.createTest("Verify the Platform Admin User Functionality on Locations Screen").assignCategory("Sanity");
		
		if (env.equals("load")) {
			logoutPage = new LogoutPage(driver);
			Thread.sleep(1000);
			logoutPage.clickReturnToSignInPage();
			Thread.sleep(1000);
		}
		
		loginPage = new LoginPage(driver);
		String username = ConfigReader.get("platformAdminUsername");
		String password = ConfigReader.get("platformAdminPassword");
		loginPage.login(username, password);
		if (env.equals("load")) {
			platformAdminDashboard = new PlatformAdminDashboard(driver);
			platformAdminDashboard.clickOnLoadEnv();
		}
		dashboardPage = new DashboardPage(driver);
		dashboardPage.isDashboardPageDisplayed(env);		
		dashboardPage.clickOnSearchIcon();
		String orgName = ConfigReader.get("orgName");
		dashboardPage.enterOrgNameOnSearchBar(orgName);
		dashboardPage.clickOnSearchedOrganization();
		organization=new Organization(driver);
		organization.isOrgNameDisplayedAsExpected(orgName, env);
		organization.clickOnSettingsIcon();
		settingsPage =new SettingsPage(driver);
		settingsPage.isSettingsPageDisplayed();
		settingsPage.selectLocationsTab();
		locationsPage=new LocationsPage(driver);
		locationsPage.verifyLocationsHeaderOnLocationsPage();
		String randomLocationName="Location_"+RandomDataGenerator.generateRandomName(5);
		PropertyUtils.writeOrUpdateProperty(env, "locationName", randomLocationName);
		locationsPage.clickAddLocation();
		locationsPage.enterLocationName(randomLocationName);
		locationsPage.selectALocationName(randomLocationName);		
		locationsPage.clickAddButtonOnSubLocation();
		String randomSubLocationName="SubLocation_"+RandomDataGenerator.generateRandomName(5);
		PropertyUtils.writeOrUpdateProperty(env, "subLocationName", randomSubLocationName);
		locationsPage.enterSubLocationName(randomSubLocationName);
		locationsPage.selectASubLocationName(randomSubLocationName);
		locationsPage.clickSubLocationEditIcon(randomSubLocationName);
		String randomUpdatedSubLocationName="SubLocation_"+RandomDataGenerator.generateRandomName(5);
		PropertyUtils.writeOrUpdateProperty(env, "subLocationName", randomUpdatedSubLocationName);
		locationsPage.updateSubLocationName(randomUpdatedSubLocationName);		
		locationsPage.deleteSubLocationName(randomUpdatedSubLocationName);
		locationsPage.isDeleteSubLocationWarningPopupDisplayed();
		locationsPage.confirmDeleteSubLocationOnPopup();
		locationsPage.isDeleteSubLocationSuccessMessageDisplayed();
		locationsPage.selectALocationName(randomLocationName);
		locationsPage.clickLocationEditIcon(randomLocationName);
		String randomUpdatedLocationName="Location_"+RandomDataGenerator.generateRandomName(5);
		PropertyUtils.writeOrUpdateProperty(env, "locationName", randomLocationName);
		locationsPage.updateLocationName(randomUpdatedLocationName);		
		locationsPage.deleteLocationName(randomUpdatedLocationName);
		locationsPage.isDeleteLocationWarningPopupDisplayed();
		locationsPage.confirmDeleteLocationOnPopup();
		locationsPage.isDeleteLocationSuccessMessageDisplayed();		
	}

	@Test(priority = 2)
	@Parameters("env")
	public void VerifyPlatformAdminFunctionalityOnDevicesScreen(String env) throws InterruptedException {
		test = extent.createTest("Verify the Platform Admin User Functionality on Devices Screen")
				.assignCategory("Sanity");

		if (env.equals("load")) {
			logoutPage = new LogoutPage(driver);
			Thread.sleep(1000);
			logoutPage.clickReturnToSignInPage();
			Thread.sleep(1000);
		}
		loginPage = new LoginPage(driver);
		String username = ConfigReader.get("platformAdminUsername");
		String password = ConfigReader.get("platformAdminPassword");

		loginPage.login(username, password);
		if (env.equals("load")) {
			platformAdminDashboard = new PlatformAdminDashboard(driver);
			platformAdminDashboard.clickOnLoadEnv();
		}
		dashboardPage = new DashboardPage(driver);
		dashboardPage.isDashboardPageDisplayed(env);
		dashboardPage.clickOnSearchIcon();
		String orgName = ConfigReader.get("orgName");
		dashboardPage.enterOrgNameOnSearchBar(orgName);
		dashboardPage.clickOnSearchedOrganization();
		organization = new Organization(driver);
		organization.isOrgNameDisplayedAsExpected(orgName, env);
		organization.clickOnSettingsIcon();
		settingsPage = new SettingsPage(driver);
		settingsPage.isSettingsPageDisplayed();
		settingsPage.selectDevicesTab();
		devicesPage = new DevicesPage(driver);
		devicesPage.verifyDevicesHeaderOnDevicesPage();
		devicesPage.clickAddDevice();
		Thread.sleep(5000);

//        hs.clickOnDevicesMenuOnWhiteSidebar();
//        Thread.sleep(2000);
//        de.clickAddDeviceButtonOnDevices();
//        Thread.sleep(2000);
//        ls.VerifyPassingDeviceNameValue();
//        Thread.sleep(2000);
//        ls.SelectDeviceLocationValueInAddDeviceScreen();
//        Thread.sleep(2000);
//        de.clickAddDeviceButtonInAddDeviceScreen();
//        Thread.sleep(2000);
//        hs.clickOnLocationsMenuOnWhiteSidebar();
//        Thread.sleep(2000);
//        ls.clickDeleteButtonNewlyCreatedLocationOnLocationScreen();
//        Thread.sleep(2000);
//        ls.clickRelocateLocationDropdownOnLocationsPage();
//        Thread.sleep(2000);
//        ls.selectLocationUsingArrowKeys();
//        Thread.sleep(2000);
//        ls.clickRelocateAndDeleteButtonOnLocationsPage();
//        Thread.sleep(2000);
//        hs.clickOnDevicesMenuOnWhiteSidebar();
//        Thread.sleep(2000);
//        ls.clickDeviceAutomationdeviceOnDevicesScreen();
//        Thread.sleep(2000);
//        de.clickDeleteButtonOnDeviceDetailsScreen();
//        Thread.sleep(2000);
//        de.clickConformButtonInDeleteDevicePopupOnDeviceDetailsScreen();
//        Thread.sleep(2000);
//        hs.clickOnLocationsMenuOnWhiteSidebar();
//        Thread.sleep(2000);
//        ls.clickAddButtonOnLocationsPage();
//        Thread.sleep(2000);
//        ls.EntervalueInLocationInputTextBox();
//        Thread.sleep(2000);
//        ls.clickAddButtonOnLocationsPage();
//        Thread.sleep(2000);
//        ls.clickAddButtonOnLocationsPage();
//        Thread.sleep(2000);
//        ls.EntervalueInLocationInputTextBox();
//        Thread.sleep(2000);
//        ls.clickAddButtonOnLocationsPage();
//        Thread.sleep(2000);
//        ls.verifyErrorMessageOnLocationScreen();
//        Thread.sleep(2000);
//        ls. DeletinglocationForValidationMessage();
//        Thread.sleep(2000);
//        ls.clickDeleteButtonInDeleteLocationTextboxOnLocationsPage();
//        Thread.sleep(2000);
//        hs.clickOnAuditLogMenuOnWhiteSidebar();
//        Thread.sleep(3000);
//        al.verifyLocationCreatedAuditOnAuditlogs();
//        Thread.sleep(2000);
//        hs.clickOnProfileIcon();
//		Thread.sleep(3000);
//		hs.clickOnLogout();
//		Thread.sleep(5000);
	}
}
