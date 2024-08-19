package action;

import org.openqa.selenium.WebDriver;

import pageObjects.VendorListingPage;

public class VendorListingAction {
	WebDriver driver;
	VendorListingPage vendorListingPage;

	public VendorListingAction(WebDriver driver) {
		this.driver = driver;
		vendorListingPage = new VendorListingPage(driver);

	}

	public void goToHiringTab() {
		vendorListingPage.clickFullMenuDropDown();
		vendorListingPage.clickOnHiring();
		vendorListingPage.clickOnVendorList();

	}

	public void validationCheck() {
		vendorListingPage.clickOnAddVendorList();
		vendorListingPage.save();
		
		vendorListingPage.VerifyMandatoryFieldValidation();

	}
	public void addVendorListing() {
		vendorListingPage.clickOnAddVendorList();
		vendorListingPage.enterCompanyName();
		
		vendorListingPage.enterFirstName();
		vendorListingPage.enterLastName();
		vendorListingPage.enterEmail();
		vendorListingPage.enterPassword();
		vendorListingPage.enterConfirmPassword();
		vendorListingPage.selectCountry();
		vendorListingPage.enterState();
		vendorListingPage.enterCity();
		vendorListingPage.enterAddress();
		vendorListingPage.enterAddress2();
		vendorListingPage.enterZipCode();
		vendorListingPage.enterMobileNumber();
		vendorListingPage.save();
		vendorListingPage.captureNotifyMessage();

	}
	public void verifyVendorOnListingPage() {
		vendorListingPage.enterVendorNameIntoSearchField();
		vendorListingPage.clickOnSearchButton();
		vendorListingPage.clickOnSearchButton();
		vendorListingPage.verifyVendor();

	}
}
