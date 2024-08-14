package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import action.CandidateListAction;
import action.LoginAction;
import action.PolicyAction;
import action.TalentPoolListAction;
import utils.WebTestBase;

public class TalentPoolListTest extends WebTestBase{
	static String Screenname ="<b> Hiring/b>";
	  
	@Test(priority=1)
	public void validationCheck()
	{
		test=getTest(Screenname + ": Validation message on Add Talent Pool List");
		TalentPoolListAction talentPoolListAction = new TalentPoolListAction(driver);
		new LoginAction(driver).logoutLogin();
		talentPoolListAction.goToHiringTab();
		talentPoolListAction.validationCheck();
	}
	  
		@Test(priority=2)
		public void addTalentPool()
		{
			test=getTest(Screenname + ": Add Talent Pool");
			TalentPoolListAction talentPoolListAction = new TalentPoolListAction(driver);
			new LoginAction(driver).logoutLogin();
			talentPoolListAction.goToHiringTab();
			talentPoolListAction.addTalentPool();
		}
		@Test(priority=3,dependsOnMethods = {"addTalentPool"})
		public void ValidateTalentPoolOnListingPAge()
		{
			test=getTest(Screenname + ": Validate Talent Pool on Listing Page");
			TalentPoolListAction talentPoolListAction = new TalentPoolListAction(driver);
			new LoginAction(driver).logoutLogin();
			talentPoolListAction.goToHiringTab();
			talentPoolListAction.verifyTalentPoolOnListingPage();
		}
		@Test(priority=4,dependsOnMethods = {"addTalentPool"})
		public void ValidateTalentPoolOnListingPAgeWithEamil()
		{
			test=getTest(Screenname + ": Validate Talent Pool on Listing Page With Email");
			TalentPoolListAction talentPoolListAction = new TalentPoolListAction(driver);
			new LoginAction(driver).logoutLogin();
			talentPoolListAction.goToHiringTab();
			talentPoolListAction.verifyTalentPoolOnListingPageWithEmail();
		}
		@Test(priority=5,dependsOnMethods = {"addTalentPool"})
		public void ValidateEditFunctionalityOfTalentPool()
		{
			test=getTest(Screenname + ": Validate Edit Functionality Of Talent Pool");
			TalentPoolListAction talentPoolListAction = new TalentPoolListAction(driver);
			new LoginAction(driver).logoutLogin();
			talentPoolListAction.goToHiringTab();
			talentPoolListAction.verifyTalentPoolOnListingPage();
			talentPoolListAction.verifyEditFunctionalityOfTalentPool();
		}
		@Test(priority=6,dependsOnMethods = {"addTalentPool"})
		public void ValidateViewFunctionalityOfTalentPool()
		{
			test=getTest(Screenname + ": Validate View Functionality Of Talent Pool");
			TalentPoolListAction talentPoolListAction = new TalentPoolListAction(driver);
			new LoginAction(driver).logoutLogin();
			talentPoolListAction.goToHiringTab();
			talentPoolListAction.verifyTalentPoolOnListingPage();
			talentPoolListAction.verifyViewFunctionalityOfTalentPool();
		}
		@Test(priority=7,dependsOnMethods = {"addTalentPool"})
		public void ValidateAddAsCandidateFunctionalityOfTalentPool()
		{
			test=getTest(Screenname + ": Validate Add As Candidate Functionality Of Talent Pool");
			TalentPoolListAction talentPoolListAction = new TalentPoolListAction(driver);
			new LoginAction(driver).logoutLogin();
			talentPoolListAction.goToHiringTab();
			talentPoolListAction.verifyTalentPoolOnListingPage();
			talentPoolListAction.verifyAddAsCandidateFunctionalityOfTalentPool();
		}
		@Test(priority=8)
		public void validateManageViewButtonFunctionality()
		{
			test=getTest(Screenname + ":validate Manage view Button Functionality ");
			TalentPoolListAction talentPoolListAction = new TalentPoolListAction(driver);
			new LoginAction(driver).logoutLogin();
			talentPoolListAction.goToHiringTab();
			talentPoolListAction.verifyManageViewFunctionality();
		}
		@Test(priority=9)
		public void validateDeleteManageViewButtonFunctionality()
		{
			test=getTest(Screenname + ":validate Delete Manage view Button Functionality ");
			TalentPoolListAction talentPoolListAction = new TalentPoolListAction(driver);
			new LoginAction(driver).logoutLogin();
			talentPoolListAction.goToHiringTab();
			talentPoolListAction.verifyDeleteManageViewFunctionality();
		}
		@Test(priority=10)
		public void validateDeleteFunctionality()
		{
			test=getTest(Screenname + ":Validate Delete Functionality of Talent Pool");
			TalentPoolListAction talentPoolListAction = new TalentPoolListAction(driver);
			new LoginAction(driver).logoutLogin();
			talentPoolListAction.goToHiringTab();
			talentPoolListAction.verifyTalentPoolOnListingPage();
			talentPoolListAction.verifyDeleteButtonFunctionalityOfTalentPool();
		}
}
