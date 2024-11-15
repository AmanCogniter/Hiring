package action;

import org.openqa.selenium.WebDriver;

import pageObjects.RequestEmployeePage;

public class RequestEmployeeAction {
	WebDriver driver;
	RequestEmployeePage requestEmployeePage;

	public RequestEmployeeAction(WebDriver driver) {
		this.driver = driver;

		requestEmployeePage = new RequestEmployeePage(driver);
	}

	public void goToHiringTab() {
		requestEmployeePage.clickFullMenuDropDown();
		requestEmployeePage.clickOnHiring();
		requestEmployeePage.clickOnRequestEmployee();

	}

	public void addRequest() {
		requestEmployeePage.clickOnAddRequestEmployee();
		requestEmployeePage.selectLinkedCompanyName();
		requestEmployeePage.clickOnResourceType();
		requestEmployeePage.selectProject();
		requestEmployeePage.clickOnCheckBox();
		requestEmployeePage.enterDecription();

		requestEmployeePage.clickOnSendRequest();

	}

	public void verifyRequestOnListingPAge() {

		requestEmployeePage.selectRequest();

		requestEmployeePage.clickOnSearchButton();
		requestEmployeePage.verifyRequestOnListingPage();

	}

	public void verifyDeleteFunctionalityOfRequestEmployee() {

		requestEmployeePage.selectRequest();

		requestEmployeePage.clickOnSearchButton();
		requestEmployeePage.clickOnCheckbox();
		requestEmployeePage.clickOnDelete();
		requestEmployeePage.clickOnConfirmationButton();

		requestEmployeePage.captureDeleteNotifyMessage();

	}

	public void verifyViewAssignedUsersButtonFunctionalityOfRequestEmployee() {

		requestEmployeePage.selectRequest();

		requestEmployeePage.clickOnSearchButton();
		requestEmployeePage.clickOnActionButton();
		requestEmployeePage.clickOnViewAssignedUsers();
		//requestEmployeePage.clickOnCloseButton();

	}
	public void addRequestWithNotSharingLicense() {
		requestEmployeePage.clickOnAddRequestEmployee();
		requestEmployeePage.selectLinkedCompanyName();
		requestEmployeePage.clickOnResourceType();
		requestEmployeePage.clickOnNoShareYourLicenseRadioButton();
		requestEmployeePage.selectProject();
		requestEmployeePage.enterNumberOfResources();
		requestEmployeePage.enterDecription();

		requestEmployeePage.clickOnSendRequest();

	}
	public void verifyViewButtonFunctionality() {

		requestEmployeePage.selectRequest();

		requestEmployeePage.clickOnSearchButton();
		requestEmployeePage.clickOnActionButton();
		requestEmployeePage.clickOnViewButton();
		//requestEmployeePage.clickOnCloseButton();

	}
	public void verifyEditButtonFunctionality() {

		requestEmployeePage.selectRequest();

		requestEmployeePage.clickOnSearchButton();
		requestEmployeePage.clickOnActionButton();
		requestEmployeePage.clickOnEditButton();
		requestEmployeePage.selectEditedLinkedCompanyName();
		requestEmployeePage.enterNumberOfResources();
		requestEmployeePage.clickOnCheckBox();
		requestEmployeePage.clickOnSendRequest();

	}
	public void verifyEditedRequestOnListingPAge() {

		requestEmployeePage.selectEditedRequest();

		requestEmployeePage.clickOnSearchButton();
		requestEmployeePage.verifyEditedRequestOnListingPage();

	}
	public void verifyDeleteFunctionalityOfEditedRequest() {

		requestEmployeePage.selectEditedRequest();

		requestEmployeePage.clickOnSearchButton();
		requestEmployeePage.clickOnCheckbox();
		requestEmployeePage.clickOnDelete();
		requestEmployeePage.clickOnConfirmationButton();

		requestEmployeePage.captureDeleteNotifyMessage();

	}
	public void addRequestWithVendor() {
		requestEmployeePage.clickOnAddRequestEmployee();
		requestEmployeePage.clickOnVendorRadioButton();
		requestEmployeePage.selectVendorLinkedCompanyName();
		
		requestEmployeePage.selectProject();
		requestEmployeePage.selectService();
		requestEmployeePage.enterDecription();

		requestEmployeePage.clickOnSendRequest();

	}

}
