package action;

import org.openqa.selenium.WebDriver;

import pageObjects.CandidateListPage;
import pageObjects.JobListPage;

public class JobListAction {
	WebDriver driver;
	JobListPage jobListPage;
	CandidateListPage candidateListPage ;
	public JobListAction(WebDriver driver) {
		this.driver = driver;
		jobListPage = new JobListPage(driver);
		candidateListPage = new CandidateListPage(driver);
	}

	public void goToHiringTab() {
		jobListPage.clickFullMenuDropDown();
		jobListPage.clickOnHiring();
		jobListPage.clickOnJobList();

	}

	public void validationCheck() {
		jobListPage.clickOnAddJobList();
		jobListPage.save();

		jobListPage.VerifyMandatoryFieldValidation();

	}

	public void addJob() {
		jobListPage.clickOnAddJobList();
		jobListPage.enterTitle();

		jobListPage.enterJobTitle();
		jobListPage.selectDesignation();
		jobListPage.enterPosition();
		jobListPage.selectDepartment();
		jobListPage.enterStartdate();
		jobListPage.enterClosedate();
		jobListPage.selectLocation();
		jobListPage.selectCurrency();
		jobListPage.selectSalleryFrequency();
		jobListPage.selectJobType();

		jobListPage.selectSkill();
		jobListPage.enterShortDescription();
		jobListPage.selectStatus();
		jobListPage.enterDescription();
		jobListPage.selectGraduation();
		jobListPage.selectPostGraduation();
		jobListPage.selectDoctorate();
		//jobListPage.selectStatus();
		jobListPage.save();
		jobListPage.clickOnConfirmationButton();
		jobListPage.captureNotifyMessage();

	}
	public void verifyJobOnListingPAge() {
		jobListPage.clickOnJobTitle();
		jobListPage.enterJobTitleIntoSearchField();

		jobListPage.clickOnSearchButton();
		jobListPage.verifyJobOnListingPage();

	}
	public void verifyJobDeleteFunctionality() {
		jobListPage.clickOnJobTitle();
		jobListPage.enterJobTitleIntoSearchField();

		jobListPage.clickOnSearchButton();
		jobListPage.verifyJobOnListingPage();
		jobListPage.clickOnCheckBox();
		jobListPage.clickOnDeleteButton();
		jobListPage.clickOnConfirmationButton();
		jobListPage.captureDeleteNotifyMessage();

	}
	public void verifyJobUpDateFunctionality() {
		jobListPage.clickOnJobTitle();
		jobListPage.enterJobTitleIntoSearchField();

		jobListPage.clickOnSearchButton();
		jobListPage.verifyJobOnListingPage();
		jobListPage.clickOnActionButton();
		jobListPage.clickOnEdit();
		jobListPage.save();
		jobListPage.clickOnConfirmationButton();
		jobListPage.captureUpdateNotifyMessage();

	}
	public void verifyCloneFunctionality() {
		jobListPage.clickOnJobTitle();
		jobListPage.enterJobTitleIntoSearchField();

		jobListPage.clickOnSearchButton();
		jobListPage.verifyJobOnListingPage();
		jobListPage.clickOnActionButton();
		jobListPage.clickOnClone();
		jobListPage.save();
		jobListPage.clickOnConfirmationButton();
		jobListPage.captureCloneNotifyMessage();

	}
	public void verifyAddNewCandidateFunctionality() {
		jobListPage.clickOnJobTitle();
		jobListPage.enterJobTitleIntoSearchField();

		jobListPage.clickOnSearchButton();
		jobListPage.verifyJobOnListingPage();
		jobListPage.clickOnActionButton();
		jobListPage.clickOnAddNewCandidate();
		candidateListPage.selectJob();
		candidateListPage.enterFirstName();
		candidateListPage.enterLastName();
		candidateListPage.enterEmail();
		//candidateListPage.enterMobileNumber();
		candidateListPage.save();
		candidateListPage.captureNotifyMessageOfAddCandidate();

	}
	public void verifyJobUpDateFunctionalityOfView() {
		jobListPage.clickOnJobTitle();
		jobListPage.enterJobTitleIntoSearchField();

		jobListPage.clickOnSearchButton();
		jobListPage.verifyJobOnListingPage();
		jobListPage.clickOnActionButton();
		jobListPage.clickOnView();
		jobListPage.clickOnEdit();
		jobListPage.save();
		jobListPage.clickOnConfirmationButton();
		jobListPage.captureUpdateNotifyMessage();

	}
	public void verifyAddAsCandidateFunctionalityOfView() {
		jobListPage.clickOnJobTitle();
		jobListPage.enterJobTitleIntoSearchField();

		jobListPage.clickOnSearchButton();
		jobListPage.verifyJobOnListingPage();
		jobListPage.clickOnActionButton();
		jobListPage.clickOnView();
		jobListPage.clickOnAddAsCandidate();
		candidateListPage.selectJob();
		candidateListPage.enterFirstName();
		candidateListPage.enterLastName();
		candidateListPage.enterEmail();
		//candidateListPage.enterMobileNumber();
		candidateListPage.save();
		candidateListPage.captureNotifyMessageOfAddCandidate();

	}
}
