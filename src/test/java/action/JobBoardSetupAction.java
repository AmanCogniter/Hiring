package action;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import pageObjects.JobBoardSetupPage;

public class JobBoardSetupAction {
	WebDriver driver;
	JobBoardSetupPage jobBoardSetupPage;

	public JobBoardSetupAction(WebDriver driver) {
		this.driver = driver;
		jobBoardSetupPage = new JobBoardSetupPage(driver);

	}

	public void goToHiringTab() {
		jobBoardSetupPage.clickFullMenuDropDown();
		jobBoardSetupPage.clickOnHiring();
		jobBoardSetupPage.clickOnJobBoardSetup();

	}
	public void verifyLayoutPAge() {
		jobBoardSetupPage.clickOnSimpleRadioButton();
		jobBoardSetupPage.verifyLayoutPage();
		jobBoardSetupPage.clickOnSaveButton();
		jobBoardSetupPage.captureNotifyMessage();

	}
	public void verifyGeneralPAge() {
		jobBoardSetupPage.clickOnSimpleRadioButton();
		jobBoardSetupPage.clickOnGeneral();
		jobBoardSetupPage.verifyGeneralPage();
		jobBoardSetupPage.clickOnSaveButton();
		jobBoardSetupPage.captureNotifyMessage();

	}
	public void verifyAppearancePAge() {
		jobBoardSetupPage.clickOnSimpleRadioButton();
		jobBoardSetupPage.clickOnAppearance();
		jobBoardSetupPage.verifyAppearancePage();
		jobBoardSetupPage.clickOnSaveButton();
		jobBoardSetupPage.captureNotifyMessage();

	}
	public void verifyWebsiteAndSocialPAge() {
		jobBoardSetupPage.clickOnSimpleRadioButton();
		jobBoardSetupPage.clickOnWebsiteAndSocial();
		jobBoardSetupPage.verifyWebsiteAndSocialPage();
		jobBoardSetupPage.clickOnSaveButton();
		jobBoardSetupPage.captureNotifyMessage();

	}
	public void verifyLayoutPAgeWithDeatilRadioButton() {
		jobBoardSetupPage.clickOnDetailsRadioButton();
		jobBoardSetupPage.verifyLayoutPage();
		jobBoardSetupPage.clickOnSaveButton();
		jobBoardSetupPage.captureNotifyMessage();

	}
	public void verifyAppearancePAgeWithDeatilRadioButton() {
		jobBoardSetupPage.clickOnDetailsRadioButton();
		jobBoardSetupPage.clickOnAppearance();
		jobBoardSetupPage.verifyAppearancePage();
		jobBoardSetupPage.clickOnSaveButton();
		jobBoardSetupPage.captureNotifyMessage();

	}
	public void verifyWebsiteAndSocialPAgeWithDeatilRadioButton() {
		jobBoardSetupPage.clickOnDetailsRadioButton();
		jobBoardSetupPage.clickOnWebsiteAndSocial();
		jobBoardSetupPage.verifyWebsiteAndSocialPage();
		jobBoardSetupPage.clickOnSaveButton();
		jobBoardSetupPage.captureNotifyMessage();

	}
	public void verifyManageContentWithDeatilRadioButton() {
		jobBoardSetupPage.clickOnDetailsRadioButton();
		jobBoardSetupPage.clickOnManageContent();
		jobBoardSetupPage.verifyManageContent();
		jobBoardSetupPage.enterHeader();
		jobBoardSetupPage.enterSubHeader();
		jobBoardSetupPage.enterDescription();
		jobBoardSetupPage.selectLanguage();
		jobBoardSetupPage.clickOnSaveButton();
		jobBoardSetupPage.captureNotifyMessage();

	}
	public void verifyTestimonialsWithDeatilRadioButton() throws AWTException {
		jobBoardSetupPage.clickOnDetailsRadioButton();
		jobBoardSetupPage.clickOnTestimonials();
		jobBoardSetupPage.verifyTestimonials();
		jobBoardSetupPage.enterEmployeeFullName();
		jobBoardSetupPage.enterJobTitle();
		jobBoardSetupPage.enterComment();
		jobBoardSetupPage.uploadFile();
		jobBoardSetupPage.clickOnAddTestimonials();
		jobBoardSetupPage.clickOnSaveButton();
		jobBoardSetupPage.captureNotifyMessage();

	}
	public void verifyEmployeesWithDeatilRadioButton() {
		jobBoardSetupPage.clickOnDetailsRadioButton();
		jobBoardSetupPage.clickOnEmployees();
		jobBoardSetupPage.verifyEmployees();
		jobBoardSetupPage.clickOnSaveButton();
		jobBoardSetupPage.captureNotifyMessage();

	}
	public void verifyPhotosAndVideosWithDeatilRadioButton() {
		jobBoardSetupPage.clickOnDetailsRadioButton();
		jobBoardSetupPage.clickOnPhotosAndVideos();
		jobBoardSetupPage.verifyPhotosAndVideos();
		jobBoardSetupPage.clickOnSaveButton();
		jobBoardSetupPage.captureNotifyMessage();

	}
	public void verifyContentWithDeatilRadioButton() {
		jobBoardSetupPage.clickOnDetailsRadioButton();
		jobBoardSetupPage.clickOnContent();
		jobBoardSetupPage.verifyContent();
		jobBoardSetupPage.clickOnSaveButton();
		jobBoardSetupPage.captureNotifyMessage();

	}
	
}
