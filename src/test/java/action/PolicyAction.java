package action;

import org.openqa.selenium.WebDriver;

import pageObjects.PolicyPage;

public class PolicyAction {
	WebDriver driver;
	PolicyPage policyPage;

	public PolicyAction(WebDriver driver) {
		this.driver = driver;
		policyPage = new PolicyPage(driver);

	}

	public void goToHiringTab() {
		policyPage.clickFullMenuDropDown();
		policyPage.clickOnHiring();
		policyPage.clickOnPolicy();

	}

	public void validationCheck() {
		policyPage.clickOnAddPolicy();
		policyPage.save();

		policyPage.VerifyMandatoryFieldValidation();

	}

	public void addPolicy() {
		policyPage.clickOnAddPolicy();
		policyPage.enterPolicyName();
		policyPage.enterDescription();
		policyPage.selectdepartment();
		policyPage.enterDurationOfProbationPeriod();
		policyPage.selectdepartmentOfNoticePeriod();
		policyPage.enterDurationOfNoticeonPeriod();
		policyPage.save();
		policyPage.captureNotifyMessage();
	}

	public void verifyPolicyNameOnListingPage() {
		policyPage.clickOnPolicyNameSearchFilter();
		policyPage.enterPolicyNameIntoSearchField();
		policyPage.clickOnSearchButton();
		policyPage.verifyPolcyName();

	}

	public void verifyEditFunctionality() {
		policyPage.clickOnPolicyName();
		policyPage.save();
		policyPage.captureupdateNotifyMessage();

	}

	public void verifyDeleteButtonFunctionalityOfPolicy() {

		policyPage.clickOnCheckBox();
		policyPage.clickOndelete();
		policyPage.clickOnConfirmationButton();
		policyPage.captureDeleteNotifyMessage();
	}

	public void verifyStatusFunctionality() {
		policyPage.selectInActiveStatus();
		policyPage.clickOnConfirmationButton();
		policyPage.selectActiveStatus();
		policyPage.clickOnConfirmationButton();

	}
	public void verifyProbationPeriodPage() {
		policyPage.clickOnProbationPeriod();
		

	}
	public void verifyNoticePeriodPage() {
		policyPage.clickOnNoticePeriod();
		

	}

}
