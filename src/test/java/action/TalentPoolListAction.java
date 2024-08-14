package action;

import org.openqa.selenium.WebDriver;

import pageObjects.TalentPoolListPage;

public class TalentPoolListAction {
	WebDriver driver;
	TalentPoolListPage talentPoolListPage;

	public TalentPoolListAction(WebDriver driver) {
		this.driver = driver;
		talentPoolListPage = new TalentPoolListPage(driver);

	}

	public void goToHiringTab() {
		talentPoolListPage.clickFullMenuDropDown();
		talentPoolListPage.clickOnHiring();
		talentPoolListPage.clickOnTalentPoolList();

	}

	public void validationCheck() {
		talentPoolListPage.clickOnAddTalentPoolList();
		talentPoolListPage.save();
		talentPoolListPage.captureErrorNotifyMessage();
		talentPoolListPage.VerifyMandatoryFieldValidation();

	}
	public void addTalentPool() {
		talentPoolListPage.clickOnAddTalentPoolList();
		talentPoolListPage.enterEmail();
		
		talentPoolListPage.uploadDocument();
		
		
		talentPoolListPage.enterMobileNumber();
		talentPoolListPage.enterFirstName();
		talentPoolListPage.enterLastName();
		talentPoolListPage.save();
		talentPoolListPage.captureNotifyMessage();

	}
	public void verifyTalentPoolOnListingPage() {
		talentPoolListPage.clickOnTalentPoolNameSearchField();
		talentPoolListPage.enterNameIntoSearchField();
		talentPoolListPage.clickOnSearchButton();
		talentPoolListPage.verifyTalentPool();

	}
	public void verifyTalentPoolOnListingPageWithEmail() {
		talentPoolListPage.clickOnTalentPoolNameSearchField();
		talentPoolListPage.enterNameIntoSearchField();
		talentPoolListPage.clickOnEmailSearchField();
		talentPoolListPage.enterEMailIntoSearchField();
		talentPoolListPage.clickOnSearchButton();
		talentPoolListPage.verifyTalentPool();

	}
	public void verifyDeleteButtonFunctionalityOfTalentPool() {

		talentPoolListPage.clickOnCheckBox();
		talentPoolListPage.clickOndelete();
		talentPoolListPage.clickOnConfirmationButton();
		talentPoolListPage.captureDeleteNotifyMessage();
	}
	public void verifyEditFunctionalityOfTalentPool() {

		talentPoolListPage.clickOnActionButton();
		talentPoolListPage.clickOnEditButton();
		talentPoolListPage.save();
		talentPoolListPage.captureUpdateNotifyMessage();
	}
	public void verifyAddAsCandidateFunctionalityOfTalentPool() {

		talentPoolListPage.clickOnActionButton();
		talentPoolListPage.clickOnAddAsCandidate();
		talentPoolListPage.selectJob();
		talentPoolListPage.enterDescription();
		talentPoolListPage.saveButton();
	}
	public void verifyViewFunctionalityOfTalentPool() {

		talentPoolListPage.clickOnActionButton();
		talentPoolListPage.clickOnViewButton();
		talentPoolListPage.clickOnBackToList();
		
	}
	public void  verifyManageViewFunctionality()
	{
		talentPoolListPage.clickOnManageView();
		talentPoolListPage.clickOnAddManageView();
		talentPoolListPage.enterViewName();
		talentPoolListPage.clickOnNext();
		talentPoolListPage.clickOnMoveAllRight();
		talentPoolListPage.clickOnNextButton();
		talentPoolListPage.selectFieldName();
		talentPoolListPage.selectConditionalOperator();
		talentPoolListPage.enterValue();
		talentPoolListPage.saveManageView();
	}
	public void  verifyDeleteManageViewFunctionality()
	{
		talentPoolListPage.clickOnManageView();
		talentPoolListPage.clickOnDeleteManageView();
		talentPoolListPage.clickOnConfirmationButton();
		
	}

}
