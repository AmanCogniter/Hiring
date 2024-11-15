package action;

import org.openqa.selenium.WebDriver;

import pageObjects.CandidateListPage;



public class CandidateListAction {
	WebDriver  driver ;
	CandidateListPage candidateListPage ;
	
	public CandidateListAction(WebDriver driver)
	{
		this.driver = driver;
		candidateListPage = new CandidateListPage(driver);
		
	}
	
	public void  goToHiringTab()
	{
		candidateListPage.clickFullMenuDropDown();
		candidateListPage.clickOnHiring();
		candidateListPage.clickOnCandidateList();
		
	}
	
	public void  validationCheck()
	{
		candidateListPage.clickOnAddCandidateList();
		candidateListPage.save();
		//candidateListPage.closeNotifyMessage();
		candidateListPage.VerifyMandatoryFieldValidation();
		
	}
	public void  addCandidate()
	{
		candidateListPage.clickOnAddCandidateList();
		candidateListPage.selectJob();
		candidateListPage.enterFirstName();
		candidateListPage.enterLastName();
		candidateListPage.enterEmail();
		//candidateListPage.enterMobileNumber();
		candidateListPage.save();
		candidateListPage.captureNotifyMessageOfAddCandidate();
		
	}
	public void  verifyCandidateOnListingPage()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		
		
	}
	public void  verifyDeleteButtonFunctionality()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOncheckbox();
		candidateListPage.clickOnDelete();
		candidateListPage.clickOnConfirmationButton();
		candidateListPage.captureNotifyMessage();
		
		
	}
	public void  verifyGridViewAndListViewButtonFunctionality()
	{
		candidateListPage.verifyGridViewFunctionality();
		candidateListPage.verifyListViewFunctionality();
		
		
	}
	public void  verifyManageViewFunctionality()
	{
		candidateListPage.clickOnManageView();
		candidateListPage.clickOnAddManageView();
		candidateListPage.enterViewName();
		candidateListPage.clickOnNext();
		candidateListPage.clickOnMoveAllRight();
		candidateListPage.clickOnNextButton();
		candidateListPage.selectFieldName();
		candidateListPage.selectConditionalOperator();
		candidateListPage.enterValue();
		candidateListPage.manageViewSave();
	}
	public void  verifyDeleteManageViewFunctionality()
	{
		candidateListPage.clickOnManageView();
		candidateListPage.clickOnDeleteManageView();
		candidateListPage.clickOnConfirmationButton();
		
	}
	public void  validationCheckOfForwardCandidateCvFunctionality()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOncheckbox();
		candidateListPage.clickOnForwardCandidateCV();
		candidateListPage.clickOnSend();
		candidateListPage.VerifyMandatoryFieldOfForwardCandidateCV();
	}
	public void  verifyForwardCandidateCvFunctionality()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOncheckbox();
		candidateListPage.clickOnForwardCandidateCV();
		candidateListPage.selectTemplate();
		candidateListPage.selectProfileFromTemplate();
		candidateListPage.selectResumeTemplate();
		candidateListPage.selectIncludeTemplate();
		candidateListPage.enterToEmail();
		candidateListPage.clickOnSend();
		
	}
	public void  verifyActionButtonEditFunctionality()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOnActionButton();
		candidateListPage.clickOnEditButton();
		candidateListPage.save();
		candidateListPage.captureUpdateNotifyMessage();
		
		
	}
	public void  verifyMakeOfferButtonEditFunctionality()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOnActionButton();
		candidateListPage.clickOnMakeOfferButton();
		candidateListPage.enterToPhoneNumber();
		candidateListPage.enterDateOfBirth();
		candidateListPage.enterStreet();
		candidateListPage.enterCity();
		candidateListPage.enterState();
		candidateListPage.selectCountry();
		candidateListPage.enterZipCode();
		candidateListPage.clickOnContinue();
		candidateListPage.enterAmountPayable();
		candidateListPage.selectCurrency();
		candidateListPage.selectPeriod();
		candidateListPage.selectPaidAs();
		candidateListPage.clickOnContinueOfCompensation();
		candidateListPage.captureUpdateNotifyMessageOfCompensation();
		candidateListPage.selectDepartment();
		candidateListPage.selectJObLocation();
		candidateListPage.selectReportingManager();
		candidateListPage.enterJoiningDAte();
		candidateListPage.enterDAte();
		candidateListPage.selectOfferTemplate();
		candidateListPage.clickOnSave();
		candidateListPage.clickOnEmailOffer();
		candidateListPage.clickOnSend();
		candidateListPage.captureNotifyMessageOfSendMail();
		
		
	}
	public void  verifyEditFunctionalityOfView()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOnActionButton();
		candidateListPage.clickOnViewButton();
		candidateListPage.clickOnEdit();
		candidateListPage.save();
		candidateListPage.captureNotifyMessageOfUpdateCandidate();
		
		
	}
	public void  verifyrequestDocumentsFunctionalityOfView()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOnActionButton();
		candidateListPage.clickOnViewButton();
		candidateListPage.clickOnRequestDocument();
		candidateListPage.selectRequestTemplate();
		candidateListPage.clickOnSendEmail();
		candidateListPage.captureNotifyMessageOfRequestDocuments();
		
		
	}
	public void  verifyHireFunctionalityOfView()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOnActionButton();
		candidateListPage.clickOnViewButton();
		candidateListPage.clickOnHire();
		candidateListPage.clickOnCancelButton();
		
		
		
	}
	public void  verifyOnHoldFunctionalityOfView()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOnActionButton();
		candidateListPage.clickOnViewButton();
		candidateListPage.clickOnHold();
		candidateListPage.selectOnHoldReason();
		
		 // candidateListPage.clickOnCandidateCheckBox();
		 // candidateListPage.clickOnHiringTeamCheckBox();
		 
		candidateListPage.enterComment();
		//candidateListPage.enterDescription();
		candidateListPage.clickOnUpdate();
		//candidateListPage.clickOnConfirmationButton();
		candidateListPage.captureNotifyMessageOfOnHold();
	}
	public void  verifyEditFunctionalityOfInterview()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOnActionButton();
		candidateListPage.clickOnViewButton();
		candidateListPage.clickOnInterview();
		candidateListPage.clickOnEdit();
		candidateListPage.save();
		candidateListPage.captureNotifyMessageOfUpdateCandidate();
		
		
	}
	public void  verifyAddEditDeleteFunctionalityOfNOtes()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOnActionButton();
		candidateListPage.clickOnViewButton();
		candidateListPage.clickOnNote();
		candidateListPage.clickOnAddNote();
		candidateListPage.enterNotesDescription();
		candidateListPage.save();
		candidateListPage.captureNotifyMessageOfNotes();
		candidateListPage.clickOnDeleteActionButton();
		candidateListPage.clickOnEditNotesButton();
		candidateListPage.save();
		candidateListPage.captureNotifyEditMessageOfNotes();
		candidateListPage.clickOnDeleteActionButton();
		candidateListPage.clickOnDeleteButton();
		candidateListPage.clickOnConfirmationButton();
		candidateListPage.captureNotifyDeleteMessageOfNotes();
		
		
	}
	public void  verifyApplyForMoreFunctionality()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOnActionButton();
		candidateListPage.clickOnApplyForMore();
		candidateListPage.selectJobForApplyMore();
		candidateListPage.clickOnSaveAndSkipEmail();
		
		
		
	}
	public void  verifyDocumentsFunctionalityOfView()
	{
		candidateListPage.clickOnCandidteNameSearchField();
		candidateListPage.enterCandidateNameIntoSearchField();
		candidateListPage.clickOnSearchButton();
		candidateListPage.verifyCandidateOnListingPage();
		candidateListPage.clickOnActionButton();
		candidateListPage.clickOnViewButton();
		candidateListPage.clickOnDocuments();
		candidateListPage.selectDocumentType();
		candidateListPage.uploadDocument();
		candidateListPage.save();
		candidateListPage.captureNotifyMessageOfManageDocumentType();
		
		
	}
}
