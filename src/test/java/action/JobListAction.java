package action;

import org.openqa.selenium.WebDriver;

import pageObjects.JobListPage;

public class JobListAction {
	WebDriver driver;
	JobListPage jobListPage;

	public JobListAction(WebDriver driver) {
		this.driver = driver;
		jobListPage = new JobListPage(driver);

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
		jobListPage.enterDescription();
		jobListPage.selectGraduation();
		jobListPage.selectPostGraduation();
		jobListPage.selectDoctorate();
		jobListPage.selectStatus();
		jobListPage.save();
		jobListPage.clickOnConfirmationButton();
		jobListPage.captureNotifyMessage();

	}
}
