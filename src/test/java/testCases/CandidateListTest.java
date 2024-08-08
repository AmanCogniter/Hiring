package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.CandidateListAction;
import action.LoginAction;
import utils.WebTestBase;

public class CandidateListTest extends WebTestBase {
	static String Screenname ="<b> Hiring/b>";
	  
	@Test(priority=1)
	public void validationCheck()
	{
		test=getTest(Screenname + ": Validation message on Add Hiring");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.validationCheck();
	}
	@Test(priority=2)
	public void addCandidate()
	{
		test=getTest(Screenname + ": Add Candidate ");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.addCandidate();
	}
	@Test(priority=3)
	public void validateCandidateSearchFunctionalityWithNAme()
	{
		test=getTest(Screenname + ":validate Candidate Search Functionality With NAme");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.verifyCandidateOnListingPage();
	}
	
	@Test(priority=4)
		public void validateGridViewAndListViewButtonFunctionality()
		{
			test=getTest(Screenname + ":validate Grid View And List view Button Functionality ");
			CandidateListAction candidateListAction = new CandidateListAction(driver);
			new LoginAction(driver).logoutLogin();
			candidateListAction.goToHiringTab();
			candidateListAction.verifyGridViewAndListViewButtonFunctionality();
		}
	@Test(priority=5)
	public void validateManageViewButtonFunctionality()
	{
		test=getTest(Screenname + ":validate Manage view Button Functionality ");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.verifyManageViewFunctionality();
	}
	@Test(priority=6)
	public void validateDeleteManageViewButtonFunctionality()
	{
		test=getTest(Screenname + ":validate Delete Manage view Button Functionality ");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.verifyDeleteManageViewFunctionality();
	}
	@Test(priority=7)
	public void validationCheckOfForwardCandidateCv()
	{
		test=getTest(Screenname + ": Validation message on Forward Candidate Cv");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.validationCheckOfForwardCandidateCvFunctionality();
	}
	@Test(priority=8)
	public void validateForwardCandidateCvFunctionality()
	{
		test=getTest(Screenname + ":validate Forward Candidate Cv Functionality ");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.verifyForwardCandidateCvFunctionality();
	}
	@Test(priority=9)
		public void validateActionButtonEditFunctionality()
		{
			test=getTest(Screenname + ":validate Action Button Edit Functionality ");
			CandidateListAction candidateListAction = new CandidateListAction(driver);
			new LoginAction(driver).logoutLogin();
			candidateListAction.goToHiringTab();
			candidateListAction.verifyActionButtonEditFunctionality();
		}
	@Test(priority=10)
	public void validateEditFunctionalityOfView()
	{
		test=getTest(Screenname + ":validate Edit Functionality Of View");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.verifyEditFunctionalityOfView();
	}
	@Test(priority=11)
	public void validateRequestDocumentsFunctionalityOfView()
	{
		test=getTest(Screenname + ":validate Request Documents Functionality Of View");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.verifyrequestDocumentsFunctionalityOfView();
	}
	@Test(priority=12)
	public void validateHireFunctionalityOfView()
	{
		test=getTest(Screenname + ":validate Hire Functionality Of View");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.verifyHireFunctionalityOfView();
	}
	@Test(priority=13)
	public void validateOnHoldFunctionalityOfView()
	{
		test=getTest(Screenname + ":validate On Hold Functionality Of View");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.verifyOnHoldFunctionalityOfView();
	}
	@Test(priority=14)
		public void validateEditFunctionalityOfInterview()
		{
			test=getTest(Screenname + ":validate Edit Functionality Of Interview");
			CandidateListAction candidateListAction = new CandidateListAction(driver);
			new LoginAction(driver).logoutLogin();
			candidateListAction.goToHiringTab();
			candidateListAction.verifyEditFunctionalityOfInterview();
		}
		@Test(priority=15)
		public void validateAddEditDeleteFunctionalityOfNotes()
		{
			test=getTest(Screenname + ":validate Add Edit Delete Functionality Of Notes");
			CandidateListAction candidateListAction = new CandidateListAction(driver);
			new LoginAction(driver).logoutLogin();
			candidateListAction.goToHiringTab();
			candidateListAction.verifyAddEditDeleteFunctionalityOfNOtes();
		}
	//@Test(priority=10)
	public void validateMakeOfferFunctionalityOfActionButton()
	{
		test=getTest(Screenname + ":validate Make Offer Functionality of Action Button");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.verifyMakeOfferButtonEditFunctionality();
	}
	@Test(priority=16)
		public void validateApplyForMoreFunctionalityOfActionButton()
		{
			test=getTest(Screenname + ":validate Apply For More Functionality of Action Button");
			CandidateListAction candidateListAction = new CandidateListAction(driver);
			new LoginAction(driver).logoutLogin();
			candidateListAction.goToHiringTab();
			candidateListAction.verifyApplyForMoreFunctionality();
		}
	@Test(priority=17)
	public void validateDocumentsFunctionalityOfView()
	{
		test=getTest(Screenname + ":validate Documents Functionality of View");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.verifyDocumentsFunctionalityOfView();
	}
	@Test(priority=18)
	public void validateDelteButtonFunctionality()
	{
		test=getTest(Screenname + ":validate Delete Button Functionality ");
		CandidateListAction candidateListAction = new CandidateListAction(driver);
		new LoginAction(driver).logoutLogin();
		candidateListAction.goToHiringTab();
		candidateListAction.verifyDeleteButtonFunctionality();
	}
}
