package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.LoginAction;
import action.RequestEmployeeAction;
import utils.WebTestBase;

public class RequestEmployeeTest extends WebTestBase{
	static String Screenname = "<b> Hiring/b>";

	@Test(priority = 1)
	public void addRequest() {
		test = getTest(Screenname + ": Validation functionality of Add requset");
		RequestEmployeeAction requestEmployeeAction = new RequestEmployeeAction(driver);
		new LoginAction(driver).logoutLogin();
		requestEmployeeAction.goToHiringTab();
		requestEmployeeAction.addRequest();
	}
	@Test(priority = 2)
	public void ValidateRequestOnListingPage() {
		test = getTest(Screenname + ":Validate Request On Listing Page");
		RequestEmployeeAction requestEmployeeAction = new RequestEmployeeAction(driver);
		new LoginAction(driver).logoutLogin();
		requestEmployeeAction.goToHiringTab();
		requestEmployeeAction.verifyRequestOnListingPAge();
	}
	@Test(priority = 3)
	public void ValidateViewAssignedUsersButtonFunctionalityOfRequestEmployee() {
		test = getTest(Screenname + ":Validate View Assigned Users Button Functionality Of Request Employee");
		RequestEmployeeAction requestEmployeeAction = new RequestEmployeeAction(driver);
		new LoginAction(driver).logoutLogin();
		requestEmployeeAction.goToHiringTab();
		requestEmployeeAction.verifyViewAssignedUsersButtonFunctionalityOfRequestEmployee();
	}
	@Test(priority = 4)
	public void ValidateDeleteButtonFunctionalityOfRequestEmployee() {
		test = getTest(Screenname + ":Validate delete Button Functionality Of Request Employee");
		RequestEmployeeAction requestEmployeeAction = new RequestEmployeeAction(driver);
		new LoginAction(driver).logoutLogin();
		requestEmployeeAction.goToHiringTab();
		requestEmployeeAction.verifyDeleteFunctionalityOfRequestEmployee();
	}
	@Test(priority = 5)
	public void addRequestWithoutSharingLicense() {
		test = getTest(Screenname + ": Validation functionality of Add requset without sharing License");
		RequestEmployeeAction requestEmployeeAction = new RequestEmployeeAction(driver);
		new LoginAction(driver).logoutLogin();
		requestEmployeeAction.goToHiringTab();
		requestEmployeeAction.addRequestWithNotSharingLicense();
	}
	@Test(priority = 6)
		public void ValidateViewAssignedUsersButtonFunctionalityOfRequestEmployeeWithoutSharingLicense() {
			test = getTest(Screenname + ":Validate View Assigned Users Button Functionality Of Request Employee");
			RequestEmployeeAction requestEmployeeAction = new RequestEmployeeAction(driver);
			new LoginAction(driver).logoutLogin();
			requestEmployeeAction.goToHiringTab();
			requestEmployeeAction.verifyViewAssignedUsersButtonFunctionalityOfRequestEmployee();
		}
	@Test(priority = 7)
	public void ValidateViewButtonFunctionality() {
		test = getTest(Screenname + ":Validate View Button Functionality");
		RequestEmployeeAction requestEmployeeAction = new RequestEmployeeAction(driver);
		new LoginAction(driver).logoutLogin();
		requestEmployeeAction.goToHiringTab();
		requestEmployeeAction.verifyViewButtonFunctionality();
	}
	@Test(priority = 8)
	public void ValidateEditButtonFunctionality() {
		test = getTest(Screenname + ":Validate Edit Button Functionality");
		RequestEmployeeAction requestEmployeeAction = new RequestEmployeeAction(driver);
		new LoginAction(driver).logoutLogin();
		requestEmployeeAction.goToHiringTab();
		requestEmployeeAction.verifyEditButtonFunctionality();
	}
	@Test(priority = 9)
		public void ValidateDeleteButtonFunctionalityOfRequestEmployeeWithoutSharingLicense() {
			test = getTest(Screenname + ":Validate delete Button Functionality Of Request Employee Without Sharing License");
			RequestEmployeeAction requestEmployeeAction = new RequestEmployeeAction(driver);
			new LoginAction(driver).logoutLogin();
			requestEmployeeAction.goToHiringTab();
			requestEmployeeAction.verifyDeleteFunctionalityOfRequestEmployee();
		}
	//@Test(priority = 9)
	public void ValidateDeleteButtonFunctionalityOfEditedRequest() {
		test = getTest(Screenname + ":Validate delete Button Functionality Of Edited Request ");
		RequestEmployeeAction requestEmployeeAction = new RequestEmployeeAction(driver);
		new LoginAction(driver).logoutLogin();
		requestEmployeeAction.goToHiringTab();
		requestEmployeeAction.verifyDeleteFunctionalityOfEditedRequest();
	}
	@Test(priority = 10)
	public void addRequestWithVendor() {
		test = getTest(Screenname + ": Validation functionality of Add requset With Vendor");
		RequestEmployeeAction requestEmployeeAction = new RequestEmployeeAction(driver);
		new LoginAction(driver).logoutLogin();
		requestEmployeeAction.goToHiringTab();
		requestEmployeeAction.addRequestWithVendor();
	}
}
