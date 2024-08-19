package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.LoginAction;
import action.TalentPoolListAction;
import action.VendorListingAction;
import utils.WebTestBase;

public class VendorListingTest extends WebTestBase{
	static String Screenname ="<b> Hiring/b>";
	@Test(priority=1)
	public void validationCheck()
	{
		test=getTest(Screenname + ": Validation message on Add Talent Pool List");
		VendorListingAction vendorListingAction = new VendorListingAction(driver);
		new LoginAction(driver).logoutLogin();
		vendorListingAction.goToHiringTab();
		vendorListingAction.validationCheck();
	}
	@Test(priority=2)
	public void addVendorListing()
	{
		test=getTest(Screenname + ": Add Vendor Listing");
		VendorListingAction vendorListingAction = new VendorListingAction(driver);
		new LoginAction(driver).logoutLogin();
		vendorListingAction.goToHiringTab();
		vendorListingAction.addVendorListing();
	}
	@Test(priority=3)
	public void ValidateVendorOnListingPAge()
	{
		test=getTest(Screenname + ": Validate Vendor on Listing Page");
		VendorListingAction vendorListingAction = new VendorListingAction(driver);
		new LoginAction(driver).logoutLogin();
		vendorListingAction.goToHiringTab();
		vendorListingAction.verifyVendorOnListingPage();
	} 
	
}
