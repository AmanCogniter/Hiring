package action;

import org.openqa.selenium.WebDriver;

import pageObjects.StagePage;

public class StageAction {
	WebDriver driver;
	StagePage stagePage;

	public StageAction(WebDriver driver) {
		this.driver = driver;
		
		stagePage = new StagePage(driver);
	}

	public void goToHiringTab() {
		stagePage.clickFullMenuDropDown();
		stagePage.clickOnHiring();
		stagePage.clickOnStage();

	}
	public void goTOHiringTab() {
		stagePage.clickFullMenuDropDown();
		stagePage.clickOnHiring();
		stagePage.clickonStage();

	}

	public void validationCheck() {
		stagePage.clickOnAddStage();
		stagePage.save();

		stagePage.VerifyMandatoryFieldValidation();

	}
	public void validateUserGuide() {
		stagePage.clickOnAddStage();
		stagePage.clickOnUserGuide();

		

	}
	public void addStage() {
		stagePage.clickOnAddStage();
		stagePage.enterStageName();
		stagePage.selectPhaseName();
		stagePage.selectType();
		stagePage.enterDescription();
		stagePage.selectStatus();
		
		stagePage.save();
		stagePage.captureNotifyMessage();

	}
public void verifyStageNameOnListingPAge() {
		
	stagePage.enterStageNameIntoSearchField();

	stagePage.clickOnSearchButton();
	stagePage.verifyStageNameOnListingPage();

	}
public void verifyEditFunctionalityOfStageName() {
	
	stagePage.enterStageNameIntoSearchField();

	stagePage.clickOnSearchButton();
	stagePage.clickOnStageName();
	stagePage.selectType();
	stagePage.enterDescription();
	stagePage.save();
	stagePage.captureUpdateNotifyMessage();

	}
public void verifyInActiveStatusFunctionalityOfStageName() {
	
	stagePage.enterStageNameIntoSearchField();

	stagePage.clickOnSearchButton();
	stagePage.clickOnCheckBox();
	stagePage.clickOnInActiveStatus();
	stagePage.clickOnConfirmationButton();
	
	stagePage.captureUpdateNotifyMessage();

	}
public void verifyActiveStatusFunctionalityOfStageName() {
	
	stagePage.enterStageNameIntoSearchField();

	stagePage.clickOnSearchButton();
	stagePage.clickOnCheckBox();
	stagePage.clickOnActiveStatus();
	stagePage.clickOnConfirmationButton();
	
	stagePage.captureUpdateNotifyMessage();

	}
public void verifyDropDownActiveStatusFunctionalityOfStageName() {
	
	stagePage.enterStageNameIntoSearchField();

	stagePage.clickOnSearchButton();
	
	stagePage.selectStatusFromDropDown();
	stagePage.clickOnConfirmationButton();
	
	stagePage.captureUpdateNotifyMessage();

	}
public void verifyDropDownInActiveStatusFunctionalityOfStageName() {
	
	stagePage.enterStageNameIntoSearchField();

	stagePage.clickOnSearchButton();
	
	stagePage.selectInActiveStatusFromDropDown();
	stagePage.clickOnConfirmationButton();
	
	stagePage.captureUpdateNotifyMessage();

	}
public void verifyDeleteFunctionalityOfStageName() {
	
	stagePage.enterStageNameIntoSearchField();

	stagePage.clickOnSearchButton();
	stagePage.clickOnCheckBox();
	stagePage.clickOnDeleteButton();
	stagePage.clickOnConfirmationButton();
	
	stagePage.captureDeleteNotifyMessage();

	}
public void stageSorting() {
	stagePage.stageAscending();
	stagePage.stageDescending();
   }
}
