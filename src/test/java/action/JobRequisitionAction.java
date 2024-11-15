package action;

import org.openqa.selenium.WebDriver;

import pageObjects.GroupListPage;
import pageObjects.JobRequisitionPage;

public class JobRequisitionAction {
	WebDriver driver;
	JobRequisitionPage jobRequisitionPage;

	public JobRequisitionAction(WebDriver driver) {
		this.driver = driver;
		jobRequisitionPage = new JobRequisitionPage(driver);

	}

	public void goToHiringTab() {
		jobRequisitionPage.clickFullMenuDropDown();
		jobRequisitionPage.clickOnHiring();
		jobRequisitionPage.clickOnJobRequisition();

	}

	public void validationCheck() {
		jobRequisitionPage.clickOnAddJobRequisition();
		jobRequisitionPage.save();

		jobRequisitionPage.VerifyMandatoryFieldValidation();

	}
	public void  addjobRequisition()
	{
		jobRequisitionPage.clickOnAddJobRequisition();
		jobRequisitionPage.selectdesignation();
		jobRequisitionPage.enterPosition();
		jobRequisitionPage.selectdepartment();
		jobRequisitionPage.selectLocation();
		jobRequisitionPage.enterStartSallry();
		jobRequisitionPage.enterSallryTo();
		jobRequisitionPage.selectExperienceFrom();
		jobRequisitionPage.selectExperienceTo();
		jobRequisitionPage.enterReason();
		jobRequisitionPage.save();
		
		
		
	}
	public void  verifyJobRequisitionOnListingPage()
	{
		jobRequisitionPage.enterDesignitionIntoSearchField();
		jobRequisitionPage.clickOnSearchButton();
		jobRequisitionPage.verifyDesignationOnListingPage();
		
		
		
	}
	public void  verifyDeleteButtonFunctionality()
	{
		jobRequisitionPage.enterDesignitionIntoSearchField();
		jobRequisitionPage.clickOnSearchButton();
		jobRequisitionPage.verifyDesignationOnListingPage();
		jobRequisitionPage.clickOnCheckBox();
		jobRequisitionPage.clickOndelete();
		jobRequisitionPage.clickOnConfirmationButton();
		jobRequisitionPage.captureDeleteNotifyMessage();
	}
	public void  verifyViewButtonFunctionality()
	{
		jobRequisitionPage.enterDesignitionIntoSearchField();
		jobRequisitionPage.clickOnSearchButton();
		jobRequisitionPage.verifyDesignationOnListingPage();
		jobRequisitionPage.clickOnActionButton();
		jobRequisitionPage.clickOnView();
		jobRequisitionPage.clickOnBackToList();
		
	}
	public void  verifyEditButtonFunctionality()
	{
		jobRequisitionPage.enterDesignitionIntoSearchField();
		jobRequisitionPage.clickOnSearchButton();
		jobRequisitionPage.verifyDesignationOnListingPage();
		jobRequisitionPage.clickOnActionButton();
		jobRequisitionPage.clickOnEdit();
		jobRequisitionPage.save();
		
	}
	public void  verifyRejectButtonFunctionality()
	{
		jobRequisitionPage.enterDesignitionIntoSearchFieldForReject();
		jobRequisitionPage.clickOnSearchButton();
		jobRequisitionPage.verifyDesignationOnListingPageForReject();
		jobRequisitionPage.clickOnActionButton();
		jobRequisitionPage.clickOnReject();
		jobRequisitionPage.enterComment();
		jobRequisitionPage.clickOnSaveComment();
		
	}
	public void  addjobRequisitionForRejectFunctionality()
	{
		jobRequisitionPage.clickOnAddJobRequisition();
		jobRequisitionPage.clickOnAddDesignation();
		jobRequisitionPage.enterDesignationName();
		jobRequisitionPage.selectStatus();
		jobRequisitionPage.clickOnSaveDesignation();
		//jobRequisitionPage.clickOnClose();
		jobRequisitionPage.selectdesignationForReject();
		jobRequisitionPage.enterPosition();
		jobRequisitionPage.selectdepartment();
		jobRequisitionPage.selectLocation();
		jobRequisitionPage.enterStartSallry();
		jobRequisitionPage.enterSallryTo();
		jobRequisitionPage.selectExperienceFrom();
		jobRequisitionPage.selectExperienceTo();
		jobRequisitionPage.enterReason();
		jobRequisitionPage.save();
		
		
		
	}
	public void  verifyJobRequisitionOnListingPageForRejectFunctionality()
	{
		jobRequisitionPage.enterDesignitionIntoSearchFieldForReject();
		jobRequisitionPage.clickOnSearchButton();
		jobRequisitionPage.verifyDesignationOnListingPageForReject();
		
		
		
	}
	public void  verifyDeleteButtonFunctionalityOfRejectedRequisition()
	{
		jobRequisitionPage.enterDesignitionIntoSearchFieldForReject();
		jobRequisitionPage.clickOnSearchButton();
		jobRequisitionPage.verifyDesignationOnListingPageForReject();
		jobRequisitionPage.clickOnCheckBox();
		jobRequisitionPage.clickOndelete();
		jobRequisitionPage.clickOnConfirmationButton();
		jobRequisitionPage.captureDeleteNotifyMessage();
	}
}
