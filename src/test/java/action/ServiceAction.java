package action;

import org.openqa.selenium.WebDriver;

import pageObjects.ServicePage;

public class ServiceAction {
	WebDriver driver;
	ServicePage servicePage;
	
	public ServiceAction(WebDriver driver) {
		this.driver = driver;
		
		servicePage = new ServicePage(driver);
	}
	public void goToHiringTab() {
		servicePage.clickFullMenuDropDown();
		servicePage.clickOnHiring();
		servicePage.clickOnService();

	}
	public void goTOHiringTab() {
		servicePage.clickFullMenuDropDown();
		servicePage.clickOnHiring();
		servicePage.clickonService();

	}

	public void validationCheck() {
		servicePage.clickOnAddService();
		servicePage.save();

		servicePage.VerifyMandatoryFieldValidation();

	}
	public void addService() {
		servicePage.clickOnAddService();
		servicePage.enterServiceName();

		servicePage.selectStatus();
		servicePage.enterDescription();
		servicePage.save();
		servicePage.captureNotifyMessage();

	}
	public void verifyServiceNameOnListingPAge() {
		
		servicePage.enterServiceNameIntoSearchField();

		servicePage.clickOnsearchButton();
		servicePage.verifyServiceNameOnListingPage();

	}
	public void verifyServiceStatusFunctionalityOnListingPAge() {
		
		servicePage.enterServiceNameIntoSearchField();

		servicePage.clickOnsearchButton();
		servicePage.verifyServiceNameOnListingPage();
		servicePage.selectInActiveStatus();
		servicePage.clickOnConfirmationButton();
		servicePage.selectActiveStatus();
		servicePage.clickOnConfirmationButton();
		

	}
	public void verifyServiceAssignFunctionalityOnListingPAge() {
		
		servicePage.clickOnAssignService();

		servicePage.selectService();
		servicePage.save();
		servicePage.captureAssignServiceNotifyMessage();
		
		

	}
	public void verifyServiceDeleteFunctionality() {
		
		servicePage.enterServiceNameIntoSearchField();

		servicePage.clickOnsearchButton();
		servicePage.verifyServiceNameOnListingPage();
		servicePage.clickOnCheckBox();
		servicePage.clickOnDelete();
		servicePage.clickOnConfirmationButton();
		servicePage.captureDeleteNotifyMessage();

	}
public void verifyServiceDeleteFunctionalityForAssignService() {
		
		servicePage.enterServiceNameIntoSearchField();

		servicePage.clickOnsearchButton();
		servicePage.verifyServiceNameOnListingPage();
		servicePage.clickOnCheckBox();
		servicePage.clickOnDelete();
		servicePage.clickOnConfirmationButton();
		servicePage.captureDeleteNotifyMessage();

	}
}
