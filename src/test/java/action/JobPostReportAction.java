package action;

import org.openqa.selenium.WebDriver;

import pageObjects.JobPostReportPage;

public class JobPostReportAction {
	WebDriver driver;
	JobPostReportPage jobPostReportPage;

	public JobPostReportAction(WebDriver driver) {
		this.driver = driver;
		jobPostReportPage = new JobPostReportPage(driver);

	}

	public void goToHiringTab() {
		jobPostReportPage.clickFullMenuDropDown();
		jobPostReportPage.clickOnHiring();
		jobPostReportPage.clickOnJobPostReport();

	}
	public void verifyHiringReportWithDesignation() {
		jobPostReportPage.selectDesignation();
		jobPostReportPage.clickOnSearchButton();
		jobPostReportPage.verifyHiringReportWithDesignation();

	}
	public void verifyHiringReportWithStatus() {
		jobPostReportPage.selectStatus();
		jobPostReportPage.clickOnSearchButton();
		jobPostReportPage.verifyHiringReportWithStatus();

	}
	public void verifyStatusRadioButtonFunctionalityOfHiringReport() {
		jobPostReportPage.clickOnStatusRadioButton();
		jobPostReportPage.selectDesignation();
		jobPostReportPage.clickOnSearchButton();
		jobPostReportPage.verifyHiringReportWithStatus();

	}
	public void verifyStatusRadioButtonFunctionality() {
		jobPostReportPage.clickOnStatusRadioButton();
		jobPostReportPage.selectStatus();
		jobPostReportPage.clickOnSearchButton();
		jobPostReportPage.verifyHiringReportWithStatus();

	}

}
